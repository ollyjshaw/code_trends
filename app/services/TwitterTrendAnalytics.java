package services;

import helpers.ApplicationProperties;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterTrendAnalytics implements CodeTrendAnalytics {

	public List<CodeTrendItem> getCodeTrends(String[] input) {

		Twitter twitter = constructTwitterClient();

		int[] popularityArray = runQueries(input, twitter);

		return calculateResult(popularityArray, input);
	}

	private List<CodeTrendItem> calculateResult(int[] popularityArray,
			String[] input) {

		int total = 0;

		for (int value : popularityArray) {
			total += value;
		}

		double indValue = 100.00 / total;
		List<CodeTrendItem> result = new LinkedList<CodeTrendItem>();

		for (int j = 0; j < popularityArray.length; ++j) {
			double trendValue = popularityArray[j] * indValue;
			CodeTrendItem item = new CodeTrendItem(input[j], trendValue);
			result.add(item);
		}

		return result;
	}

	private int[] runQueries(String[] input, Twitter twitter) {
		int[] popularityArray = new int[3];

		for (int i = 0; i < popularityArray.length; ++i) {
			try {
				Query query = constructQuery(input[i]);
				QueryResult result;

				int localTotal = 0;
				do {
					result = twitter.search(query);
					localTotal += result.getCount();
				} while ((query = result.nextQuery()) != null);
				popularityArray[i] = localTotal;
			} catch (TwitterException te) {
				te.printStackTrace();
			}
		}
		return popularityArray;
	}

	private Query constructQuery(String input) {

		String today = formatDateForTwitter(new Date());
		String yesterday = formatDateForTwitter(yesterday());

		Query query = new Query(input + " geocode:55.9531,-3.1889,30km");
		query.setSince(yesterday);
		query.setUntil(today);

		return query;
	}

	private Date yesterday() {
		Date todaysDate = new Date();
		Calendar aDay = Calendar.getInstance();
		aDay.setTime(todaysDate);
		aDay.add(Calendar.DAY_OF_MONTH, -1);
		return aDay.getTime();
	}

	private String formatDateForTwitter(Date todaysDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(todaysDate);
		return date;
	}

	private Twitter constructTwitterClient() {
		ConfigurationBuilder cb = getConfigurationBuilder();
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		return twitter;
	}

	private ConfigurationBuilder getConfigurationBuilder() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setUseSSL(true)
				.setOAuthConsumerKey(ApplicationProperties.OAUTHCONSUMERKEY)
				.setOAuthConsumerSecret(ApplicationProperties.OAUTHCONSUMERSECRET)
				.setOAuthAccessToken(ApplicationProperties.OAUTHACCESSTOKEN)
				.setOAuthAccessTokenSecret(ApplicationProperties.OAUTHACCESSTOKENSECRET);

		return cb;
	}

}
