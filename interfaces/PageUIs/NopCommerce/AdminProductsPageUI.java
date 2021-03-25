package PageUIs.NopCommerce;

public class AdminProductsPageUI {
	public static final String PAGE_AT_TABLE_BY_INDEX = "//li[@class='paginate_button ']/a[text()='%s']";
	public static final String PAGE_ACTIVE_AT_TABLE_BY_INDEX = "//li[@class='paginate_button active']/a[text()='%s']";
	public static final String SELECT_ALL_CHECKBOX = "//th/input[@id='mastercheckbox']";
	public static final String ALL_PRODUCT_CHECKBOX = "//input[@name='checkbox_products']";
	public static final String PRODUCT_CHECKBOX_BY_NAME = "//td[text()='%s']/preceding-sibling::td/input";

	public static final String COLUMN_NAME_SIBLING = "//th[text()='%s']/preceding-sibling::th";
	public static final String CELL_VALUE_BY_COLUMN_AND_ROW_INDEX = "//tr[%s]/td[%s]"; 
	public static final String PUBLISHED_STATUS_BY_COLUMN_AND_ROW_INDEX = "//tr[%s]/td[%s]/i[contains(@class,'%s')]"; 
	public static final String EDIT_ICON_COLUMN_AND_ROW_INDEX = "//td[text()='%s']/following-sibling::td/a"; 
	public static final String PRODUCT_NAME_VALUE = "//input[@id='Name']"; 
	public static final String BACK_TO_PRODUCT_LIST = "//a[text()='back to product list']"; 
	
}
