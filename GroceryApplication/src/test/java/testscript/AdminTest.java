package testscript;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestNgBase;
import constant.Constants;
import constant.Messages;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNgBase{
	HomePage homepage;
	AdminPage adminpage;
	@Test(description="AddUser functionality")
	public void verifyAddUser() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1,Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue);
		homepage=loginpage.clickOnSignin();
		adminpage=homepage.clickAdminMoreifo();// this method is moved to homepage
		FakerUtility fakerUtility = new FakerUtility();
		String randomname=fakerUtility.createRandomUserName();
		String randompassword=fakerUtility.createRandomPassword();
		String userType=ExcelUtility.getStringData(1, 2,Constants.HOMESHEET);
		adminpage.clickNewButton().enterUsername(randomname).enterPassword(randompassword).selectUserTypedropdwon(userType).clickSaveButton();
		boolean isDisplayed=adminpage.isAlertDisplayed();
		Assert.assertTrue(isDisplayed,Messages.USERNOTADDEDERROR);
		}

}