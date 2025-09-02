package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	public Loginpage(Webdriver driver) {
		this.driver=driver;
	}
	public void enterusername(String usernameValue) {
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
	}
	public void enterpassword(String passwordValue) {
		WebElement password = driver.findElement(By.xpath("//input[@name='username']"));
		password.sendKeys(passwordValue);
	}
	public void clickOnSignin() {
		WebElement loginBtn = driver.findElement(By.xpath("//button[@text()='Sign In']"));
		loginBtn.click();
		
	}
		

}
