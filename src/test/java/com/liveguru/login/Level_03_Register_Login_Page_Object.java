package com.liveguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginPageObject;
import pageObjects.liveguru.MyDashboardPageObject;

public class Level_03_Register_Login_Page_Object {
	WebDriver driver;
	String emailAddress, password;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browsersDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		emailAddress = getRandomEmail();
		password = "123456";
	}
	
	@Test
	public void Login_01_Empty_Email_And_Password() {
		//Mở URL chuyển qua trang home page
		driver.get("http://demo.guru99.com/v4/");
		homePage = new HomePageObject(driver);
		
		//Click vào My Account -> Login Page
		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");
			
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.inputToEmailTextbox("123@123.123");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address.");
	}
	
	@Test
	public void Login_03_Invalid_Password() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.inputToEmailTextbox("phong@gmail.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters.");
	}
	
	@Test
	public void Login_04_Incorrect_Email() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.inputToEmailTextbox(getRandomEmail());
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password");
	}
	
	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.inputToEmailTextbox("phong@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password");
	}
	
	@Test
	public void Login_06_Valid_Email_And_Password() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.inputToEmailTextbox("phong@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		
		// Login -> My dashboard
		myDashboardPage = new MyDashboardPageObject(driver);
		
		Assert.assertTrue(myDashboardPage.isMyDashboardHeaderDisplayed());
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
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	

}
