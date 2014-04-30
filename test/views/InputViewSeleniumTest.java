package views;

import static org.junit.Assert.*;

import org.junit.Test;

import utilities.BaseTestApplication;
import utilities.InputFormHelper;
import utilities.WebDriverHelper;

public class InputViewSeleniumTest extends BaseTestApplication{
	
	InputFormHelper inputFormHelper = new InputFormHelper();
	WebDriverHelper webDriverHelper = new WebDriverHelper();
	
	@Test
	public void checkInputViewHasTitle() {
		driver.get(DEFAULT_URL);
		assertEquals(driver.getTitle(), "title for input view");
	}
	
	@Test
	public void submitLanguageFormSuccess() {
		driver.get(DEFAULT_URL);
		
		inputFormHelper.populateDefaultLaguageDetails(driver);
		inputFormHelper.clickSubmitButton(driver);
		 
		assertEquals(driver.getTitle(), "Code Trend Results");
	}
}
