package testFiles;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.ReportListener.class)
public class Test2 {

	@Test(groups = "smoke")
	public void test2Method1() {
		System.out.println("test2Method1");
	}

	@Test(groups = "sanity")
	public void test2Method2() {
		System.out.println("test2Method2");
	}

	@Test(groups = "regression")
	public void test2Method3() {
		System.out.println("test2Method3");
	}

	@Test(groups = "smoke")
	public void test2Method4() {
		System.out.println("test2Method4");
	}

	@Test(groups = "smoke")
	public void test2Method5() {
		System.out.println("test2Method5");
	}

	@Test(groups = "sanity")
	public void test2Method6() {
		System.out.println("test2Method6");
	}
}
