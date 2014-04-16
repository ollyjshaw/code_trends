package service;

import org.junit.Test;
import play.mvc.Content;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class TrendServiceTest {

   @Test
   public void itShouldReturnAViewModelWhenGivenData(){

       TwitterService twitterService = new MockTwitterService();
       CodeTrendService service = new CodeTrendService(twitterService);
       String [] input = new String[]{"Java", "C#", "Scala"};
       CodeTrendViewModel viewModel = service.getTrends(input);

       assertThat(viewModel.getData()).isNotNull();
       assertThat(viewModel.getData().size()).isEqualTo(3);
       CodeTrendItem item = viewModel.getData().get(0);
       CodeTrendItem secondItem = viewModel.getData().get(1);

       assertThat(item.getLanguage()).isEqualTo("Java");
       assertThat(secondItem.getLanguage()).isEqualTo("C#");





   }


}
