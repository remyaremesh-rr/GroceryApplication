package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void sendDataToElement(WebElement element,String text) {
		element.sendKeys(text);
	}
	public void clickElement(WebElement element) {
		element.click();
	}
	public void selectDataWithVisibleText(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void scrollToElement(WebDriver driver, WebElement element) {
	    Actions actions=new Actions(driver);
	    actions.moveToElement(element).perform();
	}

	public void clearElementData(WebElement element) {
		element.clear();
	}

}
