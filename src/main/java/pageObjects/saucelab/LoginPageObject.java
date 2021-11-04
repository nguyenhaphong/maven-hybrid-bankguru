package pageObjects.saucelab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveguru.HomePageUI;
import pageUIs.saucelab.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMyAccountFooterLink() {
		waitElemenClickable(driver, HomePageUI.MY_ACCOUNT_FOOTER);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_FOOTER);
	}

	public void enterToUserNameTextbox(String username) {
		waitForElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, username);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public InventoryPageObject clickToLoginButton() {
		waitElemenClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGenerator.getInventoryPage(driver);
	}

}
