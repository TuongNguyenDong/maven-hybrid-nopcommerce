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

		return getElementAttribute(driver, ShoppingCartPageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROM_INDEX, "value", rowNumber,String.valueOf(columnIndex));
	}

	public String getTextProductByColumnAtRowNumberatShoppingCart(String columnName, String rowNumber) {

		int columnIndex = getElementSize(driver, ShoppingCartPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, ShoppingCartPageUI.TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		return getElementText(driver, ShoppingCartPageUI.TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
	}
	
	public void clickButtonByColumnAtRowNumberatShoppingCart(String columnName, String rowNumber) {

		int columnIndex = getElementSize(driver, ShoppingCartPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, ShoppingCartPageUI.BUTTON_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		clickToELement(driver, ShoppingCartPageUI.BUTTON_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
	}

	public String getOrderSumuryContent() {

		waitForElementVisible(driver, ShoppingCartPageUI.ORDER_SUMURY_CONTENT);
		return getElementText(driver, ShoppingCartPageUI.ORDER_SUMURY_CONTENT);
	}
	
	public WishlistPageObject openWishlistPage() {
		waitForElementClickable(driver, ShoppingCartPageUI.WISHLIST_LINK);
		clickToELement(driver, ShoppingCartPageUI.WISHLIST_LINK);
		return PageGeneratorManager.getWishlistPage(driver);
	}
	
	public void hoverToShoppingCartLink() {
		waitForElementClickable(driver, ShoppingCartPageUI.SHOPPING_CART_LINK);
		hoverMouseToElement(driver, ShoppingCartPageUI.SHOPPING_CART_LINK);
		
	}
	
	public String getShoppingCartQtyByText(String shoppingCartName) {
		waitForElementVisible(driver, ShoppingCartPageUI.SHOPPING_CART_QUANTITY_BY_TEXT, shoppingCartName);
		return getElementText(driver, ShoppingCartPageUI.SHOPPING_CART_QUANTITY_BY_TEXT, shoppingCartName);

	}
	

	public String getMiniShoppingCartCount() {
		waitForElementVisible(driver, ShoppingCartPageUI.MINI_SHOPPING_CART_COUNT);
		return getElementText(driver, ShoppingCartPageUI.MINI_SHOPPING_CART_COUNT);

	}
	
	
	public void inputToQtyByColumnAtRowNumberatShoppingCart(String columnName, String rowNumber, String qtyNumber) {

		int columnIndex = getElementSize(driver, ShoppingCartPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, ShoppingCartPageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,String.valueOf(columnIndex));
		 sendkeyToElement(driver,  ShoppingCartPageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROM_INDEX,qtyNumber,rowNumber, String.valueOf(columnIndex));
	}
	
	public  void clicktoShoppingCartButtonByTextName(String buttonName) {
		waitForElementClickable(driver, ShoppingCartPageUI.SHOPPING_CART_BUTTION_BY_TEXT, buttonName);
		clickToELement(driver, ShoppingCartPageUI.SHOPPING_CART_BUTTION_BY_TEXT, buttonName);

	}
	
	public void ClickToTermsOfService() {
		
		waitForElementVisible(driver, ShoppingCartPageUI.TERMS_OF_SERVICE);
		clickToELement(driver, ShoppingCartPageUI.TERMS_OF_SERVICE);
	}
	
	public CheckoutPageObject ClickToCheckoutButton() {

		waitForElementVisible(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
		clickToELement(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
		return PageGeneratorManager.getCheckoutPage(driver);
	}

}
