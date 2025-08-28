package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestNgBase;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNgBase {
	@Test
	public void verifyAddUser() throws IOException {
		//to login
		String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));	
		username.sendKeys(usernameValue);
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(passwordValue);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		//to click more info
		WebElement adminMoreInfo = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']"));
		adminMoreInfo.click();
		//to generate random username and password
		FakerUtility fakerUtility = new FakerUtility();
		String randomname=fakerUtility.createRandomUserName();
		String randompassword=fakerUtility.createRandomPassword();
		String randomuserType=ExcelUtility.getStringData(1, 2,"HomePage");
		
		WebElement newButton = driver.findElement(By.xpath("//a[@class-'btn btn-rounded btn-danger']"));
		newButton.click();
		WebElement usernamefield = driver.findElement(By.xpath("//input[@name='username']"));	
		usernamefield.sendKeys(randomname);
		WebElement passwordfield = driver.findElement(By.xpath("//input[@id='password']"));	
		passwordfield.sendKeys(randompassword);
		WebElement userTypefield = driver.findElement(By.xpath("//select[@id='user_type']"));	
		Select select = new Select(userTypefield);
		select.selectByVisibleText(randomuserType);
		

		}
	
	
	
	}


