package testscript;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TestNgBase;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNgBase {
	
	// retry is applied here as this is a flaky test case
    HomePage homepage; // object declaration, space wont create here
	@Test(priority = 1, description = "login with valid credentials",retryAnalyzer = retry.Retry.class)
	public void verifyLoginWithValidCredentials() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(1, 1, Constants.LOGINSHEET);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue);// chaining of methods
		homepage=loginpage.clickOnSignin(); // chaining of classes. 
		String actual = driver.getCurrentUrl();
		String expected = "https://groceryapp.uniqassosiates.com/admin";
		Assert.assertEquals(actual, expected, Messages.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "Login With Valid Username Invalid Password",groups = {"smoke"}) //groups = {"smoke"} to select test cases to run for smoke/sanity/regression
	public void verifyLoginWithValidUsernameInvalidpassword() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(2, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(2, 1, Constants.LOGINSHEET);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue).clickOnSignin();
		boolean isloginalertdisplayed = loginpage.isLoginAlertDisplayed();
		Assert.assertTrue(isloginalertdisplayed,Messages.INVALIDUSERNAMEVALIDPASSWORDERROR); 
	}

	@Test(priority = 3, description = "Login With Invalid Username Valid Password")

	public void verifyLoginWithInvalidUsernameValidpassword() throws IOException {
		String usernameValue = ExcelUtility.getStringData(3, 0, Constants.LOGINSHEET);
		String passwordValue = ExcelUtility.getStringData(3, 1, Constants.LOGINSHEET);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue).clickOnSignin();
		boolean isloginalertdisplayed = loginpage.isLoginAlertDisplayed();
		Assert.assertTrue(isloginalertdisplayed,Messages.INVALIDUSERNAMEVALIDPASSWORDERROR);

	}

	@Test(priority = 4, description = "Login With Invalid Username Invalid Password",dataProvider = "loginProvider")
	
	public void verifyLoginWithInvalidUsernameInvalidpassword(String usernameValue,String passwordValue) throws IOException // (String usernameValue,String passwordValue) two parameters to retrieve values from data provider	
{
//		String usernameValue = ExcelUtility.getStringData(4, 0, Constants.LOGINSHEET);
//		String passwordValue = ExcelUtility.getStringData(4, 1, Constants.LOGINSHEET);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue).clickOnSignin();
		boolean isloginalertdisplayed = loginpage.isLoginAlertDisplayed();
		Assert.assertTrue(isloginalertdisplayed,Messages.INVALIDUSERNAMEINVALIDPASSWORDERROR);
	}
	
	// annotation provided by testNg. more coverage 
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][]
		{  
			new Object[] {"user","password"},
			new Object[] {"username","pass"},
			new Object[] {"user1","password1"}
		};
	}
}
