package pageUIs.nopCommerce.admin;

public class AdminProductsPageUI {
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]";
	public static final String ICONS_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/i";
	public static final String SEARCH_BUTTON_AT_ADMIN_PRODUCTS_PAGE = "xpath=//button[contains(@class,'btn-search')]";
	public static final String DATATABLE_EMPTY_AT_ADMIN_PRODUCTS_PAGE = "xpath=//tbody//td[@class='dataTables_empty']";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/ancestor::div/following-sibling::div/input";


}
