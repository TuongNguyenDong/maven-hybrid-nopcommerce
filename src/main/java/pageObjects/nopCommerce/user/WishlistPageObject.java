package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserChangePasswordPageUI;
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

}
