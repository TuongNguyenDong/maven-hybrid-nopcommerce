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
	private String adminEmailAddress, adminPassword,productName1, price1, SKU1, stockQty1, category1 ;
	
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminProductsPageObject adminProductPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver =getBrowserDriver(browserName);
		adminLoginPage= PageGeneratorManager.getAdminLoginPage(driver);
		
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
		productName1  = "Build your own computer";
		price1 = "1200";
		SKU1 = "COMP_CUST";
		stockQty1 = "10000";
		category1 = "Computers";
		
		
	
		log.info("Precondition - Step 01: Enter to Email textbox with value is '" + adminEmailAddress + "'");
		adminLoginPage.inputToTextboxByID(driver, "Email", adminEmailAddress);
		
		log.info("Precondition - Step 02: Enter to LastName textbox with value is '" + adminPassword + "'");
		adminLoginPage.inputToTextboxByID(driver, "Password", adminPassword);
		
		log.info("Precondition - Step 03: Click to 'Log in' button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();
		
		log.info("Precondition - Step 04: Verify Content Header 'Dashboard' title is displayed " );
		Assert.assertTrue(adminDashboardPage.isContentHeaderByText(driver, "Dashboard"));	
		
		log.info("Precondition - Step 05: Click  To 'Catalog' nav SideBar" );
		adminDashboardPage.clickToNavSideBarByName(driver, "Catalog");
		
		log.info("Precondition - Step 06: Navigate  To 'Products' page" );
		adminProductPage = (AdminProductsPageObject) adminDashboardPage.openpageAtNavSideBarByName(driver, "Products");
		
		log.info("Precondition - Step 07: Verify Content Header 'Products' title is displayed " );
		Assert.assertTrue(adminProductPage.isContentHeaderByText(driver, "Products"));	

	}
	
	@Test
	public void Admin_01_Search_With_Product_Name() {
		log.info("Admin_01_Search_With_Product_Name - Step 01: Enter to Product name textbox with value is '" + productName1 + "'");
		adminProductPage.inputToTextboxByID(driver, "SearchProductName", productName1);
		
		log.info("Admin_01_Search_With_Product_Name - Step 02: click To Search Button");
		adminProductPage.clicktoSearchButtonAtAdminProductsPage();
		
		log.info("Admin_01_Search_With_Product_Name - Step 03: Verify 'Product name' product is displayed with value '"+ productName1 +"'" );
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("Product name", "1"), productName1);

		log.info("Admin_01_Search_With_Product_Name - Step 04: Verify 'SKU' product is  displayed with value "+ SKU1 +"'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("SKU", "1"), SKU1);
		
		log.info("Admin_01_Search_With_Product_Name - Step 05: Verify 'Price' product is  displayed with value "+ price1 +"'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("Price", "1"), price1);
		
		log.info("Admin_01_Search_With_Product_Name - Step 06: Verify 'Stock quantity' product is  displayed with value "+ stockQty1 +"'");
		Assert.assertEquals(adminProductPage.getTextByColumnAtRowNumberatAdminProductPage("Stock quantity", "1"), stockQty1);
		
		log.info("Admin_01_Search_With_Product_Name - Step 07: Verify 'Published' product is displayed");
		Assert.assertTrue(adminProductPage.getIconsByColumnAtRowNumberatAdminProductPage("Published", "1"));

		log.info("Admin_01_Search_With_Product_Name - Step 08: Select Dropdown Category with value is '" + category1 + "'");
		adminProductPage.selectToDropdownByName(driver, "SearchCategoryId", category1);
				
	}
	
	@Test
	public void Admin_02_Search_With_Product_Name_Catagory_Uncheck() {
		
		log.info("Admin_02_Search_With_Product_Name_Catagory_Uncheck - Step 01: Enter to Product name textbox with value is '" + productName1 + "'");
		adminProductPage.inputToTextboxByID(driver, "SearchProductName", productName1);
		
		log.info("Admin_02_Search_With_Product_Name_Catagory_Uncheck - Step 02: Select Dropdown Category with value is '" + category1 + "'");
		adminProductPage.selectToDropdownByName(driver, "SearchCategoryId", category1);
		
		log.info("Admin_02_Search_With_Product_Name_Catagory_Uncheck - Step 03: Uncheck to Checkbox 'Search subcategories' ");
		adminProductPage.unCheckToCheckboxByLabel("Search subcategories");
		
		log.info("Admin_02_Search_With_Product_Name_Catagory_Uncheck - Step 04: click To Search Button");
		adminProductPage.clicktoSearchButtonAtAdminProductsPage();
		
		log.info("Admin_02_Search_With_Product_Name_Catagory_Uncheck - Step 05: Verify  'DataTable' empty " );
		Assert.assertTrue(adminProductPage.isDataTableEmpty());	
		
		
	}
	
	@Test
	public void TC_03() {
		
		
	}
	
	@Test
	public void TC_04() {
		
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
//		closeBrowserDriver();		
	}

}
