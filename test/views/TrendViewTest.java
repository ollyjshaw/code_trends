package views;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import play.mvc.Content;
import services.CodeTrendItem;
import view_models.CodeTrendViewModel;
import views.html.trend_result;
import views.txt.trend_data;

public class TrendViewTest {

    @Test
    public void renderTemplate() {
        List<CodeTrendItem> items = new LinkedList<CodeTrendItem>();
        items.add(new CodeTrendItem("Ruby", 20d));
        items.add(new CodeTrendItem("Java", 60.33333d));
        items.add(new CodeTrendItem("Scala", 20.66666d));
        CodeTrendViewModel model = new CodeTrendViewModel(items);
        Content html = trend_result.render(model);
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("The code trends are as follows");
        assertThat(contentAsString(html)).contains("<tr><th>Ruby </th> <td>20.00%</td></tr>");
        assertThat(contentAsString(html)).contains("<tr><th>Java </th> <td>60.33%</td></tr>");
        assertThat(contentAsString(html)).contains("<tr><th>Scala </th> <td>20.67%</td></tr>");
    }
}
