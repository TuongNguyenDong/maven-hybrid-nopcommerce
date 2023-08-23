package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage{
	 WebDriver  driver;
		
		public UserChangePasswordPageObject (WebDriver driver) {
			this.driver = driver;
		}
		
		public String getChangePasswordSuccessMessage() {
			waitForElementVisible(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
			return getElementText(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
		}
		
		public void clickToCloseSuccessMessage() {
			waitForElementClickable(driver, UserChangePasswordPageUI.CLOSE_CHANGE_PASSWORD_SUCCESS_MESSAGE);
			clickToELement(driver, UserChangePasswordPageUI.CLOSE_CHANGE_PASSWORD_SUCCESS_MESSAGE);	
		}
		
		public UserHomePageObject getUserHomePage() {
			waitForElementClickable(driver, UserChangePasswordPageUI.LOGOUT_LINK);
			clickToELement(driver, UserChangePasswordPageUI.LOGOUT_LINK);
			return PageGeneratorManager.getUserHomePage(driver);
		}

}
