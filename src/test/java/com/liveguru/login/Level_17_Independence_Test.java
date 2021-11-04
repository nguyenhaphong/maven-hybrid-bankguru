package com.liveguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginPageObject;
import pageObjects.liveguru.MyDashboardPageObject;

public class Level_17_Independence_Test extends BaseTest{
	WebDriver driver;
	String emailAddress, password;
	 
	@Parameters({"browser", "url"})
	
	@BeforeMethod
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		emailAddress = getRandomEmail();
		password = "123456";
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);
	}
	
	@Test
	public void Login_01_Empty_Email_And_Password() {
		
		loginPage.inputToEmailTextbox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");
			
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		loginPage.inputToEmailTextbox("123@123.123");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address.");
	}
	
	@Test
	public void Login_03_Invalid_Password() {
		loginPage.inputToEmailTextbox("phong@gmail.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters.");
	}
	
	@Test
	public void Login_04_Incorrect_Email() {	
		loginPage.inputToEmailTextbox(getRandomEmail());
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password");
	}
	
	@Test
	public void Login_05_Incorrect_Password() {		
		loginPage.inputToEmailTextbox("phong@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password");
	}
	
	@Test
	public void Login_06_Valid_Email_And_Password() {	
		loginPage.inputToEmailTextbox("phong@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		
		// Login -> My dashboard
		myDashboardPage = new MyDashboardPageObject(driver);
		
		Assert.assertTrue(myDashboardPage.isMyDashboardHeaderDisplayed());
	}
	
	@AfterMethod
	public void afterMethod() {
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
