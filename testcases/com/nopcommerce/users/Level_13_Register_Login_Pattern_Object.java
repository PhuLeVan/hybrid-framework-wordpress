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

public class Level_13_Register_Login_Pattern_Object extends BaseTest {
	WebDriver driver;
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInfoPO customerInfoPage;
	UserAddressesPO addressesPage;
	UserOrdersPO ordersPage;
	UserRewardPointsPO rewardPointsPage;
	UserMyProductReviewsPO myProductReviewsPage;
	
	String firstName, lastName, day, month, year, email, companyName, password, confirmPassword;
	boolean status;
	
	@Parameters("browser")
	@BeforeClass	
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		 firstName = "Robert";
		 lastName = "Teo";
		 day = "10";
		 month = "October";
		 year = "1995";
		 email = "robertteo" + getRandomNumber() + "@gmail.com";
		 companyName = "RobertTeo";
		 password = "123456";
		 confirmPassword = "123456";
		
	}
	
	@Test
	public void TC_01_Register() {
		log.info("Register - TC01: Open home page");
		homePage = GeneratorManagerPage.getUserHomepage(driver);
		
		log.info("Register - TC02: Click Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - TC03: Click Gender Male radio button");
		registerPage.clickToRadioButtonByID(driver, "gender-male");
		
		log.info("Register - TC04: Input Firstname");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);
		
		log.info("Register - TC05: Input Lastname ");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);
		
		log.info("Register - TC06: Select day");
		registerPage.selectDropdownListByName(driver, "DateOfBirthDay", day);
		
		log.info("Register - TC07: Select month");
		registerPage.selectDropdownListByName(driver, "DateOfBirthMonth", month);
		
		log.info("Register - TC08: Select year ");
		registerPage.selectDropdownListByName(driver, "DateOfBirthYear", year);
		
		log.info("Register - TC09: Input email");
		registerPage.inputToTextboxByID(driver, "Email", email);
		
		log.info("Register - TC10: Input company name");
		registerPage.inputToTextboxByID(driver, "Company", companyName);
		
		log.info("Register - TC11: Input password");
		registerPage.inputToTextboxByID(driver, "Password", password);
		
		log.info("Register - TC12: Input confirm password");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", confirmPassword);
		
		log.info("Register - TC13: Click Register button");
		registerPage.clickToButtonByValue(driver, "Register"); 
		
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
		loginPage.inputToTextboxByID(driver, "Email", email);
		
		log.info("Register - TC03: Input password");
		loginPage.inputToTextboxByID(driver, "Password", password);
		
		log.info("Register - TC04: Click Login button");
		loginPage.clickToButtonByValue(driver, "Log in");
		homePage = GeneratorManagerPage.getUserHomepage(driver);
		
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

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
