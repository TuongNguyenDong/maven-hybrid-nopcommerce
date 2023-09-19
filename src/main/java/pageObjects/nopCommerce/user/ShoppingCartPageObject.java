package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {

	private WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;

	}

	public String getTextLinkNameProductByColumnAtRowNumberatShoppingCart(String columnName, String rowNumber) {

		int columnIndex = getElementSize(driver, ShoppingCartPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, ShoppingCartPageUI.NAME_LINK_TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		return getElementText(driver, ShoppingCartPageUI.NAME_LINK_TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
	}

	public UserProductsNamePageObject clickToEditItemLink() {
		waitForElementClickable(driver, ShoppingCartPageUI.EDIT_ITEM_LINK);
		clickToELement(driver, ShoppingCartPageUI.EDIT_ITEM_LINK);
		return PageGeneratorManager.getUserProductsNamePage(driver);
	}
	
	public String getValueTextBoxProductByColumnAtRowNumberatShoppingCart(String columnName, String rowNumber) {

		int columnIndex = getElementSize(driver, ShoppingCartPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, ShoppingCartPageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		return getElementAttribute(driver,  ShoppingCartPageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROM_INDEX, "value",rowNumber, String.valueOf(columnIndex));
	}
	
	public String getTextProductByColumnAtRowNumberatShoppingCart(String columnName, String rowNumber) {

		int columnIndex = getElementSize(driver, ShoppingCartPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, ShoppingCartPageUI.TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		return getElementText(driver, ShoppingCartPageUI.TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
	}
	
}
