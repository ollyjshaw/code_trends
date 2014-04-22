package services;

import java.util.LinkedList;
import java.util.List;

import services.CodeTrendAnalytics;
import services.CodeTrendItem;

public class MockCodeTrendAnalytics implements CodeTrendAnalytics {

    @Override
    public List<CodeTrendItem> getCodeTrends(String[] input) {

        List<CodeTrendItem> result = new LinkedList<>();
        for (String language : input){
           CodeTrendItem item = new CodeTrendItem(language, 0D);
            result.add(item);
        }
        return result;
    }
}
