package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestNgBase;
import utilities.ExcelUtility;

public class HomeTest extends TestNgBase{

@Test
public void verifyLogOut() throws IOException	 {
	
	String usernameValue=ExcelUtility.getStringData(1, 0, "LoginPage");
	String passwordValue=ExcelUtility.getStringData(1, 1, "LoginPage");
	WebElement username = driver.findElement(By.xpath("//input[@name='username']"));	
	username.sendKeys(usernameValue);
	WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordValue);
	WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
	login.click();
	WebElement adminIcon = driver.findElement(By.xpath("//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']"));
	adminIcon.click();
	WebElement logOut = driver.findElement(By.xpath("//i[@class='ace-icon fa fa-power-off']"));
	logOut.click();
	}
}

