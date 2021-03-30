package pageObjects.OrangeHRM;

import org.openqa.selenium.WebDriver;

import Commons.BasePage;
import PageUIs.OrangeHRM.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameTextbox(String username) {
		waitToElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public DashboardPageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashboardPage(driver);
	}
	
}
