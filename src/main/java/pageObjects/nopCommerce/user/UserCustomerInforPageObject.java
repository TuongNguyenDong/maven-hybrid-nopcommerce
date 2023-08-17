package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage {
	
	
	private WebDriver  driver;
	
	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToNewsletterCheckbox() {
		
		
	}
	
	

	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
		return isELementDisplayed(driver, CustomerInforPageUI.CUSTOMER_INFOR_HEADER);
	}
	
	public String getCustomerInfoUpdateSuccessMessage() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSTOMER_INFOR_UPDATE_SUCCESS_MESSAGE);
		return getElementText(driver, CustomerInforPageUI.CUSTOMER_INFOR_UPDATE_SUCCESS_MESSAGE);
	}






}
