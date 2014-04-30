package views;

import org.junit.Test;

import play.mvc.Content;
import services.CodeTrendItem;
import view_models.CodeTrendViewModel;
import views.html.trend_result;
import views.txt.trend_data;

import java.util.LinkedList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

public class TrendDataTest {

    @Test
    public void renderTemplate() {
        List<CodeTrendItem> items = new LinkedList<CodeTrendItem>();
        items.add(new CodeTrendItem("Ruby", 20d));
        items.add(new CodeTrendItem("Java", 60.33333d));
        items.add(new CodeTrendItem("Scala", 20.66666d));
        CodeTrendViewModel model = new CodeTrendViewModel(items);
        Content txt = trend_data.render(model);
        assertThat(contentAsString(txt)).contains("{language:\"Ruby\", score:20.00}");   	
        assertThat(contentAsString(txt)).contains("{language:\"Java\", score:60.33}");  
        assertThat(contentAsString(txt)).contains("{language:\"Scala\", score:20.67}");  
    }
}
