package PageUIs.OrangeHRM;

public class EmployeeDetailPageUI {
	/*Employee Form*/
	public static final String FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM = "//input[@id='firstName']";
	public static final String LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM = "//input[@id='lastName']";
	public static final String EMPLOYEEID_TEXTBOX_AT_ADD_EMPLOYEE_FORM = "//input[@id='employeeId']";
	
	/*Personal Detail Form*/
	public static final String FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_txtEmpFirstName']";
	public static final String LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_txtEmpLastName']";
	public static final String EMPLOYEEID_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_txtEmployeeId']";
	public static final String SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_txtNICNo']";
	public static final String DATE_OF_BIRTH_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_DOB']";
	public static final String MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAIL_FORM = "//select[@id='personal_cmbMarital']";
	public static final String NATIONALITY_DROPDOWN_AT_PERSONAL_DETAIL_FORM = "//select[@id='personal_cmbNation']";
	public static final String SUCCESS_MESSAGE_LABLE_AT_PERSONAL_DETAIL_FORM = "//div[contains(@class, 'message success')]";
	public static final String DYNAMIC_FULLNAME_TEXT_AT_PERSONAL_DETAIL_FORM = "//div[@id='profile-pic']/h1[text()='%s']";
	public static final String DYNAMIC_GENDER_RADIO_AT_PERSONAL_DETAIL_FORM = "//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_SIDEBAR_TAB_BY_NAME = "//ul[@id='sidenav']//a[text()='%s']";
	
	/*Salary Form*/
	public static final String PAY_GRADE_DROPDOWN_AT_SALARY_FORM = "//select[@id='salary_sal_grd_code']";
	public static final String PAY_FREQUENCY_DROPDOWN_AT_SALARY_FORM = "//select[@id='salary_payperiod_code']";
	public static final String CURRENCY_DROPDOWN_AT_SALARY_FORM = "//select[@id='salary_currency_id']";
	public static final String SALARY_COMPONENT_TEXTBOX_AT_SALARY_FORM = "//input[@id='salary_salary_component']";
	public static final String AMOUNT_TEXTBOX_AT_SALARY_FORM = "//input[@id='salary_basic_salary']";
	public static final String COMMENT_TEXTBOX_AT_SALARY_FORM = "//textarea[@id='salary_comments']";
}