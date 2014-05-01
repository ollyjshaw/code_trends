package services;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class TwitterTrendAnalyticsTest {

	@Ignore("Need to have credentials to run")
	@Test
	public void testGetCodeTrends() {
		running(fakeApplication(), new Runnable() {		      
			public void run() {
				CodeTrendAnalytics analytics = new TwitterTrendAnalytics();
				List<CodeTrendItem> items = analytics.getCodeTrends(new String[] {"Java", "C#", "Ruby" });

				assertThat(items.size()).isEqualTo(3);

				Double total = 0D;

				for (CodeTrendItem item : items) {
					total += item.getPopularity();
				}

				assertEquals(100.00, total, 0.1);
			}
		});
	}
}
