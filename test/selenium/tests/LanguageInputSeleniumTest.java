package selenium.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import selenium.utilities.BaseTestApplication;
import selenium.utilities.InputFormHelper;
import selenium.utilities.WebDriverHelper;

public class LanguageInputSeleniumTest extends BaseTestApplication{
	
	InputFormHelper inputFormHelper = new InputFormHelper();
	WebDriverHelper webDriverHelper = new WebDriverHelper();
	
	@Test
	public void loadInputViewPage() {
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
