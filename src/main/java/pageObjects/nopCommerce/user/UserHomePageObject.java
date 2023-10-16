package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage {
	
	private  WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver =driver;
		
	}

	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToELement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	
	}

	public UserLoginPageObject openLoginPage() {

		if (isElementUndisplayed(driver, HomePageUI.LOGIN_LINK) == false) {
			waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
			clickToELement(driver, HomePageUI.LOGIN_LINK);
		} else {

			waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
			clickToELement(driver, HomePageUI.LOGOUT_LINK);
			sleepInSecond(1);
			waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
			clickToELement(driver, HomePageUI.LOGIN_LINK);

		}
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
	waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isELementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}



}
