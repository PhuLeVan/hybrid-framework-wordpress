package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import Commons.BasePage;
import PageUIs.NopCommerce.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage{
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminProductsPO openProductsPage() {
		waitForElementClickable(driver, AdminDashboardPageUI.CATALOG_SIDEBAR_LINK);
		clickToElement(driver, AdminDashboardPageUI.CATALOG_SIDEBAR_LINK);
		waitForElementClickable(driver, AdminDashboardPageUI.PRODUCTS_SIDEBAR_LINK);
		clickToElement(driver, AdminDashboardPageUI.PRODUCTS_SIDEBAR_LINK);
		return GeneratorManagerPage.getAdminProductsPage(driver);
	}
	
	
}
