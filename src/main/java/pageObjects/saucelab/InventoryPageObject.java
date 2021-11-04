package pageObjects.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelab.InventoryPageUI;

public class InventoryPageObject extends BasePage{
	private WebDriver driver;

	public InventoryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String itemText) {
		waitElemenClickable(driver, InventoryPageUI.SORT_DROPDOWN);
		selectDropwdownByText(driver, InventoryPageUI.SORT_DROPDOWN, itemText);
	}

	public boolean isProductNameSortAscending() {
		List<WebElement> productElements = getElements(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
		
		List<String> productNameText = new ArrayList<String>();
		
		for (WebElement productName : productElements) {
			productNameText.add(productName.getText());
		}
		
		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameTextClone);
		
		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductNameSortDescending() {
		List<WebElement> productElements = getElements(driver, InventoryPageUI.PRODUCT_NAME_TEXT);
		
		List<String> productNameText = new ArrayList<String>();
		
		for (WebElement productName : productElements) {
			productNameText.add(productName.getText());
		}
		
		List<String> productNameTextClone = new ArrayList<String>(productNameText);
		Collections.sort(productNameTextClone);
		Collections.reverse(productNameTextClone);
		
		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductPriceSortAscending() {
		List<WebElement> productPriceElements = getElements(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
		
		List<Float> productPriceValue = new ArrayList<Float>();
		
		for (WebElement productPrice : productPriceElements) {
			productPriceValue.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}
		
		List<Float> productPriceTextClone = new ArrayList<Float>(productPriceValue);
		Collections.sort(productPriceTextClone);
		
		return productPriceValue.equals(productPriceTextClone);
	}

	public boolean isProductPriceSortDescending() {
		List<WebElement> productPriceElements = getElements(driver, InventoryPageUI.PRODUCT_PRICE_TEXT);
		
		List<Float> productPriceValue = new ArrayList<Float>();
		
		for (WebElement productPrice : productPriceElements) {
			productPriceValue.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}
		
		List<Float> productPriceTextClone = new ArrayList<Float>(productPriceValue);
		Collections.sort(productPriceTextClone);
		Collections.reverse(productPriceTextClone);
		
		return productPriceValue.equals(productPriceTextClone);
	}
}
