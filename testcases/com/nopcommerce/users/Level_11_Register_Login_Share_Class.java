package com.nopcommerce.users;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import Commons.BaseTest;
import pageObjects.GeneratorManagerPage;
import pageObjects.UserAddressesPO;
import pageObjects.UserCustomerInfoPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewsPO;
import pageObjects.UserOrdersPO;
import pageObjects.UserRegisterPO;
import pageObjects.UserRewardPointsPO;

public class Level_11_Register_Login_Share_Class extends BaseTest {
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
		
		log.info("Precondition - TC01: Open Login page");
		homePage = GeneratorManagerPage.getUserHomepage(driver);
		loginPage = homePage.clickToLoginLink(); 
		
		log.info("Precondition - TC02: Input email");
		loginPage.inputToEmailTextbox(Common_01_Register.email); 
		
		log.info("Precondition - TC03: Input password");
		loginPage.inputToPasswordTextbox(Common_01_Register.password); 
		
		log.info("Precondition - TC04: Click Login button");
		homePage = loginPage.clickToLoginButton(); 
	}
	
	@Test
	public void TC_01_Register() {
	}
	
	@Test
	public void TC_02_Login() {
		
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
