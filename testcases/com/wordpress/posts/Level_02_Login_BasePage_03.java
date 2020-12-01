package com.wordpress.posts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Commons.BasePage;

public class Level_02_Login_BasePage_03 extends BasePage {
  WebDriver driver;
  String projectLocation = System.getProperty("user.dir");
  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", projectLocation + "\\browserDriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  openPageUrl(driver, "https://automationfc.wordpress.com/wp-admin");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  openPageUrl(driver, "https://automationfc.wordpress.com/wp-admin");
  }
  
  @Test
  public void Login_01_Empty_Email_Username() {
	  sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "");
	  clickToElement(driver, "//button[text()='Continue']");
	  sleepInSecond(2);
	  
	  Assert.assertEquals(getElementText(driver, "//span[text()='Please enter a username or email address.']"), "Please enter a username or email address.");
  }
  
  @Test
  public void Login_02_Invalid_Email() {
	  sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "auto#mail.com");
	  clickToElement(driver, "//button[text()='Continue']");
	  sleepInSecond(2);
	  Assert.assertEquals(getElementText(driver, "//span[contains(.,'User does not exist. Would you like to create a new account?')]"), "User does not exist. Would you like to create a new account?");
  }
  
  @Test
  public void Login_03_Invalid_Username() {
	  sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "1dsadsadsadsad");
	  clickToElement(driver, "//button[text()='Continue']");
	  sleepInSecond(2);
	  Assert.assertEquals(getElementText(driver, "//span[contains(.,'User does not exist. Would you like to create a new account?')]"), "User does not exist. Would you like to create a new account?");

  }
  
  @Test
  public void Login_04_Empty_Password() {
	  sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
	  clickToElement(driver, "//button[text()='Continue']");
	  sleepInSecond(2);
	  
	  clickToElement(driver, "//button[text()='Log In']");
	  sleepInSecond(2);
	  
	  Assert.assertEquals(getElementText(driver, "//span[contains(.,\"Don't forget to enter your password.\")]"),"Don't forget to enter your password.");
  }
  
  @Test
  public void Login_05_little_6Characters_Password() {
	  sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
	  clickToElement(driver, "//button[text()='Continue']");
	  sleepInSecond(2);
	  
	  sendkeyToElement(driver, "//input[@id='password']", "12345");
	  clickToElement(driver, "//button[text()='Log In']");
	  sleepInSecond(2);
	  Assert.assertEquals(getElementText(driver, "//span[contains(.,\"Oops, that's not the right password. Please try again!\")]"),"Oops, that's not the right password. Please try again!");
  }
  
  @Test
  public void Login_06_Invalid_Password() {
	  sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
	  clickToElement(driver, "//button[text()='Continue']");
	  sleepInSecond(2);
	  
	  sendkeyToElement(driver, "//input[@id='password']", "123456789");
	  clickToElement(driver, "//button[text()='Log In']");
	  sleepInSecond(2);
	  Assert.assertEquals(getElementText(driver, "//span[contains(.,\"Oops, that's not the right password. Please try again!\")]"),"Oops, that's not the right password. Please try again!");
  }
  
  @Test
  public void Login_07_Correct_Email_Password() {
	  sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
	  clickToElement(driver, "//button[text()='Continue']");
	  sleepInSecond(2);
	  
	  sendkeyToElement(driver, "//input[@id='password']", "automationfc");
	  clickToElement(driver, "//button[text()='Log In']");
	  sleepInSecond(2);
	  Assert.assertTrue(isElementDisplay(driver, "//h1[text()='Dashboard']"));
  }
  
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
