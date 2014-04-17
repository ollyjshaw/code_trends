import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import models.InputForm;
import org.junit.*;

import play.data.Form;
import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class ApplicationTest {

    private static final Form<InputForm> inputForm = Form.form(InputForm.class);

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new application is ready.");
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("Your new application is ready.");
    }
	
	@Test
    public void renderInputTemplate() {
        Content html = views.html.input.render(inputForm);
        assertThat(contentType(html)).isEqualTo("text/html");
		assertThat(contentAsString(html)).contains("Search Twitter popularity");
    }

    @Test
    public void checkInputViewHasTitle() {
        Content html = views.html.input.render(inputForm);
        assertThat(contentAsString(html)).contains("title for input view");
    }

	@Test
	public void checkHTMLInputFieldsExist() {
		Content html = views.html.input.render(inputForm);
		assertThat(contentAsString(html)).contains("<input type=\"text\" id=\"language1\" name=\"language1\" value=\"\" >");
		assertThat(contentAsString(html)).contains("<input type=\"text\" id=\"language2\" name=\"language2\" value=\"\" >");
		assertThat(contentAsString(html)).contains("<input type=\"text\" id=\"language3\" name=\"language3\" value=\"\" >");

		assertThat(contentAsString(html)).contains("<input class=\"button\" type=\"submit\" value=\"View trends\">");
	}


}
