package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();//static instance of extentreports that can be shared accross the application

	public synchronized static ExtentReports createExtentReports() {
		//Creates an instance of the reporter that will generate the HTML report in the path "./extent-reports/extent-report.html".
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");//folder creation
		reporter.config().setReportName("7R Mart SuperMarket");//report name is 7R Mart SuperMarkt
		extentReports.attachReporter(reporter);// folder and report names are attached to the class extentsreports
		extentReports.setSystemInfo("Organization", "Obsqura");//set name of organization
		extentReports.setSystemInfo("Name", " Remya"); //provides context of the report
		return extentReports;
	}

}
