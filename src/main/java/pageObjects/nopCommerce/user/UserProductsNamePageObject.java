package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserProductsNamePageUI;

public class UserProductsNamePageObject extends BasePage {
	
	private  WebDriver driver;
	
	public UserProductsNamePageObject(WebDriver driver) {
		this.driver =driver;
		
	}
	
	public void  inputToTextareaReviewProduct(String reviewText) {
		waitForAllElementVisible(driver, UserProductsNamePageUI.REVIEW_PRODUCT_TEXT);
		sendkeyToElement(driver, UserProductsNamePageUI.REVIEW_PRODUCT_TEXT, reviewText);
	}
	
	public void clickToRatingRadioButtonByLable(String ratingLable) {
		waitForElementClickable(driver, UserProductsNamePageUI.DYNAMIC_PRODUCT_RATING_RADIO_BUTTON, ratingLable);
		checkToDefaultCheckboxOrRadio(driver, UserProductsNamePageUI.DYNAMIC_PRODUCT_RATING_RADIO_BUTTON, ratingLable);
		
	}
	
	public String getProductReviewAddedSuccessMessage() {
		waitForElementVisible(driver, UserProductsNamePageUI.MESSAGE_ADD_PRODUCT_REVIEW_SUCCESS);
		return getElementText(driver, UserProductsNamePageUI.MESSAGE_ADD_PRODUCT_REVIEW_SUCCESS);
	}

	public void clickToOverviewButtonByText(String overviewName) {
		waitForElementClickable(driver, UserProductsNamePageUI.DYNAMIC_OVERVIEW_BUTTON_BY_TEXT, overviewName);
		clickToELement(driver, UserProductsNamePageUI.DYNAMIC_OVERVIEW_BUTTON_BY_TEXT, overviewName);	
	}
	
	
	public String getAddToWishlistSuccessMessage() {
		waitForElementVisible(driver, UserProductsNamePageUI.MESSAGE_ADD_TO_WISHLIST_SUCCESS);
		return getElementText(driver, UserProductsNamePageUI.MESSAGE_ADD_TO_WISHLIST_SUCCESS);
	}

	public WishlistPageObject openWishlistPage() {
		waitForElementClickable(driver, UserProductsNamePageUI.WISHLIST_LINK);
		clickToELement(driver, UserProductsNamePageUI.WISHLIST_LINK);
		return PageGeneratorManager.getWishlistPage(driver);
	}
	
	public void clickToCloseSuccessMessage() {
		waitForElementClickable(driver, UserProductsNamePageUI.CLOSE_MESSAGE_ADD_TO_WISHLIST);
		clickToELement(driver, UserProductsNamePageUI.CLOSE_MESSAGE_ADD_TO_WISHLIST);	
	}

}
