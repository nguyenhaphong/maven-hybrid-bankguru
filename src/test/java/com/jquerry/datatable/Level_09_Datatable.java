package com.jquerry.datatable;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_09_Datatable extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	
	public void Table_01_Paging() {
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActivedByNumber("15"));
		
		homePage.openPageByNumber("20");
		Assert.assertTrue(homePage.isPageActivedByNumber("20"));

		homePage.openPageByNumber("10");
		Assert.assertTrue(homePage.isPageActivedByNumber("20"));
		
	}
	
	public void Table_02_Action() {
		// Input to textbox
  		homePage.inputToHeaderTextboxByName("Females", "434000");
  		homePage.sleepInSecond(3);
  		
		homePage.inputToHeaderTextboxByName("Males", "45100");
		homePage.sleepInSecond(3);
		
		homePage.inputToHeaderTextboxByName("Country", "Viet Nam");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
	}
	
	
	public void Table_03_Input_Header_Textbox() {
	
		// Click to icon
		homePage.clickToIconByCountryName("AFRICA", "remove");
		homePage.sleepInSecond(3);
		
		homePage.clickToIconByCountryName("Afghanistan", "edit");
		homePage.sleepInSecond(3);
	}	
		
	public void Table_04_Verify_Row_Values() {
		homePage.inputToHeaderTextboxByName("Country", "Afghanistan");
		Assert.assertTrue(homePage.isRowValueDisplayed("384187","Afghanistan","407124","791312"));
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextboxByName("Country", "Australia");
		Assert.assertTrue(homePage.isRowValueDisplayed("145412","Australia","154696","300109"));
		Assert.assertTrue(homePage.isRowValueDisplayed("175157","Australia/New Zealand","186032","361190"));
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
	}
	
	
	public void Table_05_Input_To_Row_Textbox() {
		homePage.inputToTextboxByRowNumber("Contact Person", "3", "Phong");
		homePage.sleepInSecond(3);
		
		homePage.inputToTextboxByRowNumber("Order Placed", "1", "5");
		homePage.sleepInSecond(3);
		
		homePage.inputToTextboxByRowNumber("Company", "2", "Apple");
		homePage.sleepInSecond(3);
		
		homePage.inputToTextboxByRowNumber("Member Since", "3", "1991");
		homePage.sleepInSecond(3);
	}
	
	@Test
	public void Table_06_Click_To_Icon_At_Row() {
		homePage.clickToIconByRowNumber("2", "Move Up");
		homePage.sleepInSecond(3);
		
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.sleepInSecond(3);
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
