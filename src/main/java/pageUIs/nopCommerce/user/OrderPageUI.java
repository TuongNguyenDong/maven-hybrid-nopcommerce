package pageUIs.nopCommerce.user;

public class OrderPageUI {
	
	public static final String ORDER_NUMBER_NAME_AT_ORDER_PAGE  = "xpath=//div[@class='order-list']//strong";
	
	public static final String DYNAMIC_TEXT_BY_CLASS_AT_ORDER_PAGE = "xpath=//div[@class='%s']//strong";
	public static final String DYNAMIC_CLASS_BY_VALUE_AT_ORDER_PAGE = "xpath=//li[@class='%s']//span[@class='value']";
	public static final String OPTION_SELECTED_AT_ORDER_PAGE = "xpath=//div[@class='section options']/div";
	public static final String DYNAMIC_CART_TOTAL_INFO_BY_LABEL = "xpath=//table[@class='cart-total']//label[text()='%s']/parent::td/following-sibling::td/span";
	
	public static final String TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/span";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String DYNAMIC_LIST_INFO_BY_TITLE_NAME_AND_CLASS_NAME_AT_ORDER_PAGE = "xpath=//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='%s']";
	public static final String NAME_LINK_TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/em/a";
	
	public static final String ORDER_NUMBER_IN_ORDER_OVERVIEW_AT_ORDER_PAGE = "xpath=//div[@class='order-overview']/div[@class='order-number']//strong";
	public static final String DYNAMIC_ORDER_CONTENT_IN_ORDER_OVERVIEW_AT_ORDER_PAGE_BY_CLASS = "xpath=//ul[@class='order-overview-content']/li[@class='%s']";
	
	public static final String RE_ORDER_BUTTON = "xpath=//div[@class='page-body']//button[text()='Re-order']";
	
	
	
}
