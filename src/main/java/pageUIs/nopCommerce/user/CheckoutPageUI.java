package pageUIs.nopCommerce.user;

public class CheckoutPageUI {

	public static final String DYNAMIC_BUTTON_BY_ID_AT_CHECKOUT_PAGE = "xpath=//div[@id='%s']//button[text()='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL_AT_CHECKOUT_PAGE = "xpath=//label[contains(text(),'%s')]/preceding-sibling::input";
	public static final String DYNAMIC_TEXT_BY_CLASS_AT_CHECKOUT_PAGE = "xpath=//div[contains(@class,'checkout-data')]//div[@class='%s']//strong";
	public static final String DYNAMIC_TEXT_BY_CLASS_AT_CONFIRM_ORDER = "xpath=//div[@class='%s']//strong";
	public static final String DYNAMIC_CLASS_BY_VALUE_AT_CONFIRM_ORDER = "xpath=//li[@class='%s']//span[@class='value']";
	public static final String DYNAMIC_LIST_INFO_BY_TITLE_NAME_AND_CLASS_NAME_AT_CONFIRM_ORDER = "xpath=//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='%s']";
	
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String NAME_LINK_TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/a";
	public static final String TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/span";
	
	public static final String CART_OPTION_SELECTED_AT_CONFIRM_ORDER = "xpath=//div[@class='cart-options']/div";
	
	public static final String DYNAMIC_CART_TOTAL_INFO_BY_LABEL = "xpath=//table[@class='cart-total']//label[text()='%s']/parent::td/following-sibling::td/span";
	public static final String BUTTON_CONTINUE_AT_ORDER_COMPLETED_PAGE = "xpath=//div[@class='page checkout-page order-completed-page']//button[text()='Continue']";
	
	

}
