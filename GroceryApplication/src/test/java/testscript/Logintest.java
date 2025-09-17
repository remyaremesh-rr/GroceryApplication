package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.HomePage;
import base.TestNgBase;
import constant.Constants;
import constant.Messages;
import utilities.ExcelUtility;

public class Logintest extends TestNgBase {
HomePage homepage;// declaration before testcase
	@Test(priority = 1, description = "login with valid credentials,retryAnalyzer = retry.Retry.class")
	public void verifyLoginWithValidCredentials() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(usernameValue).enterpassword(passwordValue);// combined 2 methods of username and password
		homepage = loginpage.clickOnSignin();
		String actual = driver.getCurrentUrl();
		System.out.println(actual);
		String expected = "https://groceryapp.uniqassosiates.com/admin";
		Assert.assertEquals(actual, expected,Messages.VALIDCREDENTIALSERROR);//

	}

	@Test(priority = 2, description = "Login With Valid Username Invalid Password",groups = {"smoke"})
	public void verifyLoginWithValidUsernameInvalidpassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(2, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(2, 1, Constants.LOGINSHEET);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(usernameValue).enterpassword(passwordValue).clickOnSignin();
		boolean isloginalertdisplayed = loginpage.isLoginAlertDisplayed();
		Assert.assertTrue(isloginalertdisplayed, "Valid Username Invalid Password functionality failed");
 
	}

	@Test(priority = 3, description = "Login With Invalid Username Valid Password")

	public void verifyLoginWithInvalidUsernameValidpassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(3, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(3, 1, Constants.LOGINSHEET);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(usernameValue).enterpassword(passwordValue).clickOnSignin();
		boolean isloginalertdisplayed = loginpage.isLoginAlertDisplayed();
		Assert.assertTrue(isloginalertdisplayed,"Login With Invalid Username Valid Password functionality failed");

	}

	@Test(priority = 4, description = "Login With Invalid Username Invalid Password",dataProvider = "loginProvider")
	public void verifyLoginWithInvalidUsernameInvalidpassword(String usernameValue, String passwordValue) throws IOException {
		//String usernameValue = ExcelUtility.getStringData(4, 0, Constants.LOGINSHEET);
		//String passwordValue = ExcelUtility.getStringData(4, 1, Constants.LOGINSHEET);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterusername(usernameValue).enterpassword(passwordValue).clickOnSignin();
		boolean isloginalertdisplayed = loginpage.isLoginAlertDisplayed();
		Assert.assertTrue(isloginalertdisplayed,"Login With Invalid Username Invalid Password functionality failed");

	}
	@DataProvider(name="loginProvider")//testing providing annotation @Dataprovider and we call it as login provider
	public Object[][] getDataFromDataProvider() throws IOException//2D arraay object is returned
	{
		return new Object[][] { new Object[] {"user","password"},// 2 parameter passed
			new Object[] {"username","pass"},
			new Object[] {"user","password"}
		};
	}
}
