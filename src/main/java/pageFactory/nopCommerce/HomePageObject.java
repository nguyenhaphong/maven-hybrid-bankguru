package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {
	WebDriver driver;
	
	// UI
	@FindBy(id="nivo-slider")
	WebElement homePageSlider;
	
	@FindBy(id="ico-register")
	WebElement registerLink;
	
	@FindBy(id="ico-login")
	WebElement loginLink;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Action
	public void clickToRegisterLink() {
		waitElemenClickable(driver, registerLink);
		clickToElement(driver, registerLink);	
	}

	public void clickToLoginLink() {
		waitElemenClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		
	}

	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, homePageSlider);
		return isElementDisplayed(driver, homePageSlider);
	}

}
