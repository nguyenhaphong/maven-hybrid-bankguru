package com.facebook.resgiter;

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
import pageObject.facebook.PageGeneratorManager;
import pageObject.facebook.RegisterPageObject;

public class Level_12_Register_Login_Assert_Verify extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	RegisterPageObject registerPage;
	
	@Parameters({"browser", "url"})
	
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		registerPage = PageGeneratorManager.getResgisterPage(driver);

	}
	
	@Test
	public void Register_01_Verify() {
		// Failed lần 1
		verifyFalse(registerPage.isEmailTextboxDisplayed());
		
		registerPage.enterToEmailTextbox("phong@gmail.com");
		
		// Failed lần 2
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		registerPage.enterToEmailTextbox("");
		
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		// Verify lần 3
		verifyFalse(registerPage.isLoginButtonUndisplayed());
	}
	
	@Test
	public void Register_02_Element_Undisplayed_In_Dom() {
		registerPage.enterToEmailTextbox("");
		
		// Undisplayed: Ko hiển thị trên UI nhưng có trong DOM
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());
	}

	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	
	}
	
}
