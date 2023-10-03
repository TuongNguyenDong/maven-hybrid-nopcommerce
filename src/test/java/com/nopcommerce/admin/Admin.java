package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductsPageObject;

public class Admin extends BaseTest {

	private WebDriver driver;
	private String adminEmailAddress, adminPassword, productName1, price1, SKU1, stockQty1, category1, childCategory1, manufacturerHP;

	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminProductsPageObject adminProductPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
		productName1 = "Build your own computer";
		price1 = "1200";
		SKU1 = "COMP_CUST";
		stockQty1 = "10000";
		category1 = "Computers";
		childCategory1 = "Computers >> Desktops";
		manufacturerHP = "HP";

		log.info("Precondition - Step 01: Enter to Email textbox with value is '" + adminEmailAddress + "'");
		adminLoginPage.inputToTextboxByID(driver, "Email", adminEmailAddress);

		log.info("Precondition - Step 02: Enter to LastName textbox with value is '" + adminPassword + "'");
		adminLoginPage.inputToTextboxByID(driver, "Password", adminPassword);

		log.info("Precondition - Step 03: Click to 'Log in' button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();

		log.info("Precondition - Step 04: Verify Content Header 'Dashboard' title is displayed ");
		Assert.assertTrue(adminDashboardPage.isContentHeaderByText(driver, "Dashboard"));

		log.info("Precondition - Step 05: Click  To 'Catalog' nav SideBar");
		adminDashboardPage.clickToNavSideBarByName(driver, "Catalog");

		log.info("Precondition - Step 06: Navigate  To 'Products' page");
		adminProductPage = (AdminProductsPageObject) adminDashboardPage.openpageAtNavSideBarByName(driver, "Products");

		log.info("Precondition - Step 07: Verify Content Header 'Products' title is displayed ");
		Assert.assertTrue(adminProductPage.isContentHeaderByText(driver, "Products"));

	}

