package base;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import constant.Constants;
import utilities.ScreenshotUtility;

public class TestNgBase {
	Properties prop; // defining object  for Properties class
	FileInputStream f;	// defining object  for FileInputStream class,to read a file
	public WebDriver driver;
		@BeforeMethod(alwaysRun = true)
		@Parameters("browser") // this is name="browser" from testng.xml
				
		public void browserInitializer(String browser) throws Exception // String browser= can be any variable name
		{ 	
			prop = new Properties();
			f= new FileInputStream(Constants.CONFIGFILE); //to get the the paths from Constant class
			prop.load(f);// retrieving the config.properties file
			
		   if(browser.equalsIgnoreCase("Chrome"))
		   {
			//ChromeOptions` allows you to customize how Chrome starts — such as setting preferences, enabling headless mode, disabling extensions, etc.
			ChromeOptions options = new ChromeOptions();
			//Create a map that has the key as password leak detection , and value to be false so that leak detect is turned off while launching browser.
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.password_manager_leak_detection", false);
			//Set the above pref as "Experimental option" so that it is reflected in user preferences
			options.setExperimentalOption("prefs", prefs);
			//Launch the driver with customized preference with "options"
			
			driver=new ChromeDriver(options);
			}
			else if(browser.equalsIgnoreCase("Firefox")) 
			{
				driver=new FirefoxDriver();
			}
	        else 
	        {
				throw new Exception("Invalid browser name");
			}
//		driver.get("https://groceryapp.uniqassosiates.com/admin/login"); 
		driver.get(prop.getProperty("url"));// retrieving the login url from config.properties file in main/resource
	  	driver.manage().window().maximize(); 
	  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  	}

	// we need run this this after each test case
	// alwaysRun = true : if the test script fails in the middle of the test case.
  // to ensure the method following is executed before test case is terminated
	//iTestResult= test case pass/fail
	//ITestResult: in built interface provided by testng. which includes all the date of one testcase

	@AfterMethod(alwaysRun = true)
		public void driverQuit(ITestResult iTestResult) throws IOException
	{
		
		if(iTestResult.getStatus()==ITestResult.FAILURE)
		{
			ScreenshotUtility screenShot=new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();

	}

}