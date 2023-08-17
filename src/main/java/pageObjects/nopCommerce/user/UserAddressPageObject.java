package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.AddressesPageUI;

public class UserAddressPageObject extends BasePage {
	
	 WebDriver  driver;
	
	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAddressAddSuccessMessage() {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS_ADD_SUCCESS_MESSAGE);
		return getElementText(driver, AddressesPageUI.ADDRESS_ADD_SUCCESS_MESSAGE);
	}

	
	public String getTextboxValueByName(WebDriver driver, String textName) {
		waitForElementVisible(driver,AddressesPageUI.DYNAMIC_ADDRESS_INFO_BY_CLASS,textName);
		return getElementText(driver, AddressesPageUI.DYNAMIC_ADDRESS_INFO_BY_CLASS,textName);
	}
	

}
