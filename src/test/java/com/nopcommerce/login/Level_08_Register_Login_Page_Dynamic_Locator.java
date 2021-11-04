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

public class Level_08_Register_Login_Page_Dynamic_Locator extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	
	@Parameters({"browser", "url"})
	
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
	
		emailAddress = getRandomEmail();
		password = "123456";
	}
	
	@Test
	public void Login_01_Register_To_System() {
		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToGenderMaleRadioButton(); 
		registerPage.inputToFirstNameTextbox("Phong");
		registerPage.inputToLastNameTextbox("Nguyen");
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMassageDisplayed());
		
		homePage = registerPage.clickToLogoutLink();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_02_Login_To_System() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	@Test
	public void Login_03_Open_Page_At_Footer() {
		// Home Page => Search Page
		searchPage = (SearchPageObject) homePage.getFooterPageByName(driver, "Search");
		
		// Search Page => My Account Page
		myAccountPage = (MyAccountPageObject) homePage.getFooterPageByName(driver, "My account");
		
		// My Account Page => Order Page
		orderPage = (OrderPageObject) homePage.getFooterPageByName(driver, "Orders");
		
		// Order Page => My Account
		myAccountPage = (MyAccountPageObject) homePage.getFooterPageByName(driver, "My account");
		
		// My Account => Search Page
		searchPage = (SearchPageObject) homePage.getFooterPageByName(driver, "Search");
		
		// Search page => Order Page
		orderPage = (OrderPageObject) homePage.getFooterPageByName(driver, "Orders");
	
	}
	
	@Test
	public void Login_04_Open_Page_At_Footer() {
		// Order Page => My Account
		orderPage.openFooterPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		// My Account => Search Page
		myAccountPage.getFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		// Search page => Order Page
		searchPage.openFooterPageByName(driver, "Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);
	
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
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;
}
