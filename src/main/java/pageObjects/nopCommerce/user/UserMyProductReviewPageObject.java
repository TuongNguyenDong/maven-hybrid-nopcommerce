package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserMyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage {
	
 WebDriver  driver;
	
	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getReviewProductTilleByTextName(String textName) {
		waitForAllElementVisible(driver, UserMyProductReviewPageUI.REVIEW_PRODUCT_TITILE, textName);
		return getElementText(driver, UserMyProductReviewPageUI.REVIEW_PRODUCT_TITILE, textName);
		
	}
	
	public String getReviewProductTextByTextName(String textName) {
		waitForAllElementVisible(driver, UserMyProductReviewPageUI.REVIEW_PRODUCT_TEXT, textName);
		return getElementText(driver, UserMyProductReviewPageUI.REVIEW_PRODUCT_TEXT, textName);
		
	}
	
	public String getReviewProductRatingByTextName(String textName) {
		waitForAllElementVisible(driver, UserMyProductReviewPageUI.REVIEW_PRODUCT_RATING, textName);
		return getElementAttribute(driver, UserMyProductReviewPageUI.REVIEW_PRODUCT_RATING,"style", textName);
		
	}

}
