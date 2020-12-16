package pageObjects;

import org.openqa.selenium.WebDriver;

import Commons.BasePage;

public class MyProductReviewsPageObject  extends BasePage {
	WebDriver driver;

	public MyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
