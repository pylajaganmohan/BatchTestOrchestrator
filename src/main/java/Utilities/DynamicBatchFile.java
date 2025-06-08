package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class DynamicBatchFile {
	public static void main(String[] args) throws Exception {
		// Path to your Excel file
		String excelPath = System.getProperty("user.dir") + "\\testdata\\TestExecution.xlsx";
		FileInputStream fis = new FileInputStream(new File(excelPath));
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);

		// Create batch file writer
		FileWriter writer = new FileWriter(System.getProperty("user.dir") + "\\runTests.bat");
		writer.write("@echo off\n"); // Start the batch file
		writer.write("cd " + System.getProperty("user.dir")+"\n");

		for (Row row : sheet) {
			if (row.getRowNum() == 0)
				continue; // Skip header

			Cell specCell = row.getCell(0); // Test class name
			Cell flagCell = row.getCell(1); // Yes/No

			if (specCell == null || flagCell == null)
				continue;

			String className = specCell.getStringCellValue().trim();
			String shouldRun = flagCell.getStringCellValue().trim();

			if ("Yes".equalsIgnoreCase(shouldRun)) {
				writer.write("CALL mvn test -Dtest=testFiles." + className + "\n");
			}
		}

		workbook.close();
		writer.close();

		System.out.println("✅ runTests.bat generated successfully based on Excel input.");
	}
}