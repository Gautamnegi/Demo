package Udemy.E2Eproject;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener{
	ExtentTest test;                                            
	ExtentReportNG obj= new ExtentReportNG();                   //We are calling getReportObject() method of EXtentReportNG class into Listener class
	ExtentReports extents= obj.getReportObject();               //so that we can use reports method in onteststart method.
																//We can also call method by using classname.methodname if we make getReportobject() method as static
	
	
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();     //we use threadlocal class to make parallel exec. thread safe
	
	@Override
	public void onTestStart(ITestResult result) {
		test= extents.createTest(result.getMethod().getMethodName());                //this test is now entry for our testcase and we can use it for logging in pass or fail in our reports
		extentTest.set(test);                                                        //using this to set test obj to thread locall pool
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//test.log(Status.PASS, "Test passed");
		extentTest.get().log(Status.PASS, "Test passed");                //now as we are using threadlocall for thread safe exec, so we will use obj of thread
																		 //-local class to use functions of extent test object
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//test.fail(result.getThrowable());                    //this will send failed log to our reports
	    extentTest.get().fail(result.getThrowable());          //same using obj of thread locall class
		
		WebDriver driver = null;
		
		String testMethodName= result.getMethod().getMethodName();
		
		
		
			 try {
				driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			 try {
				//getScreenshot(testMethodName,driver);
				extentTest.get().addScreenCaptureFromPath(getScreenshot(testMethodName,driver));    //this will attach screenshot to reports
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extents.flush();
		
	}
	

}
