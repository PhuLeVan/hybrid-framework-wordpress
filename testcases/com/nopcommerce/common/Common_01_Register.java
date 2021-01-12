package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Commons.BaseTest;
import pageObjects.GeneratorManagerPage;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;

public class Common_01_Register extends BaseTest{
	WebDriver driver;
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;

	
	String firstName, lastName, day, month, year, companyName, confirmPassword;
	public static String email, password;
	
	
	@Parameters("browser")
	@BeforeTest	
	public void beforeTest(String browserName) {
		firstName = "Robert";
		lastName = "Teo";
		day = "10";
		month = "October";
		year = "1995";
		email = "robertteo@gmail.com";
		companyName = "RobertTeo";
		password = "123456";
		confirmPassword = "123456";
		
		driver = getBrowserDriver(browserName);
		
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
		

		
		driver.quit();
	}
	
}
