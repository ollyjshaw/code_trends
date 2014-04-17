package controllers;

import models.InputForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.input;

public class Trends extends Controller {

    public static Result submit() {
        return ok(index.render("This was submitted."));
    }

    private static final Form<InputForm> inputForm = Form.form(InputForm.class);

    public static Result newTrend() {
        return ok(input.render(inputForm));
    }

}
