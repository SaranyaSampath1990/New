package org.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

public class BrowserLaunch {
	public static void main(String[] args) throws IOException, InterruptedException {
		//Set the Property of the Browser
		WebDriverManager.chromedriver().setup();
		//Initiate the WebDriver
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		File file = new File("E:\\Saranya\\Maven Framework\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fis);
		Sheet sheet = w.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String stringCellValue = cell.getStringCellValue();
		
		Cell cell2 = row.getCell(1);
		String stringCellValue2 = cell2.getStringCellValue();
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys(stringCellValue);
		
		WebElement pwd = driver.findElement(By.id("pass"));
		pwd.sendKeys(stringCellValue2);
		
		Thread.sleep(3000);
		driver.close();
	}

}
