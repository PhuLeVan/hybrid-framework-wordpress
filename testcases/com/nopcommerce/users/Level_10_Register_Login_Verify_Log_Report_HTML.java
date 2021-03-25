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

public class Level_10_Register_Login_Verify_Log_Report_HTML extends BaseTest {
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
		log.info("Register - TC01: Open home page");
		homePage = GeneratorManagerPage.getUserHomepage(driver);
		
		log.info("Register - TC02: Click Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - TC03: Click Gender Male radio button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("Register - TC04: Input Firstname");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Register - TC05: Input Lastname ");
		registerPage.inputToLastnameTextbox(lastName); 
		
		log.info("Register - TC06: Select day");
		registerPage.selectDayDropdown("10"); 
		
		log.info("Register - TC07: Select month");
		registerPage.selectMonthDropdown("October"); 
		
		log.info("Register - TC08: Select year ");
		registerPage.selectYearDropdown("1995"); 
		
		log.info("Register - TC09: Input email");
		registerPage.inputToEmailTextbox(email); 
		
		log.info("Register - TC10: Input company name");
		registerPage.inputToCompanyTextbox(companyName); 
		
		log.info("Register - TC11: Input password");
		registerPage.inputToPasswordTextbox(password); 
		
		log.info("Register - TC12: Input confirm password");
		registerPage.inputToConfirmPasswordTextbox(confirmPassword); 
		
		log.info("Register - TC13: Click Register button");
		registerPage.clickToRegisterButton(); 
		
		log.info("Register - TC14: Verify");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed"); 
		
		log.info("Register - TC15: Click log out link");
		homePage = registerPage.clickToLogoutLink();
		
	}
	
	@Test
	public void TC_02_Login() {
		
		log.info("Register - TC01: Open Login page");
		loginPage = homePage.clickToLoginLink(); 
		
		log.info("Register - TC02: Input email");
		loginPage.inputToEmailTextbox(email); 
		
		log.info("Register - TC03: Input password");
		loginPage.inputToPasswordTextbox(password); 
		
		log.info("Register - TC04: Click Login button");
		homePage = loginPage.clickToLoginButton(); 
		
		log.info("Register - TC05: Verify my account link");
		status = homePage.isMyAccountLinkDisplayed(); 
		Assert.assertTrue(status);
		
		log.info("Register - TC06: Verify logout link");
		status = homePage.isLogoutLinkDisplayed(); 
		Assert.assertTrue(status);
		
		log.info("Register - TC07: verify Register link is undisplayed ");
		status = homePage.isRegisterLinkUnDisplayed(); 
		Assert.assertTrue(status);
		
		log.info("Register - TC08: verify Login link is undisplayed");
		status = homePage.isLoginLinkUnDisplayed(); 
		Assert.assertTrue(status);
		
		log.info("Register - TC09: Click my account link");
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
