package pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;	
	PageUtility pageutility=new PageUtility();
	WaitUtility waitutility=new WaitUtility();//explicit wait
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);//this is to refer the current class method. 
	//PageFactory is class
	}
	
	@FindBy(xpath = "//input[@name='username']")WebElement username;
	public LoginPage enterUserName(String usernameValue)
	{
		pageutility.sendDataToElement(username, usernameValue);
		return this;// as login page is the current page, to refer the current class object this keyword is used
	}
	
	@FindBy(xpath = "//input[@name='password']")WebElement password;
	  public LoginPage enterPassword(String passwordValue) {
	  pageutility.sendDataToElement(password,passwordValue);	
	  return this;
	}
    
	@FindBy(xpath = "//button[text()='Sign In']")WebElement loginBtn;
	public HomePage clickOnSignin() {
		waitutility.waitUntilClickable(driver, loginBtn); //explicit wait
		pageutility.clickElement(loginBtn);
		return new HomePage(driver);// Home page is another class, created object for Homepage
	
	}
	
	////assertion web element and method
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")WebElement loginAlert;
	public boolean isLoginAlertDisplayed()
	{
		return loginAlert.isDisplayed();
	}
	
}
