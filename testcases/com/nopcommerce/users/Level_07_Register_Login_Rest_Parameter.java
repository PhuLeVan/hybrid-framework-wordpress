package com.nopcommerce.users;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Commons.BaseTest;
import pageObjects.AddressesPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.GeneratorManagerPage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyProductReviewsPageObject;
import pageObjects.OrdersPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointsPageObject;

public class Level_07_Register_Login_Rest_Parameter extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject customerInfoPage;
	AddressesPageObject addressesPage;
	OrdersPageObject ordersPage;
	RewardPointsPageObject rewardPointsPage;
	MyProductReviewsPageObject myProductReviewsPage;
	
	
	String firstName = "Robert";
	String lastName = "Teo";
	String day = "10";
	String month = "October";
	String year = "1995";
	String email = "robertteo" + getRandomNumber() + "@gmail.com";
	String companyName = "RobertTeo";
	String password = "123456";
	String confirmPassword = "123456";
	
	@Parameters("browser")
	@BeforeClass	
	public void beforeClass(String browserName) {
		
		driver = getBrowserDriver(browserName);
				
	}
	
	@Test
	public void TC_01_Register() {
		homePage = GeneratorManagerPage.getHomepage(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadioButton();
		
		registerPage.inputToFirstnameTextbox(firstName);
		
		registerPage.inputToLastnameTextbox(lastName); 
		
		registerPage.selectDayDropdown("10"); 
		
		registerPage.selectMonthDropdown("October"); 
		
		registerPage.selectYearDropdown("1995"); 
		
		registerPage.inputToEmailTextbox(email); 
		
		registerPage.inputToCompanyTextbox(companyName); 
		
		registerPage.inputToPasswordTextbox(password); 
		
		registerPage.inputToConfirmPasswordTextbox(confirmPassword); 
		
		registerPage.clickToRegisterButton(); 
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed"); 
		
		homePage = registerPage.clickToLogoutLink();
		
	}
	
	@Test
	public void TC_02_Login() {
		
		loginPage = homePage.clickToLoginLink(); 
		
		loginPage.inputToEmailTextbox(email); 
		
		loginPage.inputToPasswordTextbox(password); 
		
		homePage = loginPage.clickToLoginButton(); 
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed()); 
		
		Assert.assertTrue(homePage.isLogoutLinkDisplayed()); 
		
		customerInfoPage = homePage.clickToMyAccountLink();
		
	}
	
	@Test
	public void TC_03_View_My_account() {
		
		Assert.assertTrue(customerInfoPage.isGenderMaleRadioButtonSelected());
		
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
		
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
		
		Assert.assertEquals(customerInfoPage.getSelectedTextInDaydropdown(),"10");
		
		Assert.assertEquals(customerInfoPage.getSelectedTextInMonthdropdown(),"October");
		
		Assert.assertEquals(customerInfoPage.getSelectedTextInYeardropdown(),"1995");
		
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),email);
		
		Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(),companyName);
		
		Assert.assertTrue(customerInfoPage.isNewsLetterCheckboxSelected());
		
	}
	
	@Test
	public void TC_04_Rest_parameter_Solution_1() {
		// Customer Info -> Reward Points
		rewardPointsPage = (RewardPointsPageObject) customerInfoPage.openLinkByPageName(driver, "Reward points");
		
		// Reward Points -> Addresses
		addressesPage = (AddressesPageObject) rewardPointsPage.openLinkByPageName(driver, "Addresses");
		
		// Addresses -> Orders
		ordersPage = (OrdersPageObject) addressesPage.openLinkByPageName(driver, "Orders");
		
		// Orders -> My Product Reviews
		myProductReviewsPage = (MyProductReviewsPageObject) ordersPage.openLinkByPageName(driver, "My product reviews");
	}
	
	@Test
	public void TC_04_Rest_parameter_Solution_2() {
		myProductReviewsPage.openLinkWithPageName(driver, "Addresses");
		addressesPage = GeneratorManagerPage.getAddressesPage(driver);
		
		addressesPage.openLinkWithPageName(driver, "Orders");
		ordersPage = GeneratorManagerPage.getOrdersPage(driver);
		
		ordersPage.openLinkWithPageName(driver, "My product reviews");
		myProductReviewsPage = GeneratorManagerPage.getMyProductReviewsPage(driver);
		
		myProductReviewsPage.openLinkWithPageName(driver, "Customer info");
		customerInfoPage = GeneratorManagerPage.getCustomerInfoPage(driver);
	}
	
	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
