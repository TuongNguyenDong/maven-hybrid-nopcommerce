package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage {

	private WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;

	}


	
	public String getTextProductByColumnAtRowNumberatShoppingCart(String columnName, String rowNumber) {

		int columnIndex = getElementSize(driver, ShoppingCartPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, ShoppingCartPageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,
				String.valueOf(columnIndex));
		return getElementText(driver, ShoppingCartPageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,
				String.valueOf(columnIndex));
	}
}
