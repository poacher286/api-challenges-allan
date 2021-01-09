package allan.challenge.base;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase  {

    static ExtentTest test;
    static ExtentReports report;
    static ExtentHtmlReporter reporter;

    @BeforeTest
    public static void startReport(ITestContext iTestContext) {
        reporter = new ExtentHtmlReporter("./reports/Run_" + System.currentTimeMillis() + "Report.html");
        report = new ExtentReports();
        report.attachReporter(reporter);
        test = report.createTest(iTestContext.getName());
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed is " + result.getName());
            test.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped is " + result.getName());
        }
    }

    @AfterTest
    public void endReport() {
        report.flush();
    }
}
