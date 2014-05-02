package views;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import play.mvc.Content;
import services.CodeTrendItem;
import view_models.CodeTrendViewModel;
import views.txt.trend_data;

public class TrendDataTest {

    @Test
    public void renderTemplate() {
        List<CodeTrendItem> items = new LinkedList<CodeTrendItem>();
        items.add(new CodeTrendItem("Ruby", 20d));
        items.add(new CodeTrendItem("Java", 60.33333d));
        items.add(new CodeTrendItem("Scala", 20.66666d));
        CodeTrendViewModel model = new CodeTrendViewModel(items);
        Content txt = trend_data.render(model);
        assertThat(contentAsString(txt)).contains(
                "[\r\n" + 
                "    {\r\n" + 
                "        \"language\" : \"Ruby\",\r\n" + 
                "        \"display\": \"20.00%\",\r\n" + 
                "        \"color\":\"#332F45\",\r\n" + 
                "        \"value\" : 20.0\r\n" + 
                "    },\r\n" + 
                "    {\r\n" + 
                "        \"language\" : Java,\r\n" + 
                "        \"display\" : \"60.33%\",\r\n" + 
                "        \"color\" : \"#015770\",\r\n" + 
                "        \"value\" : 60.33333\r\n" + 
                "    },\r\n" + 
                "    {\r\n" + 
                "        \"language\" : Scala,\r\n" + 
                "        \"display\" : \"20.67%\",\r\n" + 
                "        \"color\" : \"#2A8782\",\r\n" + 
                "        \"value\" : 20.66666\r\n" + 
                "    }               \r\n" + 
                "]");
    }
}
