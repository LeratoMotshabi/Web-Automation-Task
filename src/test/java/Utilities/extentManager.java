package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Utility class to manage and configure ExtentReports.
 */
public class extentManager {
	
	// Reporter for generating HTML reports
	public static ExtentSparkReporter htmlReporter;
	
	// ExtentReports instance for reporting
	public static ExtentReports extent;
	
	
	public static ExtentReports createInstance(String fileName)
	{
		// Initialize the HTML reporter and configure the HTML report
		htmlReporter = new ExtentSparkReporter(fileName);
		htmlReporter.config().setDocumentTitle("https://www.way2automation.com/angularjs-protractor/webtables/");
		htmlReporter.config().setReportName("Web Automation Task");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		// Initialize the ExtentReports instance and set system information for the report
		extent = new ExtentReports();
		extent.setSystemInfo("Tester:", "Lerato Motshabi");
		extent.setSystemInfo("Enviroment: ", "Windows 10");
		
		// Attach the HTML reporter to the ExtentReports instance
		extent.attachReporter(htmlReporter);
		return extent;
	}

}
