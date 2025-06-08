package Utilities;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	public static int getCellCount(String xlfile, String xlsheet, int rowNum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}

//	public static String getCellData(String xlfile, String xlsheet, int rowNum, int colNum) throws IOException {
//		fi = new FileInputStream(xlfile);
//		wb = new XSSFWorkbook(fi);
//		ws = wb.getSheet(xlsheet);
//		row = ws.getRow(rowNum);
//
//		String data;
//		try {
//			//data = cell.toString();
//			DataFormatter formatter = new DataFormatter();
//			data = formatter.formatCellValue(cell);
//		} catch (Exception e) {
//			data = "";
//		}
//		wb.close();
//		fi.close();
//		return data;
//	}

	public static String getCellData(String xlfile, String xlsheet, int rowNum, int colNum) throws IOException {
	    fi = new FileInputStream(xlfile);
	    wb = new XSSFWorkbook(fi);
	    ws = wb.getSheet(xlsheet);
	    row = ws.getRow(rowNum);

	    String data = "";
	    try {
	        if (row != null) {  // Ensure row exists
	            cell = row.getCell(colNum); // 🔴 Get the specific cell first
	            if (cell != null) {  // Ensure cell exists
	                DataFormatter formatter = new DataFormatter();
	                data = formatter.formatCellValue(cell); // 🟢 Now format it
	            }
	        }
	    } catch (Exception e) {
	        data = "";
	    }

	    wb.close();
	    fi.close();
	    return data;
	}

	
	public static void setCellData(String xlfile, String xlsheet, int rowNum, int colNum, String data)
			throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);

		cell = row.createCell(colNum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public static void fillGreenColor(String xlfile, String xlsheet, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	public static void fillRedColor(String xlfile, String xlsheet, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(colNum);
		
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

}
