package pageUIs.nopCommerce.user;

public class CompareProductsPageUI {
	


	public static final String TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]/a";
	public static final String PRICE_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]";
	public static final String SPEC_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]";
	public static final String COLUMN_BY_NAME = "xpath=//tbody/tr/td/label[text()='%s']/parent::td/parent::tr/preceding-sibling::tr";
	public static final String REMOVE_BUTTON_BY_COLUMN_INDEX = "xpath=//tbody/tr/td[%s]/button";
	public static final String CLEAR_LIST = "xpath=//div[@class='page-body']/a[text()='Clear list']";
	public static final String MESSAGE_CLEAR_LIST = "xpath=//div[@class='page-body']/div[text()='You have no items to compare.']";
	
	

}
