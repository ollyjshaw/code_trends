package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import models.InputForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import services.CodeTrendService;
import services.RandomCodeTrendAnalytics;
import view_models.CodeTrendViewModel;
import views.html.input;
import views.html.trend_result;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class Trends extends Controller {
	
	@Autowired
	private CodeTrendService service;

    public Result submit() {
        Form<InputForm> boundForm = inputForm.bindFromRequest();
        InputForm input = boundForm.get();
        RandomCodeTrendAnalytics random = new RandomCodeTrendAnalytics();
        //CodeTrendService service = new CodeTrendService(random);
        CodeTrendViewModel viewModel = service.getTrends(input);
        return ok(trend_result.render(viewModel));

    }

    private static final Form<InputForm> inputForm = Form.form(InputForm.class);

    public Result newTrend() {
        return ok(input.render(inputForm));
    }
    
}
