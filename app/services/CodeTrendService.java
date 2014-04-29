package services;

import java.util.List;

import models.InputForm;
import view_models.*;


public class CodeTrendService {

    CodeTrendAnalytics twitterService;

    public CodeTrendService(CodeTrendAnalytics service){
        this.twitterService = service;
    }

    public CodeTrendViewModel getTrends(InputForm form) {
    	play.Logger.info("CodeTrendViewModel.getTrends, search for " + form.language1 + ", " + form.language2 + ", " + form.language3);
        String [] input = new String [3];
        input[0] = form.language1;
        input[1] = form.language2;
        input[2] = form.language3;

        //create view model
        List<CodeTrendItem> items = twitterService.getCodeTrends(input);

        //return
        return new CodeTrendViewModel(items);
    }
}