	@Test
	public void Admin_01_Search_With_Product_Name() {

		log.info("Admin_01_Search_With_Product_Name - Step 01: Enter to Product name textbox with value is '" + productName1 + "'");
		adminProductPage.inputToTextboxByID(driver, "SearchProductName", productName1);

		log.info("Admin_01_Search_With_Product_Name - Step 02: click To Search Button");
		adminProductPage.clicktoSearchButtonAtAdminProductsPage();

		log.info("Admin_01_Search_With_Product_Name - Step 03: Verify 'Product name' product is displayed with value '" + productName1 + "'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("Product name", "1"), productName1);

		log.info("Admin_01_Search_With_Product_Name - Step 04: Verify 'SKU' product is  displayed with value " + SKU1 + "'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("SKU", "1"), SKU1);

		log.info("Admin_01_Search_With_Product_Name - Step 05: Verify 'Price' product is  displayed with value " + price1 + "'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("Price", "1"), price1);

		log.info("Admin_01_Search_With_Product_Name - Step 06: Verify 'Stock quantity' product is  displayed with value " + stockQty1 + "'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("Stock quantity", "1"), stockQty1);

		log.info("Admin_01_Search_With_Product_Name - Step 07: Verify 'Published' product is displayed");
		Assert.assertTrue(adminProductPage.getIconsByColumnAtRowNumberatAdminProductPage("Published", "1"));

	}

	@Test
	public void Admin_02_Search_With_Product_Name_Catagory_Uncheck() {
		log.info("Admin_02_Search_With_Product_Name_Catagory_Uncheck - Step 01: Refresh Current Page");
		adminProductPage.refreshCurrentPage(driver);

		log.info("Admin_02_Search_With_Product_Name_Catagory_Uncheck - Step 02: Enter to Product name textbox with value is '" + productName1 + "'");
		adminProductPage.inputToTextboxByID(driver, "SearchProductName", productName1);

		log.info("Admin_02_Search_With_Product_Name_Catagory_Uncheck - Step 03: Select Dropdown Category with value is '" + category1 + "'");
		adminProductPage.selectToDropdownByName(driver, "SearchCategoryId", category1);

		log.info("Admin_02_Search_With_Product_Name_Catagory_Uncheck - Step 04: Uncheck to Checkbox 'Search subcategories' ");
		adminProductPage.unCheckToCheckboxByLabel("Search subcategories");

		log.info("Admin_02_Search_With_Product_Name_Catagory_Uncheck - Step 05: click To Search Button");
		adminProductPage.clicktoSearchButtonAtAdminProductsPage();

		log.info("Admin_02_Search_With_Product_Name_Catagory_Uncheck - Step 06: Verify  'DataTable' empty ");
		Assert.assertTrue(adminProductPage.isDataTableEmpty());

	}

	@Test
	public void Admin_03_Search_With_Product_Name_Catagory_Checked() {

		log.info("Admin_03_Search_With_Product_Name_Catagory_Checked - Step 01: Refresh Current Page");
		adminProductPage.refreshCurrentPage(driver);

		log.info("Admin_03_Search_With_Product_Name_Catagory_Checked - Step 02: Enter to Product name textbox with value is '" + productName1 + "'");
		adminProductPage.inputToTextboxByID(driver, "SearchProductName", productName1);

		log.info("Admin_03_Search_With_Product_Name_Catagory_Checked - Step 03: Select Dropdown Category with value is '" + category1 + "'");
		adminProductPage.selectToDropdownByName(driver, "SearchCategoryId", category1);

		log.info("Admin_03_Search_With_Product_Name_Catagory_Checked - Step 04: Uncheck to Checkbox 'Search subcategories' ");
		adminProductPage.clickToCheckboxByLabel("Search subcategories");

		log.info("Admin_03_Search_With_Product_Name_Catagory_Checked - Step 05: click To Search Button");
		adminProductPage.clicktoSearchButtonAtAdminProductsPage();

		log.info("Admin_03_Search_With_Product_Name_Catagory_Checked - Step 06: Verify 'Product name' product is displayed with value '" + productName1 + "'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("Product name", "1"), productName1);

		log.info("Admin_03_Search_With_Product_Name_Catagory_Checked - Step 07: Verify 'SKU' product is  displayed with value " + SKU1 + "'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("SKU", "1"), SKU1);

		log.info("Admin_03_Search_With_Product_Name_Catagory_Checked - Step 08: Verify 'Price' product is  displayed with value " + price1 + "'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("Price", "1"), price1);

		log.info("Admin_03_Search_With_Product_Name_Catagory_Checked - Step 09: Verify 'Stock quantity' product is  displayed with value " + stockQty1 + "'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("Stock quantity", "1"), stockQty1);

		log.info("Admin_03_Search_With_Product_Name_Catagory_Checked - Step 10: Verify 'Published' product is displayed");
		Assert.assertTrue(adminProductPage.getIconsByColumnAtRowNumberatAdminProductPage("Published", "1"));

	}

	@Test
	public void Admin_04_Search_With_Product_Name_Child_Catagory() {

		log.info("Admin_04_Search_With_Product_Name_Child_Catagory - Step 01: Refresh Current Page");
		adminProductPage.refreshCurrentPage(driver);

		log.info("Admin_04_Search_With_Product_Name_Child_Catagory - Step 02: Enter to Product name textbox with value is '" + productName1 + "'");
		adminProductPage.inputToTextboxByID(driver, "SearchProductName", productName1);

		log.info("Admin_04_Search_With_Product_Name_Child_Catagory - Step 03: Select Dropdown Category with value is '" + childCategory1 + "'");
		adminProductPage.selectToDropdownByName(driver, "SearchCategoryId", childCategory1);

		log.info("Admin_04_Search_With_Product_Name_Child_Catagory - Step 04: Uncheck to Checkbox 'Search subcategories' ");
		adminProductPage.unCheckToCheckboxByLabel("Search subcategories");

		log.info("Admin_04_Search_With_Product_Name_Child_Catagory - Step 05: click To Search Button");
		adminProductPage.clicktoSearchButtonAtAdminProductsPage();

		log.info("Admin_04_Search_With_Product_Name_Child_Catagory - Step 06: Verify 'Product name' product is displayed with value '" + productName1 + "'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("Product name", "1"), productName1);

		log.info("Admin_04_Search_With_Product_Name_Child_Catagory - Step 07: Verify 'SKU' product is  displayed with value " + SKU1 + "'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("SKU", "1"), SKU1);

		log.info("Admin_04_Search_With_Product_Name_Child_Catagory - Step 08: Verify 'Price' product is  displayed with value " + price1 + "'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("Price", "1"), price1);

		log.info("Admin_04_Search_With_Product_Name_Child_Catagory - Step 09: Verify 'Stock quantity' product is  displayed with value " + stockQty1 + "'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("Stock quantity", "1"), stockQty1);

		log.info("Admin_04_Search_With_Product_Name_Child_Catagory - Step 10: Verify 'Published' product is displayed");
		Assert.assertTrue(adminProductPage.getIconsByColumnAtRowNumberatAdminProductPage("Published", "1"));

	}

	@Test
	public void Admin_05_Search_With_Product_Name_Manufacturer() {

		log.info("Admin_05_Search_With_Product_Name_Manufacturer - Step 01: Refresh Current Page");
		adminProductPage.refreshCurrentPage(driver);

		log.info("Admin_05_Search_With_Product_Name_Manufacturer - Step 02: Enter to Product name textbox with value is '" + productName1 + "'");
		adminProductPage.inputToTextboxByID(driver, "SearchProductName", productName1);

		log.info("Admin_05_Search_With_Product_Name_Manufacturer - Step 03: Select Dropdown Category with value is 'All'");
		adminProductPage.selectToDropdownByName(driver, "SearchCategoryId", "All");

		log.info("Admin_05_Search_With_Product_Name_Manufacturer - Step 04: Uncheck to Checkbox 'Search subcategories' ");
		adminProductPage.clickToCheckboxByLabel("Search subcategories");

		log.info("Admin_05_Search_With_Product_Name_Manufacturer - Step 05: Select Dropdown Manufacturer with value is '" + manufacturerHP + "'");
		adminProductPage.selectToDropdownByName(driver, "SearchManufacturerId", manufacturerHP);

		log.info("Admin_05_Search_With_Product_Name_Manufacturer - Step 06: click To Search Button");
		adminProductPage.clicktoSearchButtonAtAdminProductsPage();

		log.info("Admin_05_Search_With_Product_Name_Manufacturer - Step 07: Verify  'DataTable' empty ");
		Assert.assertTrue(adminProductPage.isDataTableEmpty());

	}
	
	@Test
	public void Admin_06_Go_Direct_Product_SKU() {

		log.info("Admin_06_Go_Direct_Product_SKU - Step 01: Refresh Current Page");
		adminProductPage.refreshCurrentPage(driver);

		log.info("Admin_06_Go_Direct_Product_SKU - Step 02: Enter to Go Directly To Product SKU textbox with value is '" + SKU1 + "'");
		adminProductPage.inputToTextboxByID(driver, "GoDirectlyToSku", SKU1);

		log.info("Admin_06_Go_Direct_Product_SKU - Step 03: click To Go Button");
		adminProductPage.clicktoGoButtonAtAdminProductsPage();
		
		log.info("Admin_06_Go_Direct_Product_SKU - Step 04: Verify Cart Title 'Product info' is displayed ");
		Assert.assertTrue(adminProductPage.isCartTitleByText( "Product info"));
		
		log.info("Admin_06_Go_Direct_Product_SKU - Step 05: Verify 'Product name' is displayed ");
		Assert.assertTrue(adminProductPage.isProductDetailByLabel( "Product name"));
		
		log.info("Admin_06_Go_Direct_Product_SKU - Step 06: Verify 'productName1' is displayed ");
		Assert.assertEquals(adminProductPage.getTextboxValueByID( driver, "Name"),productName1);
		
		log.info("Admin_06_Go_Direct_Product_SKU - Step 07: Verify 'Short description' is displayed ");
		Assert.assertTrue(adminProductPage.isProductDetailByLabel( "Short description"));
		
		log.info("Admin_06_Go_Direct_Product_SKU - Step 08: Verify 'Full description' is displayed ");
		Assert.assertTrue(adminProductPage.isProductDetailByLabel( "Full description"));
			
		log.info("Admin_06_Go_Direct_Product_SKU - Step 09: Verify 'SKU' is displayed ");
		Assert.assertTrue(adminProductPage.isProductDetailByLabel( "SKU"));
		
		log.info("Admin_06_Go_Direct_Product_SKU - Step 10: Verify 'SKU1' is displayed ");
		Assert.assertEquals(adminProductPage.getTextboxValueByID( driver, "Sku"), SKU1);
		


	}

	@Test
	public void TC_04() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
//		closeBrowserDriver();		
	}

}
