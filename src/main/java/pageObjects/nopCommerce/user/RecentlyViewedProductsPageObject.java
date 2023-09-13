package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.RecentlyViewedProductsPageUI;

public class RecentlyViewedProductsPageObject extends BasePage {

	private WebDriver driver;

	public RecentlyViewedProductsPageObject(WebDriver driver) {
		this.driver = driver;

	}
	
	public boolean getProductNameByTextAtRViewedPage(String productName) {
		waitForElementVisible(driver, RecentlyViewedProductsPageUI.PRODUCT_NAME_BY_TEXT_AT_VIEWED_PAGE, productName);
		return isELementDisplayed(driver, RecentlyViewedProductsPageUI.PRODUCT_NAME_BY_TEXT_AT_VIEWED_PAGE, productName);
		
	}

}
