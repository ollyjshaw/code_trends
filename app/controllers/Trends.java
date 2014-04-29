package controllers;

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

    public static Result submit() {
        Form<InputForm> boundForm = inputForm.bindFromRequest();
        InputForm input = boundForm.get();
        
        RandomCodeTrendAnalytics random = new RandomCodeTrendAnalytics();
        CodeTrendService service = new CodeTrendService(random);
        
        CodeTrendViewModel viewModel = service.getTrends(input);
        return ok(trend_result.render(viewModel));

    }

    private static final Form<InputForm> inputForm = Form.form(InputForm.class);

    public static Result newTrend() {
        return ok(input.render(inputForm));
    }
    
}
