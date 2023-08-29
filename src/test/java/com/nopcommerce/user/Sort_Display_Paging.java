package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserComputersPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserNotebooksPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Sort_Display_Paging extends BaseTest {
	
	private WebDriver driver;
	private String firstName, lastName, validPassword, emailAddress;
	private String day, month, year;
	private String nameAscending, nameDescending, priceLowToHight, priceHighToLow ;
	
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserComputersPageObject computersPage;
	private UserNotebooksPageObject notebooksPage;
	
	
	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browerName, String enviromentName) {
		driver = getBrowserDriver(browerName, enviromentName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		validPassword = "1234556";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		day = "10";
		month = "May";
		year = "1998";
		nameAscending ="Name: A to Z";
		nameDescending ="Name: Z to A";
		priceLowToHight ="Price: Low to High";
		priceHighToLow ="Price: High to Low";

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
		
		log.info("Precondition - Step 19: Swith to 'Computers' page");
		computersPage = (UserComputersPageObject) homePage.openpageAtHomePageByName(driver, "Computers");
		
		log.info("Precondition - Step 20: Verify 'Computers' title is displayed " );
		Assert.assertTrue(computersPage.isPageTitleByText(driver, "Computers"));
		
		log.info("Precondition - Step 21: Swith to 'Notebooks' page");
		notebooksPage =   (UserNotebooksPageObject) computersPage.openpageAtComputersPageByName(driver, "Notebooks");
		
		log.info("Precondition - Step 22: Verify 'Notebooks' title is displayed " );
		Assert.assertTrue(notebooksPage.isPageTitleByText(driver, "Notebooks"));
		

	}
	
//	@Test
	public void Soft_01_Name_Ascending() {
		
		log.info("Soft_01 - Step 01: Select Dropdown Product soft order with value is '" + nameAscending + "'" );
		notebooksPage.selectItemProductSoftDropdown(driver, nameAscending);
	
		log.info("Soft_01 - Step 02: Verify Dropdown  Product soft order result is correct with value of '" + nameAscending + "'" );
		Assert.assertTrue(notebooksPage.isProductNameSortByAscending(driver));
		
	}
	
//	@Test
	public void Soft_02_Name_Decending() {
		
		log.info("Soft_02 - Step 01: Select Dropdown Product soft order with value is '" + nameDescending + "'" );
		notebooksPage.selectItemProductSoftDropdown(driver, nameDescending);
	
		log.info("Soft_02 - Step 02: Verify Dropdown  Product soft order result is correct with value of '" + nameDescending + "'" );
		Assert.assertTrue(notebooksPage.isProductNameSortByDecending(driver));
		
	}
	
	@Test
	public void Soft_03_Price_Low_To_High() {
		
		log.info("Soft_03 - Step 01: Select Dropdown Product soft order with value is '" + priceLowToHight + "'" );
		notebooksPage.selectItemProductSoftDropdown(driver, priceLowToHight);
	
		log.info("Soft_03 - Step 02: Verify Dropdown  Product soft order result is correct with value of '" + priceLowToHight + "'" );
		Assert.assertTrue(notebooksPage.isProductPriceSortByLowToHigh(driver));
		
	}
	
	@Test
	public void Soft_04_Price_High_To_Low() {
		
		log.info("Soft_04 - Step 01: Select Dropdown Product soft order with value is '" + priceHighToLow + "'" );
		notebooksPage.selectItemProductSoftDropdown(driver, priceHighToLow);
	
		log.info("Soft_04 - Step 02: Verify Dropdown  Product soft order result is correct with value of '" + priceHighToLow + "'" );
		Assert.assertTrue(notebooksPage.isProductPriceSortByHighToLow(driver));
		
	}

}
