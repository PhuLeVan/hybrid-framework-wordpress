package pageObjects;

import org.openqa.selenium.WebDriver;

public class GeneratorManagerPage {
	public static UserHomePO getUserHomepage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	
	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	
	public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPO(driver);
	}
	
	public static UserAddressesPO getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPO(driver);
	}
	
	public static UserOrdersPO getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPO(driver);
	}
	
	public static UserMyProductReviewsPO getUserMyProductReviewsPage(WebDriver driver) {
		return new UserMyProductReviewsPO(driver);
	}
	
	public static UserRewardPointsPO getUserRewardPointsPage(WebDriver driver) {
		return new UserRewardPointsPO(driver);
	}
	
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	
	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
	}
	
	public static AdminProductsPO getAdminProductsPage(WebDriver driver) {
		return new AdminProductsPO(driver);
	}
}
