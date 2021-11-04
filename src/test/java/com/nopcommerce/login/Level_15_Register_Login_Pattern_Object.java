package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.MyAccountPageObject;
import pageObjects.user.nopCommerce.OrderPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;

public class Level_15_Register_Login_Pattern_Object extends BaseTest {
	WebDriver driver;
	String emailAddress, password, date, month, year;
	
	@Parameters({"browser", "url"})
	
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser'" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
	
		emailAddress = getRandomEmail();
		password = "123456";
		date = "8";
		month = "3";
		year = "2021";
	}
	
	@Test
	public void Login_01_Register_To_System() {
		log.info("User_01_Register - Step 01: Verify Home page is displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		registerPage.sleepInSecond(3);
		
		log.info("User_01_Register - Step 02: Click to Resgister Link");
		homePage.openHeaderPageByName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("User_01_Register - Step 03: Click to Male radio button");
		registerPage.clickToRadioButtonByID(driver, "gender-male");
		
		log.info("User_01_Register - Step 04: Enter to Firstname textbox");
		registerPage.enterToTextboxByID(driver, "FirstName", "Nguyen");
		
		log.info("User_01_Register - Step 05: Enter to Lastname textbox");
		registerPage.enterToTextboxByID(driver, "LastName", "Phong");
		
		log.info("User_01_Register - Step 06: Enter to Email textbox with value" + emailAddress);
		registerPage.enterToTextboxByID(driver, "Email", emailAddress);
		
		log.info("User_01_Register - Step 07: Enter to Password textbox with value" + password);
		registerPage.enterToTextboxByID(driver, "Password", password);
		
		log.info("User_01_Register - Step 08: Enter to Confirm Password textbox with value" + password);
		registerPage.enterToTextboxByID(driver, "ConfirmPassword", password);
		
		log.info("User_01_Register - Step 09: Select item in Date dropdown");
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
		
		log.info("User_01_Register - Step 10: Select item in Month dropdown");
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
		log.info("User_01_Register - Step 11: Select item in Year dropdown");
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("User_01_Register - Step 12: Click to Register button");
		registerPage.clickToButtonByText(driver, "Register");
		
		log.info("User_01_Register - Step 13: Verify success message is displayed");
		Assert.assertTrue(registerPage.isSuccessMassageDisplayed());
		
		log.info("User_01_Register - Step 14: Click to Logout link");
		registerPage.openHeaderPageByName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("User_01_Register - Step 15: Verify Home Page is displayed");
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_02_Login_To_System() {
		log.info("User_02_Login - Step 01: Click to Login link");
		homePage.openHeaderPageByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("User_02_Login - Step 02: Enter to Email textbox with value" + emailAddress);
		loginPage.enterToTextboxByID(driver, "Email", emailAddress);
		
		log.info("User_02_Login - Step 03: Enter to Password textbox with value" + password);
		loginPage.enterToTextboxByID(driver, "Password", password);
		
		log.info("User_02_Login - Step 04: Click to Login button");
		registerPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("User_02_Login - Step 05: Verify Home Page is displayed");
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@AfterClass
	public void cleanBrowser() {
		log.info("Post-Condition: Close browser");
		driver.quit();
		
	}
	
	public String getRandomEmail() {
		Random rand = new Random();
		rand.nextInt(99999);
		return "testing" + rand.nextInt(99999) + "@gmail.com";
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;
}
