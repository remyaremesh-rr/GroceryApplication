package Pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility waitutility = new WaitUtility();
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//input[@name='username']") WebElement username;
	public LoginPage enterusername(String usernameValue) {
		//WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		//username.sendKeys(usernameValue);
		pageutility.sendDataToElement(username, usernameValue);
		return this;// to return
	}
	@FindBy(xpath ="//input[@name='password']") WebElement password;
	public LoginPage enterpassword(String passwordValue) {
		//WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		return this;// to return
	}
	@FindBy(xpath ="//button[@name='Submit']") WebElement login;
	public HomePage clickOnSignin() {
		//WebElement login = driver.findElement(By.xpath("//button[@text()='Submit']"));
		//login.click();
		waitutility.waitUntilClickable(driver, login);
		pageutility.clickElement(login);
		return new HomePage(driver);//to return object of HomePage
		
	}
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")WebElement loginAlert;
	public boolean isLoginAlertDisplayed() {
		
		return loginAlert.isDisplayed();
	}
	
		

}
