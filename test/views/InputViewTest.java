package views;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;
import models.InputForm;

import org.junit.Test;

import play.data.Form;
import play.mvc.Content;

public class InputViewTest {
    private static final Form<InputForm> inputForm = Form.form(InputForm.class);

    @Test
    public void renderInputTemplate() {
        Content html = views.html.input.render(inputForm);
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains(
                "Twitter programming language trends");
    }

    @Test
    public void checkInputViewHasTitle() {
        Content html = views.html.input.render(inputForm);
        assertThat(contentAsString(html)).contains(
                "Twitter programming language trends");
    }

    @Test
    public void checkHTMLInputFieldsExist() {
        Content html = views.html.input.render(inputForm);
        assertThat(contentAsString(html))
                .contains(
                        "<input type=\"text\" id=\"language1\" name=\"language1\" value=\"\" >");
        assertThat(contentAsString(html))
                .contains(
                        "<input type=\"text\" id=\"language2\" name=\"language2\" value=\"\" >");
        assertThat(contentAsString(html))
                .contains(
                        "<input type=\"text\" id=\"language3\" name=\"language3\" value=\"\" >");
        assertThat(contentAsString(html))
                .contains(
                        "<input class=\"button\" type=\"submit\" id=\"view_trends\" value=\"View trends\">");
    }
}
