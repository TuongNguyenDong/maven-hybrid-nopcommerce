package pageUIs.nopCommerce.admin;

public class AdminCustomersPageUI {
	
	public static final String CUSTOMER_ROLE_SELECTED_BY_NAME = "xpath=//ul[@id='SelectedCustomerRoleIds_taglist']//span[text()='%s']";
	public static final String COLUMN_INDEX_BY_CART_NAME_AND_NAME_COLUMN = "xpath=//div[contains(text(),'%s')]/parent::div/following-sibling::div//tr/th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String COLUMN_INDEX_BY_NAME_COLUMN = "xpath=//tr/th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String TEXT_BY_CART_NAME_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//div[contains(text(),'%s')]/parent::div/following-sibling::div//tbody/tr[%s]/td[%s]";
	public static final String LINK_TEXT_BY_CART_NAME_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//div[contains(text(),'%s')]/parent::div/following-sibling::div//tbody/tr[%s]/td[%s]/a";
	public static final String TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]";
	public static final String LINK_TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/a";
	public static final String PAGING_NEXT = "xpath=//ul/li[contains(@class,'next')]/a[@class='page-link']";
	
	public static final String DATATABLE_EMPTY_AT_ADMIN_CUSTOMER_PAGE = "xpath=//div[contains(text(),'%s')]/parent::div/following-sibling::div//tbody//td[@class='dataTables_empty']";



}
