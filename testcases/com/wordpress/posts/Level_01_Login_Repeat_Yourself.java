package com.wordpress.posts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Level_01_Login_Repeat_Yourself {
  WebDriver driver;
  String projectLocation = System.getProperty("user.dir");
  
  By usernameTextboxBy = By.id("usernameOrEmail");
  By passwordTextboxBy = By.id("password");
  By continueButtonBy = By.xpath("//button[text()='Continue']");
  By loginButtonBy = By.xpath("//button[text()='Log In']");
  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", projectLocation + "\\browserDriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("https://automationfc.wordpress.com/wp-admin");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver.get("https://automationfc.wordpress.com/wp-admin");
  }
  
  @Test
  public void Login_01_Empty_Email_Username() {
	  driver.findElement(usernameTextboxBy).sendKeys("");
	  driver.findElement(continueButtonBy).click();
	  sleepThread(2);
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Please enter a username or email address.']")).getText(), "Please enter a username or email address.");
  }
  
  @Test
  public void Login_02_Invalid_Email() {
	  driver.findElement(usernameTextboxBy).sendKeys("auto#mail.com");
	  driver.findElement(continueButtonBy).click();
	  sleepThread(2);
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//span[contains(.,'User does not exist. Would you like to create a new account?')]")).getText().trim(), "User does not exist. Would you like to create a new account?");
  }
  
  @Test
  public void Login_03_Invalid_Username() {
	  driver.findElement(usernameTextboxBy).sendKeys("1dsadsadsadsad");
	  driver.findElement(continueButtonBy).click();
	  sleepThread(2);
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//span[contains(.,'User does not exist. Would you like to create a new account?')]")).getText().trim(), "User does not exist. Would you like to create a new account?");
  }
  
  @Test
  public void Login_04_Empty_Password() {
	  driver.findElement(usernameTextboxBy).sendKeys("automationeditor");
	  driver.findElement(continueButtonBy).click();
	  sleepThread(2);
	  
	  driver.findElement(loginButtonBy).click();
	  sleepThread(2);
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//span[contains(.,\"Don't forget to enter your password.\")]")).getText(), "Don't forget to enter your password.");
  }
  
  @Test
  public void Login_05_little_6Characters_Password() {
	  driver.findElement(usernameTextboxBy).sendKeys("automationeditor");
	  driver.findElement(continueButtonBy).click();
	  sleepThread(2);
	  
	  driver.findElement(passwordTextboxBy).sendKeys("12345");
	  driver.findElement(loginButtonBy).click();
	  sleepThread(2);
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//span[contains(.,\"Oops, that's not the right password. Please try again!\")]")).getText(), "Oops, that's not the right password. Please try again!");
  }
  
  @Test
  public void Login_06_Invalid_Password() {
	  driver.findElement(usernameTextboxBy).sendKeys("automationeditor");
	  driver.findElement(continueButtonBy).click();
	  sleepThread(2);
	  
	  driver.findElement(passwordTextboxBy).sendKeys("123456789");
	  driver.findElement(loginButtonBy).click();
	  sleepThread(2);
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//span[contains(.,\"Oops, that's not the right password. Please try again!\")]")).getText(), "Oops, that's not the right password. Please try again!");
  }
  
  @Test
  public void Login_07_Correct_Email_Password() {
	  driver.findElement(usernameTextboxBy).sendKeys("automationeditor");
	  driver.findElement(continueButtonBy).click();
	  sleepThread(2);
	  
	  driver.findElement(passwordTextboxBy).sendKeys("automationfc");
	  driver.findElement(loginButtonBy).click();
	  sleepThread(2);
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed());
  }
  
  public void sleepThread (long timeout) {
	  try {
		Thread.sleep(timeout * 1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
