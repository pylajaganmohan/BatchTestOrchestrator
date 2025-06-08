package testFiles;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

@Listeners(Utilities.ReportListener.class)
public class Test3 {
	@Test(groups = "smoke")
	public void test3Method1() {
		System.out.println("test3Method1");
	}

	@Test(groups = "sanity")
	public void test3Method2() {
		System.out.println("test3Method2");
	}

	@Test(groups = "regression")
	public void test3Method3() {
		System.out.println("test3Method3");
	}

	@Test(groups = "smoke")
	public void test3Method4() {
		System.out.println("test3Method4");
	}

	@Test(groups = "smoke")
	public void test3Method5() {
		System.out.println("test3Method5");
	}

	@Test(groups = "sanity")
	public void test3Method6() {
		System.out.println("test3Method6");
		Assert.fail();
	}
}
