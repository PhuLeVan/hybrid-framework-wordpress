package com.nopcommerce.users;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.NopCommerce.UserCustomerInfoPO;
import pageObjects.NopCommerce.UserHomePO;
import pageObjects.NopCommerce.UserLoginPO;
import pageObjects.NopCommerce.UserRegisterPO;


public class Level_03_Register_Login_Page_Object {
	WebDriver driver;
	String projectFolder = System.getProperty("user.dir");
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInfoPO customerInfoPage;
	String firstName = "Robert";
	String lastName = "Teo";
	String day = "10";
	String month = "October";
	String year = "1995";
	String email = "robertteo" + getRandomNumber() + "@gmail.com";
	String companyName = "RobertTeo";
	String password = "123456";
	String confirmPassword = "123456";
	
	@BeforeClass	
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();    
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", 
		        Collections.singletonList("enable-automation"));
		driver = new ChromeDriver(options);
		//System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		homePage = new UserHomePO(driver);
	}
	
	@Test
	public void TC_01_Register() {
		homePage.clickToRegisterLink();
		
		homePage.sleepInSecond(1);
		
		registerPage = new UserRegisterPO(driver);
		
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
		
		registerPage.clickToLogoutLink();
		
		//registerPage.clickToLogoutLinkJS();
		
	}
	
	@Test
	public void TC_02_Login() {
		homePage = new UserHomePO(driver);
		
		homePage.clickToLoginLink(); 
		
		loginPage = new UserLoginPO(driver);
		
		loginPage.inputToEmailTextbox(email); 
		
		loginPage.inputToPasswordTextbox(password); 
		
		loginPage.clickToLoginButton(); 
		
		homePage = new UserHomePO(driver);
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed()); 
		
		Assert.assertTrue(homePage.isLogoutLinkDisplayed()); 
		
		homePage.clickToMyAccountLink();
		
	}
	
	@Test
	public void TC_03_View_My_account() {
		
		customerInfoPage = new UserCustomerInfoPO(driver);
		
		Assert.assertTrue(customerInfoPage.isGenderMaleRadioButtonSelected());
		
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
		
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
		
		Assert.assertEquals(customerInfoPage.getSelectedTextInDaydropdown(),"10");
		
		Assert.assertEquals(customerInfoPage.getSelectedTextInMonthdropdown(),"October");
		
		Assert.assertEquals(customerInfoPage.getSelectedTextInYeardropdown(),"1995");
		
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),email);
		
		Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(),companyName);
		
		Assert.assertTrue(customerInfoPage.isNewsLetterCheckboxSelected());
		
		customerInfoPage.clickToLogoutLink(); 
		
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
