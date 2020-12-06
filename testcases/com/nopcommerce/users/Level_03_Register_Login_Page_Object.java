package com.nopcommerce.users;

import org.testng.annotations.Test;

import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Level_03_Register_Login_Page_Object {
	WebDriver driver;
	String projectFolder = System.getProperty("user.dir");
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject customerInfoPage;
	String firstName = "Robert";
	String lastName = "Teo";
	String day = "10";
	String month = "October";
	String year = "1995";
	String email = "robertteo" + getRandomNumber() + "@gmail.com";
	String company = "RobertTeo";
	String password = "123456";
	String confirmPassword = "123456";
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", projectFolder + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void TC_01_Register() {
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		
		registerPage.clickToGenderMaleRadioButton();
		
		registerPage.inputToFirstnameTextbox(firstName);
		
		registerPage.inputToLastnameTextbox(lastName); 
		
		registerPage.selectDayDropdown(day); 
		
		registerPage.selectMonthDropdown(month); 
		
		registerPage.selectYearDropdown(year); 
		
		registerPage.inputToEmailTextbox(email); 
		
		registerPage.inputToCompanyTextbox(company); 
		
		registerPage.inputToPasswordTextbox(password); 
		
		registerPage.inputToConfirmPasswordTextbox(confirmPassword); 
		
		registerPage.clickToRegisterButton(); 
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed"); 
		
		registerPage.clickToLogoutLink();
	}
	
	@Test
	public void TC_02_Login() {
		homePage = new HomePageObject(driver);
		
		homePage.clickToLoginLink(); 
		
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(email); 
		
		loginPage.inputToPasswordTextbox(password); 
		
		loginPage.clickToLoginButton(); 
		
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed()); 
		
		Assert.assertTrue(homePage.isLogoutLinkDisplayed()); 
	}
	
	@Test
	public void TC_03_View_My_account() {
		homePage.clickToMyAccountLink();
		
		customerInfoPage = new CustomerInfoPageObject(driver);
		
		Assert.assertTrue(customerInfoPage.isGenderMaleRadioButtonSelected());
		
		Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(), "firstName");
		
		Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(), lastName);
		
		Assert.assertEquals(customerInfoPage.getSelectedTextInDaydropdown(), day);
		
		Assert.assertEquals(customerInfoPage.getSelectedTextInMonthdropdown(), month);
		
		Assert.assertEquals(customerInfoPage.getSelectedTextInYeardropdown(), year);
		
		Assert.assertEquals(customerInfoPage.getEmailTextboxValue(), email);
		
		Assert.assertEquals(customerInfoPage.getCompanyTextboxValue(), company);
		
		Assert.assertTrue(customerInfoPage.isNewsLetterCheckboxSelected());
		
		customerInfoPage.clickToLogoutLink(); 
		
	}
	
	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}

}
