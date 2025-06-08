package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {
	private int retryCount = 0;
	private static final int maxRetryCount = 2; // Set max retries

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			System.out.println("🔄 Retrying test: " + result.getName() + " | Attempt " + retryCount);
			return true;
		}
		return false;
	}

	public int getRetryCount() {
		return retryCount;
	}
}
