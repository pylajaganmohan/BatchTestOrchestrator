package testFiles;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.ReportListener.class)
public class Test1 {
	
	@BeforeMethod
	public void beforeMethodTest() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethodTest() {
		System.out.println("After Method");
	}
	
	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void afterTestMethod() {
		System.out.println("After Test");
	}
	
	@BeforeSuite
	public void beforeSuiteMethod() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void afterSuiteMethod() {
		System.out.println("After Suite");
	}
	
	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void afterClassMethod() {
		System.out.println("After Class");
	}
	
	@Test(groups="regression")
	public void testMethod1() {
		System.out.println("Test Method 1");
	}
	
	@Test(groups="sanity")
	public void testMethod2() {
		System.out.println("Test Method 2");
	}
	
	@Test(groups="smoke")
	public void testMethod3() {
		System.out.println("Test Method 3");
	}
	
}
