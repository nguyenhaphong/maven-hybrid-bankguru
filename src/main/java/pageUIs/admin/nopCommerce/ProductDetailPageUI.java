package pageUIs.admin.nopCommerce;

public class ProductDetailPageUI {
	public static final String TOOGLE_ICON_BY_NAME = "//div[@class='card-title' and contains(string(),'%s')]/following-sibling::div//i";
	public static final String PICTURE_IMAGE_ADD_NEW = "//div[@class='upload-picture-block']//img[contains(@src,%s')]";
	public static final String ALT_TEXTBOX_ADD_NEW ="//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_TEXTBOX_ADD_NEW ="//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String DISPLAY_ORDER_TEXTBOX_ADD_NEW ="//input[@id='AddPictureModel_DisplayOrder']";
	public static final String ADD_PRODUCT_PICTURE_BUTTON ="//button[@id='addProductPicture']";
	public static final String PICTURE_TABLE_BY_NAME_ORDER_ALT_TITLE = "//a[contains(@href,'%s')]/parent::td/following-sibling::td[@data-columnname='DisplayOrder' and text()='%s']/following-sibling::td[@data-columnname='OverrideAltAttribute' and text()='%s']/following-sibling::td[@data-columnname='OverrideTitleAttribute' and text()='%s']";
	public static final String SAVE_BUTTON ="//button[@name='save']";
	public static final String DELETE_BUTTON_BY_IMAGE_TITLE = "//td[@text='%s']/following-sibling::td/a[contains(string(),'Delete')]";

}
