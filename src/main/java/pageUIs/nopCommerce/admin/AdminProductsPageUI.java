package pageUIs.nopCommerce.admin;

public class AdminProductsPageUI {
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String TEXT_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]";
	public static final String ICONS_BY_COLUMN_INDEX_AND_ROM_INDEX = "xpath=//tbody/tr[%s]/td[%s]/i";

	public static final String DATATABLE_EMPTY_AT_ADMIN_PRODUCTS_PAGE = "xpath=//tbody//td[@class='dataTables_empty']";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/ancestor::div/following-sibling::div/input";
	public static final String GO_BUTTON_AT_ADMIN_PRODUCTS_PAGE = "xpath=//button[@name='go-to-product-by-sku']";
	
	public static final String PRODUCT_DETAIL_BY_LABEL_AT_ADMIN_PRODUCTS_PAGE = "xpath=//div[@class='card-body']//label[text()='%s']";


}
