package services;

import java.util.List;

import com.google.inject.Inject;

import models.InputForm;
import view_models.*;


public class CodeTrendService {

	
    CodeTrendAnalytics twitterService;

    @Inject
    public CodeTrendService(CodeTrendAnalytics service){
        this.twitterService = service;
    }

    public CodeTrendViewModel getTrends(InputForm form) {

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
