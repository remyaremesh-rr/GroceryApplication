package base;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ScreenshotUtitity;

public class TestNgBase {
		
	public WebDriver driver;
	
	@BeforeMethod
	
	public void browserInitializer()
	{ 
		//driver = new ChromeDriver(); 
		//driver=new FirefoxDriver();
		
		//ChromeOptions` allows you to customize how Chrome starts — such as setting preferences, enabling headless mode, disabling extensions, etc.
		ChromeOptions options = new ChromeOptions();
		//Create a map that has the key as password leak detection , and value to be false so that leak detect is turned off while launching browser.
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.password_manager_leak_detection", false);
		//Set the above pref as "Experimental option" so that it is reflected in user preferences
		options.setExperimentalOption("prefs", prefs);
		//Launch the driver with customized preference with "options"
		driver = new ChromeDriver(options);
		
		driver.get("https://groceryapp.uniqassosiates.com/admin/login"); 
	  	driver.manage().window().maximize(); 
	  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  	
	  	

	}
	
	@AfterMethod	
	public void quitAndClose() {
	//	driver.close();

	}
	
	// we need run this this after each test case
	// alwaysRun = true : if the testscript fails in the middle of the test case.
    // to ensure the method following is executed before test case is terminted
	//iTestResult= test case pass/fail
	//ITestResult: in built interface provided by testng. which includes all the date of one testcase
	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult iTestResult) throws IOException
	{
		if(iTestResult.getStatus()==ITestResult.FAILURE)
		{
			ScreenshotUtitity screenShot=new ScreenshotUtitity();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();

	}



}