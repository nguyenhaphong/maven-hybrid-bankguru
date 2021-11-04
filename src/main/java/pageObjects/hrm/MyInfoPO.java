package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.MyInfoPageUI;

public class MyInfoPO extends BasePage {
	WebDriver driver;
	
	public MyInfoPO (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToChangePhotoImage() {
		waitElemenClickable(driver, MyInfoPageUI.AVATA_IMAGE);
		clickToElement(driver, MyInfoPageUI.AVATA_IMAGE);	
	}

	public boolean isNewAvatarImageDisplayed() {
		waitElemenClickable(driver, MyInfoPageUI.AVATA_IMAGE);
		int imageWidth = Integer.parseInt(getElementAttributeValue(driver, MyInfoPageUI.AVATA_IMAGE, "width"));
		int imageHeight = Integer.parseInt(getElementAttributeValue(driver, MyInfoPageUI.AVATA_IMAGE, "height"));
		return (imageWidth != 200) || (imageHeight != 200);
	}
	
	public void openTabAtSideBarByName(String tabName) {
		waitElemenClickable(driver, MyInfoPageUI.TAB_LINK_AT_SIDEBAR, tabName);
		clickToElement(driver, MyInfoPageUI.TAB_LINK_AT_SIDEBAR, tabName);
	}

}
