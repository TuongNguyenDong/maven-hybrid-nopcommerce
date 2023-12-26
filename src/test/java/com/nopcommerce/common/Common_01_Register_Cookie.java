package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_Cookie extends BaseTest {
	private WebDriver driver;
	private String emailAddress, password;
	private String firstName, lastName;
	public static Set<Cookie> loggedCookies;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;


	@Parameters({"browser", "environment", "envName", "osName", "nodeName"})
	@BeforeTest(description = "Create new common User for all Classes Test")
	@BeforeClass
	public void beforeClass(@Optional("chrome")String browerName,@Optional("testing") String environmentName,@Optional("localApp") String envName, @Optional("windows")String osName,@Optional("NodeB") String nodeName ) {
		
		driver =  getBrowserDriver(browerName, environmentName, envName, osName, nodeName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		password = "1234556";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";

		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();
		log.info("Register - Step 02: Enter to FirstName textbox with value is '" + firstName + "'");
		registerPage.inputToFisrtnameTextbox(firstName);
		log.info("Register - Step 03: Enter to LastName textbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);
		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		log.info("Register - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);
		log.info("Register - Step 06: Enter to Comfirm Password textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);
		log.info("Register - Step 07: Click to 'Register' button ");
		registerPage.clickToRegisterButton();
		log.info("Register - Step 08: Verify register success message is displayed ");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		log.info("Login - Step 09: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();
		log.info("Login - Step 10: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);
		log.info("Login - Step 11: Enter to Passwordtextbox with value is '" + password + "'");
		loginPage.inputToPasswordTextbox(password);
		log.info("Login - Step 12: Click to 'Login' button " );
		homePage = loginPage.clickLoginButton();

		loggedCookies = homePage.getAllCookies(driver);
		for (Cookie cookie : loggedCookies) {
			System.out.println("Cookie at Common Class" + cookie);

		}

	}

	@AfterTest
	public void afterClass() {

		driver.quit();
	}

}
