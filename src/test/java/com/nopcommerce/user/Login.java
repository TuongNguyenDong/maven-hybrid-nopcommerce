package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Login  extends BaseTest {
	
	private WebDriver driver;
	private String firstName, lastName, validPassword ,emailAddress, wrongEmailAddress, notFoundEmail, inValidPassword;
	private  String day, month, year;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	
	@Parameters({"browser", "environment", "envName", "osName", "nodeName"})
	@BeforeClass
	public void beforeClass(@Optional("chrome")String browerName,@Optional("testing") String environmentName,@Optional("localUser") String envName, @Optional("windows")String osName,@Optional("NodeB") String nodeName ) {
		
		driver =  getBrowserDriver(browerName, environmentName, envName, osName, nodeName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		firstName = "Automation";
		lastName = "FC";
		validPassword = "1234556";
		inValidPassword = "1234567";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		wrongEmailAddress = "1234@123#$";
		notFoundEmail = "afc" + generateFakeNumber() + "@mail.com";
		

		day = "10";
		month = "May";
		year = "1998";
		
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
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Precondition - Step 10: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Precondition - Step 11: Enter to Comfirm Password textbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Precondition - Step 12: Click to 'Register' button ");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Precondition - Step 13: Verify register success message is displayed ");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	
	}
	
	@Test
	public void Login_01_Empty_Data() {
		
		log.info("Login_01 - Step 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();
		
		log.info("Login_01 - Step 02: Click to 'Log in' button");
		loginPage.clickLoginButton();
		
		log.info("Login_01 - Step 03:Verify 'Email-error' message");
		Assert.assertEquals(loginPage.getErrorMessageByID(driver, "Email-error"), "Please enter your email");
		
	}
	
	@Test
	public void Login_02_Invalid_Email() {

		log.info("Login_02 - Step 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Login_02 - Step 02: Enter to Email textbox with value is '" + wrongEmailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", wrongEmailAddress);
		
		log.info("Login_02 - Step 03: Click to 'Log in' button");
		loginPage.clickLoginButton();

		log.info("Login_02 - Step 04:Verify 'Wrong email' message");
		Assert.assertEquals(loginPage.getErrorMessageByID(driver, "Email-error"), "Wrong email");

	}
	
	@Test
	public void Login_03_Email_Mot_Found() {
		
		log.info("Login_03 - Step 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();
		
		log.info("Login_03 - Step 02: Enter to Email textbox with value is '" + notFoundEmail + "'");
		loginPage.inputToTextboxByID(driver, "Email", notFoundEmail);
		
		log.info("Login_03 - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToTextboxByID(driver, "Password", validPassword);
		
		log.info("Login_03 - Step 04: Click to 'Log in' button");
		loginPage.clickLoginButton();
		
		log.info("Login_03 - Step 05:Verify Unsuccessfull message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
		 	
	}
	
	@Test
	public void Login_04_Existing_Email_And_Empty_Password() {
		log.info("Login_04 - Step 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();
		
		log.info("Login_04 - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Login_04 - Step 03: Click to 'Log in' button");
		loginPage.clickLoginButton();
		
		log.info("Login_04 - Step 04:Verify Unsuccessfull message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
		 	
		
	}
	
	@Test
	public void Login_05_Existing_Email_And_Incorrect_Password() {
		
		log.info("Login_05 - Step 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();
		
		log.info("Login_05 - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Login_05 - Step 03: Enter to Password textbox with value is '" + inValidPassword + "'");
		loginPage.inputToTextboxByID(driver, "Password", inValidPassword);
		
		log.info("Login_05 - Step 04: Click to 'Log in' button");
		loginPage.clickLoginButton();
		
		log.info("Login_05 - Step 05:Verify Unsuccessfull message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");		 	
		
	}
	
	@Test
	public void Login_06_Valid_Email_And_Password() {
		
		log.info("Login_06 - Step 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();
		
		log.info("Login_06 - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Login_06 - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToTextboxByID(driver, "Password", validPassword);
		
		log.info("Login_06 - Step 04: Click to 'Log in' button");
		homePage= loginPage.clickLoginButton();
		
		log.info("Login_06 - Step 05: Verify 'My Account' link is displayed " );
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
	}
	
    @AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
