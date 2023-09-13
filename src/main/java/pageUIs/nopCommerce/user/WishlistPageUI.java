package pageUIs.nopCommerce.user;

public class WishlistPageUI {
	


	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/a";
	public static final String WISHLIST_SHARING = "xpath=//div[@class='share-info']/span[text()='Your wishlist URL for sharing:']/following-sibling::a";
	public static final String COLUMN_BY_NAME = "xpath=//tr/th[text()='Add to cart']";
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input";
	public static final String ADD_TO_CART_BUTTON = "xpath=//div[@class='page-body']//button[text()='Add to cart']";
	public static final String MESSAGE_WISHLIST_EMPTY = "xpath=//div[@class='page wishlist-page']//div[contains(text(),'The wishlist is empty!')]";
	public static final String REMOVE_BUTTON_BY_PRODUCT_NAME = "xpath=//tbody/tr/td[@class='product']/a[text()='%s']/parent::td/following-sibling::td/button";
	
	



	



}
