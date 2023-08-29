package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {
	public static final String CUSTOMER_INFOR_LINK = "Xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String ADDRESS_LINK = "Xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "XPath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	

	public static final String LOGOUT_LINK_AT_USER = "css=a[class='ico-logout']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	
	// Pattern Object
	public static final String DYNAMIC_PAGES_AT_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//div[@class='page-body']//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
	
	public static final String DYNAMIC_ERROR_MASSAGE = "xpath=//span[@id='%s']";

	public static final String DYNAMIC_MENU_AT_HOME_PAGE = "xpath=//div[@class='header-menu']/ul[contains(@class,'notmobile')]//a[contains(text(),'%s')]";
	public static final String PAGE_TIILE_BY_TEXT = "xpath=//div[@class='page-title']/h1[text()='%s']";
	public static final String DYNAMIC_PRODUCT_PAGE_BODY_BY_TEXT = "xpath=//div[@class='page-body']//div[contains(@class,'product')]//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_NAME_BY_TEXT = "xpath=//div[@class='products-container']//div[@class='item-box']//a[text()='%s']";
	public static final String DYNAMIC_FOOTER_MENU_NAME = "xpath=//div[@class='footer']//div[contains(@class,'footer-block')]//a[text()='%s']";
	
	public static final String PRODUCT_ORDER_DROPDOWN = "xpath=//select[@name='products-orderby']";
	public static final String PRODUCT_NAME_TEXT = "xpath=//div[@class='products-container']//div[@class='product-item']//h2[@class='product-title']/a";
	public static final String PRODUCT_PRICE_TEXT = "xpath=//div[@class='products-container']//div[@class='product-item']//div[@class='prices']//span";

}
