package views;

import org.junit.Test;
import play.mvc.Content;
import services.CodeTrendItem;
import view_models.CodeTrendViewModel;
import views.html.trend_result;

import java.util.LinkedList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

public class TrendViewTest {

    @Test
    public void renderTemplate() {
        List<CodeTrendItem> items = new LinkedList<CodeTrendItem>();
        items.add(new CodeTrendItem("Ruby", 20d));
        items.add(new CodeTrendItem("Java", 60d));
        items.add(new CodeTrendItem("Scala", 20d));
        CodeTrendViewModel model = new CodeTrendViewModel(items);
        Content html = trend_result.render(model);
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("The code trends are as follows");
        assertThat(contentAsString(html)).contains("Java: 60.0%");
        assertThat(contentAsString(html)).contains("Ruby: 20.0%");
        assertThat(contentAsString(html)).contains("Scala: 20.0%");
    }
}
