package pageUIs.nopCommerce.user;

public class ShoppingCartPageUI {

	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String NAME_LINK_TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/a";
	public static final String EDIT_ITEM_LINK = "xpath=//div[@class='edit-item']/a";

	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/span";
	public static final String BUTTON_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/button";
	public static final String ORDER_SUMURY_CONTENT = "xpath=//div[@class='page-body']//div[@class='order-summary-content']/div";
	public static final String WISHLIST_LINK = "xpath=//a[@class='ico-wishlist']";
	
	public static final String SHOPPING_CART_LINK = "xpath=//a[@class='ico-cart']";
	public static final String SHOPPING_CART_QUANTITY_BY_TEXT = "xpath=//div[@class='header-links']//li/a/span[text()='%s']/following-sibling::span";
	public static final String MINI_SHOPPING_CART_COUNT = "xpath=//div[@class='mini-shopping-cart']/div[@class='count']";
	public static final String SHOPPING_CART_BUTTION_BY_TEXT = "xpath=//div[@class='cart-options']/div[@class='common-buttons']/button[text()='%s']";
	
	public static final String TERMS_OF_SERVICE = "xpath=//div[@class='terms-of-service']/input";
	public static final String CHECKOUT_BUTTON = "xpath=//div[@class='page-body']//button[contains(text(),'Checkout')]";


}
