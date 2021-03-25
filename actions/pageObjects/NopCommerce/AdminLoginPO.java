package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import Commons.BasePage;
import PageUIs.NopCommerce.AdminLoginPageUI;

public class AdminLoginPO extends BasePage{
	WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmailTextbox(String email) {
		waitForElementClickable(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementClickable(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public AdminDashboardPO clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return GeneratorManagerPage.getAdminDashboardPage(driver);
	}
	
	public AdminDashboardPO loginWithAdmin(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		return clickToLoginButton();	
	}
}
