package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminProductsPageUI;

public class AdminProductsPageObject extends BasePage{

	private WebDriver driver;

	public AdminProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTextByColumnAtRowNumberatAdminProductPage(String columnName, String rowNumber) {
		
		int columnIndex = getElementSize(driver, AdminProductsPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		
		waitForElementVisible(driver, AdminProductsPageUI.TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		return getElementText(driver, AdminProductsPageUI.TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
	}
	
	public Boolean getIconsByColumnAtRowNumberatAdminProductPage(String columnName, String rowNumber) {

		int columnIndex = getElementSize(driver, AdminProductsPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, AdminProductsPageUI.ICONS_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		return isELementDisplayed(driver, AdminProductsPageUI.ICONS_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
	}

	public void clicktoGoButtonAtAdminProductsPage() {
		waitForElementClickable(driver, AdminProductsPageUI.GO_BUTTON_AT_ADMIN_PRODUCTS_PAGE);
		clickToELement(driver, AdminProductsPageUI.GO_BUTTON_AT_ADMIN_PRODUCTS_PAGE);
		sleepInSecond(1);
	}

	public Boolean isDataTableEmpty() {
		waitForElementVisible(driver, AdminProductsPageUI.DATATABLE_EMPTY_AT_ADMIN_PRODUCTS_PAGE);
		return isELementDisplayed(driver, AdminProductsPageUI.DATATABLE_EMPTY_AT_ADMIN_PRODUCTS_PAGE);
	}
	
	public void clickToCheckboxByLabel( String checkBoxLabelName) {
		waitForElementClickable(driver, AdminProductsPageUI.DYNAMIC_CHECKBOX_BY_LABEL, checkBoxLabelName);
		checkToDefaultCheckboxOrRadio(driver, AdminProductsPageUI.DYNAMIC_CHECKBOX_BY_LABEL, checkBoxLabelName);	
		
	}
	
	public void unCheckToCheckboxByLabel( String checkBoxLabelName) {
		waitForElementClickable(driver, AdminProductsPageUI.DYNAMIC_CHECKBOX_BY_LABEL, checkBoxLabelName);
		uncheckToDefaultCheckbox(driver, AdminProductsPageUI.DYNAMIC_CHECKBOX_BY_LABEL, checkBoxLabelName);	
		
	}

	
	public Boolean isProductDetailByLabel( String productDetailName) {
		waitForElementVisible(driver, AdminProductsPageUI.PRODUCT_DETAIL_BY_LABEL_AT_ADMIN_PRODUCTS_PAGE, productDetailName);
		return isELementDisplayed(driver, AdminProductsPageUI.PRODUCT_DETAIL_BY_LABEL_AT_ADMIN_PRODUCTS_PAGE, productDetailName);
	}
	

}
