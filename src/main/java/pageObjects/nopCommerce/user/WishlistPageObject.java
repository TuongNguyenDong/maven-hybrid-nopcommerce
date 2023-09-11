package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.WishlistPageUI;

public class WishlistPageObject extends BasePage {

	private WebDriver driver;

	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;

	}

	public String getTextProductByColumnAtRowNumber(String columnName, String rowNumber) {

		int columnIndex = getElementSize(driver, WishlistPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, WishlistPageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,
				String.valueOf(columnIndex));
		return getElementText(driver, WishlistPageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROM_INDEX, rowNumber,
				String.valueOf(columnIndex));
	}

	public void clickToWishlistSharingLink() {
		waitForElementClickable(driver, WishlistPageUI.WISHLIST_SHARING);
		clickToELement(driver, WishlistPageUI.WISHLIST_SHARING);
	}
	
	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		
	    int columnIndex = getElementSize(driver, WishlistPageUI.COLUMN_BY_NAME, columnName) ;
	    waitForElementClickable(driver, WishlistPageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
	   checkToDefaultCheckboxOrRadio(driver, WishlistPageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columnIndex));
	}
	
	public ShoppingCartPageObject clickToAddToCartButton() {
		waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		clickToELement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManager.getShoppingCartPage(driver);
	}
	
	public WishlistPageObject openWishlistPageUrl(String wishlistUrl) {
		openPageUrl(driver, wishlistUrl);
		return PageGeneratorManager.getWishlistPage(driver);
	}
	
	public Boolean isWishlistEmptyMessage() {
		waitForElementVisible(driver, WishlistPageUI.MESSAGE_WISHLIST_EMPTY);
		return isELementDisplayed(driver,  WishlistPageUI.MESSAGE_WISHLIST_EMPTY);
	}
}
