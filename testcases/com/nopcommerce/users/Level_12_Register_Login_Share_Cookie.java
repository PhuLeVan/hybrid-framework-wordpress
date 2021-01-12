package com.nopcommerce.users;

import java.util.Random;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Cookie;

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

public class Level_12_Register_Login_Share_Cookie extends BaseTest {
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
		
		log.info("Precondition - login equal to cookie");
		for (Cookie cookie : Common_01_Cookie.allCookies) {
			driver.manage().addCookie(cookie);
		}
		
		log.info("Pre-condition - Refresh page");
		homePage.refreshPage(driver);
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

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
