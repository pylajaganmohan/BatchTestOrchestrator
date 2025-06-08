package Utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportListener implements ITestListener {
	private ExtentReports extent;
	private ExtentTest test;
	private String reportPath;
	private RetryLogic retryAnalyzer = new RetryLogic(); // Initialize retry logic

	@Override
	public void onStart(ITestContext context) {
		// String className = context.getAllTestMethods()[0].getTestClass().getName();
		String className = context.getAllTestMethods()[0].getTestClass().getRealClass().getSimpleName();
		reportPath = System.getProperty("user.dir") + "\\reports\\" + className + "_Report.html";

		// Ensure reports directory exists
		new File(System.getProperty("user.dir") + "\\reports").mkdirs();

		if (extent == null) { // ✅ Initialize ExtentReports only once
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
		}

	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getName() + " PASSED.");
		extent.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (retryAnalyzer.retry(result)) {
			int retryAttempt = retryAnalyzer.getRetryCount();
			test.warning("🔄 Retrying " + result.getName() + " | Attempt " + retryAttempt);
			result.setStatus(ITestResult.SKIP); // Temporarily mark skipped for retry
		} else {
			test.fail("❌ " + result.getName() + " FAILED after max retries.");

			// ✅ Explicitly remove "Skipped" status and enforce failure
			result.setStatus(ITestResult.FAILURE);
			result.getTestContext().getFailedTests().removeResult(result); // ✅ Remove previous "Skipped" entry
			result.getTestContext().getFailedTests().addResult(result); // ✅ Add the correct "Failure" result

			System.out.println("❌ Final Failure: " + result.getName());
		}
		extent.flush();
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("✅ Report generated: " + reportPath);
	}
}