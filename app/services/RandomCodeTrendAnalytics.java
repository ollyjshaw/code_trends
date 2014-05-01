package services;

import java.util.LinkedList;
import java.util.List;

public class RandomCodeTrendAnalytics implements CodeTrendAnalytics {

    @Override
    public List<CodeTrendItem> getCodeTrends(String[] input) {

        List<CodeTrendItem> result = new LinkedList<CodeTrendItem>();

        double[] randArray = new double[input.length];
        double total = 0D;

        for (int i = 0; i < input.length; ++i) {
            randArray[i] = Math.random();
            total += randArray[i];
        }

        double indValue = 100.00 / total;

        for (int j = 0; j < input.length; ++j) {
            double trendValue = randArray[j] * indValue;
            CodeTrendItem item = new CodeTrendItem(input[j], trendValue);
            result.add(item);
        }

        return result;
    }
}
