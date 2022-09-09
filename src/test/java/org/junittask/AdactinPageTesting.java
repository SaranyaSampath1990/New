package org.junittask;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdactinPageTesting extends BaseClass{
	@BeforeClass
	public static void browserLaunch() throws InterruptedException {
		launch("http://adactinhotelapp.com/HotelAppBuild2/");
		Thread.sleep(3000);
		System.out.println("Page Title: " +title());
		boolean contains = title().contains("Adactin");
		Assert.assertTrue(contains);
		System.out.println("Title Verified");
			
	}
	
	@Test
	public void login() throws InterruptedException {
		WebElement user = elementById("username");
		boolean displayed = user.isDisplayed();
		Assert.assertTrue(displayed);
		System.out.println("Username enabled");
		sendkeys(user, "sara2204");
		
		WebElement pwd = elementById("password");
		boolean displayed2 = pwd.isDisplayed();
		Assert.assertTrue(displayed2);
		System.out.println("Password enabled");
		sendkeys(pwd, "123456");
		
		WebElement loginbtn = elementById("login");
		boolean displayed3 = loginbtn.isDisplayed();
		Assert.assertTrue(displayed3);
		click(loginbtn);
		
		Thread.sleep(3000);
	}
	
	@Before
	public void newUser() throws InterruptedException {
		elementByPartialLink("New User").click();
		WebElement username= elementByname("username");
		sendkeys(username, "sara1234");
		
		WebElement pass= elementByname("password");
		sendkeys(pass, "123456");
		
		WebElement repass = elementByname("re_password");
		sendkeys(repass, "123456");
		
		WebElement name = elementById("full_name");
		sendkeys(name, "Saranya Sampath");
		
		WebElement email = elementById("email_add");
		sendkeys(email, "replytosaranya@gmail.com");
		
		Thread.sleep(3000);
		elementByXpath("//input[@type='checkbox']").click();
		
		elementById("Submit").submit();
		
		Thread.sleep(5000);
		
		String errormsg = elementById("captcha_span").getText();
		boolean empty = errormsg.isEmpty();
		if(!empty) {
			elementByPartialLink("Go back").click();
		}
	}
	
	@After
	public void search() throws InterruptedException {
		SingleSelectByValue("//select[@id='location']", "London");
		SingleSelectbByIndex("//select[@id='hotels']", 2);
		SingleSelectByVisibleText("//select[@id='room_type']", "Deluxe");
		SingleSelectbByIndex("//select[@id='room_nos']", 1);
		elementById("datepick_in").sendKeys("02/09/2022");
		elementById("datepick_out").sendKeys("04/09/2022");
		SingleSelectbByIndex("//select[@id='adult_room']", 1);
		SingleSelectbByIndex("//select[@id='child_room']", 0);
		elementById("Submit").click();
		Thread.sleep(5000);
		
		elementByXpath("//input[@type='radio']").click();
		elementByname("continue").submit();
		
		Thread.sleep(3000);
		
		elementByLink("Logout").click();
	}
	
	
	@AfterClass
	public static void finish() {
		ending();
	}
	
	
	
	
	
	
	
	
	
	
}
