package service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oliver.shaw
 * Date: 16/04/14
 * Time: 12:07
 * To change this template use File | Settings | File Templates.
 */
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
