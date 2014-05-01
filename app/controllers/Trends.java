package controllers;

import models.InputForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import services.CodeTrendService;
import view_models.CodeTrendViewModel;
import views.html.input;
import views.html.trend_result;
import views.txt.trend_data;

import com.google.inject.Inject;

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

    public Result data() {
        Form<InputForm> boundForm = inputForm.bindFromRequest();
        InputForm input = boundForm.get();

        CodeTrendViewModel viewModel = service.getTrends(input);
        response().setContentType("application/json");

        return ok(trend_data.render(viewModel));
    }

}
