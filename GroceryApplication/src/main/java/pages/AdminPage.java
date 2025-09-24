package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtility;
import utilities.WaitUtility;


public class AdminPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	WaitUtility waitutility=new WaitUtility();//explicit wait
	
   public AdminPage(WebDriver driver) {
	  this.driver=driver; 
	  PageFactory.initElements(driver, this);
   }
   
  
   @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
   public AdminPage clickNewButton()
   {
	   waitutility.waitUntilClickable(driver, newbutton); //explicit wait
	pageutility.clickElement(newbutton);
	
	return new AdminPage(driver);
   }
   
   @FindBy(xpath = "//input[@id='username']") WebElement username_input;
   public AdminPage enterUsername(String randomname )
   {
	pageutility.sendDataToElement(username_input, randomname);
	return this;
   }
   
   @FindBy(xpath = "//input[@id='password']")WebElement password_input;
   public AdminPage enterPassword(String randompassword )
   {
	pageutility.sendDataToElement(password_input, randompassword);
	return this;
   }
   
   @FindBy(xpath = "//select[@name='user_type']")WebElement usertypedropdown;
   public AdminPage selectUserTypedropdwon(String userType) 
   {
	pageutility.selectDataWithVisibleText(usertypedropdown, userType); 
	return this;
	
   }
   
   @FindBy(xpath = "//button[@name='Create']")WebElement savebutton;
   public AdminPage clickSaveButton() 
   {
	pageutility.clickElement(savebutton);
	return this;
	 
   }
   
 //assertion web element and method
   @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement addUserAlert;
  public boolean isAlertDisplayed()
  {
	 return addUserAlert.isDisplayed();
  }
  
}