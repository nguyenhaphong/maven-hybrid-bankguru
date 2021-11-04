package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.ProductSearchPageUI;

public class ProductSearchPageObject extends BasePage{
	WebDriver driver;
	
	public ProductSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToProductNameTextbox(String productName) {
		waitForElementVisible(driver, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX);
		sendKeyToElement(driver, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void clickToSearchButton() {
		waitElemenClickable(driver, ProductSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductSearchPageUI.SEARCH_BUTTON);
		
	}

	public ProductDetailPageObject clickToEditButtonByProductName(String productName) {
		waitElemenClickable(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		return PageGeneratorManager.getProductDetailPage(driver);
	}

	public boolean isSuccessMessageDisplayed(String messageName) {
		waitForElementVisible(driver, ProductSearchPageUI.SUCCESS_MESSAGE_NAME, messageName);
		return isElementDisplayed(driver, ProductSearchPageUI.SUCCESS_MESSAGE_NAME, messageName);
	}

}
