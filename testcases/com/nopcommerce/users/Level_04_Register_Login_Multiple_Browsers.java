package com.nopcommerce.users;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Commons.BaseTest;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;


public class Level_04_Register_Login_Multiple_Browsers extends BaseTest {
	WebDriver driver;
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
		homePage = new HomePageObject(driver);
		
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		
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
		homePage = new HomePageObject(driver);
		
		homePage.clickToLoginLink(); 
		
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTextbox(email); 
		
		loginPage.inputToPasswordTextbox(password); 
		
		loginPage.clickToLoginButton(); 
		
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed()); 
		
		Assert.assertTrue(homePage.isLogoutLinkDisplayed()); 
		
		homePage.clickToMyAccountLink();
	}
	
	@Test
	public void TC_03_View_My_account() {
		
		customerInfoPage = new CustomerInfoPageObject(driver);
		
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
