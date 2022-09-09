package org.junittask;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	
	public static void launch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public static String title() {
		String title = driver.getTitle();
		return title;
	}
	
	public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public static String pageSource() {
		String pageSource = driver.getPageSource();
		return pageSource;
	}
	
	public static WebElement elementById(String value) {
		WebElement locatebyId = driver.findElement(By.id(value));
		return locatebyId;
	}
	
	public static WebElement elementByname(String name) {
		WebElement locatebyName = driver.findElement(By.name(name));
		return locatebyName;
	}
	
	public static WebElement elementByXpath(String xpath) {
		WebElement locatebyXpath = driver.findElement(By.xpath(xpath));
		return locatebyXpath;
	}
	
	public static WebElement elementByTagName(String tag) {
		WebElement locatebyTag = driver.findElement(By.tagName(tag));
		return locatebyTag;
	}
	
	public static WebElement elementByLink(String link) {
		WebElement locateByLink = driver.findElement(By.linkText(link));
		return locateByLink;
	}
	
	public static WebElement elementByPartialLink(String plink) {
		WebElement partiallink = driver.findElement(By.partialLinkText(plink));
		return partiallink;
	}
	
	public static List<WebElement> elementlist(String list) {
		List<WebElement> list2 = driver.findElements(By.xpath(list));
		return list2;
	}
	
	public static void SingleSelectbByIndex(String sel,int i) {
		WebElement d1 = driver.findElement(By.xpath(sel));
		Select s = new Select(d1);
		s.selectByIndex(i);
	}
	
	public static void SingleSelectByValue(String xpath, String value) {
		WebElement d1 = driver.findElement(By.xpath(xpath));
		Select s = new Select(d1);
		s.selectByValue(value);
	}
	
	public static void SingleSelectByVisibleText(String xpath, String txt) {
		WebElement d1 = driver.findElement(By.xpath(xpath));
		Select s = new Select(d1);
		s.selectByVisibleText(txt);
	}
	
	public static void winHandle() {
		// TODO Auto-generated method stub

	}
	
	public static void winHandles() {
		// TODO Auto-generated method stub

	}
	
	public static void nav() {
		// TODO Auto-generated method stub

	}
	
	public static void ending() {
		driver.close();
	}
	
	public static void getAttribute() {
		// TODO Auto-generated method stub

	}
	
	private void getText() {
		// TODO Auto-generated method stub

	}
	
	public static void click(WebElement btn) {
		btn.click();
	}
	
	public static void sendkeys(WebElement text, String value) {
		text.sendKeys(value);
	}
	
	private void submit() {
		// TODO Auto-generated method stub

	}
	
	private void DropDown() {
		// TODO Auto-generated method stub

	}
	
	private void screenshot() {
		// TODO Auto-generated method stub

	}
	
	private void jsExecutor() {
		// TODO Auto-generated method stub

	}
	
	private void Alert() {
		// TODO Auto-generated method stub

	}
	
	private void frames() {
		// TODO Auto-generated method stub

	}
	
	
}
