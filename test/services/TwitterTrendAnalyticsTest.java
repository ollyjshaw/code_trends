package services;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TwitterTrendAnalyticsTest {

	@Test
	public void testGetCodeTrends() {
		CodeTrendAnalytics analytics = new TwitterTrendAnalytics();
		List<CodeTrendItem> items = analytics.getCodeTrends(new String[] {
				"Java", "C#", "Ruby" });

		assertThat(items.size()).isEqualTo(3);

		Double total = 0D;

		for (CodeTrendItem item : items) {
			total += item.getPopularity();
		}

		assertEquals(100.00, total, 0.1);
	}

}
