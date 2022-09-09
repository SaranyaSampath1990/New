package org.baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void setup(String url) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	public static WebElement ElementById(String idvalue) {
		WebElement id = driver.findElement(By.id(idvalue));
		return id;
	}
	
	public static WebElement ElementByName(String name) {
		WebElement byname = driver.findElement(By.name(name));
		return byname;
	}
	
	public static WebElement  ElementByXpath(String xpath) {
		WebElement byXpath = driver.findElement(By.xpath(xpath));
		return byXpath;
	}
	
	
	public void EndTest() {
		driver.close();
	}

}
