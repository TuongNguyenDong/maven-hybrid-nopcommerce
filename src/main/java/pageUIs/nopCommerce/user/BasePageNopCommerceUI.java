package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {
	
	public static final String CUSTOMER_INFOR_LINK = "Xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String ADDRESS_LINK = "Xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "XPath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";

	public static final String LOGOUT_LINK_AT_USER = "css=a[class='ico-logout']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";

	public static final String DYNAMIC_PAGES_AT_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//div[@class='page-body']//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BY_LABEL = "xpath=//label[contains(text(),'%s')]/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_ID = "xpath=//input[@id='%s']";

	public static final String DYNAMIC_ERROR_MASSAGE = "xpath=//span[@id='%s']";

	public static final String DYNAMIC_MENU_AT_HOME_PAGE = "xpath=//div[@class='header-menu']/ul[contains(@class,'notmobile')]//a[contains(text(),'%s')]";
	public static final String PAGE_TIILE_BY_TEXT = "xpath=//div[@class='page-title']/h1[text()='%s']";
	public static final String DYNAMIC_PRODUCT_PAGE_BODY_BY_TEXT = "xpath=//div[@class='page-body']//div[contains(@class,'product')]//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_NAME_BY_TEXT = "xpath=//div[@class='products-container']//div[@class='item-box']//a[text()='%s']";
	public static final String DYNAMIC_FOOTER_MENU_NAME = "xpath=//div[@class='footer']//div[contains(@class,'footer-block')]//a[text()='%s']";

	public static final String PRODUCT_ORDER_DROPDOWN = "xpath=//select[@name='products-orderby']";
	public static final String PRODUCT_PAGE_DROPDOWN = "xpath=//select[@name='products-pagesize']";
	public static final String PRODUCT_LIST_NAME_TEXT = "xpath=//div[@class='products-container']//div[@class='product-item']//h2[@class='product-title']/a";
	public static final String PRODUCT_PRICE_TEXT = "xpath=//div[@class='products-container']//div[@class='product-item']//div[@class='prices']//span";
	public static final String DYNAMIC_PAGING_BY_TEXT = "xpath=//div[@class='products-container']//div[@class='pager']//li/a[text()='%s']";
	public static final String ADD_TO_COMPARE_LIST_BY_PRODUCT_NAME = "xpath=//div[@class='item-box']//a[text()='%s']/parent::h2/following-sibling::div//button[text()='Add to compare list']";

	public static final String MESSAGE_ADD_SUCCESS = "xpath=//div[contains(@class,'success')]/p";

	public static final String DYNAMIC_CONTENT_HEADER_BY_TEXT = "xpath=//div[contains(@class,'content-header')]/h1[contains(text(),'%s')]";
	public static final String DYNAMIC_NAV_SIDEBAR_BY_TEXT = "xpath=//ul[contains(@class,'nav-sidebar')]//p[contains(text(),'%s')]/parent::a[@href='#']";
	public static final String DYNAMIC_NAV_TREE_VIEW_BY_TEXT = "xpath=//ul[contains(@class,'nav-treeview')and @style]//p[contains(text(),'%s')]";
	public static final String CART_TITLE_BY_TEXT_AT_ADMIN_PRODUCTS_PAGE = "xpath=//nop-cards[@id='%s']//div[text()='%s']";
	public static final String DYNAMIC_LINK_AT_ADMIN_PAGE = "xpath=//div[contains(@class,'content-header')]/div/a[contains(.,('%s'))]";
	public static final String CHILD_CUSTOMER_DROPDOWN_AT_ADMIN_CUSTOMER_PAGE = "xpath=//ul[@id='SelectedCustomerRoleIds_listbox']/li";
	public static final String PARENT_CUSTOMER_DROPDOWN_AT_ADMIN_CUSTOMER_PAGE = "xpath=//input[contains(@class,'k-input') and @aria-owns='SelectedCustomerRoleIds_taglist SelectedCustomerRoleIds_listbox']";
	public static final String DELETE_CUSTOME_DROPDOWN_MUTIPLE_SELECTED_BY_TEXT = "xpath=//span[text()='%s']/following-sibling::span";
	public static final String DYNAMIC_BUTTON_BY_NAME_AT_ADMIN_PAGE = "xpath=//div[contains(@class,'content-header')]//button[@name='%s']";
	public static final String ARLERT_SUCCESS_AT_ADMIN_PAGE = "xpath=//div[contains(@class,'alert-success')]";
	public static final String DYNAMIC_TEXTAREA_BY_ID = "xpath=//textarea[@id='%s']";
	public static final String DYNAMIC_LINK_AT_FLOAT_LEFT_ADMIN_PAGE = "xpath=//div[contains(@class,'content-header')]/h1//a[contains(.,('%s'))]";
	public static final String SEARCH_BUTTON_AT_ADMIN_PRODUCTS_PAGE = "xpath=//button[contains(@class,'btn-search')]";
	public static final String COLLAPSE_BUTTON_BY_CART_TITLE = "xpath=//div[text()='%s']/following-sibling::div/button";
	public static final String DYNAMIC_BUTTON_BY_TEXT_AT_CUSTOMER_ADMIN_PAGE = "xpath=//div[@class='card-body']//button[contains(.,'%s')]";
	public static final String CHECK_COLLAPSE_CUSTOMER_ADMIN_PAGE = "xpath=//div[contains(@class,'collapsed-card')]//div[text()='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT_AT_ADMIN_PAGE = "xpath=//div[contains(@class,'content-header')]//button[contains(.,'%s')]";

}
