package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	WebDriver driver;
	
	@FindBy(css="input[id='gender-male']")
	WebElement genderMaleRadio;
	
	@FindBy(id="FirstName")
	WebElement firstNameTextbox;
	
	@FindBy(id="LastName")
	WebElement lastNameTextbox;
	
	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTextbox;
	
	@FindBy(id="register-button")
	WebElement registerButton;
	
	@FindBy(xpath="//div[@class='result' and text()='Your registration completed']")
	WebElement successMessage;
	
	@FindBy(className="ico-logout")
	WebElement logoutLink;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickToGenderMaleRadioButton() {
		waitElemenClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);		
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeyToElement(driver, firstNameTextbox, firstName);	
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeyToElement(driver, lastNameTextbox, lastName);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);	
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendKeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public void clickToRegisterButton() {
		waitForElementVisible(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public boolean isSuccessMassageDisplayed() {
		waitForElementVisible(driver, successMessage);
		return isElementDisplayed(driver, successMessage);
	}

	public void clickToLogoutLink() {
		waitElemenClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

}
