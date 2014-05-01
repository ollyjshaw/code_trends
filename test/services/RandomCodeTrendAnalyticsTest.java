package services;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;
import models.InputForm;

import org.junit.Test;

import view_models.CodeTrendViewModel;

public class RandomCodeTrendAnalyticsTest {

    @Test
    public void itShouldReturnTrendValueWhenGivenData() {

        CodeTrendAnalytics twitterService = new RandomCodeTrendAnalytics();
        CodeTrendService service = new CodeTrendService(twitterService);
        InputForm form = getSimpleInputForm();
        CodeTrendViewModel viewModel = service.getTrends(form);

        assertThat(viewModel.getData()).isNotNull();

        Double total = 0D;

        for (CodeTrendItem item : viewModel.getData()) {
            total += item.getPopularity();
        }

        assertEquals(100.00, total, 0.1);
    }

    private InputForm getSimpleInputForm() {
        InputForm form = new InputForm();
        form.language1 = "Java";
        form.language2 = "C#";
        form.language3 = "Scala";
        return form;
    }
}
