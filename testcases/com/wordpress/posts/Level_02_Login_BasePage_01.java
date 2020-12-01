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

public class Level_02_Login_BasePage_01 {
  WebDriver driver;
  BasePage basePage;
  String projectLocation = System.getProperty("user.dir");
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", projectLocation + "\\browserDriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  basePage = new BasePage();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  basePage.openPageUrl(driver, "https://automationfc.wordpress.com/wp-admin");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  basePage.openPageUrl(driver, "https://automationfc.wordpress.com/wp-admin");
  }
  
  @Test
  public void Login_01_Empty_Email_Username() {
	  basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "");
	  basePage.clickToElement(driver, "//button[text()='Continue']");
	  basePage.sleepInSecond(2);
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//span[text()='Please enter a username or email address.']"), "Please enter a username or email address.");
  }
  
  @Test
  public void Login_02_Invalid_Email() {
	  basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "auto#mail.com");
	  basePage.clickToElement(driver, "//button[text()='Continue']");
	  basePage.sleepInSecond(2);
	  Assert.assertEquals(basePage.getElementText(driver, "//span[contains(.,'User does not exist. Would you like to create a new account?')]"), "User does not exist. Would you like to create a new account?");
  }
  
  @Test
  public void Login_03_Invalid_Username() {
	  basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "1dsadsadsadsad");
	  basePage.clickToElement(driver, "//button[text()='Continue']");
	  basePage.sleepInSecond(2);
	  Assert.assertEquals(basePage.getElementText(driver, "//span[contains(.,'User does not exist. Would you like to create a new account?')]"), "User does not exist. Would you like to create a new account?");

  }
  
  @Test
  public void Login_04_Empty_Password() {
	  basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
	  basePage.clickToElement(driver, "//button[text()='Continue']");
	  basePage.sleepInSecond(2);
	  
	  basePage.clickToElement(driver, "//button[text()='Log In']");
	  basePage.sleepInSecond(2);
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//span[contains(.,\"Don't forget to enter your password.\")]"),"Don't forget to enter your password.");
  }
  
  @Test
  public void Login_05_little_6Characters_Password() {
	  basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
	  basePage.clickToElement(driver, "//button[text()='Continue']");
	  basePage.sleepInSecond(2);
	  
	  basePage.sendkeyToElement(driver, "//input[@id='password']", "12345");
	  basePage.clickToElement(driver, "//button[text()='Log In']");
	  basePage.sleepInSecond(2);
	  Assert.assertEquals(basePage.getElementText(driver, "//span[contains(.,\"Oops, that's not the right password. Please try again!\")]"),"Oops, that's not the right password. Please try again!");
  }
  
  @Test
  public void Login_06_Invalid_Password() {
	  basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
	  basePage.clickToElement(driver, "//button[text()='Continue']");
	  basePage.sleepInSecond(2);
	  
	  basePage.sendkeyToElement(driver, "//input[@id='password']", "123456789");
	  basePage.clickToElement(driver, "//button[text()='Log In']");
	  basePage.sleepInSecond(2);
	  Assert.assertEquals(basePage.getElementText(driver, "//span[contains(.,\"Oops, that's not the right password. Please try again!\")]"),"Oops, that's not the right password. Please try again!");
  }
  
  @Test
  public void Login_07_Correct_Email_Password() {
	  basePage.sendkeyToElement(driver, "//input[@id='usernameOrEmail']", "automationeditor");
	  basePage.clickToElement(driver, "//button[text()='Continue']");
	  basePage.sleepInSecond(2);
	  
	  basePage.sendkeyToElement(driver, "//input[@id='password']", "automationfc");
	  basePage.clickToElement(driver, "//button[text()='Log In']");
	  basePage.sleepInSecond(2);
	  Assert.assertTrue(basePage.isElementDisplay(driver, "//h1[text()='Dashboard']"));
  }
  
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
