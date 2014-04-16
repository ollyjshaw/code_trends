package service;

import java.util.List;

public class CodeTrendService {

    TwitterService twitterService;

    public CodeTrendService(TwitterService service){
        this.twitterService = service;
    }

    public CodeTrendViewModel getTrends(String[] input) {

        //create view model
        List<CodeTrendItem> items = twitterService.getCodeTrends(input);

        //return
        return new CodeTrendViewModel(items);
    }
}
