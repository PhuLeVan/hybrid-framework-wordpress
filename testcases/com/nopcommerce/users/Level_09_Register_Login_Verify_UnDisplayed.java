package com.nopcommerce.users;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Commons.BaseTest;
import pageObjects.NopCommerce.GeneratorManagerPage;
import pageObjects.NopCommerce.UserAddressesPO;
import pageObjects.NopCommerce.UserCustomerInfoPO;
import pageObjects.NopCommerce.UserHomePO;
import pageObjects.NopCommerce.UserLoginPO;
import pageObjects.NopCommerce.UserMyProductReviewsPO;
import pageObjects.NopCommerce.UserOrdersPO;
import pageObjects.NopCommerce.UserRegisterPO;
import pageObjects.NopCommerce.UserRewardPointsPO;

public class Level_09_Register_Login_Verify_UnDisplayed extends BaseTest {
	WebDriver driver;
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInfoPO customerInfoPage;
	UserAddressesPO addressesPage;
	UserOrdersPO ordersPage;
	UserRewardPointsPO rewardPointsPage;
	UserMyProductReviewsPO myProductReviewsPage;
	
	String firstName = "Robert";
	String lastName = "Teo";
	String day = "10";
	String month = "October";
	String year = "1995";
	String email = "robertteo" + getRandomNumber() + "@gmail.com";
	String companyName = "RobertTeo";
	String password = "123456";
	String confirmPassword = "123456";
	boolean status;
	
	@Parameters("browser")
	@BeforeClass	
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
				
	}
	
	@Test
	public void TC_01_Register() {
		homePage = GeneratorManagerPage.getUserHomepage(driver);
		
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
		
		// verify My account link is displayed
		status = homePage.isMyAccountLinkDisplayed(); 
		Assert.assertTrue(status);
		
		// verify Logout link is displayed
		status = homePage.isLogoutLinkDisplayed(); 
		Assert.assertTrue(status);
		
		// verify Register link is undisplayed
		status = homePage.isRegisterLinkUnDisplayed(); 
		Assert.assertTrue(status);
		
		// verify Login link is undisplayed
		status = homePage.isLoginLinkUnDisplayed(); 
		Assert.assertTrue(status);
		
		
		customerInfoPage = homePage.clickToMyAccountLink();
		
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
