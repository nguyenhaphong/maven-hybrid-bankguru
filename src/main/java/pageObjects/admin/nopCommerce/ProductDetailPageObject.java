package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.ProductDetailPageUI;
import pageUIs.admin.nopCommerce.ProductSearchPageUI;

public class ProductDetailPageObject extends BasePage{
	WebDriver driver;
	
	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToExpandPanelByName(String panelName) {
		waitForElementVisible(driver, ProductDetailPageUI.TOOGLE_ICON_BY_NAME, panelName);
		String toogleIconStatus = getElementAttributeValue(driver, ProductDetailPageUI.TOOGLE_ICON_BY_NAME, "class", panelName);
		if (toogleIconStatus.contains("fa-plus")) {
			waitElemenClickable(driver, ProductDetailPageUI.TOOGLE_ICON_BY_NAME, panelName);
			clickToElement(driver, ProductDetailPageUI.TOOGLE_ICON_BY_NAME, panelName);
		}	
	}

	public boolean isPictureUploadSuccessByFileName(String fileName) {
		fileName = fileName.split(".")[0];
		waitForElementVisible(driver, ProductDetailPageUI.PICTURE_IMAGE_ADD_NEW, fileName);
		return false;
	}

	public void enterToAltTextbox(String productImageAlt) {
		waitForElementVisible(driver, ProductDetailPageUI.ALT_TEXTBOX_ADD_NEW, productImageAlt);
		sendKeyToElement(driver, ProductDetailPageUI.ALT_TEXTBOX_ADD_NEW, productImageAlt);
	}

	public void enterToTitleTextbox(String productImageTitle) {
		waitForElementVisible(driver, ProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW, productImageTitle);
		sendKeyToElement(driver, ProductDetailPageUI.TITLE_TEXTBOX_ADD_NEW, productImageTitle);
	}

	public void enterToDisplayOrderTextbox(String productImageDisplayOrder) {
		waitForElementVisible(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX_ADD_NEW, productImageDisplayOrder);
		sendKeyToElement(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX_ADD_NEW, productImageDisplayOrder);
	}

	public void clickToAddProductPictureButton() {
		waitElemenClickable(driver, ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.ADD_PRODUCT_PICTURE_BUTTON);
	}

	public boolean isPictureImageDisplayed(String imageName, String displayOrder, String imageAlt, String imageTitle) {
		imageName = imageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX_ADD_NEW, imageName, displayOrder, imageAlt, imageTitle);
		return isElementDisplayed(driver, ProductDetailPageUI.DISPLAY_ORDER_TEXTBOX_ADD_NEW, imageName, displayOrder, imageAlt, imageTitle);
	}

	public ProductSearchPageObject clickToSaveButton() {
		waitElemenClickable(driver, ProductDetailPageUI.SAVE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getProductSearchPage(driver);
	}

	public void clickToDeleteButtonAtPictureName(String productTitle) {
		waitElemenClickable(driver, ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
		clickToElement(driver, ProductDetailPageUI.DELETE_BUTTON_BY_IMAGE_TITLE);
		acceptAlert(driver);
	}

	public boolean isPictureImageUpdated(String productImageName, String productName) {
		productImageName = productImageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productImageName, productName);
		return isElementDisplayed(driver, ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME);
	}

}
