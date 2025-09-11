package testscript;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.AdminPage;
import Pages.LoginPage;
import base.TestNgBase;
import constant.Constants;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends TestNgBase{
	@Test(description="AddUser functionality")
	public void verifyAddUser() throws IOException {
		String usernameValue=ExcelUtility.getStringData(1, 0, Constants.LOGINSHEET);
		String passwordValue=ExcelUtility.getStringData(1, 1,Constants.LOGINSHEET);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(usernameValue);
		loginpage.enterpassword(passwordValue);
		loginpage.clickOnSignin();
		AdminPage adminpage=new AdminPage(driver);
		adminpage.clickAdminMoreifo();
		FakerUtility fakerUtility = new FakerUtility();
		String randomname=fakerUtility.createRandomUserName();
		String randompassword=fakerUtility.createRandomPassword();
		String userType=ExcelUtility.getStringData(1, 2,Constants.HOMESHEET);
		adminpage.clickNewButton();
		adminpage.enterUsername(randomname);
		adminpage.enterPassword(randompassword);
		adminpage.selectUserTypedropdwon(userType);
		adminpage.clickSaveButtob();
		boolean isDisplayed=adminpage.isAlertDisplayed();
		Assert.assertTrue(isDisplayed,"user is not added susccessfully");
	}

}
