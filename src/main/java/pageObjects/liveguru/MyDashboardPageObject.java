package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.LoginPageUI;
import pageUIs.liveguru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage{
	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyDashboardHeaderDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.MY_DASHBOARD_HEADER_TEXT);
		return isElementDisplayed(driver, MyDashboardPageUI.MY_DASHBOARD_HEADER_TEXT);
	}

}
