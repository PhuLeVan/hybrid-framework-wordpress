package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import Commons.BasePage;
import PageUIs.NopCommerce.UserHomePageUI;

public class UserHomePO extends BasePage {
	private WebDriver driver;
	
	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPO clickToRegisterLink() {
		waitToElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return GeneratorManagerPage.getUserRegisterPage(driver);
	}

	public UserLoginPO clickToLoginLink() {
		waitToElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return GeneratorManagerPage.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplay(driver, UserHomePageUI.LOGOUT_LINK);
	}
	
	public boolean isRegisterLinkUnDisplayed() {
		waitToElementInvisible(driver, UserHomePageUI.REGISTER_LINK);
		return isElementUnDisplay(driver, UserHomePageUI.REGISTER_LINK);
	}
	
	public boolean isLoginLinkUnDisplayed() {
		waitToElementInvisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementUnDisplay(driver, UserHomePageUI.LOGIN_LINK);
	}
	
	public UserCustomerInfoPO clickToMyAccountLink() {
		waitToElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return GeneratorManagerPage.getUserCustomerInfoPage(driver);
	}

}
