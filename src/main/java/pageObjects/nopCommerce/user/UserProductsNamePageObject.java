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
	
	
	public BasePage openPageAtUserProductsPageByName( String pageName) {
		waitForElementClickable(driver, UserProductsNamePageUI.ITEM_SCOPE_LINK_BY_NAME, pageName);
		clickToELement(driver, UserProductsNamePageUI.ITEM_SCOPE_LINK_BY_NAME, pageName);
		switch (pageName) {
		case "Home":
			return PageGeneratorManager.getUserHomePage(driver);
		case "Computers":
			return PageGeneratorManager.getCompareProductsPage(driver);
		case "Notebooks":
			return PageGeneratorManager.getUserNotebooksPage(driver);
		
		default:
			throw new RuntimeException("Invalid page name at UserProducts page itemscope");

		}

	}
	
	public void selectToDropdownByNameAtProductNamePage(String dropdownAttributeName, String itemValue) {
		waitForElementClickable(driver, UserProductsNamePageUI.ATTRIBUTE_DROPDOWN_BY_NAME_TEXT, dropdownAttributeName);
		selectItemInDefaultDropdown(driver, UserProductsNamePageUI.ATTRIBUTE_DROPDOWN_BY_NAME_TEXT,itemValue, dropdownAttributeName);
	
	}
	
	public void clicktoRadioButtonByButtonNameAndValueName(String radioButtonLabelName, String valueName) {
		waitForElementClickable(driver, UserProductsNamePageUI.ATTRIBUTE_BUTTON_BY_NAME_TEXT_AND_VALUE_TEXT, radioButtonLabelName,  valueName);
		checkToDefaultCheckboxOrRadio(driver, UserProductsNamePageUI.ATTRIBUTE_BUTTON_BY_NAME_TEXT_AND_VALUE_TEXT, radioButtonLabelName, valueName);
	}
	
	public void clicktoCheckboxByButtonNameAndValueName( String checkBoxLabelName, String valueName) {
		waitForElementClickable(driver, UserProductsNamePageUI.ATTRIBUTE_CHECKBOX_BY_NAME_TEXT_AND_VALUE_TEXT, checkBoxLabelName, valueName);
		checkToDefaultCheckboxOrRadio(driver, UserProductsNamePageUI.ATTRIBUTE_CHECKBOX_BY_NAME_TEXT_AND_VALUE_TEXT, checkBoxLabelName, valueName);	
		
	}
	
	public void clickAddToCartAtOverviewClass() {
		waitForElementClickable(driver, UserProductsNamePageUI.ADD_TO_CART_BUTTON_AT_OVERVIEW_CLASS );
		clickToELement(driver, UserProductsNamePageUI.ADD_TO_CART_BUTTON_AT_OVERVIEW_CLASS);
		
	}
	
	public ShoppingCartPageObject openShoppingCartPage() {
		waitForElementClickable(driver, UserProductsNamePageUI.SHOPPING_CART_LINK);
		clickToELement(driver, UserProductsNamePageUI.SHOPPING_CART_LINK);
		return PageGeneratorManager.getShoppingCartPage(driver);
	}
	
	public void clickToCloseAtToCartSuccessMessage() {
		waitForElementClickable(driver, UserProductsNamePageUI.CLOSE_ADD_TO_CART_SUCCESS_MESSAGE);
		clickToELement(driver, UserProductsNamePageUI.CLOSE_ADD_TO_CART_SUCCESS_MESSAGE);	
	}
	
	public void hoverToShoppingCartLink() {
		waitForElementClickable(driver, UserProductsNamePageUI.SHOPPING_CART_LINK);
		hoverMouseToElement(driver, UserProductsNamePageUI.SHOPPING_CART_LINK);
		
	}

	public String isShoppingCartQtyByText(String shoppingCartName) {
		waitForElementVisible(driver, UserProductsNamePageUI.SHOPPING_CART_QUANTITY_BY_TEXT, shoppingCartName);
		return getElementText(driver, UserProductsNamePageUI.SHOPPING_CART_QUANTITY_BY_TEXT, shoppingCartName);

	}

	public String isMiniShoppingCartCount() {
		waitForElementVisible(driver, UserProductsNamePageUI.MINI_SHOPPING_CART_COUNT);
		return getElementText(driver, UserProductsNamePageUI.MINI_SHOPPING_CART_COUNT);

	}

	public String isMiniShoppingCartName() {
		waitForElementVisible(driver, UserProductsNamePageUI.MINI_SHOPPING_CART_NAME);
		return getElementText(driver, UserProductsNamePageUI.MINI_SHOPPING_CART_NAME );
	}

	public String isMiniShoppingCartPrice() {
		waitForElementVisible(driver, UserProductsNamePageUI.MINI_SHOPPING_CART_PRICE);
		return getElementText(driver, UserProductsNamePageUI.MINI_SHOPPING_CART_PRICE );
	}

	public String isMiniShoppingCartQuantity() {
		waitForElementVisible(driver, UserProductsNamePageUI.MINI_SHOPPING_CART_QUANTITY);
		return getElementText(driver, UserProductsNamePageUI.MINI_SHOPPING_CART_QUANTITY );
	}
	
	public String isMiniShoppingCartSubTotal() {
		waitForElementVisible(driver, UserProductsNamePageUI.MINI_SHOPPING_CART_SUB_TOTAL);
		return getElementText(driver, UserProductsNamePageUI.MINI_SHOPPING_CART_SUB_TOTAL );
	}

	public String isMiniShoppingCartAttribute() {
		waitForElementVisible(driver, UserProductsNamePageUI.MINI_SHOPPING_CART_ATTRIBUTES_PR);
		return getElementText(driver, UserProductsNamePageUI.MINI_SHOPPING_CART_ATTRIBUTES_PR);

	}
	
	public void clickUpdateButtonAtOverviewClass() {
		waitForElementClickable(driver, UserProductsNamePageUI.UPDATE_BUTTON_AT_OVERVIEW_CLASS );
		clickToELement(driver, UserProductsNamePageUI.UPDATE_BUTTON_AT_OVERVIEW_CLASS);
	}
	
	public void inputToQtyByButtonNameAtOverviewClass(String buttonName,String qtyNumber) {
		waitForElementVisible(driver, UserProductsNamePageUI.QTY_INPUT_BY_BUTTON_TEXT_AT_OVERVIEW_CLASS, buttonName );
		sendkeyToElement(driver, UserProductsNamePageUI.QTY_INPUT_BY_BUTTON_TEXT_AT_OVERVIEW_CLASS, qtyNumber, buttonName );
	}
	
	
	
	
}
