package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CompareProductsPageUI;
import pageUIs.nopCommerce.user.WishlistPageUI;

public class CompareProductsPageObject extends BasePage {

	private WebDriver driver;

	public CompareProductsPageObject(WebDriver driver) {
		this.driver = driver;

	}
	
	public String getTextProductByRowAtColumnNumber(String rowName, String ColumnNumber) {
		
		int rowIndex = getElementSize(driver, CompareProductsPageUI.COLUMN_BY_NAME, rowName) + 1;
		
		waitForElementVisible(driver, CompareProductsPageUI.TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(rowIndex),ColumnNumber );
		return getElementText(driver, CompareProductsPageUI.TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(rowIndex), ColumnNumber);
	}
	
	public String getPriceProductByRowAtColumnNumber(String rowName, String ColumnNumber) {
		
		int rowIndex = getElementSize(driver, CompareProductsPageUI.COLUMN_BY_NAME, rowName) + 1;
		
		waitForElementVisible(driver, CompareProductsPageUI.PRICE_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(rowIndex),ColumnNumber );
		return getElementText(driver, CompareProductsPageUI.PRICE_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(rowIndex), ColumnNumber);
	}

	public String getSpecificationProductByRowAtColumnNumber(String rowName, String ColumnNumber) {

		int rowIndex = getElementSize(driver, CompareProductsPageUI.COLUMN_BY_NAME, rowName) + 1;

		waitForElementVisible(driver, CompareProductsPageUI.SPEC_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(rowIndex),ColumnNumber );
		return getElementText(driver, CompareProductsPageUI.SPEC_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(rowIndex), ColumnNumber);
	}
	
	public String getRemoveButtonRTextByColumnNumber(String ColumnNumber) {
		
		waitForElementVisible(driver, CompareProductsPageUI.REMOVE_BUTTON_BY_COLUMN_INDEX, ColumnNumber);
		return getElementText(driver, CompareProductsPageUI.REMOVE_BUTTON_BY_COLUMN_INDEX, ColumnNumber);
	}
	
	public void clickToClearList() {

		waitForElementClickable(driver, CompareProductsPageUI.CLEAR_LIST);
		clickToELement(driver, CompareProductsPageUI.CLEAR_LIST);
	}
	
	public Boolean isCompareProductsEmptyMessage() {
		waitForElementVisible(driver, CompareProductsPageUI.MESSAGE_CLEAR_LIST);
		return isELementDisplayed(driver,  CompareProductsPageUI.MESSAGE_CLEAR_LIST);
	}

}
