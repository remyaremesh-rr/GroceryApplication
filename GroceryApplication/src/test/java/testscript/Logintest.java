package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.LoginPage;
import base.TestNgBase;
import utilities.ExcelUtility;

public class Logintest extends TestNgBase {
	@Test(priority = 1,description = "login with valid credentials")
	public void verifyLoginWithValidCredentials() throws IOException{

		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage();
		loginpage.enterusername(usernameValue);
		loginpage.enterpassword(passwordValue);
		loginpage.clickOnSignin();
		
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	}
	@Test(priority = 2)
	public void verifyLoginWithInvalidUsername() throws IOException {
		String usernameValue=ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(3, 1, "LoginPage");
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));	
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	}
	@Test(priority = 3)
	public void verifyLoginWithValidUsername() throws IOException {
		String usernameValue=ExcelUtility.getStringData(4, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(4, 1, "LoginPage");
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));	
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	}
	@Test(priority = 4)
	public void verifyLoginWithValidPassword() throws IOException {
		String usernameValue=ExcelUtility.getStringData(2, 0 , "LoginPage");
		String passwordValue=ExcelUtility.getStringData(2, 1, "LoginPage");
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));	
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	}

}



