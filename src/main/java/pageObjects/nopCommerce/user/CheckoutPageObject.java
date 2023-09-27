package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.CheckoutPageUI;

public class CheckoutPageObject extends BasePage {

	private WebDriver driver;

	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;

	}


	
	public void clickToButtonByIDAtCheckoutPage( String nameID, String nameButton) {
		waitForElementClickable(driver, CheckoutPageUI.DYNAMIC_BUTTON_BY_ID_AT_CHECKOUT_PAGE, nameID, nameButton );
		clickToELement(driver, CheckoutPageUI.DYNAMIC_BUTTON_BY_ID_AT_CHECKOUT_PAGE, nameID, nameButton);
		
	}
	
	public void unClickToCheckboxByLabelAtCheckoutPage( String checkBoxLabelName) {
		waitForElementClickable(driver, CheckoutPageUI.DYNAMIC_CHECKBOX_BY_LABEL_AT_CHECKOUT_PAGE, checkBoxLabelName);
		uncheckToDefaultCheckbox(driver, CheckoutPageUI.DYNAMIC_CHECKBOX_BY_LABEL_AT_CHECKOUT_PAGE, checkBoxLabelName);	
		
	}



	public Boolean isTextByClassAtCheckoutPage(String nameClass) {
		waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXT_BY_CLASS_AT_CHECKOUT_PAGE, nameClass);
		return isELementDisplayed(driver, CheckoutPageUI.DYNAMIC_TEXT_BY_CLASS_AT_CHECKOUT_PAGE, nameClass);
	}
	
	public String getTextByClassAtCheckoutPage(String nameClass) {
		waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXT_BY_CLASS_AT_CHECKOUT_PAGE, nameClass);
		String orderNumberAtCheckOutPage = getElementText(driver, CheckoutPageUI.DYNAMIC_TEXT_BY_CLASS_AT_CHECKOUT_PAGE, nameClass);
		return orderNumberAtCheckOutPage.split(": ")[1];
	}



	public String getOrderReviewDataByNameAtComfirmOrder(String nameClass) {
		waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_CLASS_BY_VALUE_AT_CONFIRM_ORDER, nameClass);
		return getElementText(driver, CheckoutPageUI.DYNAMIC_CLASS_BY_VALUE_AT_CONFIRM_ORDER, nameClass);
	}



	public Boolean isTitleByClassNameAtComfirmOrder(String nameClass) {
		waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_TEXT_BY_CLASS_AT_CONFIRM_ORDER, nameClass);
		return isELementDisplayed(driver, CheckoutPageUI.DYNAMIC_TEXT_BY_CLASS_AT_CONFIRM_ORDER, nameClass);

	}



	public String getTextboxValueByTitleNameAndNameClass(String titleName, String nameClass) {
		waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_LIST_INFO_BY_TITLE_NAME_AND_CLASS_NAME_AT_CONFIRM_ORDER,titleName ,nameClass);
		return getElementText(driver, CheckoutPageUI.DYNAMIC_LIST_INFO_BY_TITLE_NAME_AND_CLASS_NAME_AT_CONFIRM_ORDER,titleName ,nameClass);
	}
	
	

	public String getTextLinkNameProductByColumnAtRowNumberAtCheckOutPage(String columnName, String rowNumber) {

		int columnIndex = getElementSize(driver, CheckoutPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, CheckoutPageUI.NAME_LINK_TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		return getElementText(driver, CheckoutPageUI.NAME_LINK_TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
	}
	
	public String getTextProductByColumnAtRowNumberAtCheckOutPage(String columnName, String rowNumber) {

		int columnIndex = getElementSize(driver, CheckoutPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, CheckoutPageUI.TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		return getElementText(driver, CheckoutPageUI.TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
	}
	
	public String getSelectedCartOptionAtComfirmOrder() {
		waitForElementVisible(driver, CheckoutPageUI.CART_OPTION_SELECTED_AT_CONFIRM_ORDER);
		return getElementText(driver, CheckoutPageUI.CART_OPTION_SELECTED_AT_CONFIRM_ORDER);
	}
	
	public String getCartTotalInfoByLableAtComfirmOrder(String labelName) {
		waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_CART_TOTAL_INFO_BY_LABEL, labelName);
		return getElementText(driver, CheckoutPageUI.DYNAMIC_CART_TOTAL_INFO_BY_LABEL, labelName);
	}
	
	public UserHomePageObject clickToContinueButtonAtOrderCompletedPage() {
		waitForElementClickable(driver, CheckoutPageUI.BUTTON_CONTINUE_AT_ORDER_COMPLETED_PAGE);
		clickToELement(driver, CheckoutPageUI.BUTTON_CONTINUE_AT_ORDER_COMPLETED_PAGE);
		
		return PageGeneratorManager.getUserHomePage(driver);
	}
}
