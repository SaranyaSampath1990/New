package org.login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadWriteTable {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		File file = new File("E:\\Saranya\\Maven Framework\\newtask.xlsx");
		FileOutputStream fos = new FileOutputStream(file);
		Workbook w = new XSSFWorkbook();
		Sheet createSheet = w.createSheet("Sheet1");
		
		//locate and read the webtable contents
		WebElement table = driver.findElement(By.xpath("//table[@id='customers']"));
		
		List<WebElement> tablerow = table.findElements(By.tagName("tr"));
		List<WebElement> columns = table.findElements(By.tagName("th"));
		
		int rowsize = tablerow.size();
		int colsize = columns.size();
		
				
		for (int i = 1; i < rowsize; i++) {
			for (int j = 0; j < colsize; j++) {
				Row createRow = createSheet.createRow(i);
				Cell createCell = createRow.createCell(j);
				WebElement thead = columns.get(j);
				String headtxt = thead.getText();
				createCell.setCellValue(headtxt);
				w.write(fos);
						
			}
		}	
		
		driver.close();
	}

}
