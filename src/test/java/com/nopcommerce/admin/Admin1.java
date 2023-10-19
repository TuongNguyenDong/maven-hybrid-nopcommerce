package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminCustomersPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductsPageObject;

public class Admin1 extends BaseTest {

	private WebDriver driver;
	private String adminEmailAddress, adminPassword, productName1, price1, SKU1, stockQty1, category1, childCategory1, manufacturerHP;
	private String newCusEmailAddress, newCusPassword, newCusFirstName, newCusLastName, newCusDateofBirth, newCusCompanyName, newCustomerRole, newCusAdminComment;
	private String editCusEmailAddress, editCusFirstName, editCusLastName, editCusDateofBirth, editCusCompanyName, editCusAdminComment;
	private String searchCusMonthofBirth, searchCusDateofBirth;
	private String searchEditCusMonthofBirth, searchEditCusDateofBirth;

	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminProductsPageObject adminProductPage;
	private AdminCustomersPageObject admincustomerPage;

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

		newCusEmailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		newCusPassword = "123456";
		newCusFirstName = "Automation22";
		newCusLastName = "FC22";
		newCusDateofBirth = "11/11/2022";
		newCusCompanyName = "Automation FC";
		newCustomerRole = "Guests";
		newCusAdminComment = "Add new customer (Guest)";
		searchCusDateofBirth = "11";
		searchCusMonthofBirth = "11";

		editCusEmailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		editCusFirstName = "Automation4";
		editCusLastName = "FC4";
		editCusDateofBirth = "02/02/2002";
		editCusCompanyName = "Automation FC4";
		editCusAdminComment = "Edit customer (Guest)";
		searchEditCusDateofBirth = "2";
		searchEditCusMonthofBirth = "2";

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
		adminProductPage.clicktoSearchButtonAtAdminProductsPage(driver);

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
		adminProductPage.clicktoSearchButtonAtAdminProductsPage(driver);

		log.info("Admin_02_Search_With_Product_Name_Catagory_Uncheck - Step 06: Verify  'DataTable' empty ");
		Assert.assertTrue(adminProductPage.isDataTableEmptyAtAdminProductPage());

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
		adminProductPage.clicktoSearchButtonAtAdminProductsPage(driver);

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
		adminProductPage.clicktoSearchButtonAtAdminProductsPage(driver);

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
		adminProductPage.clicktoSearchButtonAtAdminProductsPage(driver);

		log.info("Admin_05_Search_With_Product_Name_Manufacturer - Step 07: Verify  'DataTable' empty ");
		Assert.assertTrue(adminProductPage.isDataTableEmptyAtAdminProductPage());

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
		Assert.assertTrue(adminProductPage.isCartTitleByCartNameAndCartTitle(driver, "product-cards", "Product info"));

		log.info("Admin_06_Go_Direct_Product_SKU - Step 05: Verify 'Product name' is displayed ");
		Assert.assertTrue(adminProductPage.isProductDetailByLabel("Product name"));

		log.info("Admin_06_Go_Direct_Product_SKU - Step 06: Verify 'productName1' is displayed ");
		Assert.assertEquals(adminProductPage.getTextboxValueByID(driver, "Name"), productName1);

		log.info("Admin_06_Go_Direct_Product_SKU - Step 07: Verify 'Short description' is displayed ");
		Assert.assertTrue(adminProductPage.isProductDetailByLabel("Short description"));

		log.info("Admin_06_Go_Direct_Product_SKU - Step 08: Verify 'Full description' is displayed ");
		Assert.assertTrue(adminProductPage.isProductDetailByLabel("Full description"));

		log.info("Admin_06_Go_Direct_Product_SKU - Step 09: Verify 'SKU' is displayed ");
		Assert.assertTrue(adminProductPage.isProductDetailByLabel("SKU"));

