package Pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//input[@name='username']") WebElement username;
	public void enterusername(String usernameValue) {
		//WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
	}
	@FindBy(xpath ="//input[@name='password']") WebElement password;
	public void enterpassword(String passwordValue) {
		//WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
	}
	@FindBy(xpath ="//button[@name='Submit']") WebElement login;
	public void clickOnSignin() {
		//WebElement login = driver.findElement(By.xpath("//button[@text()='Submit']"));
		login.click();
		
	}
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")WebElement loginAlert;
	public boolean isLoginAlertDisplayed() {
		
		return loginAlert.isDisplayed();
	}
	
		

}
