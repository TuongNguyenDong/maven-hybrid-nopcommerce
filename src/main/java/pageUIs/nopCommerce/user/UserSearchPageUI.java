package pageUIs.nopCommerce.user;

public class UserSearchPageUI {
	
	public static final String SEARCH_MESSAGE = "xpath=//div[@class='products-wrapper']/div";
	public static final String SEARCH_TEXT_BY_LABLE = "xpath=//label[contains(text(),'Search keyword')]/following-sibling::input";
	public static final String SEARCH_RESULT_BY_NAME = "xpath=//div[@class='products-container']//div[@class='item-box']//a[contains(text(),'%s')]";
	public static final String SEARCH_RESULT_ABSOLUTE_BY_NAME = "xpath=//div[@class='products-container']//div[@class='item-box']//a[contains(text(),'%s')]";
	

}
