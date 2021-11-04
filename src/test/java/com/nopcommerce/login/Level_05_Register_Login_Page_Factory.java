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
import pageFactory.nopCommerce.HomePageObject;
import pageFactory.nopCommerce.LoginPageObject;
import pageFactory.nopCommerce.RegisterPageObject;

public class Level_05_Register_Login_Page_Factory extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	
	@Parameters({"browser", "url"})
	
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
	}
	public void initBrowser() {
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		emailAddress = getRandomEmail();
		password = "123456";
	}
	
	@Test
	public void Login_01_Register_To_System() {
		//Mở URL chuyển qua trang home page
		homePage = new HomePageObject(driver);
		
		// Verify Home Page Slider displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		// Click to Register Link => Register Page
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		
		// Click to gerder male radio
		registerPage.clickToGenderMaleRadioButton(); 
		
		// Input to Fristname textbox
		registerPage.inputToFirstNameTextbox("Phong");
		
		// Input to Lastname textbox
		registerPage.inputToLastNameTextbox("Nguyen");
		
		// Input to Email textbox
		registerPage.inputToEmailTextbox(emailAddress);
		
		// Input to Password textbox
		registerPage.inputToPasswordTextbox(password);
		
		// Input to Confirm password textbox
		registerPage.inputToConfirmPasswordTextbox(password);
		
		// Click to register button
		registerPage.clickToRegisterButton();
		
		// Verify success massage hiển thị
		Assert.assertTrue(registerPage.isSuccessMassageDisplayed());
		
		// Click to logout link => Home page
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
		
		// Verify Home Page Silder displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_02_Login_To_System() {
		// Click to Login link
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		// Input to Email Textbox
		loginPage.inputToEmailTextbox(emailAddress);
		
		// Input to Password Textbox
		loginPage.inputToPasswordTextbox(password);
		
		// Click to Login Button => Home page
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		
		// Verify Home Page Logo display
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
		
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

}
