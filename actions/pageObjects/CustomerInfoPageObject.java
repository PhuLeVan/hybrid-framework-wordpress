package pageObjects;

import org.openqa.selenium.WebDriver;

import Commons.BasePage;
import PageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage{
	WebDriver driver;
	
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isGenderMaleRadioButtonSelected() {
		waitForElementVisible(driver, CustomerInfoPageUI.GENDER_MALE_RADIO_BUTTON);
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO_BUTTON);
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getFirstNameTextboxValue() {
		waitForElementInvisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getSelectedTextInDaydropdown() {
		waitForElementVisible(driver, CustomerInfoPageUI.DAY_DROPDOWN);
		return getSelectItemInDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextInMonthdropdown() {
		waitForElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		return getSelectItemInDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedTextInYeardropdown() {
		waitForElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		return getSelectItemInDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isNewsLetterCheckboxSelected() {
		waitForElementVisible(driver, CustomerInfoPageUI.NEWSLETTER_CHECKBOX);
		return isElementSelected(driver, CustomerInfoPageUI.NEWSLETTER_CHECKBOX);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, CustomerInfoPageUI.LOGOUT_LINK);
		clickToElement(driver, CustomerInfoPageUI.LOGOUT_LINK);
	}



}
