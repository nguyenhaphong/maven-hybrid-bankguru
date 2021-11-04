package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	WebDriver driver;
	
	@FindBy(css="input[id='Email']")
	WebElement emailTextbox;
	
	@FindBy(xpath="//input=[@id='Password']")
	WebElement passwordTextbox;
	
	@FindBy(css="input[value='Log in']")
	WebElement loginButton;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, emailTextbox, password);	
	}

	public void clickToLoginButton() {
		 waitElemenClickable(driver, loginButton);
		 clickToElement(driver, loginButton);
	}

}
