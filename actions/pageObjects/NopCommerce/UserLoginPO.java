package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import Commons.BasePage;
import PageUIs.NopCommerce.UserLoginPageUI;

public class UserLoginPO extends BasePage{
	WebDriver driver;
	
	public UserLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public UserHomePO clickToLoginButton() {
		waitToElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return GeneratorManagerPage.getUserHomepage(driver);
	}

}
