package com.orangehrm.employee;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Commons.BaseTest;
import pageObjects.NopCommerce.GeneratorManagerPage;
import pageObjects.NopCommerce.UserAddressesPO;
import pageObjects.NopCommerce.UserCustomerInfoPO;
import pageObjects.NopCommerce.UserHomePO;
import pageObjects.NopCommerce.UserLoginPO;
import pageObjects.NopCommerce.UserMyProductReviewsPO;
import pageObjects.NopCommerce.UserOrdersPO;
import pageObjects.NopCommerce.UserRegisterPO;
import pageObjects.NopCommerce.UserRewardPointsPO;
import pageObjects.OrangeHRM.DashboardPageObject;
import pageObjects.OrangeHRM.EmployeeDetailPageObject;
import pageObjects.OrangeHRM.EmployeeListPageObject;
import pageObjects.OrangeHRM.LoginPageObject;
import pageObjects.OrangeHRM.PageGeneratorManager;
import pageObjects.OrangeHRM.UserDetailPageObject;

public class Employee_TC01_Add_Edit_Employee_User extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	EmployeeDetailPageObject employeeDetailPage;
	UserDetailPageObject userDetailPage;
	EmployeeListPageObject employeeListPage;

	String firstName, lastName, employeeID;
	String editFirstName, editLastName, editSSNNumber, editGenderRadio, editMaritalStatus, editNationality,
			editDateOfBirth;
	String payGrade, salaryComponent, payFrequency, currency, amount, comment;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		firstName = "Phu";
		lastName = "Le " + getRandomNumber();
		editFirstName = "Teo " + getRandomNumber();
		editLastName = "Robert " + getRandomNumber();
		editSSNNumber = "329-68-2055";
		editGenderRadio = "Male";
		editMaritalStatus = "Single";
		editNationality = "Vietnamese";
		editDateOfBirth = "2000-10-10";

		payGrade = "Grade 1";
		salaryComponent = editFirstName + " - Annual Basic Payment";
		payFrequency = "Monthly on first pay of month.";
		currency = "United States Dollar";
		amount = "50000";
		comment = "Salary per month";

		log.info("Pre-condition - Step 01: Enter to Username textbox ");
		loginPage.inputToUsernameTextbox("Admin");

		log.info("Pre-condition - Step 02: Enter to Password textbox ");
		loginPage.inputToPasswordTextbox("admin123");

		log.info("Pre-condition - Step 03: Click to Login button ");
		dashboardPage = loginPage.clickToLoginButton();

		dashboardPage = PageGeneratorManager.getDashboardPage(driver);

	}

	@Test
	public void Employee_TC_01_Add_Employee() {
		log.info("Add Employee - Step 01: Open to PIM page ");
		dashboardPage.openMenuPageByName(driver, "PIM");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("Add Employee - Step 02: Click to Add button ");
		employeeDetailPage = employeeListPage.clickToAddButton();

		log.info("Add Employee - Step 03: Input to Firstname textbox ");
		employeeDetailPage.inputToFirstNameTextboxAtAddEmployeeForm(firstName);

		log.info("Add Employee - Step 04: Input to Lastname textbox ");
		employeeDetailPage.inputToLastNameTextboxAtAddEmployeeForm(lastName);

		log.info("Add Employee - Step 05: Get Employee ID info ");
		employeeID = employeeDetailPage.getEmployeeIDAtEmployeeForm();

		log.info("Add Employee - Step 06: Click to Save button ");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Add Employee", "Save");

		log.info("Add Employee - Step 07: Verify Fullname displayed at header is correct ");
		verifyTrue(employeeDetailPage.isFullNameDisplayedAtHeader(firstName + " " + lastName));

		log.info("Add Employee - Step 08: Verify Firstname displayed at Personal Detail form is correct ");
		verifyEquals(employeeDetailPage.getFirstNameValueAtPersonalForm(), firstName);

		log.info("Add Employee - Step 09: Verify Lastname displayed at Personal Detail form is correct ");
		verifyEquals(employeeDetailPage.getLastNameValueAtPersonalForm(), lastName);

		log.info("Add Employee - Step 10: Verify Employee ID displayed at Personal Detail form is correct ");
		verifyEquals(employeeDetailPage.getEmployeeValueAtPersonalForm(), employeeID);

	}

	@Test
	public void Employee_TC_02_Edit_Employee_By_Personal() {
		log.info("Edit Employee [Personal] - Step 01: Click to Edit button at Personal Detail Form");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Personal Details", "Edit");

		log.info("Edit Employee [Personal] - Step 02: Input new info to 'Firstname' textbox");
		employeeDetailPage.inputToFirstNameTextboxAtPersonalDetailForm(editFirstName);

		log.info("Edit Employee [Personal] - Step 03: Input new info to 'Lasttname' textbox");
		employeeDetailPage.inputToLastNameTextboxAtPersonalDetailForm(editLastName);

		log.info("Edit Employee [Personal] - Step 04: Input new info to 'SSN Number' textbox");
		employeeDetailPage.inputToSSNNumberTextboxAtPersonalDetailForm(editSSNNumber);

		log.info("Edit Employee [Personal] - Step 05: Click new info to Gender radio with 'Male'");
		employeeDetailPage.clickToGenderRadioAtPersonalDetailForm(editGenderRadio);

		log.info("Edit Employee [Personal] - Step 06: Select to 'Marital Status' dropdown with 'single'");
		employeeDetailPage.selectToMaritalStatusDropdownAtPersonalDetailForm(editMaritalStatus);

		log.info("Edit Employee [Personal] - Step 07: Select to 'Nationlity' dropdown with 'Vietnamese'");
		employeeDetailPage.selectToNationalityDropdownAtPersonalDetailForm(editNationality);

		log.info("Edit Employee [Personal] - Step 08: Input new info to 'Date of Birth' textbox");
		employeeDetailPage.inputToDateofBirthTextboxAtPersonalDetailForm(editDateOfBirth);

		log.info("Edit Employee [Personal] - Step 09: Click to 'Save' button at Personal Detail Form");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Personal Details", "Save");

		log.info("Edit Employee [Personal] - Step 10: Verify success message displayed with 'Successfully Saved'");
		verifyEquals(employeeDetailPage.getSuccessMessageAtPersonalDetailForm(), "Successfully Saved");

		log.info("Edit Employee [Personal] - Step 11: Verify 'Firstname' textbox edited successfully");
		verifyEquals(employeeDetailPage.getFirstNameValueAtPersonalForm(), editFirstName);

		log.info("Edit Employee [Personal] - Step 12: Verify 'Lasttname' textbox edited successfully");
		verifyEquals(employeeDetailPage.getLastNameValueAtPersonalForm(), editLastName);

		log.info("Edit Employee [Personal] - Step 13: Verify 'SSN Number' textbox edited successfully");
		verifyEquals(employeeDetailPage.getSSNNumberValueAtPersonalForm(), editSSNNumber);

		log.info("Edit Employee [Personal] - Step 14: Verify 'Gender Male' radio edited successfully");
		verifyTrue(employeeDetailPage.isGenderRaidoButtonSelectedAtPersonalDetailForm(editGenderRadio));

		log.info("Edit Employee [Personal] - Step 15: Verify 'Marital Status' dropdown edited successfully");
		verifyEquals(employeeDetailPage.getSelectItemOfMaritalStatusDropdownAtPersonalDetailForm(), editMaritalStatus);

		log.info("Edit Employee [Personal] - Step 16: Verify 'Nationality' dropdown edited successfully");
		verifyEquals(employeeDetailPage.getSelectItemOfNationlityDropdownAtPersonalDetailForm(), editNationality);

		log.info("Edit Employee [Personal] - Step 17: Verify 'Date of Birth' textbox edited successfully");
		verifyEquals(employeeDetailPage.getDateOfBirthValueAtPersonalDetailForm(), editDateOfBirth);
	}

	@Test
	public void Employee_TC_03_Edit_Employee_By_Contact() {
	}

	@Test
	public void Employee_TC_04_Edit_Employee_By_Job() {

	}

	@Test
	public void Employee_TC_05_Edit_Employee_By_Salary() {
		log.info("Edit Employee [Salary] - Step 01: Open Salary tab");
		employeeDetailPage.openSidebarTabByName("Salary");

		log.info("Edit Employee [Salary] - Step 02: Click to Add button at 'Assigned Salary Components' Form");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Assigned Salary Components", "Add");

		log.info("Edit Employee [Salary] - Step 03: Select to 'Pay Grade' dropdown with value ''");
		employeeDetailPage.selectPayGradeDropdownAtSalaryForm(payGrade);

		log.info("Edit Employee [Salary] - Step 04: Enter to 'Salary Component' textbox with value''");
		employeeDetailPage.inputToSalaryComponentTextboxAtSalaryForm(salaryComponent);

		log.info("Edit Employee [Salary] - Step 05: Select to 'Pay Frequency' dropdown with value ''");
		employeeDetailPage.selectToPayFrequencyDropdownAtSalaryForm(payFrequency);

		log.info("Edit Employee [Salary] - Step 06: Select to 'Currency' dropdown with value ''");
		employeeDetailPage.selectToCurrencyDropdownAtSalaryForm(currency);

		log.info("Edit Employee [Salary] - Step 07: Enter to 'Amount' textbox with value''v");
		employeeDetailPage.inputToAmountTextboxAtSalaryForm(amount);

		log.info("Edit Employee [Salary] - Step 08: Enter to 'Comments' textbox");
		employeeDetailPage.inputToCommentsTextboxAtSalaryForm(comment);

		log.info("Edit Employee [Salary] - Step 09: Click to 'Save' button at 'Assigned Salary Components'");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Add Salary Component", "Save");
		
		/*Verify*/
		verifyTrue(employeeDetailPage.isInfomationDisplayAtColumnNameAndRowName(driver, "tblSalary", "Salary Component", "1", salaryComponent));
		verifyTrue(employeeDetailPage.isInfomationDisplayAtColumnNameAndRowName(driver, "tblSalary", "Pay Frequency", "1", payFrequency));
		verifyTrue(employeeDetailPage.isInfomationDisplayAtColumnNameAndRowName(driver, "tblSalary", "Currency", "1", currency));
		verifyTrue(employeeDetailPage.isInfomationDisplayAtColumnNameAndRowName(driver, "tblSalary", "Amount", "1", amount));
		verifyTrue(employeeDetailPage.isInfomationDisplayAtColumnNameAndRowName(driver, "tblSalary", "Comments", "1", comment));
	}

	@Test
	public void Employee_TC_06_Search_Employee() {

	}

	@Test
	public void Employee_TC_07_Add_User_To_Employee() {

	}

	@Test
	public void Employee_TC_08_Search_User() {

	}

	@Test
	public void Employee_TC_09_Delete_User() {

	}

	@Test
	public void Employee_TC_10_Delete_Employee() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
