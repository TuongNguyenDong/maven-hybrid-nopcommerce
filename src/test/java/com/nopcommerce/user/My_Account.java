package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class My_Account extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, validPassword, emailAddress, updateEmail, updateFirstName, updateLastName;
	private String day, updateDay, month, updateMonth, year, updateYear;
	private String company;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

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
		Assert.assertEquals(customerInforPage.getCustomerInfoUpdateSuccessMessage(), "The customer info has been updated successfully.");
		
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

	}

	@Test
	public void TC_03_Change_Password() {

	}

	@Test
	public void TC_04_My_Product_Review() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
