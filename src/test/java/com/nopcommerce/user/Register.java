package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Register extends BaseTest {
	
	private WebDriver driver;
	private String firstName, lastName, validPassword ,emailAddress,wrongEmailAddress,invalidPassword;
	private  String day, month, year;
	
	private UserHomePageObject  homePage;
	private UserRegisterPageObject  registerPage;
	
	@Parameters({"browser", "environment"})
	@BeforeClass
	public void beforceClass(String browerName, String enviromentName) {
		driver =  getBrowserDriver(browerName, enviromentName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Automation";
		lastName = "FC";
		validPassword = "1234556";
		invalidPassword = "123";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		wrongEmailAddress = "1234@123#$";

		day = "10";
		month = "May";
		year = "1998";
		
		
	}
	
	@Test
	public void TC_01_Register_Emmpty_Data() {
		log.info("Register_01 - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Register_01 - Step 02: Click to 'Register' button ");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register_01 - Step 03: Verify 'FirstName-error' message");
		assertEquals(registerPage.getRegisterErrorMessageByID(driver, "FirstName-error"), "First name is required.");

		log.info("Register_01 - Step 04: Verify 'LastName-error' message");
		assertEquals(registerPage.getRegisterErrorMessageByID(driver, "LastName-error"), "Last name is required.");

		log.info("Register_01 - Step 05: Verify 'Email-error' message");
		assertEquals(registerPage.getRegisterErrorMessageByID(driver, "Email-error"), "Email is required.");

		log.info("Register_01 - Step 06: Verify 'Password-error' message");
		assertEquals(registerPage.getRegisterErrorMessageByID(driver, "Password-error"), "Password is required.");

		log.info("Register_01 - Step 07: Verify 'ConfirmPassword-error' message");
		assertEquals(registerPage.getRegisterErrorMessageByID(driver, "ConfirmPassword-error"),"Password is required.");

	}
	
	@Test
	public void TC_02_Register_Invalid_Email () {
		log.info("Register_02 - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();
		
		log.info("Register_02 - Step 02: Click to Radio button 'Male'");
		registerPage.clicktoRadioButtonByLabel(driver, "Male");
		
		log.info("Register_02 - Step 03: Enter to FirstName textbox with value is '" + firstName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register_02 - Step 04: Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		log.info("Register_02 - Step 05: Enter to Email textbox with value is '" + wrongEmailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", wrongEmailAddress);

		log.info("Register_02 - Step 06: Select Dropdown DateOfBirthDay with value is '" + day + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Register_02 - Step 07: Select Dropdown DateOfBirthMonth with value is '" + month + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register_02 - Step 08: Select Dropdown DateOfBirthYear with value is '" + year + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register_02 - Step 02: Click to Checkbox 'Newsletter' ");
		registerPage.clicktoCheckboxByLabel(driver, "Newsletter");

		log.info("Register_02 - Step 10: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Register_02 - Step 11: Enter to Comfirm Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Register_02 - Step 12: Click to 'Register' button ");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register_02 - Step 13: Verify 'Email-error' message");
		Assert.assertEquals(registerPage.getRegisterErrorMessageByID(driver, "Email-error"), "Wrong email");
			
	}

	@Test
	public void TC_03_Register_Success () {
		
		log.info("Register_03 - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Register_03 - Step 02: Click to Radio button 'Male' ");
		registerPage.clicktoRadioButtonByLabel(driver, "Male");

		log.info("Register_03 - Step 03: Enter to FirstName textbox with value is '" + firstName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register_03 - Step 04: Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		log.info("Register_03 - Step 05: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Register_03 - Step 06: Select Dropdown DateOfBirthDay with value is '" + day + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Register_03 - Step 07: Select Dropdown DateOfBirthMonth with value is '" + month + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register_03 - Step 08: Select Dropdown DateOfBirthYear with value is '" + year + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register_03 - Step 02: Click to Checkbox 'Newsletter' ");
		registerPage.clicktoCheckboxByLabel(driver, "Newsletter");

		log.info("Register_03 - Step 10: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Register_03 - Step 11: Enter to Comfirm Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Register_03 - Step 12: Click to 'Register' button ");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register_03 - Step 13: Verify register success message is displayed ");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		
	}

	@Test
	public void TC_04_Register_Existing_Email () {
		log.info("Register_04 - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Register_04 - Step 02: Click to Radio button 'Male' ");
		registerPage.clicktoRadioButtonByLabel(driver, "Male");

		log.info("Register_04 - Step 03: Enter to FirstName textbox with value is '" + firstName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register_04 - Step 04: Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		log.info("Register_04 - Step 05: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Register_04 - Step 06: Select Dropdown DateOfBirthDay with value is '" + day + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Register_04 - Step 07: Select Dropdown DateOfBirthMonth with value is '" + month + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register_04 - Step 08: Select Dropdown DateOfBirthYear with value is '" + year + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register_04 - Step 02: Click to Checkbox 'Newsletter' ");
		registerPage.clicktoCheckboxByLabel(driver, "Newsletter");

		log.info("Register_04 - Step 10: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Register_04 - Step 11: Enter to Comfirm Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Register_04 - Step 12: Click to 'Register' button ");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register_04 - Step 13: Verify register success message is displayed ");
		Assert.assertEquals(registerPage.getRegisterErrorExistingEmailMessage(), "The specified email already exists");
		
	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars () {
		
		log.info("Register_05 - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Register_05 - Step 02: Click to Radio button 'Male' ");
		registerPage.clicktoRadioButtonByLabel(driver, "Male");

		log.info("Register_05 - Step 03: Enter to FirstName textbox with value is '" + firstName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register_05 - Step 04: Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		log.info("Register_05 - Step 05: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Register_05 - Step 06: Select Dropdown DateOfBirthDay with value is '" + day + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Register_05 - Step 07: Select Dropdown DateOfBirthMonth with value is '" + month + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register_05 - Step 08: Select Dropdown DateOfBirthYear with value is '" + year + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register_05 - Step 02: Click to Checkbox 'Newsletter' ");
		registerPage.clicktoCheckboxByLabel(driver, "Newsletter");

		log.info("Register_05 - Step 10: Enter to Password textbox with value is '" + invalidPassword + "'");
		registerPage.inputToTextboxByID(driver, "Password", invalidPassword);

		log.info("Register_05 - Step 11: Enter to Comfirm Password textbox with value is '" + invalidPassword + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", invalidPassword);

		log.info("Register_05 - Step 12: Click to 'Register' button ");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register_05 - Step 13: Verify register success message is displayed ");
		Assert.assertEquals(registerPage.getRegisterErrorMessageByID(driver, "Password-error"), "Password must meet the following rules:\nmust have at least 6 characters");
		
		
	}
	
	@Test
	public void TC_06_Register_Invalid_Confirm_Password () {

		log.info("Register_06 - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Register_06 - Step 02: Click to Radio button 'Male' ");
		registerPage.clicktoRadioButtonByLabel(driver, "Male");

		log.info("Register_06 - Step 03: Enter to FirstName textbox with value is '" + firstName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register_06 - Step 04: Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		log.info("Register_06 - Step 05: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Register_06 - Step 06: Select Dropdown DateOfBirthDay with value is '" + day + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Register_06 - Step 07: Select Dropdown DateOfBirthMonth with value is '" + month + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register_06 - Step 08: Select Dropdown DateOfBirthYear with value is '" + year + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register_06 - Step 02: Click to Checkbox 'Newsletter' ");
		registerPage.clicktoCheckboxByLabel(driver, "Newsletter");

		log.info("Register_06 - Step 10: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Register_06 - Step 11: Enter to Comfirm Password textbox with value is '" + invalidPassword + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", invalidPassword);

		log.info("Register_06 - Step 12: Click to 'Register' button ");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register_06 - Step 13: Verify register success message is displayed ");
		Assert.assertEquals(registerPage.getRegisterErrorMessageByID(driver, "ConfirmPassword-error"), "The password and confirmation password do not match.");
		
		
	}
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();		
	}

}
