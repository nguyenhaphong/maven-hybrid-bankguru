package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.admin.nopCommerce.DashboardPageObject;
import pageObjects.admin.nopCommerce.LoginPageObject;
import pageObjects.admin.nopCommerce.PageGeneratorManager;
import pageObjects.admin.nopCommerce.ProductDetailPageObject;
import pageObjects.admin.nopCommerce.ProductSearchPageObject;

public class Level_10_Admin_Upload_File extends BaseTest {
	WebDriver driver;
	String productName = "Adobe Photoshop CS4";
	String productAvatarImg = "Anh.jpg";
	String productAvatarAlt = "Avatar Alt";
	String productAvatarTitle = "Avatar Title";
	String productAvatarOrder = "1";
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	ProductSearchPageObject productSearchPage;
	ProductDetailPageObject productDetailPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		loginPage.enterToEmailTextbox("admin@yourstore.com");
		loginPage.enterToPasswordTextbox("admin");
		dashboardPage = loginPage.clickToLoginButton();
		
		dashboardPage.openSubMenuPageByName(driver, "Catalog", "Products");
		productSearchPage = PageGeneratorManager.getProductSearchPage(driver);
		
		productSearchPage.enterToProductNameTextbox("productName");
		
		productSearchPage.clickToSearchButton();
		
		productDetailPage = productSearchPage.clickToEditButtonByProductName("productName");
	}
	
	@Test
	public void Admin_01_Paging() {
		productDetailPage.clickToExpandPanelByName("Pictures");
		
		productDetailPage.uploadFileAtCardName(driver, "pictures", productAvatarImg);
		
		Assert.assertTrue(productDetailPage.isPictureUploadSuccessByFileName(""));
		
		productDetailPage.enterToAltTextbox(productAvatarAlt);
		productDetailPage.enterToTitleTextbox(productAvatarTitle);
		productDetailPage.enterToDisplayOrderTextbox(productAvatarOrder);
		
		productDetailPage.clickToAddProductPictureButton();
		
		Assert.assertTrue(productDetailPage.isPictureImageDisplayed("productName", productAvatarOrder, productAvatarAlt, productAvatarTitle));
		
		productSearchPage = productDetailPage.clickToSaveButton();
		
		Assert.assertTrue(productSearchPage.isSuccessMessageDisplayed("The product has been updated successfully."));
		
		productSearchPage.enterToProductNameTextbox("Adobe Photoshop CS4");
		
		productSearchPage.clickToSearchButton();
		
		Assert.assertTrue(productDetailPage.isPictureImageUpdated("productName", "productName"));
		
		productDetailPage = productSearchPage.clickToEditButtonByProductName("productName");
		
		productDetailPage.clickToExpandPanelByName("Pictures");
		
		productDetailPage.clickToDeleteButtonAtPictureName("productAvatarTitle"); // Accept allert
		
		productSearchPage = productDetailPage.clickToSaveButton();
		
		productSearchPage.enterToProductNameTextbox("productName");
		
		productSearchPage.clickToSearchButton();
		
		Assert.assertTrue(productDetailPage.isPictureImageUpdated("default-image", "productName"));
	}
		
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
		
	}
	
}
