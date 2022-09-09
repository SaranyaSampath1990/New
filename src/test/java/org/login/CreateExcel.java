package org.login;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcel {
	public static void main(String[] args) throws IOException {
		File file = new File ("E:\\Saranya\\Maven Framework\\create.xlsx");
		FileOutputStream fo = new FileOutputStream(file);
		Workbook wb = new XSSFWorkbook();
		Sheet Sheet1 = wb.createSheet("Sheet1");
		Row row1 = Sheet1.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("Java");
		wb.write(fo); 
	}

}
