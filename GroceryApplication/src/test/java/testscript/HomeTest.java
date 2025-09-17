package testscript;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestNgBase;
import constant.Constants;
import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
public class HomeTest extends TestNgBase {
HomePage homepage;
	@Test(description ="verify Logout functionality")
	public void verifyLogout() throws IOException {
		
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1,  Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
	    loginpage.enterUserName(usernameValue).enterPassword(passwordValue);
		homepage=loginpage.clickOnSignin(); // clickOnSignin() return the home page
		homepage.clickAdminIcon();
		loginpage= homepage.clickLogoutIcon();
		String actual=driver.getCurrentUrl();
		String expected="https://groceryapp.uniqassosiates.com/admin/login";
		Assert.assertEquals(actual,expected,Messages.LOGOUTERROR);
			
	}

}