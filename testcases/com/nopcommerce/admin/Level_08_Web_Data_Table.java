package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Commons.BaseTest;
import pageObjects.NopCommerce.AdminDashboardPO;
import pageObjects.NopCommerce.AdminLoginPO;
import pageObjects.NopCommerce.AdminProductsPO;
import pageObjects.NopCommerce.GeneratorManagerPage;

public class Level_08_Web_Data_Table extends BaseTest {
	WebDriver driver;
	AdminLoginPO loginPage;
	AdminDashboardPO dashboardPage;
	AdminProductsPO productPage;
	
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName,String url) {
		
		driver = getBrowserDriver(browserName, url);
		
		loginPage = GeneratorManagerPage.getAdminLoginPage(driver);
		
		dashboardPage = loginPage.loginWithAdmin("admin@yourstore.com", "admin");
		
		productPage = dashboardPage.openProductsPage();
	
	}
	
	@Test
	public void TC_01_Paging() {
		productPage.goToPageAtTableByIndex("3");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("3"));
		
		productPage.goToPageAtTableByIndex("2");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("2"));
		
		productPage.goToPageAtTableByIndex("1");
		Assert.assertTrue(productPage.isPageActiveAtTableByIndex("1"));
		
	}
	
	@Test
	public void TC_02_Select_Deselect_All() {
		productPage.waitToAjaxLoadingIconInvisible(driver);
		
		productPage.checkToSelectAllCheckbox();
		productPage.allProductCheckboxesChecked();
		
		productPage.unCheckToSelectAllCheckbox();
		productPage.allProductCheckboxesUnchecked();
		
		productPage.checkToProductCheckboxByName("$100 Physical Gift Card");
		
		productPage.checkToProductCheckboxByName("Apple MacBook Pro 13-inch");
		
		productPage.checkToProductCheckboxByName("$50 Physical Gift Card");
	}
	
	@Test
	public void TC_03_Displayed() {
		
		Assert.assertTrue(productPage.isInfomationDisplayAtColumnNameAndRowName("Product name", "2", "$25 Virtual Gift Card"));
		Assert.assertTrue(productPage.isInfomationDisplayAtColumnNameAndRowName("SKU", "3", "PG_CR_050"));
		Assert.assertTrue(productPage.isInfomationDisplayAtColumnNameAndRowName("Price", "6", "1300"));
		Assert.assertTrue(productPage.isPublishStatusAtColumnNameAndRowName("Published", "6", "true"));
		
		productPage.clickToEditIconAtTable("Apple iCam");
		productPage.isProductNameDisplayed();
		productPage.backToProductList();
		productPage.clickToEditIconAtTable("First Prize Pies");
	}
	
	@Test
	public void TC_04_Edit() {
		
		
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
