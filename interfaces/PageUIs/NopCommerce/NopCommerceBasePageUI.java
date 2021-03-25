package PageUIs.NopCommerce;

public class NopCommerceBasePageUI {
	public static final String CUSTOMER_INFO_LINK = "//div[@class='listbox']//a[text()='Customer info']";
	public static final String ADDRESSES_LINK = "//div[@class='listbox']//a[text()='Addresses']";
	public static final String ORDERS_LINK = "//div[@class='listbox']//a[text()='Orders']";
	public static final String MY_PRODUCT_REVIEWS_LINK = "//div[@class='listbox']//a[text()='My product reviews']";
	public static final String REWARD_POINTS_LINK = "//div[@class='listbox']//a[text()='Reward points']";
	
	// Dynamic link
	public static final String DYNAMIC_LINK = "//div[@class='listbox']//a[text()='%s']";
	public static final String AJAX_LOADING_ICON = "//div[@id='ajaxBusy']/span";
	public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_LIST_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_BUTTON_BY_VALUE = "//input[@value='%s']";
	
}
