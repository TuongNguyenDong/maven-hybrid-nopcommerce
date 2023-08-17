package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class My_Account extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, validPassword, emailAddress, updateEmail, updateFirstName, updateLastName;
	private String day, updateDay, month, updateMonth, year, updateYear, CountryId, cityName, address1,address2;
	private String company,postCode,phoneNumber,faxNumber;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browerName, String enviromentName) {
		driver = getBrowserDriver(browerName, enviromentName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		updateFirstName = "Automation1";
		lastName = "FC";
		updateLastName = "FC1";
		validPassword = "1234556";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		updateEmail = "afc" + generateFakeNumber() + "@mail.vn";
		day = "10";
		month = "May";
		year = "1998";
		
		updateDay = "11";
		updateMonth = "March";
		updateYear = "1999";
		company = "Automation1 FC1";
		
		CountryId = "Viet Nam";
		cityName = "Ho Chi Minh";
		address1 = "123/4 Nghi Ngo";
		address2 = "123/5 Nghi Nha";
		
		postCode = "7000000";
		phoneNumber = "0123456789";
		faxNumber = "0987654321";

		log.info("Precondition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Precondition - Step 02: Click to Radio button 'Male' ");
		registerPage.clicktoRadioButtonByLabel(driver, "Male");

		log.info("Precondition - Step 03: Enter to FirstName textbox with value is '" + firstName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Precondition - Step 04: Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		log.info("Precondition - Step 05: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Precondition - Step 06: Select Dropdown DateOfBirthDay with value is '" + day + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Precondition - Step 07: Select Dropdown DateOfBirthMonth with value is '" + month + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Precondition - Step 08: Select Dropdown DateOfBirthYear with value is '" + year + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Precondition - Step 02: Click to Checkbox 'Newsletter' ");
		registerPage.clicktoCheckboxByLabel(driver, "Newsletter");

		log.info("Precondition - Step 10: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Precondition - Step 11: Enter to Comfirm Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Precondition - Step 12: Click to 'Register' button ");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Precondition - Step 13: Verify register success message is displayed ");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Precondition - Step 14: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Precondition - Step 15: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Precondition - Step 16: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Precondition - Step 17: Click to 'Log in' button");
		homePage = loginPage.clickLoginButton();

		log.info("Precondition - Step 18: Verify 'My Account' link is displayed ");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void TC_01_Customer_info() {
		log.info("TC_01 - Step 01: Navigate to 'My Account' page");
		customerInforPage = homePage.openMyAccountPage();

		log.info("TC_01 - Step 02: Verify 'Customer Infor' page is displayed ");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());

		log.info("TC_01 - Step 03: Click to Radio button 'Female'");
		customerInforPage.clicktoRadioButtonByLabel(driver, "Female");

		log.info("TC_01 - Step 04: Enter to FirstName textbox with value is '" + updateFirstName + "'");
		customerInforPage.inputToTextboxByID(driver, "FirstName", updateFirstName);

		log.info("TC_01 - Step 05: Enter to LastName textbox with value is '" + updateLastName + "'");
		customerInforPage.inputToTextboxByID(driver, "LastName", updateLastName);

		log.info("TC_01 - Step 06: Select Dropdown DateOfBirthDay with value is '" + updateDay + "'");
		customerInforPage.selectToDropdownByName(driver, "DateOfBirthDay", updateDay);

		log.info("TC_01 - Step 07: Select Dropdown DateOfBirthMonth with value is '" + updateMonth + "'");
		customerInforPage.selectToDropdownByName(driver, "DateOfBirthMonth", updateMonth);

		log.info("TC_01 - Step 08: Select Dropdown DateOfBirthYear with value is '" + updateYear + "'");
		customerInforPage.selectToDropdownByName(driver, "DateOfBirthYear", updateYear);

		log.info("TC_01 - Step 09: Enter to Email textbox with value is '" + updateEmail + "'");
		customerInforPage.inputToTextboxByID(driver, "Email", updateEmail);

		log.info("TC_01 - Step 09: Enter to Company textbox with value is '" + company + "'");
		customerInforPage.inputToTextboxByID(driver, "Company", company);

		log.info("TC_01 - Step 10: Click to 'Save' button ");
		customerInforPage.clickToButtonByText(driver, "Save");

		log.info("TC_01 - Step 11: Verify CustomerInfo success message is displayed ");
		Assert.assertEquals(customerInforPage.getCustomerInfoUpdateSuccessMessage(),
				"The customer info has been updated successfully.");

		log.info("TC_01 - Step 12: Verify Radio button 'Female' is updated ");
		Assert.assertTrue(customerInforPage.isDefaultCheckboxOrRadioButtonSelectedByLable(driver, "Female"));

		log.info("TC_01 - Step 13: Verify FirstName textbox is updated with value '" + updateFirstName + "' ");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), updateFirstName);

		log.info("TC_01 - Step 14: Verify LastName textbox is updated with value '" + updateLastName + "' ");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), updateLastName);

		log.info("TC_01 - Step 15: Verify Dropdown DateOfBirthDay is updated with value  '" + updateDay + "'");
		Assert.assertEquals(customerInforPage.getdefaultDropdownValueByName(driver, "DateOfBirthDay"), updateDay);

		log.info("TC_01 - Step 16: Verify Dropdown DateOfBirthMonth is updated with value  '" + updateMonth + "'");
		Assert.assertEquals(customerInforPage.getdefaultDropdownValueByName(driver, "DateOfBirthMonth"), updateMonth);

		log.info("TC_01 - Step 17: Verify Dropdown DateOfBirthYear is updated with value  '" + updateYear + "'");
		Assert.assertEquals(customerInforPage.getdefaultDropdownValueByName(driver, "DateOfBirthYear"), updateYear);

		log.info("TC_01 - Step 18: Verify Email textbox is updated with value '" + updateEmail + "'");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Email"), updateEmail);

		log.info("TC_01 - Step 19: Verify Company textbox is updated with value '" + company + "'");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Company"), company);

	}

	@Test
	public void TC_02_Add_Addresses() {
		log.info("TC_02 - Step 01: Swith to  'Address' page");
		addressPage = customerInforPage.openAddressPage(driver);
		
		log.info("TC_02 - Step 02: Click to 'Add new' button ");
		addressPage.clickToButtonByText(driver, "Add new");
		
		log.info("TC_02 - Step 03: Enter to FirstName textbox with value is '" + updateFirstName + "'");
		addressPage.inputToTextboxByID(driver, "Address_FirstName", updateFirstName);

		log.info("TC_02 - Step 04: Enter to LastName textbox with value is '" + updateLastName + "'");
		addressPage.inputToTextboxByID(driver, "Address_LastName", updateLastName);
		
		log.info("TC_02 - Step 05: Enter to Email textbox with value is '" + updateEmail + "'");
		addressPage.inputToTextboxByID(driver, "Address_Email", updateEmail);

		log.info("TC_02 - Step 06: Enter to Company textbox with value is '" + company + "'");
		addressPage.inputToTextboxByID(driver, "Address_Company", company);
		
		log.info("TC_01 - Step 07: Select Dropdown Address.CountryId with value is '" + CountryId + "'");
		customerInforPage.selectToDropdownByName(driver, "Address.CountryId", CountryId);
		
		log.info("TC_02 - Step 08: Enter to Address_City textbox with value is '" + cityName + "'");
		addressPage.inputToTextboxByID(driver, "Address_City", cityName);
		
		log.info("TC_02 - Step 09: Enter to Address_Address1 textbox with value is '" + address1 + "'");
		addressPage.inputToTextboxByID(driver, "Address_Address1", address1);
		
		log.info("TC_02 - Step 10: Enter to Address_Address2 textbox with value is '" + address2 + "'");
		addressPage.inputToTextboxByID(driver, "Address_Address2", address2);
		
		log.info("TC_02 - Step 11: Enter to Address_ZipPostalCode textbox with value is '" + postCode + "'");
		addressPage.inputToTextboxByID(driver, "Address_ZipPostalCode", postCode);
		
		log.info("TC_02 - Step 12: Enter to Address_PhoneNumber textbox with value is '" + phoneNumber + "'");
		addressPage.inputToTextboxByID(driver, "Address_PhoneNumber", phoneNumber);
		
		log.info("TC_02 - Step 13: Enter to Address_FaxNumber textbox with value is '" + faxNumber + "'");
		addressPage.inputToTextboxByID(driver, "Address_FaxNumber", faxNumber);
		
		log.info("TC_02 - Step 14: Click to 'Save' button ");
		addressPage.clickToButtonByText(driver, "Save");
		
		log.info("TC_02 - Step 15: Verify Address  add success message is displayed ");
		Assert.assertEquals(addressPage.getAddressAddSuccessMessage(), "The new address has been added successfully.");
		
		log.info("TC_02 - Step 16: Verify name is updated with value '" + updateFirstName +" "+ updateLastName + "' ");
		Assert.assertEquals(addressPage.getTextboxValueByName(driver, "name"), updateFirstName +" "+ updateLastName);
		
		log.info("TC_02 - Step 17: Verify Email is updated with value '" + updateEmail + "' ");
		Assert.assertTrue(addressPage.getTextboxValueByName(driver, "email").contains(updateEmail));
		
		log.info("TC_02 - Step 18: Verify Phone is updated with value '" + phoneNumber + "' ");
		Assert.assertTrue(addressPage.getTextboxValueByName(driver, "phone").contains(phoneNumber));
		
		log.info("TC_02 - Step 19: Verify Fax is updated with value '" + faxNumber + "' ");
		Assert.assertTrue(addressPage.getTextboxValueByName(driver, "fax").contains(faxNumber));
		
		log.info("TC_02 - Step 20: Verify company is updated with value '" + company + "' ");
		Assert.assertEquals(addressPage.getTextboxValueByName(driver, "company"), company);
		
		log.info("TC_02 - Step 21: Verify address1 is updated with value '" + address1 + "' ");
		Assert.assertEquals(addressPage.getTextboxValueByName(driver, "address1"), address1);
		
		log.info("TC_02 - Step 22: Verify address2 is updated with value '" + address2 + "' ");
		Assert.assertEquals(addressPage.getTextboxValueByName(driver, "address2"), address2);
		
		log.info("TC_02 - Step 23: Verify city-state-zip is updated with value '" + cityName +", "+ postCode + "' ");
		Assert.assertEquals(addressPage.getTextboxValueByName(driver, "city-state-zip"), cityName +", "+ postCode);
		
		log.info("TC_02 - Step 24: Verify country is updated with value '" + CountryId + "' ");
		Assert.assertEquals(addressPage.getTextboxValueByName(driver, "country"), CountryId);
	
	}

	@Test
	public void TC_03_Change_Password() {

	}

	@Test
	public void TC_04_My_Product_Review() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//closeBrowserDriver();
	}

}
