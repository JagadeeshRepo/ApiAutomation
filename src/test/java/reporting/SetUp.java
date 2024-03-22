package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class SetUp implements ITestListener {

    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public static String name = "jack";
    private static ExtentReports extentReports;

    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest("Test  Name" + result.getTestClass().getName() + "--" + result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onStart(ITestContext context) {
        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") + "\\reports\\" + fileName;
        extentReports = ExtentReportManager.createInstance(fullReportPath, "Text Api Automation Report", "Test Results");
    }

    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
        }

    }

    public void onTestFailure(ITestResult result){
        ExtentReportManager.logFailDetails(result.getThrowable().getMessage());
        String stackTrace=Arrays.toString(result.getThrowable().getStackTrace());
        ExtentReportManager.logFailDetails(stackTrace);
    }
}
