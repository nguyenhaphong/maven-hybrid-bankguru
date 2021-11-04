package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.nopCommerce.OrderPageUI;

public class OrderPageObject extends BasePage {
	WebDriver driver;
	
	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
