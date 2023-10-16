package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminCustomersPageUI;

public class AdminCustomersPageObject extends BasePage{

	private WebDriver driver;

	public AdminCustomersPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String getCustomerRoleTextByName( String nameCustomerRole) {
		waitForElementVisible(driver, AdminCustomersPageUI.CUSTOMER_ROLE_SELECTED_BY_NAME, nameCustomerRole);
		return getElementText(driver, AdminCustomersPageUI.CUSTOMER_ROLE_SELECTED_BY_NAME, nameCustomerRole);
	}
	
	public String getTextByColumnAtRowNumberatAdminCustomerPage(String columnName, String rowNumber) {
		
		int columnIndex = getElementSize(driver, AdminCustomersPageUI.COLUMN_INDEX_BY_NAME_COLUMN, columnName) + 1;
		
		waitForElementVisible(driver, AdminCustomersPageUI.TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		return getElementText(driver, AdminCustomersPageUI.TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
	}
	
	public void clickToButtonLinkByColumnAtRowNumberatAdminCustomerPage(String columnName, String rowNumber) {
		
		int columnIndex = getElementSize(driver, AdminCustomersPageUI.COLUMN_INDEX_BY_NAME_COLUMN, columnName) + 1;
		
		waitForElementVisible(driver, AdminCustomersPageUI.LINK_TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		clickToELement(driver, AdminCustomersPageUI.LINK_TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
	}
	
	public String getTextByColumnMulCartAtRowNumberatAdminCustomerPage(String cartName, String columnName, String rowNumber) {
		
		int columnIndex = getElementSize(driver, AdminCustomersPageUI.COLUMN_INDEX_BY_CART_NAME_AND_NAME_COLUMN, cartName, columnName) + 1;
		
		waitForElementVisible(driver, AdminCustomersPageUI.TEXT_BY_CART_NAME_COLUMN_INDEX_AND_ROM_INDEX, cartName, rowNumber, String.valueOf(columnIndex));
		return getElementText(driver, AdminCustomersPageUI.TEXT_BY_CART_NAME_COLUMN_INDEX_AND_ROM_INDEX, cartName, rowNumber, String.valueOf(columnIndex));
		
	}
	
	public void clickToButtonLinkByColumnMulCartAtRowNumberatAdminCustomerPage(String cartName, String columnName, String rowNumber) {

		int columnIndex = getElementSize(driver, AdminCustomersPageUI.COLUMN_INDEX_BY_CART_NAME_AND_NAME_COLUMN, cartName, columnName) + 1;

		waitForElementVisible(driver, AdminCustomersPageUI.LINK_TEXT_BY_CART_NAME_COLUMN_INDEX_AND_ROM_INDEX, cartName, rowNumber, String.valueOf(columnIndex));
		 clickToELement(driver, AdminCustomersPageUI.LINK_TEXT_BY_CART_NAME_COLUMN_INDEX_AND_ROM_INDEX, cartName, rowNumber, String.valueOf(columnIndex));
			sleepInSecond(2);
	}

//	public String getTextByColumnAtRowNumberatAdminCustomerPageTest(String columnName, String expecCustomeName) {
//
//		int columnIndex = getElementSize(driver, AdminCustomersPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
//		List<WebElement> customerNames = getListWebElement(driver, AdminCustomersPageUI.TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX_TEST, String.valueOf(columnIndex));
//
//		for (WebElement customerName : customerNames) {
//			String actualCustomerName = customerName.getText();
//			System.out.println("value : " + actualCustomerName);
//			if (actualCustomerName.equals(expecCustomeName)) {
//				System.out.println("value  1 : " + actualCustomerName);
//
//			} 
////			else if (!actualCustomerName.equals(expecCustomeName)) {
////				clickToNextPagingPage();
////				
////			}  else {
////				break;
////			}
//		}
//		return expecCustomeName;
//
//	}

//	public void clickToNextPagingPage() {
//		waitForElementClickable(driver, AdminCustomersPageUI.PAGING_NEXT);
//		clickToELement(driver, AdminCustomersPageUI.PAGING_NEXT);
//		sleepInSecond(2);
//
//	}
	
	
}
