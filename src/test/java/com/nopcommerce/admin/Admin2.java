package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminCustomersPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductsPageObject;

public class Admin2 extends BaseTest {

	private WebDriver driver;
	private String adminEmailAddress, adminPassword;
	private String newCusEmailAddress, newCusPassword, newCusFirstName, newCusLastName, newCusDateofBirth, newCusCompanyName, newCustomerRole, newCusAdminComment;
	private String newAddEmailAddress, newAddFirstName, newAddLastName, newAddCompanyName, newAddCountry, newAddState, newAddCity, newAdd1, newAdd2, newAddZip, newAddPhoneNumber,newAddCounty, newAddFax;
	private String editAddEmailAddress, editAddFirstName, editAddLastName, editAddCompanyName, editAddCountry, editAddState, editAddCity, editAdd1, editAdd2, editAddZip, editAddPhoneNumber,editAddCounty, editAddFax;
	private String searchCusMonthofBirth, searchCusDateofBirth;

	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminProductsPageObject adminProductPage;
	private AdminCustomersPageObject admincustomerPage;

	@Parameters({"browser", "environment", "envName", "osName", "nodeName"})
	@BeforeClass
	public void beforeClass(@Optional("chrome")String browerName,@Optional("testing") String environmentName,@Optional("localAdmin") String envName, @Optional("windows")String osName,@Optional("NodeB") String nodeName ) {
		
		driver =  getBrowserDriver(browerName, environmentName, envName, osName, nodeName);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";

		newCusEmailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		
		newCusPassword = "123456";
		newCusFirstName = "Join25";
		newCusLastName = "Hen25";
		newCusDateofBirth = "11/11/2022";
		newCusCompanyName = "Automation FC";
		newCustomerRole = "Guests";
		newCusAdminComment = "Add new customer (Guest)";
		searchCusDateofBirth = "11";
		searchCusMonthofBirth = "11";
		
		newAddEmailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		newAddFirstName = "Automation44";
		newAddLastName = "FC44";
		newAddCompanyName = "Automation55 FC55";
		newAddCountry = "Viet Nam";
		newAddState = "Other";
		newAddCounty = "Dong Nam Bo";
		newAddCity = "Ho Chi Minh";
		newAdd1 = "111 Quang Trung";
		newAdd2 = "15 Phan Van Tri";
		newAddZip = "65000";
		newAddPhoneNumber = "0999876543";
		newAddFax = "+84999876543";

		editAddEmailAddress = "hbric" + generateFakeNumber() + "@hotmail.com";
		editAddFirstName = "Join";
		editAddLastName = "Henry";
		editAddCompanyName = "Keebler Group";
		editAddCountry = "United States";
		editAddState = "Texas";
		editAddCounty = "Houston";
		editAddCity = "Hillland";
		editAdd1 = "103 Hanover Alley";
		editAdd2 = "1125 Norway Maple Drive";
		editAddZip = "51000";
		editAddPhoneNumber = "(281) 590-1419";
		editAddFax = "+44(281) 590-1419";


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
		
		log.info("Precondition - Step 08: Click  To 'Customers' nav SideBar");
		adminProductPage.clickToNavSideBarByName(driver, "Customers");

		log.info("Precondition - Step 09: Navigate  To 'Customers' page");
		admincustomerPage = (AdminCustomersPageObject) adminProductPage.openpageAtNavSideBarByName(driver, "Customers");

		log.info("Precondition - Step 10: Verify Content Header 'Customers' title is displayed ");
		Assert.assertTrue(admincustomerPage.isContentHeaderByText(driver, "Customers"));

		log.info("Precondition - Step 11: Click  To 'Add new' at Admin Customer Page");
		admincustomerPage.clickToLinkAtAdminPageByName(driver, "Add new");

		log.info("Precondition - Step 12: Verify Cart Title 'Customer info' is displayed ");
		Assert.assertTrue(admincustomerPage.isCartTitleByCartNameAndCartTitle(driver, "customer-cards", "Customer info"));
		
		log.info("Precondition - Step 03: Collpase  button at Customer info Card ");
		admincustomerPage.checkToCollapseByNameAtCustomerAdminPage(driver, "Customer info");

		log.info("Precondition - Step 13: Enter to Email textbox with value is '" + newCusEmailAddress + "'");
		admincustomerPage.inputToTextboxByID(driver, "Email", newCusEmailAddress);

		log.info("Precondition - Step 14: Enter to Password textbox with value is '" + newCusPassword + "'");
		admincustomerPage.inputToTextboxByID(driver, "Password", newCusPassword);

		log.info("Precondition - Step 15: Enter to FirstName textbox with value is '" + newCusFirstName + "'");
		admincustomerPage.inputToTextboxByID(driver, "FirstName", newCusFirstName);

		log.info("Precondition - Step 16: Enter to LastName textbox with value is '" + newCusLastName + "'");
		admincustomerPage.inputToTextboxByID(driver, "LastName", newCusLastName);

		log.info("Precondition - Step 17: Click to Radio button 'Female'");
		admincustomerPage.clicktoRadioButtonByLabel(driver, "Female");

		log.info("Precondition - Step 18: Enter to DateOfBirth textbox with value is '" + newCusDateofBirth + "'");
		admincustomerPage.inputToTextboxByID(driver, "DateOfBirth", newCusDateofBirth);

		log.info("Precondition - Step 19: Enter to Company  Name textbox with value is '" + newCusCompanyName + "'");
		admincustomerPage.inputToTextboxByID(driver, "Company", newCusCompanyName);

		log.info("Precondition - Step 20: Delete to Customer Role Dropdown selected 'Registered' ");
		admincustomerPage.clickToCustomeDropdownSelectedByName(driver, "Registered");

		log.info("Precondition - Step 21: Select Dropdown Customers Role with value '" + newCustomerRole + "'");
		admincustomerPage.selectToAdminCustomerRoleDropdown(driver, newCustomerRole);

		log.info("Precondition - Step 22: Click to Checkbox 'Active' ");
		admincustomerPage.clickToCheckboxByID(driver, "Active");

		log.info("Precondition - Step 23: Enter to Admin Comment textarea with value is '" + newCusAdminComment + "'");
		admincustomerPage.inputToTextareaByID(driver, "AdminComment", newCusAdminComment);

		log.info("Precondition - Step 24: Click to Checkbox 'Save and Continue Edit' button ");
		admincustomerPage.clickToButtonByNameAtAdminPage(driver, "save-continue");

		log.info("Precondition - Step 25: Verify Customer added success message is displayed ");
		Assert.assertTrue(admincustomerPage.getArlertMessageSuccessAtAdminPage(driver).contains("The new customer has been added successfully."));

		log.info("Precondition - Step 26: Verify Email textbox is displayed with value '" + newCusEmailAddress + "' ");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Email"), newCusEmailAddress);

		log.info("Precondition - Step 27: Verify FirstName textbox is displayed with value '" + newCusFirstName + "' ");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "FirstName"), newCusFirstName);

		log.info("Precondition - Step 28: Verify LastName textbox is displayed with value '" + newCusLastName + "' ");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "LastName"), newCusLastName);

		log.info("Precondition - Step 29: Verify Radio button 'Female' is selected ");
		Assert.assertTrue(admincustomerPage.isDefaultCheckboxOrRadioButtonSelectedByLabel(driver, "Female"));

		log.info("Precondition - Step 30: Verify Date of Birth textbox is displayed with value '" + newCusDateofBirth + "' ");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "DateOfBirth"), newCusDateofBirth);

		log.info("Precondition - Step 31: Verify Company textbox is displayed with value '" + newCusCompanyName + "' ");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Company"), newCusCompanyName);

		log.info("Precondition - Step 32: Verify CustomerRole Dropdown TextArea is displayed with value '" + newCustomerRole + "' ");
		Assert.assertEquals(admincustomerPage.getCustomerRoleTextByName(newCustomerRole), newCustomerRole);

		log.info("Precondition - Step 33: Verify Checkbox 'Active' is selected ");
		Assert.assertTrue(admincustomerPage.isDefaultCheckboxOrRadioButtonSelectedByID(driver, "Active"));

		log.info("Precondition - Step 34: Verify AdminComment TextArea is displayed with value '" + newCusAdminComment + "' ");
		Assert.assertEquals(admincustomerPage.getTextAreaByID(driver, "AdminComment"), newCusAdminComment);

		log.info("Precondition - Step 35: Click  To 'back to customer list' Link at Admin Customer Page");
		admincustomerPage.clickToFloatLeftLinkAtAdminPageByName(driver, "back to customer list");

		log.info("Precondition - Step 36: Enter to Email textbox with value is '" + newCusEmailAddress + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchEmail", newCusEmailAddress);

		log.info("Precondition - Step 37: Enter to FirstName textbox with value is '" + newCusFirstName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchFirstName", newCusFirstName);

		log.info("Precondition - Step 38: Enter to LastName textbox with value is '" + newCusLastName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchLastName", newCusLastName);

		log.info("Precondition - Step 39: Enter to Company textbox with value is '" + newCusCompanyName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchCompany", newCusCompanyName);

		log.info("Precondition - Step 40: Select to MonthofBirth Dropdown with value is '" + searchCusMonthofBirth + "'");
		admincustomerPage.selectToDropdownByName(driver, "SearchMonthOfBirth", searchCusMonthofBirth);

		log.info("Precondition - Step 41: Select to DateofBirth Dropdown with value is '" + searchCusDateofBirth + "'");
		admincustomerPage.selectToDropdownByName(driver, "SearchDayOfBirth", searchCusDateofBirth);

		log.info("Precondition - Step 42: Delete to Customer Role Dropdown selected 'Registered' ");
		admincustomerPage.clickToCustomeDropdownSelectedByName(driver, "Registered");

		log.info("Precondition - Step 43: Select Dropdown Customers Role with value '" + newCustomerRole + "'");
		admincustomerPage.selectToAdminCustomerRoleDropdown(driver, newCustomerRole);

		log.info("Precondition - Step 44: click To Search Button");
		admincustomerPage.clicktoSearchButtonAtAdminProductsPage(driver);

		log.info("Precondition - Step 45: Verify 'Name' CustomerRole is displayed with value '" + newCusFirstName + " " + newCusLastName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Name", "1"), newCusFirstName + " " + newCusLastName);

		log.info("Precondition - Step 46: Verify 'Customer roles' CustomerRole is displayed with value '" + newCustomerRole + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Customer roles", "1"), newCustomerRole);

		log.info("Precondition - Step 47: Verify 'Company name' CustomerRole is displayed with value '" + newCusCompanyName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Company name", "1"), newCusCompanyName);

	}

	@Test
	public void Admin_13_Add_New_Address_In_Customer_Details() {

		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 01: click To EDIT Button at Search result table");
		admincustomerPage.clickToButtonLinkByColumnAtRowNumberatAdminCustomerPage("Edit", "1");
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 02: Verify Cart Title 'Addresses' is displayed ");
		Assert.assertTrue(admincustomerPage.isCartTitleByCartNameAndCartTitle(driver, "customer-cards", "Addresses"));
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 03: Collapse  button at Addresses Card ");
		admincustomerPage.checkToCollapseByNameAtCustomerAdminPage(driver, "Addresses");	
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 04: Click to 'Add new addresss' button ");
		admincustomerPage.clickToButtonByNameAtCustomerAdminPage(driver, "Add new address");

		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 05: Enter to FirstName textbox with value is '" + newAddFirstName + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_FirstName", newAddFirstName);

		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 06: Enter to LastName textbox with value is '" + newAddLastName + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_LastName", newAddLastName);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 07: Enter to Email textbox with value is '" + newAddEmailAddress + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_Email", newAddEmailAddress);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 08: Enter to Company textbox with value is '" + newAddCompanyName + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_Company", newAddCompanyName);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 09: Select to Country Dropdown  with value is '" + newAddCountry + "'");
		admincustomerPage.selectToDropdownByName(driver, "Address.CountryId", newAddCountry);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 10: Select to State Dropdown  with value is '" + newAddState + "'");
		admincustomerPage.selectToDropdownByName(driver, "Address.StateProvinceId", newAddState);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 11: Enter to County textbox with value is '" + newAddCounty + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_County", newAddCounty);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 12: Enter to City textbox with value is '" + newAddCity + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_City", newAddCity);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 13: Enter to Address1 textbox with value is '" + newAdd1 + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_Address1", newAdd1);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 14: Enter to Address2 textbox with value is '" + newAdd2 + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_Address2", newAdd2);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 15: Enter to ZipCode textbox with value is '" + newAddZip + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_ZipPostalCode", newAddZip);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 16: Enter to Address2 textbox with value is '" + newAddPhoneNumber + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_PhoneNumber", newAddPhoneNumber);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 17: Enter to Address2 textbox with value is '" + newAddFax + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_FaxNumber", newAddFax);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 18: Click to 'Save' button at Address Admin Page");
		admincustomerPage.clicktoButtonByTextNameAtAddressAdminPage(driver, "Save");
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 19: Verify Address customer added success message is displayed ");
		Assert.assertTrue(admincustomerPage.getArlertMessageSuccessAtAdminPage(driver).contains("The new address has been added successfully."));
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 20: Verify FirstName textbox with value is '" + newAddFirstName + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_FirstName"), newAddFirstName);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 21: Verify LastName textbox with value is '" + newAddLastName + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_LastName"), newAddLastName);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 22: Verify Email textbox with value is '" + newAddEmailAddress + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_Email"), newAddEmailAddress);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 23: Verify Company textbox with value is '" + newAddCompanyName + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_Company"), newAddCompanyName);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 24: Verify Country Dropdown with value is '" + newAddCountry + "'");
		Assert.assertEquals(admincustomerPage.getdefaultDropdownValueByName(driver, "Address.CountryId"), newAddCountry);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 25: Verify State Dropdown with value is '" + newAddState + "'");
		Assert.assertEquals(admincustomerPage.getdefaultDropdownValueByName(driver, "Address.StateProvinceId"), newAddState);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 26: Verify County textbox with value is '" + newAddCounty+ "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_County"), newAddCounty);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 27: Verify City textbox with value is '" + newAddCity + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_City"), newAddCity);
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 28: Verify Address1 textbox with value is '" + newAdd1 + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_Address1"), newAdd1);

		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 29: Verify Address2 textbox with value is '" + newAdd2 + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_Address2"), newAdd2);

		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 30: Click  To 'back to customer detail' Link at Admin Customer Page");
		admincustomerPage.clickToFloatLeftLinkAtAdminPageByName(driver, "back to customer detail");
			
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 31: Verify Cart Title 'Addresses' is displayed ");
		Assert.assertTrue(admincustomerPage.isCartTitleByCartNameAndCartTitle(driver, "customer-cards", "Addresses"));
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 32: Verify 'First name' of Address Customer table is displayed with value '" + newAddFirstName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","First name", "1"), newAddFirstName );
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 33: Verify 'Last name' of Address Customer table is displayed with value '" + newAddLastName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","Last name", "1"), newAddLastName );
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 34: Verify 'Email' of Address Customer table is displayed with value '" + newAddEmailAddress + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","Email", "1"), newAddEmailAddress );
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 35: Verify 'Phone number' of Address Customer table is displayed with value '" + newAddPhoneNumber + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","Phone number", "1"), newAddPhoneNumber );
		
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 36: Verify 'Fax number' of Address Customer table is displayed with value '" + newAddFax + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","Fax number", "1"), newAddFax );
				
		log.info("Admin_13_Add_New_Address_In_Customer_Details - Step 37: Verify 'Address' of Address Customer table is displayed with value \n'" + newAddCompanyName + "\n" + newAdd1 + "\n" +  newAdd2 + "\n" + newAddCity  +","+ newAddZip + "\n" + newAddCountry + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","Address", "1"), newAddCompanyName + "\n" + newAdd1 + "\n" +  newAdd2 + "\n" + newAddCity  +","+ newAddZip + "\n" + newAddCountry);


	}
	
	@Test
	public void Admin_14_Edit_Address_In_Customer_Details() {

		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 01: click To EDIT Button at Addresses Customer table");
		admincustomerPage.clickToButtonLinkByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","Edit", "1");

		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 02: Verify Content Header 'Edit address' title is displayed ");
		Assert.assertTrue(admincustomerPage.isContentHeaderByText(driver, "Edit address"));
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 03: Enter to FirstName textbox with value is '" + editAddFirstName + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_FirstName", editAddFirstName);

		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 04: Enter to LastName textbox with value is '" + editAddLastName + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_LastName", editAddLastName);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 05: Enter to Email textbox with value is '" + editAddEmailAddress + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_Email", editAddEmailAddress);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 06: Enter to Company textbox with value is '" + editAddCompanyName + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_Company", editAddCompanyName);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 07: Select to Country Dropdown  with value is '" + editAddCountry + "'");
		admincustomerPage.selectToDropdownByName(driver, "Address.CountryId", editAddCountry);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 08: Select to State Dropdown  with value is '" + editAddState + "'");
		admincustomerPage.selectToDropdownByName(driver, "Address.StateProvinceId", editAddState);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 09: Enter to County textbox with value is '" + editAddCounty + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_County", editAddCounty);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 10: Enter to City textbox with value is '" + editAddCity + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_City", editAddCity);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 11: Enter to Address1 textbox with value is '" + editAdd1 + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_Address1", editAdd1);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 12: Enter to Address2 textbox with value is '" + editAdd2 + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_Address2", editAdd2);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 13: Enter to ZipCode textbox with value is '" + editAddZip + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_ZipPostalCode", editAddZip);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 14: Enter to Address2 textbox with value is '" + editAddPhoneNumber + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_PhoneNumber", editAddPhoneNumber);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 15: Enter to Address2 textbox with value is '" + editAddFax + "'");
		admincustomerPage.inputToTextboxByID(driver, "Address_FaxNumber", editAddFax);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 16: Click to 'Save' button at Address Admin Page");
		admincustomerPage.clicktoButtonByTextNameAtAddressAdminPage(driver, "Save");
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 17: Verify Address customer updated message is displayed ");
		Assert.assertTrue(admincustomerPage.getArlertMessageSuccessAtAdminPage(driver).contains("The address has been updated successfully."));
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 18: Verify FirstName textbox with value is '" + editAddFirstName + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_FirstName"), editAddFirstName);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 19: Verify LastName textbox with value is '" + editAddLastName + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_LastName"), editAddLastName);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 20: Verify Email textbox with value is '" + editAddEmailAddress + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_Email"), editAddEmailAddress);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 21: Verify Company textbox with value is '" + editAddCompanyName + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_Company"), editAddCompanyName);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 22: Verify Country Dropdown with value is '" + editAddCountry + "'");
		Assert.assertEquals(admincustomerPage.getdefaultDropdownValueByName(driver, "Address.CountryId"), editAddCountry);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 23: Verify State Dropdown with value is '" + editAddState + "'");
		Assert.assertEquals(admincustomerPage.getdefaultDropdownValueByName(driver, "Address.StateProvinceId"), editAddState);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 24: Verify County textbox with value is '" + editAddCounty+ "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_County"), editAddCounty);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 25: Verify City textbox with value is '" + editAddCity + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_City"), editAddCity);
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 26: Verify Address1 textbox with value is '" + editAdd1 + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_Address1"), editAdd1);

		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 27: Verify Address2 textbox with value is '" + editAdd2 + "'");
		Assert.assertEquals(admincustomerPage.getTextboxValueByID(driver, "Address_Address2"), editAdd2);

		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 28: Click  To 'back to customer detail' Link at Admin Customer Page");
		admincustomerPage.clickToFloatLeftLinkAtAdminPageByName(driver, "back to customer detail");
			
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 29: Verify Cart Title 'Addresses' is displayed ");
		Assert.assertTrue(admincustomerPage.isCartTitleByCartNameAndCartTitle(driver, "customer-cards", "Addresses"));
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 30: Verify 'First name' of Address Customer table is displayed with value '" + editAddFirstName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","First name", "1"), editAddFirstName );
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 31: Verify 'Last name' of Address Customer table is displayed with value '" + editAddLastName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","Last name", "1"), editAddLastName );
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 32: Verify 'Email' of Address Customer table is displayed with value '" + editAddEmailAddress + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","Email", "1"), editAddEmailAddress );
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 33: Verify 'Phone number' of Address Customer table is displayed with value '" + editAddPhoneNumber + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","Phone number", "1"), editAddPhoneNumber );
		
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 34: Verify 'Fax number' of Address Customer table is displayed with value '" + editAddFax + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","Fax number", "1"), editAddFax );
				
		log.info("Admin_14_Edit_Address_In_Customer_Details - Step 35: Verify 'Address' of Address Customer table is displayed with value \n'" + editAddCompanyName + "\n" + editAdd1 + "\n" +  editAdd2 + "\n" + editAddCity  + "," + editAddState  + "," + editAddZip + "\n" + editAddCountry + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","Address", "1"), editAddCompanyName + "\n" + editAdd1 + "\n" +  editAdd2 + "\n" + editAddCity  + "," + editAddState  +"," + editAddZip + "\n" + editAddCountry);

	}
	
	@Test
	public void Admin_15_Remove_Address_In_Customer_Details() {
			
		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 01: Click  To 'back to customer list' Link at Admin Customer Page");
		admincustomerPage.clickToFloatLeftLinkAtAdminPageByName(driver, "back to customer list");

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 02: Enter to Email textbox with value is '" + newCusEmailAddress + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchEmail", newCusEmailAddress);

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 03: Enter to FirstName textbox with value is '" + newCusFirstName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchFirstName", newCusFirstName);

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 04: Enter to LastName textbox with value is '" + newCusLastName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchLastName", newCusLastName);

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 05: Enter to Company textbox with value is '" + newCusCompanyName + "'");
		admincustomerPage.inputToTextboxByID(driver, "SearchCompany", newCusCompanyName);

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 06: Select to MonthofBirth Dropdown with value is '" + searchCusMonthofBirth + "'");
		admincustomerPage.selectToDropdownByName(driver, "SearchMonthOfBirth", searchCusMonthofBirth);

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 07: Select to DateofBirth Dropdown with value is '" + searchCusDateofBirth + "'");
		admincustomerPage.selectToDropdownByName(driver, "SearchDayOfBirth", searchCusDateofBirth);

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 08: Delete to Customer Role Dropdown selected 'Registered' ");
		admincustomerPage.clickToCustomeDropdownSelectedByName(driver, "Registered");

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 09: Select Dropdown Customers Role with value '" + newCustomerRole + "'");
		admincustomerPage.selectToAdminCustomerRoleDropdown(driver, newCustomerRole);

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 10: click To Search Button");
		admincustomerPage.clicktoSearchButtonAtAdminProductsPage(driver);

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 11: Verify 'Name' CustomerRole is displayed with value '" + newCusFirstName + " " + newCusLastName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Name", "1"), newCusFirstName + " " + newCusLastName);

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 12: Verify 'Customer roles' CustomerRole is displayed with value '" + newCustomerRole + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Customer roles", "1"), newCustomerRole);

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 13: Verify 'Company name' CustomerRole is displayed with value '" + newCusCompanyName + "'");
		Assert.assertEquals(admincustomerPage.getTextByColumnAtRowNumberatAdminCustomerPage("Company name", "1"), newCusCompanyName);
		
		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 14: click To EDIT Button at Search result table");
		admincustomerPage.clickToButtonLinkByColumnAtRowNumberatAdminCustomerPage("Edit", "1");
		
		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 15: Verify Cart Title 'Addresses' is displayed ");
		Assert.assertTrue(admincustomerPage.isCartTitleByCartNameAndCartTitle(driver, "customer-cards", "Addresses"));
		
		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 16: Collapse  button at Addresses Card ");
		admincustomerPage.checkToCollapseByNameAtCustomerAdminPage(driver, "Addresses");
		
		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 17: click To Delete Button at Addresses Customer table");
		admincustomerPage.clickToButtonLinkByColumnMulCartAtRowNumberatAdminCustomerPage("Addresses","Delete", "1");
		
		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 18: Verify confirm alert delete item display");
		Assert.assertTrue(admincustomerPage.getAlertText(driver).contains("Are you sure you want to delete this item?"));

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 19: Accept confirm alert delete item display");
		admincustomerPage.acceptAlert(driver);

		log.info("Admin_15_Remove_Address_In_Customer_Details - Step 20: Verify 'DataTable' empty at Addresses card ");
		Assert.assertTrue(admincustomerPage.isDataTableEmptyAtAdminCustomerPage("Addresses"));

	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		
		closeBrowserDriver();		
	}

}
