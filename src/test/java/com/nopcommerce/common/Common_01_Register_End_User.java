package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest {
	private WebDriver driver;
	public static String  emailAddress, password;
	private String firstName, lastName;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;



	@Parameters("browser")
	@BeforeTest (description = "Create new common User for all Classes Test")
	public void Register(String browserName) {
		
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		password = "1234556";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";

		
        log.info("Pre-Condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();
		log.info("Pre-Condition - Step 02: Enter to FirstName textbox with value is '"+ firstName + "'" );
		registerPage.inputToFisrtnameTextbox(firstName);
		log.info("Pre-Condition - Step 03: Enter to LastName textbox with value is '" + lastName + "'" );
		registerPage.inputToLastnameTextbox(lastName);
		log.info("Pre-Condition - Step 04: Enter to Email textbox with value is '" + emailAddress + "'" );
		registerPage.inputToEmailTextbox(emailAddress);
		log.info("Pre-Condition - Step 05: Enter to Password textbox with value is '" + password + "'" );
		registerPage.inputToPasswordTextbox(password);
		log.info("Pre-Condition - Step 06: Enter to Comfirm Password textbox with value is '" + password + "'" );
		registerPage.inputToConfirmPasswordTextbox(password);
		log.info("Pre-Condition - Step 07: Click to 'Register' button " );
		registerPage.clickToRegisterButton();
		log.info("Pre-Condition - Step 08: Verify register success message is displayed " );
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");



	}

	@AfterTest
	public void afterClass() {

		driver.quit();
	}

}
