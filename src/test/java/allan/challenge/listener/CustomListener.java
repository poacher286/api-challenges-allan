package allan.challenge.listener;

import allan.challenge.base.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends TestBase implements ITestListener {

    public synchronized void onTestStart(ITestResult result) {
        test = report.createTest(result.getInstanceName());
        test.log(Status.INFO, result.getInstanceName() + " Has Started");
    }

    public void onTestSuccess(ITestResult result) {
        report.flush();
    }

    public void onTestFailure(ITestResult result) {
        report.flush();
    }

    public void onTestSkipped(ITestResult result) {
        report.flush();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
//        report.flush();
    }
}
