package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AdminPage {
	public WebDriver driver;
	
   public AdminPage(WebDriver driver) {
	  this.driver=driver; 
	  PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminmoreinfo;
   public void clickAdminMoreifo() {
		//WebElement adminmoreinfo=driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		adminmoreinfo.click();
   }
   
   @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
   public void clickNewButton() {
	 //  WebElement newbutton=driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-danger']"));
		newbutton.click();
   }
   
   @FindBy(xpath = "//input[@id='username']") WebElement username_input;
   public void enterUsername(String randomname ) {
	  // WebElement username_input=driver.findElement(By.xpath("//input[@id='username']"));
		username_input.sendKeys(randomname);
   }
   
   @FindBy(xpath = "//input[@id='password']")WebElement password_input;
   public void enterPassword(String randompassword ) {
	   //WebElement password_input=driver.findElement(By.xpath("//input[@id='password']"));
	password_input.sendKeys(randompassword);
   }
   
   @FindBy(xpath = "//select[@name='user_type']")WebElement usertypedropdown;
   public void selectUserTypedropdwon(String userType) {
	   //WebElement usertypedropdown=driver.findElement(By.xpath("//select[@name='user_type']"));
	   Select select=new Select(usertypedropdown);
	   select.selectByVisibleText(userType);
   }
   
   @FindBy(xpath = "//button[@name='Create']")WebElement savebutton;
   public void clickSaveButtob() {
	  // WebElement savebutton=driver.findElement(By.xpath("//button[@name='Create']"));
	   savebutton.click();
	 
   }
   
   @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement addUserAlert;
  public boolean isAlertDisplayed() {
	 return addUserAlert.isDisplayed();
  }
  
}