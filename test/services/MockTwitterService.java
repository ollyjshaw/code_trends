package services;

import java.util.LinkedList;
import java.util.List;

public class MockTwitterService implements TwitterService {

    @Override
    public List<CodeTrendItem> getCodeTrends(String[] input) {

        List<CodeTrendItem> result = new LinkedList<CodeTrendItem>();
        for (String language : input){
           CodeTrendItem item = new CodeTrendItem(language);
            result.add(item);
        }
        return result;
    }
}
