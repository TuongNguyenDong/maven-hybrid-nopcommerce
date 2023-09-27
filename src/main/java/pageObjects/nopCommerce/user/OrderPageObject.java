package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.OrderPageUI;

public class OrderPageObject extends BasePage {

	private WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		this.driver = driver;

	}

	public String getOrderNumberNameAtOrderPage() {
		waitForAllElementVisible(driver, OrderPageUI.ORDER_NUMBER_NAME_AT_ORDER_PAGE);
		String orderNumerAtOderPage =  getElementText(driver, OrderPageUI.ORDER_NUMBER_NAME_AT_ORDER_PAGE);
		return orderNumerAtOderPage.split(": ")[1];
		
		
	}

	public boolean isTitleByClassNameAtOrderPage(String nameClass) {
		waitForElementVisible(driver, OrderPageUI.DYNAMIC_TEXT_BY_CLASS_AT_ORDER_PAGE, nameClass);
		return isELementDisplayed(driver, OrderPageUI.DYNAMIC_TEXT_BY_CLASS_AT_ORDER_PAGE, nameClass);

	}

	public String getOrderReviewDataByNameAtOrderPage(String nameClass) {
		waitForElementVisible(driver, OrderPageUI.DYNAMIC_CLASS_BY_VALUE_AT_ORDER_PAGE, nameClass);
		return getElementText(driver, OrderPageUI.DYNAMIC_CLASS_BY_VALUE_AT_ORDER_PAGE, nameClass);
	}

	public String getSelectedCartOptionAtOrderPage() {
		waitForElementVisible(driver, OrderPageUI.OPTION_SELECTED_AT_ORDER_PAGE);
		return getElementText(driver, OrderPageUI.OPTION_SELECTED_AT_ORDER_PAGE);
	}

	public String getCartTotalInfoByLableAtOrderPage(String labelName) {
		waitForElementVisible(driver, OrderPageUI.DYNAMIC_CART_TOTAL_INFO_BY_LABEL, labelName);
		return getElementText(driver, OrderPageUI.DYNAMIC_CART_TOTAL_INFO_BY_LABEL, labelName);
	}

	public String getTextProductByColumnAtRowNumberAtOrderPage(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, OrderPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, OrderPageUI.TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		return getElementText(driver, OrderPageUI.TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
	}

	public String getTextboxValueByTitleNameAndNameClass(String titleName, String nameClass) {
		waitForElementVisible(driver, OrderPageUI.DYNAMIC_LIST_INFO_BY_TITLE_NAME_AND_CLASS_NAME_AT_ORDER_PAGE,titleName ,nameClass);
		return getElementText(driver, OrderPageUI.DYNAMIC_LIST_INFO_BY_TITLE_NAME_AND_CLASS_NAME_AT_ORDER_PAGE,titleName ,nameClass);
	}

	public String getTextLinkNameProductByColumnAtRowNumberAtOrderPage(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, OrderPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, OrderPageUI.NAME_LINK_TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		return getElementText(driver, OrderPageUI.NAME_LINK_TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
	}
	
	public String getOrderNumberNameInOrderOverViewAtOrderPage() {
		waitForAllElementVisible(driver, OrderPageUI.ORDER_NUMBER_IN_ORDER_OVERVIEW_AT_ORDER_PAGE);
		String orderNumerInOrderOverViewAtOderPage =  getElementText(driver, OrderPageUI.ORDER_NUMBER_IN_ORDER_OVERVIEW_AT_ORDER_PAGE);
		return orderNumerInOrderOverViewAtOderPage.split(" #")[1];
	}
	
	public String getOrderContentInOrderOverviewAtOrderPage(String className) {
		waitForElementVisible(driver, OrderPageUI.DYNAMIC_ORDER_CONTENT_IN_ORDER_OVERVIEW_AT_ORDER_PAGE_BY_CLASS, className);
		return getElementText(driver, OrderPageUI.DYNAMIC_ORDER_CONTENT_IN_ORDER_OVERVIEW_AT_ORDER_PAGE_BY_CLASS, className);
	}
}
