package testFiles;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.ExcelUtils;

public class TestDemo {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();

		String filepath = System.getProperty("user.dir") + "//testdata//TestData.xlsx";

		int rows = ExcelUtils.getRowCount(filepath, "Sheet1");
		for (int i = 1; i <= rows; i++) {
			driver.findElement(By.xpath("//a[@class='ico-register']")).click();
			String gender = ExcelUtils.getCellData(filepath, "Sheet1", i, 0);
			String firstName = ExcelUtils.getCellData(filepath, "Sheet1", i, 1);
			String lastName = ExcelUtils.getCellData(filepath, "Sheet1", i, 2);
			String email = ExcelUtils.getCellData(filepath, "Sheet1", i, 3);
			String pwd = ExcelUtils.getCellData(filepath, "Sheet1", i, 4);
			
			if(gender.equalsIgnoreCase("male")) {
				driver.findElement(By.id("gender-male")).click();
			}else {
				driver.findElement(By.id("gender-female")).click();
			}
			
			driver.findElement(By.id("FirstName")).sendKeys(firstName);
			driver.findElement(By.id("LastName")).sendKeys(lastName);
			driver.findElement(By.id("Email")).sendKeys(email);
			driver.findElement(By.id("Password")).sendKeys(pwd);
			driver.findElement(By.id("ConfirmPassword")).sendKeys(pwd);
			
			driver.findElement(By.id("register-button")).click();
			
			driver.findElement(By.cssSelector(".button-1.register-continue-button")).click();
			
			driver.findElement(By.className("ico-logout")).click();
		}
		
		driver.quit();

	}

}
