package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{

	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

//	public void inputToUserNameTextbox(String emailAddress) {
//		waitForAllElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
//		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
//
//	}
//
//	public void inputToPasswordTextbox(String Password) {
//		waitForAllElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
//		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, Password);
//
//	}

	public AdminDashboardPageObject clickToLoginButton() {
		waitForAllElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToELement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
		

	}
	
//	public AdminDashboardPageObject loginAsAdmin(String emailAddress, String password) {
//		inputToUserNameTextbox(emailAddress);
//		inputToPasswordTextbox(password);
//		return clickToLoginButton();
//	}

}
