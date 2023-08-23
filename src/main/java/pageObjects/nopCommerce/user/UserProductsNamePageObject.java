package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.RegisterPageUI;
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

}
