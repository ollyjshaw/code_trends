import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;

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


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

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
        Content html = views.html.input.render();
        assertThat(contentType(html)).isEqualTo("text/html");
		assertThat(contentAsString(html)).contains("Search Twitter popularity");
    }

    @Test
    public void checkInputViewHasTitle() {
        Content html = views.html.input.render();
        assertThat(contentAsString(html)).contains("title for input view");
    }

	// Check that the input page contains 3 text fields and a button
	@Test
	public void checkHTMLInputFieldsExist() {
		Content html = views.html.input.render();
		assertThat(contentAsString(html)).contains("<input type=\"text\" id=\"trend1\" name=\"trend1\" value=\"\">");
		assertThat(contentAsString(html)).contains("<input type=\"text\" id=\"trend2\" name=\"trend2\" value=\"\">");
		assertThat(contentAsString(html)).contains("<input type=\"text\" id=\"trend3\" name=\"trend3\" value=\"\">");
		assertThat(contentAsString(html)).contains("<input class=\"button\" type=\"submit\" value=\"View trends\">");
	}


}
