package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class HomePage {

   public WebDriver driver;
   PageUtility pageutility=new PageUtility();	
   
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement adminIcon;
	public HomePage clickAdminIcon() {
		pageutility.clickElement(adminIcon);
		return this;
	}
	
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")WebElement logoutIcon;
	public LoginPage clickLogoutIcon() {
		pageutility.clickElement(logoutIcon);
		return new LoginPage(driver);
	}
	
	// this method is used to click admin ifo tile-> it will redirect to AdminPage
	 @FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminmoreinfo;
	   public AdminPage clickAdminMoreifo() 
	   {
		pageutility.clickElement(adminmoreinfo);
		return new AdminPage(driver);
	   }
	//to click on the manage news tile   
	   @FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']")WebElement managenewstile;
	   public ManageNewsPage clickManageNewsTile() {
			pageutility.clickElement(managenewstile);
			return new ManageNewsPage(driver) ;
	   }
	   
	   
}