package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport/extentReport.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setReportName("Test Automation Report");
        sparkReporter.config().setDocumentTitle("Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Testci", "Mahmut Can Saribal");
        extent.setSystemInfo("Tarayici", "Chrome");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("Test Framework", "TestNG");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        test.get().info("Test Started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail("Test Failed: " + result.getThrowable().toString());
        test.get().fail("Stack Trace: " + result.getThrowable().getStackTrace());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }
}
