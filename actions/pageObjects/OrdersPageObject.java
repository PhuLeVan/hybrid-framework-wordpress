package pageObjects;

import org.openqa.selenium.WebDriver;

import Commons.BasePage;

public class OrdersPageObject extends BasePage {
	WebDriver driver;

	public OrdersPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
