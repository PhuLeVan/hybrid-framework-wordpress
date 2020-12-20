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
	
}
