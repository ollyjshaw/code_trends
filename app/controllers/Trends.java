package controllers;

import com.google.inject.Inject;

import models.InputForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import services.CodeTrendService;
import services.RandomCodeTrendAnalytics;
import view_models.CodeTrendViewModel;
import views.html.input;
import views.html.trend_result;

public class Trends extends Controller {
	
	@Inject
	private CodeTrendService service;

    public Result submit() {
        Form<InputForm> boundForm = inputForm.bindFromRequest();
        InputForm input = boundForm.get();
        CodeTrendViewModel viewModel = service.getTrends(input);
        return ok(trend_result.render(viewModel));

    }

    private static final Form<InputForm> inputForm = Form.form(InputForm.class);

    public Result newTrend() {
        return ok(input.render(inputForm));
    }
    
}
