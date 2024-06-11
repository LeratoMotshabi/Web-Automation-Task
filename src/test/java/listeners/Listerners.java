package listeners;

import java.util.Date;

/**
 * Listerners class implements ITestListener to provide custom logging and reporting
 * for TestNG test cases using ExtentReports.
 */

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.extentManager;

public class Listerners implements ITestListener {
	
	// Date object to generate unique report file names
	public static Date date = new Date();
	// Formatting the date to use in the report file name
	static String dateF = date.toString().replace(":", "_").toString().replace(" ", "_");
	// File path for the extent report
	public static String file = System.getProperty("user.dir") +"/src/test/resources/reports/" + dateF +".html";
	// ExtentReports instance for generating reports
	public static ExtentReports extent = extentManager.createInstance(file);
	// ThreadLocal variable to handle parallel execution of tests
	public static  ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	

	// Create a new test in the report and set it to the current thread
	public void onTestStart(ITestResult result) {
		
		ExtentTest testReport = extent.createTest(" @TEST CASE " + result.getMethod().getMethodName());
		test.set(testReport);
	}

	// Log the test success with a green label
	public void onTestSuccess(ITestResult result) {
		
		
		Markup m = MarkupHelper.createLabel(result.getName() + ": PASSES ", ExtentColor.GREEN);
		test.get().pass(m);
	}

	// Log the test fail with a red label and the exception message
	public void onTestFailure(ITestResult result) {
		//get exception details
		String detatils = result.getThrowable().getMessage();
		String getThrowable = "<details><summary><font color=red>" + "Exception occured: Click to see more"
				+ "</font></summary> <p>" + detatils.replaceAll(",", "<br>") + "</p></details>";
		
		Markup m = MarkupHelper.createLabel(result.getName() + ": PASSES ", ExtentColor.RED);
		test.get().fail(m);
		test.get().fail(getThrowable);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	//flushes the extent reporters
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	

}