		log.info("Admin_06_Go_Direct_Product_SKU - Step 10: Verify 'SKU1' is displayed ");
		Assert.assertEquals(adminProductPage.getTextboxValueByID(driver, "Sku"), SKU1);

	}

	@Test
	public void Admin_07_Create_New_Customer() {

		log.info("Admin_07_Create_New_Customer - Step 01: Click  To 'Customers' nav SideBar");
		adminProductPage.clickToNavSideBarByName(driver, "Customers");

		log.info("Admin_07_Create_New_Customer - Step 02: Navigate  To 'Customers' page");
		admincustomerPage = (AdminCustomersPageObject) adminProductPage.openpageAtNavSideBarByName(driver, "Customers");

		log.info("Admin_07_Create_New_Customer - Step 03: Verify Content Header 'Customers' title is displayed ");
		Assert.assertTrue(admincustomerPage.isContentHeaderByText(driver, "Customers"));

		log.info("Admin_07_Create_New_Customer - Step 04: Click  To 'Add new' at Admin Customer Page");
		admincustomerPage.clickToLinkAtAdminPageByName(driver, "Add new");

		log.info("Admin_07_Create_New_Customer - Step 05: Verify Cart Title 'Customer info' is displayed ");
		Assert.assertTrue(admincustomerPage.isCartTitleByCartNameAndCartTitle(driver, "customer-cards", "Customer info"));

		log.info("Admin_07_Create_New_Customer - Step 07: Enter to Email textbox with value is '" + newCusEmailAddress + "'");
		admincustomerPage.inputToTextboxByID(driver, "Email", newCusEmailAddress);

		log.info("Admin_07_Create_New_Customer - Step 08: Enter to Password textbox with value is '" + newCusPassword + "'");
		admincustomerPage.inputToTextboxByID(driver, "Password", newCusPassword);

		log.info("Admin_07_Create_New_Customer - Step 09: Enter to FirstName textbox with value is '" + newCusFirstName + "'");
		admincustomerPage.inputToTextboxByID(driver, "FirstName", newCusFirstName);

		log.info("Admin_07_Create_New_Customer - Step 10: Enter to LastName textbox with value is '" + newCusLastName + "'");
		admincustomerPage.inputToTextboxByID(driver, "LastName", newCusLastName);

		log.info("Admin_07_Create_New_Customer - Step 11: Click to Radio button 'Female'");
		admincustomerPage.clicktoRadioButtonByLabel(driver, "Female");

		log.info("Admin_07_Create_New_Customer - Step 12: Enter to DateOfBirth textbox with value is '" + newCusDateofBirth + "'");
		admincustomerPage.inputToTextboxByID(driver, "DateOfBirth", newCusDateofBirth);

		log.info("Admin_07_Create_New_Customer - Step 13: Enter to Company  Name textbox with value is '" + newCusCompanyName + "'");
		admincustomerPage.inputToTextboxByID(driver, "Company", newCusCompanyName);

		log.info("Admin_07_Create_New_Customer - Step 14: Delete to Customer Role Dropdown selected 'Registered' ");
		admincustomerPage.clickToCustomeDropdownSelectedByName(driver, "Registered");

		log.info("Admin_07_Create_New_Customer - Step 15: Select Dropdown Customers Role with value '" + newCustomerRole + "'");
		admincustomerPage.selectToAdminCustomerRoleDropdown(driver, newCustomerRole);

		log.info("Admin_07_Create_New_Customer - Step 16: Click to Checkbox 'Active' ");
		admincustomerPage.clickToCheckboxByID(driver, "Active");

		log.info("Admin_07_Create_New_Customer - Step 17: Enter to Admin Comment textarea with value is '" + newCusAdminComment + "'");
		admincustomerPage.inputToTextareaByID(driver, "AdminComment", newCusAdminComment);

		log.info("Admin_07_Create_New_Customer - Step 18: Click to Checkbox 'Save and Continue Edit' button ");
		admincustomerPage.clickToButtonByNameAtAdminPage(driver, "save-continue");

		log.info("Admin_07_Create_New_Customer - Step 19: Verify Address  add success message is displayed ");
		Assert.assertTrue(admincustomerPage.getArlertMessageSuccessAtAdminPage(driver).contains("The new customer has been added successfully."));

		log.info("Admin_07_Create_New_Customer - Step 20: Verify Email textbox is displayed with value '" + newCusEmailAddress + "' ");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Email"), newCusEmailAddress);

		log.info("Admin_07_Create_New_Customer - Step 21: Verify FirstName textbox is displayed with value '" + newCusFirstName + "' ");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "FirstName"), newCusFirstName);

		log.info("Admin_07_Create_New_Customer - Step 22: Verify LastName textbox is displayed with value '" + newCusLastName + "' ");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "LastName"), newCusLastName);

		log.info("Admin_07_Create_New_Customer - Step 23: Verify Radio button 'Female' is selected ");
		Assert.assertTrue(admincustomerPage.isDefaultCheckboxOrRadioButtonSelectedByLabel(driver, "Female"));

		log.info("Admin_07_Create_New_Customer - Step 24: Verify Date of Birth textbox is displayed with value '" + newCusDateofBirth + "' ");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "DateOfBirth"), newCusDateofBirth);

		log.info("Admin_07_Create_New_Customer - Step 25: Verify Company textbox is displayed with value '" + newCusCompanyName + "' ");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Company"), newCusCompanyName);

		log.info("Admin_07_Create_New_Customer - Step 26: Verify CustomerRole Dropdown TextArea is displayed with value '" + newCustomerRole + "' ");
		Assert.assertEquals(admincustomerPage.getCustomerRoleTextByName(newCustomerRole), newCustomerRole);

		log.info("Admin_07_Create_New_Customer - Step 27: Verify Checkbox 'Active' is selected ");
		Assert.assertTrue(admincustomerPage.isDefaultCheckboxOrRadioButtonSelectedByID(driver, "Active"));

		log.info("Admin_07_Create_New_Customer - Step 28: Verify AdminComment TextArea is displayed with value '" + newCusAdminComment + "' ");
		Assert.assertEquals(admincustomerPage.getTextAreaByID(driver, "AdminComment"), newCusAdminComment);

		log.info("Admin_07_Create_New_Customer - Step 29: Click  To 'back to customer list' Link at Admin Customer Page");
		admincustomerPage.clickToFloatLeftLinkAtAdminPageByName(driver, "back to customer list");
		
		log.info("Admin_07_Create_New_Customer - Step 30: Select to MonthofBirth Dropdown with value is '" + searchCusMonthofBirth + "'");
		admincustomerPage.selectToDropdownByName(driver, "SearchMonthOfBirth", searchCusMonthofBirth);

		log.info("Admin_07_Create_New_Customer - Step 31: Select to DateofBirth Dropdown with value is '" + searchCusDateofBirth + "'");
		admincustomerPage.selectToDropdownByName(driver, "SearchDayOfBirth", searchCusDateofBirth);

		log.info("Admin_07_Create_New_Customer - Step 32: Delete to Customer Role Dropdown selected 'Registered' ");
		admincustomerPage.clickToCustomeDropdownSelectedByName(driver, "Registered");

		log.info("Admin_07_Create_New_Customer - Step 33: Select Dropdown Customers Role with value '" + newCustomerRole + "'");
		admincustomerPage.selectToAdminCustomerRoleDropdown(driver, newCustomerRole);

		log.info("Admin_07_Create_New_Customer - Step 34: click To Search Button");
		admincustomerPage.clicktoSearchButtonAtAdminProductsPage(driver);
		
		log.info("Admin_07_Create_New_Customer - Step 35: Verify 'Name' CustomerRole is displayed with value '" + newCusFirstName + " " + newCusLastName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Name", "1"), newCusFirstName + " " + newCusLastName);

		log.info("Admin_07_Create_New_Customer - Step 36: Verify 'Customer roles' CustomerRole is displayed with value '" + newCustomerRole + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Customer roles", "1"), newCustomerRole);

		log.info("Admin_07_Create_New_Customer - Step 37: Verify 'Company name' CustomerRole is displayed with value '" + newCusCompanyName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Company name", "1"), newCusCompanyName);

	}

	@Test
	public void Admin_08_Search_Customer_With_Email() {

		log.info("Admin_08_Search_Customer_With_Email - Step 01: Refresh Current Page");
		adminProductPage.refreshCurrentPage(driver);

		log.info("Admin_08_Search_Customer_With_Email - Step 02: Enter to Email textbox with value is '" + newCusEmailAddress + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchEmail", newCusEmailAddress);

		log.info("Admin_08_Search_Customer_With_Email - Step 03: Delete to Customer Role Dropdown selected 'Registered' ");
		admincustomerPage.clickToCustomeDropdownSelectedByName(driver, "Registered");

		log.info("Admin_08_Search_Customer_With_Email - Step 04: Select Dropdown Customers Role with value '" + newCustomerRole + "'");
		admincustomerPage.selectToAdminCustomerRoleDropdown(driver, newCustomerRole);

		log.info("Admin_08_Search_Customer_With_Email - Step 05: click To Search Button");
		admincustomerPage.clicktoSearchButtonAtAdminProductsPage(driver);

		log.info("Admin_08_Search_Customer_With_Email - Step 06: Verify 'Name' CustomerRole is displayed with value '" + newCusFirstName + " " + newCusLastName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Name", "1"), newCusFirstName + " " + newCusLastName);

		log.info("Admin_08_Search_Customer_With_Email - Step 07: Verify 'Customer roles' CustomerRole is displayed with value '" + newCustomerRole + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Customer roles", "1"), newCustomerRole);

		log.info("Admin_08_Search_Customer_With_Email - Step 08: Verify 'Company name' CustomerRole is displayed with value '" + newCusCompanyName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Company name", "1"), newCusCompanyName);
	}

	@Test
	public void Admin_09_Search_Customer_With_Company_Name() {

		log.info("Admin_09_Search_Customer_With_Company_Name - Step 01: Refresh Current Page");
		adminProductPage.refreshCurrentPage(driver);

		log.info("Admin_09_Search_Customer_With_Company_Name - Step 02: Enter to Company textbox with value is '" + newCusCompanyName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchCompany", newCusCompanyName);

		log.info("Admin_09_Search_Customer_With_Company_Name - Step 03: Delete to Customer Role Dropdown selected 'Registered' ");
		admincustomerPage.clickToCustomeDropdownSelectedByName(driver, "Registered");

		log.info("Admin_09_Search_Customer_With_Company_Name - Step 04: Select Dropdown Customers Role with value '" + newCustomerRole + "'");
		admincustomerPage.selectToAdminCustomerRoleDropdown(driver, newCustomerRole);

		log.info("Admin_09_Search_Customer_With_Company_Name - Step 05: click To Search Button");
		admincustomerPage.clicktoSearchButtonAtAdminProductsPage(driver);

		log.info("Admin_09_Search_Customer_With_Company_Name - Step 06: Verify 'Name' CustomerRole is displayed with value '" + newCusFirstName + " " + newCusLastName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Name", "1"), newCusFirstName + " " + newCusLastName);

		log.info("Admin_09_Search_Customer_With_Company_Name - Step 07: Verify 'Customer roles' CustomerRole is displayed with value '" + newCustomerRole + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Customer roles", "1"), newCustomerRole);

		log.info("Admin_09_Search_Customer_With_Company_Name - Step 08: Verify 'Company name' CustomerRole is displayed with value '" + newCusCompanyName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Company name", "1"), newCusCompanyName);

	}

	@Test
	public void Admin_10_Search_Customer_With_First_Name_And_Last_name() {

		log.info("Admin_10_Search_Customer_With_First_Name_And_Last_name - Step 01: Refresh Current Page");
		adminProductPage.refreshCurrentPage(driver);

		log.info("Admin_10_Search_Customer_With_First_Name_And_Last_name - Step 02: Enter to FirstName textbox with value is '" + newCusFirstName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchFirstName", newCusFirstName);

		log.info("Admin_10_Search_Customer_With_First_Name_And_Last_name - Step 03: Enter to LastName textbox with value is '" + newCusLastName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchLastName", newCusLastName);

		log.info("Admin_10_Search_Customer_With_First_Name_And_Last_name - Step 04: Delete to Customer Role Dropdown selected 'Registered' ");
		admincustomerPage.clickToCustomeDropdownSelectedByName(driver, "Registered");

		log.info("Admin_10_Search_Customer_With_First_Name_And_Last_name - Step 05: Select Dropdown Customers Role with value '" + newCustomerRole + "'");
		admincustomerPage.selectToAdminCustomerRoleDropdown(driver, newCustomerRole);

		log.info("Admin_10_Search_Customer_With_First_Name_And_Last_name - Step 06: click To Search Button");
		admincustomerPage.clicktoSearchButtonAtAdminProductsPage(driver);

		log.info("Admin_10_Search_Customer_With_First_Name_And_Last_name - Step 07: Verify 'Name' CustomerRole is displayed with value '" + newCusFirstName + " " + newCusLastName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Name", "1"), newCusFirstName + " " + newCusLastName);

		log.info("Admin_10_Search_Customer_With_First_Name_And_Last_name - Step 08: Verify 'Customer roles' CustomerRole is displayed with value '" + newCustomerRole + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Customer roles", "1"), newCustomerRole);

		log.info("Admin_10_Search_Customer_With_First_Name_And_Last_name - Step 09: Verify 'Company name' CustomerRole is displayed with value '" + newCusCompanyName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Company name", "1"), newCusCompanyName);

	}

	@Test
	public void Admin_11_Search_Customer_With_Full_Data() {

		log.info("Admin_11_Search_Customer_With_Full_Data - Step 01: Refresh Current Page");
		adminProductPage.refreshCurrentPage(driver);

		log.info("Admin_11_Search_Customer_With_Full_Data - Step 02: Enter to Email textbox with value is '" + newCusEmailAddress + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchEmail", newCusEmailAddress);

		log.info("Admin_11_Search_Customer_With_Full_Data - Step 03: Enter to FirstName textbox with value is '" + newCusFirstName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchFirstName", newCusFirstName);

		log.info("Admin_11_Search_Customer_With_Full_Data - Step 04: Enter to LastName textbox with value is '" + newCusLastName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchLastName", newCusLastName);

		log.info("Admin_11_Search_Customer_With_Full_Data - Step 05: Enter to Company textbox with value is '" + newCusCompanyName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchCompany", newCusCompanyName);

		log.info("Admin_11_Search_Customer_With_Full_Data - Step 06: Select to MonthofBirth Dropdown with value is '" + searchCusMonthofBirth + "'");
		admincustomerPage.selectToDropdownByName(driver, "SearchMonthOfBirth", searchCusMonthofBirth);

		log.info("Admin_11_Search_Customer_With_Full_Data - Step 07: Select to DateofBirth Dropdown with value is '" + searchCusDateofBirth + "'");
		admincustomerPage.selectToDropdownByName(driver, "SearchDayOfBirth", searchCusDateofBirth);

		log.info("Admin_11_Search_Customer_With_Full_Data - Step 08: Delete to Customer Role Dropdown selected 'Registered' ");
		admincustomerPage.clickToCustomeDropdownSelectedByName(driver, "Registered");

		log.info("Admin_11_Search_Customer_With_Full_Data - Step 09: Select Dropdown Customers Role with value '" + newCustomerRole + "'");
		admincustomerPage.selectToAdminCustomerRoleDropdown(driver, newCustomerRole);

		log.info("Admin_11_Search_Customer_With_Full_Data - Step 10: click To Search Button");
		admincustomerPage.clicktoSearchButtonAtAdminProductsPage(driver);

		log.info("Admin_11_Search_Customer_With_Full_Data - Step 11: Verify 'Name' CustomerRole is displayed with value '" + newCusFirstName + " " + newCusLastName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Name", "1"), newCusFirstName + " " + newCusLastName);

		log.info("Admin_11_Search_Customer_With_Full_Data - Step 12: Verify 'Customer roles' CustomerRole is displayed with value '" + newCustomerRole + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Customer roles", "1"), newCustomerRole);

		log.info("Admin_11_Search_Customer_With_Full_Data - Step 13: Verify 'Company name' CustomerRole is displayed with value '" + newCusCompanyName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Company name", "1"), newCusCompanyName);

	}

	@Test
	public void Admin_12_Edit_Customer() {

		log.info("Admin_12_Edit_Customer - Step 01: click To EDIT Button at Search result table");
		admincustomerPage.clickToButtonLinkByColumnAtRowNumberatAdminCustomerPage("Edit", "1");

		log.info("Admin_12_Edit_Customer - Step 02: Enter to Email textbox with value is '" + editCusEmailAddress + "'");
		admincustomerPage.inputToTextboxByID(driver, "Email", editCusEmailAddress);

		log.info("Admin_12_Edit_Customer - Step 03: Enter to FirstName textbox with value is '" + editCusFirstName + "'");
		admincustomerPage.inputToTextboxByID(driver, "FirstName", editCusFirstName);

		log.info("Admin_12_Edit_Customer - Step 04: Enter to LastName textbox with value is '" + editCusLastName + "'");
		admincustomerPage.inputToTextboxByID(driver, "LastName", editCusLastName);

		log.info("Admin_12_Edit_Customer - Step 05: Enter to DateOfBirth textbox with value is '" + editCusDateofBirth + "'");
		admincustomerPage.inputToTextboxByID(driver, "DateOfBirth", editCusDateofBirth);

		log.info("Admin_12_Edit_Customer - Step 06: Enter to Company  Name textbox with value is '" + editCusCompanyName + "'");
		admincustomerPage.inputToTextboxByID(driver, "Company", editCusCompanyName);

		log.info("Admin_12_Edit_Customer - Step 07: Enter to Admin Comment textarea with value is '" + editCusAdminComment + "'");
		admincustomerPage.inputToTextareaByID(driver, "AdminComment", editCusAdminComment);

		log.info("Admin_12_Edit_Customer - Step 08: Click to Checkbox 'Save' button ");
		admincustomerPage.clickToButtonByNameAtAdminPage(driver, "save");

		log.info("Admin_12_Edit_Customer - Step 09: Verify Address  add success message is displayed ");
		Assert.assertTrue(admincustomerPage.getArlertMessageSuccessAtAdminPage(driver).contains("The customer has been updated successfully."));

		log.info("Admin_12_Edit_Customer - Step 10: Enter to Email textbox with value is '" + editCusEmailAddress + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchEmail", editCusEmailAddress);

		log.info("Admin_12_Edit_Customer - Step 11: Enter to FirstName textbox with value is '" + editCusFirstName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchFirstName", editCusFirstName);

		log.info("Admin_12_Edit_Customer - Step 12: Enter to LastName textbox with value is '" + editCusLastName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchLastName", editCusLastName);

		log.info("Admin_12_Edit_Customer - Step 13: Enter to Company textbox with value is '" + editCusCompanyName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchCompany", editCusCompanyName);

		log.info("Admin_12_Edit_Customer - Step 14: Select to MonthofBirth Dropdown with value is '" + searchEditCusMonthofBirth + "'");
		admincustomerPage.selectToDropdownByName(driver, "SearchMonthOfBirth", searchEditCusMonthofBirth);

		log.info("Admin_12_Edit_Customer - Step 15: Select to DateofBirth Dropdown with value is '" + searchEditCusDateofBirth + "'");
		admincustomerPage.selectToDropdownByName(driver, "SearchDayOfBirth", searchEditCusDateofBirth);

		log.info("Admin_12_Edit_Customer - Step 16: Delete to Customer Role Dropdown selected 'Registered' ");
		admincustomerPage.clickToCustomeDropdownSelectedByName(driver, "Registered");

		log.info("Admin_12_Edit_Customer - Step 17: Select Dropdown Customers Role with value '" + newCustomerRole + "'");
		admincustomerPage.selectToAdminCustomerRoleDropdown(driver, newCustomerRole);

		log.info("Admin_12_Edit_Customer - Step 18: click To Search Button");
		admincustomerPage.clicktoSearchButtonAtAdminProductsPage(driver);

		log.info("Admin_12_Edit_Customer - Step 19: Verify 'Name' CustomerRole is displayed with value '" + editCusFirstName + " " + editCusLastName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Name", "1"), editCusFirstName + " " + editCusLastName);

		log.info("Admin_12_Edit_Customer - Step 20: Verify 'Customer roles' CustomerRole is displayed with value '" + newCustomerRole + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Customer roles", "1"), newCustomerRole);

		log.info("Admin_12_Edit_Customer - Step 21: Verify 'Company name' CustomerRole is displayed with value '" + editCusCompanyName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Company name", "1"), editCusCompanyName);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		
		closeBrowserDriver();		
	}

}
