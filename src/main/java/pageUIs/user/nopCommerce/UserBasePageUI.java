package pageUIs.user.nopCommerce;

public class UserBasePageUI {
	public static final String SEARCH_PAGE_FOTTER = "//div[@class='footer']//a[text()='Search']";
	public static final String MY_ACCOUNT_PAGE_FOOTER = "//div[@class='footer']//a[text()='My account']";
	public static final String ORDER_PAGE_FOOTER = "//div[@class='footer']//a[text()='Orders']";
	
	// 1 locator dynamic cho 20 page
	public static final String DYNAMIC_PAGE_FOOTER = "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_PAGE_HEADER = "//div[@class='header']//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_RADIO_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "//button[text()='%s']";

}
