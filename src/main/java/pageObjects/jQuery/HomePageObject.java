package pageObjects.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitElemenClickable(driver, pageUIs.jQuery.HomePageUI.PAGING_BY_NUMBER, pageNumber);
		clickToElement(driver, pageUIs.jQuery.HomePageUI.PAGING_BY_NUMBER, pageNumber);
	}

	public boolean isPageActivedByNumber(String pageNumber) {
		waitForElementVisible(driver, pageUIs.jQuery.HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGING_BY_NUMBER_ACTIVE, pageNumber);
	}

	public void inputToHeaderTextboxByName(String headerName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BYNAME, headerName);
		sendKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BYNAME, value, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BYNAME, Keys.ENTER, headerName);
	}

	public void clickToIconByCountryName(String countryName, String iconAction) {
		waitForElementVisible(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, iconAction);
	}

	public boolean isRowValueDisplayed(String female, String country, String males, String total) {
		waitForElementVisible(driver, pageUIs.jQuery.HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL, female, country, males, total);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL, female, country, males, total);
	}

	public void inputToTextboxByRowNumber(String headerName, String rowIndex, String value) {
		// Column index
		int columnIndex = getElementSize(driver, HomePageUI.HEADER_NAME_INDEX, headerName) + 1;
		
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, rowIndex, String.valueOf(columnIndex));
		sendKeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_ROW_INDEX, value, rowIndex, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowIndex, String iconAction) {
		waitElemenClickable(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowIndex, iconAction);
		clickToElement(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowIndex, iconAction);
		
	}
	
}
