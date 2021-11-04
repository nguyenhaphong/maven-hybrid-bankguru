package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_Login_Base_Page_1 extends BasePage {
	WebDriver driver;
	String username, password, loginPageUrl;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browsersDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/v4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void Login_01_Register_To_System() {
		loginPageUrl = getPageUrl(driver);
		clickToElement(driver, "//a[text()='here']");
		sendKeyToElement(driver, "//input[@name='emailid']", getRandomEmail());
		clickToElement(driver, "//input[@name='btnLogin']");
		username = getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = getElementText(driver, "//td[text()='Password :']/following-sibling::td");
		
	}
	
	@Test
	public void Login_02_Login_To_System() {
		openPageUrl(driver, loginPageUrl);
		sendKeyToElement(driver, "//input[@name='uid']", username);
		sendKeyToElement(driver, "//input[@name='password']", password);
		clickToElement(driver, "//input[@name='btnLogin']");
		Assert.assertEquals(getElementText(driver, "//marquee[@class='heading3']"), "Welcome To Manager's Page of Guru99 Bank");

	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
		
	}
	
	public String getRandomEmail() {
		Random rand = new Random();
		rand.nextInt(99999);
		return "testing" + rand.nextInt(99999) + "@gmail.com";
	}

}
