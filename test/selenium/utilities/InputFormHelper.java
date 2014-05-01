package selenium.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputFormHelper {

    // Default form values
    public final String LANGUAGE1_DEFAULT = "Java";
    public final String LANGUAGE2_DEFAULT = "C#";
    public final String LANGUAGE3_DEFAULT = "Scala";

    // Default form ids
    public static final String LANGUAGE1_ID = "language1";
    public static final String LANGUAGE2_ID = "language2";
    public static final String LANGUAGE3_ID = "language3";
    public static final String BUTTON_ID = "view_trends";

    public static WebDriverHelper webDriverHelper = new WebDriverHelper();

    public void populateInputFormTextFields(WebDriver driver, String language1,
            String language2, String language3) {

        webDriverHelper.clearAndPopulateTextFieldByName(driver, LANGUAGE1_ID,
                language1);
        webDriverHelper.clearAndPopulateTextFieldByName(driver, LANGUAGE2_ID,
                language2);
        webDriverHelper.clearAndPopulateTextFieldByName(driver, LANGUAGE3_ID,
                language3);
    }

    public void populateDefaultLaguageDetails(WebDriver driver) {

        populateInputFormTextFields(driver, LANGUAGE1_DEFAULT,
                LANGUAGE2_DEFAULT, LANGUAGE3_DEFAULT);
    }

    public void clickSubmitButton(WebDriver driver) {

        driver.findElement(By.id(BUTTON_ID)).click();
    }

}
