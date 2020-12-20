package pageObjects;

import org.openqa.selenium.WebDriver;

import Commons.BasePage;

public class UserOrdersPO extends BasePage {
	WebDriver driver;

	public UserOrdersPO(WebDriver driver) {
		this.driver = driver;
	}
}
