package pageUIs.nopCommerce.admin;

public class AdminCustomersPageUI {
	
	public static final String CUSTOMER_ROLE_SELECTED_BY_NAME = "xpath=//ul[@id='SelectedCustomerRoleIds_taglist']//span[text()='%s']";
	public static final String COLUMN_INDEX_BY_CART_NAME_AND_NAME_COLUMN = "xpath=//div[contains(text(),'%s')]/parent::div/following-sibling::div//tr/th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String COLUMN_INDEX_BY_NAME_COLUMN = "xpath=//tr/th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String TEXT_BY_CART_NAME_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//div[contains(text(),'%s')]/parent::div/following-sibling::div//tbody/tr[%s]/td[%s]";
	public static final String TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]";

//	public static final String TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX_TEST = "xpath=//tbody/tr/td[%s]";
	public static final String LINK_TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/a";
	public static final String PAGING_NEXT = "xpath=//ul/li[contains(@class,'next')]/a[@class='page-link']";
//	public static final String TEX_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr/td[text()='Guests']/following-sibling::td[text()='Automation FC']";
//	public static final String TEX_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr/td[text()='Guests']/preceding-sibling::td[text()='Automation FC']";
	
//	public static final String TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]";
//	public static final String ICONS_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/i";
//	public static final String SEARCH_BUTTON_AT_ADMIN_PRODUCTS_PAGE = "xpath=//button[contains(@class,'btn-search')]";
//	public static final String DATATABLE_EMPTY_AT_ADMIN_PRODUCTS_PAGE = "xpath=//tbody//td[@class='dataTables_empty']";
//	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/ancestor::div/following-sibling::div/input";
//	public static final String GO_BUTTON_AT_ADMIN_PRODUCTS_PAGE = "xpath=//button[@name='go-to-product-by-sku']";
//	
//	public static final String CART_TITLE_BY_TEXT_AT_ADMIN_PRODUCTS_PAGE = "xpath=//nop-cards[@id='product-cards']//div[text()='%s']";
//	public static final String PRODUCT_DETAIL_BY_LABEL_AT_ADMIN_PRODUCTS_PAGE = "xpath=//div[@class='card-body']//label[text()='%s']";


}
