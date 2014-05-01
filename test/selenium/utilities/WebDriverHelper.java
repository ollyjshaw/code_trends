package selenium.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverHelper {
	
	public void navigateToUrl(WebDriver driver, String url){	
		driver.get(url);
	}
	
	public WebElement findWebElementByName(WebDriver driver, String name) {
		return driver.findElement(By.name(name));
	}
	
	public WebElement findWebElementById(WebDriver driver, String id){
		return driver.findElement(By.id(id));
	}
	
	public void clearAndPopulateTextFieldByName(WebDriver driver, String name, String sendText) {
		WebElement webElement = findWebElementByName(driver, name);
		webElement.clear();
		webElement.sendKeys(sendText);
	}
}
