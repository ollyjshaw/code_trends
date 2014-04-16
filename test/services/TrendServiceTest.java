package services;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

import view_models.*;

public class TrendServiceTest {

   @Test
   public void itShouldReturnAViewModelWhenGivenData(){

       CodeTrendAnalytics twitterService = new MockCodeTrendAnalytics();
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
