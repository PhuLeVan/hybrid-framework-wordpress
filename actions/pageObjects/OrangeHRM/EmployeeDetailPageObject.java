package pageObjects.OrangeHRM;

import org.openqa.selenium.WebDriver;

import Commons.BasePage;
import PageUIs.OrangeHRM.EmployeeDetailPageUI;

public class EmployeeDetailPageObject extends BasePage{
	WebDriver driver;

	public EmployeeDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstNameTextboxAtAddEmployeeForm(String firstName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM, firstName);
	}

	public void inputToLastNameTextboxAtAddEmployeeForm(String lastName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM, lastName);
	}
 
	public String getEmployeeIDAtEmployeeForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEEID_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.EMPLOYEEID_TEXTBOX_AT_ADD_EMPLOYEE_FORM, "value");
	}

	public boolean isFullNameDisplayedAtHeader(String fullName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.DYNAMIC_FULLNAME_TEXT_AT_PERSONAL_DETAIL_FORM, fullName);
		return isElementDisplay(driver, EmployeeDetailPageUI.DYNAMIC_FULLNAME_TEXT_AT_PERSONAL_DETAIL_FORM, fullName);
	}

	public String getFirstNameValueAtPersonalForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, "value");
	}

	public String getLastNameValueAtPersonalForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, "value");
	}

	public String getEmployeeValueAtPersonalForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEEID_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementText(driver, EmployeeDetailPageUI.EMPLOYEEID_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
	}

	public void inputToFirstNameTextboxAtPersonalDetailForm(String firstName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, firstName);
	}

	public void inputToLastNameTextboxAtPersonalDetailForm(String lastName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, lastName);
	}

	public void inputToSSNNumberTextboxAtPersonalDetailForm(String ssnNumber) {
		waitForElementVisible(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM, ssnNumber);
	}

	public void clickToGenderRadioAtPersonalDetailForm(String genderValue) {
		waitForElementClickable(driver, EmployeeDetailPageUI.DYNAMIC_GENDER_RADIO_AT_PERSONAL_DETAIL_FORM, genderValue);
		checkToCheckbox(driver, EmployeeDetailPageUI.DYNAMIC_GENDER_RADIO_AT_PERSONAL_DETAIL_FORM, genderValue);
	}

	public void selectToMaritalStatusDropdownAtPersonalDetailForm(String maritalStatusValue) {
		waitForElementClickable(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAIL_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAIL_FORM, maritalStatusValue);
	} 

	public void selectToNationalityDropdownAtPersonalDetailForm(String nationalityValue) {
		waitForElementClickable(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAIL_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAIL_FORM, nationalityValue);
	}

	public void inputToDateofBirthTextboxAtPersonalDetailForm(String dateOfBirth) {
		waitForElementVisible(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXTBOX_AT_PERSONAL_DETAIL_FORM, dateOfBirth);
	}

	public String getSuccessMessageAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.SUCCESS_MESSAGE_LABLE_AT_PERSONAL_DETAIL_FORM);
		return getElementText(driver, EmployeeDetailPageUI.SUCCESS_MESSAGE_LABLE_AT_PERSONAL_DETAIL_FORM);
	}

	public String getSSNNumberValueAtPersonalForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM, "value");
	}

	public boolean isGenderRaidoButtonSelectedAtPersonalDetailForm(String genderValue) {
		waitForElementVisible(driver, EmployeeDetailPageUI.DYNAMIC_GENDER_RADIO_AT_PERSONAL_DETAIL_FORM, genderValue);
		return isElementSelected(driver, EmployeeDetailPageUI.DYNAMIC_GENDER_RADIO_AT_PERSONAL_DETAIL_FORM, genderValue);
	}

	public String getSelectItemOfMaritalStatusDropdownAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAIL_FORM);
		return getSelectItemInDropdown(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAIL_FORM);
	}

	public String getSelectItemOfNationlityDropdownAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAIL_FORM);
		return getSelectItemInDropdown(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAIL_FORM);
	}

	public String getDateOfBirthValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXTBOX_AT_PERSONAL_DETAIL_FORM, "value");
	}

	public void openSidebarTabByName(String tabName) {
		waitForElementClickable(driver, EmployeeDetailPageUI.DYNAMIC_SIDEBAR_TAB_BY_NAME, tabName);
		clickToElement(driver, EmployeeDetailPageUI.DYNAMIC_SIDEBAR_TAB_BY_NAME, tabName);
	}

	public void selectPayGradeDropdownAtSalaryForm(String payGrade) {
		waitForElementClickable(driver, EmployeeDetailPageUI.PAY_GRADE_DROPDOWN_AT_SALARY_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.PAY_GRADE_DROPDOWN_AT_SALARY_FORM, payGrade);
	}

	public void inputToSalaryComponentTextboxAtSalaryForm(String salaryComponent) {
		waitForElementVisible(driver, EmployeeDetailPageUI.SALARY_COMPONENT_TEXTBOX_AT_SALARY_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.SALARY_COMPONENT_TEXTBOX_AT_SALARY_FORM, salaryComponent);
		
	}

	public void selectToPayFrequencyDropdownAtSalaryForm(String payFrequency) {
		waitForElementClickable(driver, EmployeeDetailPageUI.PAY_FREQUENCY_DROPDOWN_AT_SALARY_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.PAY_FREQUENCY_DROPDOWN_AT_SALARY_FORM, payFrequency);
		
	}

	public void selectToCurrencyDropdownAtSalaryForm(String currency) {
		waitForElementClickable(driver, EmployeeDetailPageUI.CURRENCY_DROPDOWN_AT_SALARY_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.CURRENCY_DROPDOWN_AT_SALARY_FORM, currency);
		
	}

	public void inputToAmountTextboxAtSalaryForm(String amount) {
		waitForElementVisible(driver, EmployeeDetailPageUI.AMOUNT_TEXTBOX_AT_SALARY_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.AMOUNT_TEXTBOX_AT_SALARY_FORM, amount);
	}

	public void inputToCommentsTextboxAtSalaryForm(String comments) {
		waitForElementVisible(driver, EmployeeDetailPageUI.COMMENT_TEXTBOX_AT_SALARY_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.COMMENT_TEXTBOX_AT_SALARY_FORM, comments);
	}

	
}
