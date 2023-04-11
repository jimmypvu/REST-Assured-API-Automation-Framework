package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {
    private static ExtentReports extentReport;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context){
        extentReport = ExtentReportManager.createExtentReport("Test Execution Report - API Tests", "Extent Report - API Tests Report");
    }

    @Override
    public void onTestStart(ITestResult result){
        ExtentTest test = extentReport.createTest(result.getTestClass().getName() + " - " + result.getMethod().getMethodName(), result.getMethod().getDescription());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result){

    }

    @Override
    public void onTestFailure(ITestResult result){
        ExtentReportManager.logFailDetails(result.getThrowable().getMessage());

        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replaceAll(",", "<br>");
        String formattedTrace = "<details>\n" +
                "    <summary>VIEW STACKTRACE & EXCEPTION LOG</summary>\n" +
                "    "+stackTrace+"\n" +
                "</details>";

        ExtentReportManager.logExceptionDetails(formattedTrace);
    }

    @Override
    public void onFinish(ITestContext context){
        if(extentReport != null){
            extentReport.flush();
        }
    }
}
