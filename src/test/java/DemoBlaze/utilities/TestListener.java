package DemoBlaze.utilities;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed - Taking Screenshot");

        WebDriver driver = BaseTest.getDriver();

        String path = ScreenshotUtil.captureScreenshot(
                driver,
                result.getMethod().getMethodName()
        );

        System.out.println("Screenshot path: " + path);

        extentTest.get().fail(result.getThrowable());
        extentTest.get().addScreenCaptureFromPath(path);
    }


    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
