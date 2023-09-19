package pageUIs.nopCommerce.user;

public class UserProductsNamePageUI {
	
	public static final String REVIEW_PRODUCT_TEXT = "xpath=//textarea[@id='AddProductReview_ReviewText']";
	public static final String DYNAMIC_PRODUCT_RATING_RADIO_BUTTON = "xpath=//div[@class='review-rating']//div[@class='rating-options']//input[@aria-label='%s']";
	public static final String MESSAGE_ADD_PRODUCT_REVIEW_SUCCESS = "xpath=//div[@class='result']";
	public static final String DYNAMIC_OVERVIEW_BUTTON_BY_TEXT = "xpath=//div[@class='overview-buttons']//button[text()='%s']";
	public static final String MESSAGE_ADD_TO_WISHLIST_SUCCESS = "xpath=//div[contains(@class,'success')]/p";
	public static final String CLOSE_MESSAGE_ADD_TO_WISHLIST = "xpath=//div[contains(@class,'success')]//span";
	public static final String WISHLIST_LINK = "xpath=//a[@class='ico-wishlist']";
	public static final String ITEM_SCOPE_LINK_BY_NAME = "xpath=//ul//li/a/span[text()='%s']";
	
	
	public static final String ATTRIBUTE_BUTTON_BY_NAME_TEXT_AND_VALUE_TEXT = "xpath=//div[@class='attributes']//label[contains(text(),'%s')]/parent::dt/following-sibling::dd//label[contains(text(),'%s')]/preceding-sibling::input[@type='radio']";
	public static final String ATTRIBUTE_DROPDOWN_BY_NAME_TEXT = "xpath=//div[@class='attributes']//label[contains(text(),'%s')]/parent::dt/following-sibling::dd/select";
	public static final String ATTRIBUTE_CHECKBOX_BY_NAME_TEXT_AND_VALUE_TEXT = "xpath=//div[@class='attributes']//label[contains(text(),'%s')]/parent::dt/following-sibling::dd//label[contains(text(),'%s')]/preceding-sibling::input[@type='checkbox']";
	public static final String ADD_TO_CART_AT_OVERVIEW_CLASS = "xpath=//div[@class='overview']//button[text()='Add to cart']";
	
	public static final String SHOPPING_CART_LINK = "xpath=//a[@class='ico-cart']";
	public static final String CLOSE_ADD_TO_CART_SUCCESS_MESSAGE = "xpath=//div[contains(@class,'success')]//span";
	
	public static final String SHOPPING_CART_QUANTITY_BY_TEXT = "xpath=//div[@class='header-links']//li/a/span[text()='%s']/following-sibling::span";
	
	public static final String MINI_SHOPPING_CART_COUNT = "xpath=//div[@class='mini-shopping-cart']/div[@class='count']";
	public static final String MINI_SHOPPING_CART_NAME = "xpath=//div[@class='mini-shopping-cart']//div[@class='name']/a";
	public static final String MINI_SHOPPING_CART_ATTRIBUTES_PR = "xpath=//div[@class='mini-shopping-cart']//div[@class='attributes']";
	
	public static final String MINI_SHOPPING_CART_PRICE = "xpath=//div[@class='mini-shopping-cart']//div[@class='price']/span";
	public static final String MINI_SHOPPING_CART_QUANTITY = "xpath=//div[@class='mini-shopping-cart']//div[@class='quantity']/span";
	public static final String MINI_SHOPPING_CART_SUB_TOTAL = "xpath=//div[@class='mini-shopping-cart']//div[@class='totals']/strong";
	
	
	
	



}
