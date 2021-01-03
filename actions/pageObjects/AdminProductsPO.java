package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Commons.BasePage;
import PageUIs.AdminProductsPageUI;

public class AdminProductsPO extends BasePage{
	WebDriver driver;

	public AdminProductsPO(WebDriver driver) {
		this.driver = driver;
	}

	public void goToPageAtTableByIndex(String indexPage) {
		waitForElementClickable(driver, AdminProductsPageUI.PAGE_AT_TABLE_BY_INDEX, indexPage);
		clickToElement(driver, AdminProductsPageUI.PAGE_AT_TABLE_BY_INDEX, indexPage);
	}
	
	public boolean isPageActiveAtTableByIndex(String indexPage) {
		waitForElementVisible(driver, AdminProductsPageUI.PAGE_ACTIVE_AT_TABLE_BY_INDEX, indexPage);
		return isElementDisplay(driver, AdminProductsPageUI.PAGE_ACTIVE_AT_TABLE_BY_INDEX, indexPage);		
	}

	public void checkToSelectAllCheckbox() {
		waitForElementClickable(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
		clickToElement(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
	}

	public void unCheckToSelectAllCheckbox() {
		waitForElementClickable(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
		unCheckToCheckbox(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
	}

	public void allProductCheckboxesChecked() {
		List<WebElement> allProductCheckboxesChecked = getListElement(driver, AdminProductsPageUI.ALL_PRODUCT_CHECKBOX);
		for (WebElement productCheckbox : allProductCheckboxesChecked) {
			Assert.assertTrue(productCheckbox.isSelected());
		}
	}

	public void allProductCheckboxesUnchecked() {
		List<WebElement> allProductCheckboxesChecked = getListElement(driver, AdminProductsPageUI.ALL_PRODUCT_CHECKBOX);
		for (WebElement productCheckbox : allProductCheckboxesChecked) {
			Assert.assertFalse(productCheckbox.isSelected());
		}
	}

	public void checkToProductCheckboxByName(String productName) {
		waitForElementClickable(driver, AdminProductsPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);
		checkToCheckbox(driver, AdminProductsPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);
	}

	public boolean isInfomationDisplayAtColumnNameAndRowName(String columnName, String rowNumber, String expectedValue) {
		int getColumnIndex = countElementSize(driver, AdminProductsPageUI.COLUMN_NAME_SIBLING, columnName) + 1;
		String actualValues = getElementText(driver, AdminProductsPageUI.CELL_VALUE_BY_COLUMN_AND_ROW_INDEX, rowNumber, String.valueOf(getColumnIndex));
		return actualValues.equals(expectedValue);
	}

	public boolean isPublishStatusAtColumnNameAndRowName(String columnName, String rowNumber, String publishedStatus) {
		int getColumnIndex = countElementSize(driver, AdminProductsPageUI.COLUMN_NAME_SIBLING, columnName) + 1;
		return isElementDisplay(driver, AdminProductsPageUI.PUBLISHED_STATUS_BY_COLUMN_AND_ROW_INDEX, rowNumber, String.valueOf(getColumnIndex), publishedStatus);
	}

	public void clickToEditIconAtTable(String productName) {
		waitForElementClickable(driver, AdminProductsPageUI.EDIT_ICON_COLUMN_AND_ROW_INDEX, productName);
		clickToElement(driver, AdminProductsPageUI.EDIT_ICON_COLUMN_AND_ROW_INDEX, productName);
		waitForAjaxLoadingIconInvisible(driver);
	}

	public String isProductNameDisplayed() {
		return getElementAttribute(driver, AdminProductsPageUI.PRODUCT_NAME_VALUE, "value");
	}
	
	public void backToProductList() {
		waitForElementClickable(driver, AdminProductsPageUI.BACK_TO_PRODUCT_LIST);
		clickToElement(driver, AdminProductsPageUI.BACK_TO_PRODUCT_LIST);
		waitForAjaxLoadingIconInvisible(driver);
	}
}
