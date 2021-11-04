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

public class Level_13_Register_Login_Log_Report extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	
	@Parameters({"browser", "url"})
	
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Open browser'" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
	
		emailAddress = getRandomEmail();
		password = "123456";
	}
	
	@Test
	public void Login_01_Register_To_System() {
		log.info("User_01_Register - Step 01: Verify Home page is displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		registerPage.sleepInSecond(3);
		
		log.info("User_01_Register - Step 02: Click to Resgister Link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("User_01_Register - Step 03: Click to Male radio button");
		registerPage.clickToGenderMaleRadioButton(); 
		
		log.info("User_01_Register - Step 04: Enter to Firstname textbox");
		registerPage.inputToFirstNameTextbox("Phong");
		
		log.info("User_01_Register - Step 05: Enter to Lastname textbox");
		registerPage.inputToLastNameTextbox("Nguyen");
		
		log.info("User_01_Register - Step 06: Enter to Email textbox with value" + emailAddress);
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("User_01_Register - Step 07: Enter to Password textbox with value" + password);
		registerPage.inputToPasswordTextbox(password);
		
		log.info("User_01_Register - Step 08: Enter to Confirm Password textbox with value" + password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("User_01_Register - Step 09: Click to Register button");
		registerPage.clickToRegisterButton();
		registerPage.sleepInSecond(3);
		
		log.info("User_01_Register - Step 10: Verify success message is displayed");
		Assert.assertTrue(registerPage.isSuccessMassageDisplayed());
		
		log.info("User_01_Register - Step 11: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("User_01_Register - Step 12: Verify Home Page is displayed");
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_02_Login_To_System() {
		log.info("User_02_Login - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("User_02_Login - Step 02: Enter to Email textbox with value" + emailAddress);
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("User_02_Login - Step 03: Enter to Password textbox with value" + password);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("User_02_Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
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
