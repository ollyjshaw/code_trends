package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;

import models.InputForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.CodeTrendService;
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
    
    public Result data() {
    	Form<InputForm> boundForm = inputForm.bindFromRequest();
        InputForm input = boundForm.get();

        CodeTrendViewModel viewModel = service.getTrends(input);
    	
    	
    	ObjectNode result = Json.newObject();

    	result.put("data", viewModel.getData().toString());
    	result.put("language1", input.language1);
    	result.put("language2", input.language2);
    	result.put("language3", input.language3);
    	return ok(result);
    }
    
}
