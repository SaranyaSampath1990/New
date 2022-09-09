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

public class Task1 {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		WebElement fname = driver.findElement(By.id("firstName"));
		WebElement lname = driver.findElement(By.id("lastName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement gender = driver.findElement(By.xpath("(//input[@name='gender'])[2]"));
		WebElement phone = driver.findElement(By.id("userNumber"));
		WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
		WebElement subject = driver.findElement(By.id("subjectsContainer"));
		WebElement hobbies = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		WebElement address = driver.findElement(By.tagName("textarea"));
		
		File file = new File("E:\\Saranya\\Maven Framework\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fis);
		Sheet sheet = w.getSheet("Sheet2");
		
		Row row = sheet.getRow(0);
		Cell name = row.getCell(0);
		String firstname = name.getStringCellValue();
		System.out.println(firstname);
		fname.sendKeys(firstname);
		
		Cell name1 = row.getCell(1);
		String lastname = name1.getStringCellValue();
		lname.sendKeys(lastname);
		
		Cell mail = row.getCell(2);
		String mailid = mail.getStringCellValue();
		System.out.println(mailid);
		email.sendKeys(mailid);
		
		gender.click();
		
		Cell num = row.getCell(3);
		double phno = num.getNumericCellValue();
		String ph = String.valueOf(phno);
		phone.sendKeys(ph);
		
		//Cell date = row.getCell(4);
		//String dateofbirth = date.getStringCellValue();
		//dob.sendKeys(dateofbirth);
		
		Cell sub = row.getCell(5);
		String subj = sub.getStringCellValue();
		subject.sendKeys(subj);
		
		hobbies.click();
		
		Cell add = row.getCell(6);
		String ad = add.getStringCellValue();
		address.sendKeys(ad);
		
		Thread.sleep(4000);
		driver.close();
	}

}
