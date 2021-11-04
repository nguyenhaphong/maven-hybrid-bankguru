package pageObject.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isEmailTextboxDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_TEXTBOX);
	}
	
	public boolean isConfirmEmailTextboxDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void enterToEmailTextbox(String email) {
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	public boolean isLoginButtonDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}

	public boolean isLoginButtonUndisplayed() {
		return isElementUndisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}

}
