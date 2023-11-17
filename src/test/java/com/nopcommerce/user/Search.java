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
import pageObjects.nopCommerce.user.UserSearchPageObject;

public class Search extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, validPassword, emailAddress;
	private String day, month, year;
	private String dataNoExist, dataExistRelative, dataExistAbsolute, appleName, category,manufacturerHP, manufacturerA ;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserSearchPageObject searchPage;

	@Parameters({"browser", "environment", "envName", "osName", "nodeName"})
	@BeforeClass
	public void beforeClass(@Optional("chrome")String browerName,@Optional("testing") String environmentName,@Optional("localUser") String envName, @Optional("windows")String osName,@Optional("NodeB") String nodeName ) {
		
		driver =  getBrowserDriver(browerName, environmentName, envName, osName, nodeName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		validPassword = "1234556";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		day = "10";
		month = "May";
		year = "1998";
		
		dataNoExist = "2050";
		dataExistRelative = "Lenovo";
		dataExistAbsolute = "Thinkpad X1 Carbon Laptop";
		
		category =  "Computers" ;
		manufacturerHP = "HP";
		manufacturerA = "Apple";
		appleName = "Apple MacBook Pro";
		
		

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
		
		log.info("Precondition - Step 19: Navigate to 'Search' page");
		searchPage = (UserSearchPageObject) homePage.openpageAtFooterByName(driver, "Search");
		
		log.info("Precondition - Step 20: Verify 'Search' title is displayed " );
		Assert.assertTrue(searchPage.isPageTitleByText(driver, "Search"));

	}
	
	@Test
	public void Search_01_Empty_Data() {
		
		log.info("Search_01- Step 01: Click to 'Search' button ");
		searchPage.clickToButtonByText(driver, "Search");
		
		log.info("Search_01- Step 02: Verify Search message ");
		Assert.assertEquals(searchPage.getSearchMessage(), "Search term minimum length is 3 characters");
	}
	
	@Test
	public void Search_02_Data_Not_Exist() {
		
		log.info("Search_02- Step 01: Enter to Search keyword textbox with value is '" + dataNoExist + "'");
		searchPage.inputToSearchText(dataNoExist);
		
		log.info("Search_02- Step 02: Click to 'Search' button ");
		searchPage.clickToButtonByText(driver, "Search");
		
		log.info("Search_02- Step 03: Verify Search message ");
		Assert.assertEquals(searchPage.getSearchMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void Search_03_Data_Relative() {
		
		log.info("Search_03- Step 01: Enter to Search keyword textbox with value is '" + dataExistRelative + "'");
		searchPage.inputToSearchText(dataExistRelative);
		
		log.info("Search_03- Step 02: Click to 'Search' button ");
		searchPage.clickToButtonByText(driver, "Search");
		
		log.info("Search_03- Step 03: Verify Search result ");
		Assert.assertFalse(searchPage.isSearchResultUndisplayed(dataExistRelative));
	}
	
	@Test
	public void Search_04_Data_Absolute() {
		
		log.info("Search_04- Step 01: Enter to Search keyword textbox with value is '" + dataExistAbsolute + "'");
		searchPage.inputToSearchText(dataExistAbsolute);
		
		log.info("Search_04- Step 02: Click to 'Search' button ");
		searchPage.clickToButtonByText(driver, "Search");
		
		log.info("Search_04- Step 03: Verify Search result ");
		Assert.assertTrue(searchPage.isSearchResultAbsoluteDisplayed(dataExistAbsolute));
		
	}
	
	@Test
	public void Search_05_Parent_Categories() {
	
		log.info("Search_05 - Step 01: Click to Radio button 'Advanced search' ");
		searchPage.clicktoRadioButtonByLabel(driver, "Advanced search");
		
		log.info("Search_05 - Step 02: Enter to Search keyword textbox with value is '" + appleName + "'");
		searchPage.inputToSearchText(appleName);
		
		log.info("Search_05 - Step 03: Select Dropdown Category with value is '" + category + "'");
		searchPage.selectToDropdownByName(driver, "cid", category);
		
		log.info("Search_05- Step 04: Click to 'Search' button ");
		searchPage.clickToButtonByText(driver, "Search");
		
		log.info("Search_05- Step 05: Verify Search message ");
		Assert.assertEquals(searchPage.getSearchMessage(), "No products were found that matched your criteria.");
		
	}
	
	@Test
	public void Search_06_Sub_Categories() {
		
		log.info("Search_06 - Step 01: Navigate to 'Search' page");
		searchPage = (UserSearchPageObject) searchPage.openpageAtFooterByName(driver, "Search");
	
		log.info("Search_06 - Step 02: Click to Radio button 'Advanced search' ");
		searchPage.clicktoRadioButtonByLabel(driver, "Advanced search");
		
		log.info("Search_06 - Step 03: Enter to Search keyword textbox with value is '" + appleName + "'");
		searchPage.inputToSearchText(appleName);
		
		log.info("Search_06 - Step 04: Select Dropdown Category with value is '" + category + "'");
		searchPage.selectToDropdownByName(driver, "cid", category);
		
		log.info("Search_06 - Step 05: Click to Radio button 'Automatically search sub categories' ");
		searchPage.clicktoRadioButtonByLabel(driver, "Automatically search sub categories");
		
		log.info("Search_06- Step 06: Click to 'Search' button ");
		searchPage.clickToButtonByText(driver, "Search");
		
		log.info("Search_06- Step 07: Verify Search result ");
		Assert.assertTrue(searchPage.isSearchResultAbsoluteDisplayed(appleName));
		
	}
	
	@Test
	public void Search_07_Incorrect_Manufacturer() {
		
		log.info("Search_07 - Step 01: Click to Radio button 'Advanced search' ");
		searchPage.clicktoRadioButtonByLabel(driver, "Advanced search");
		
		log.info("Search_07 - Step 02: Enter to Search keyword textbox with value is '" + appleName + "'");
		searchPage.inputToSearchText(appleName);
		
		log.info("Search_07 - Step 03: Select Dropdown Category with value is '" + category + "'");
		searchPage.selectToDropdownByName(driver, "cid", category);
		
		log.info("Search_07 - Step 04: Click to Radio button 'Automatically search sub categories' ");
		searchPage.clicktoRadioButtonByLabel(driver, "Automatically search sub categories");
		
		log.info("Search_07 - Step 05: Select Dropdown Category with value is '" + manufacturerHP + "'");
		searchPage.selectToDropdownByName(driver, "mid", manufacturerHP);
		
		log.info("Search_07- Step 06: Click to 'Search' button ");
		searchPage.clickToButtonByText(driver, "Search");
		
		log.info("Search_07- Step 07: Verify Search message ");
		Assert.assertEquals(searchPage.getSearchMessage(), "No products were found that matched your criteria.");
		
		
	}
	
	@Test
	public void Search_08_Correct_Manufacturer() {
		
		log.info("Search_08 - Step 01: Click to Radio button 'Advanced search' ");
		searchPage.clicktoRadioButtonByLabel(driver, "Advanced search");
		
		log.info("Search_08 - Step 02: Enter to Search keyword textbox with value is '" + appleName + "'");
		searchPage.inputToSearchText(appleName);
		
		log.info("Search_08 - Step 03: Select Dropdown Category with value is '" + category + "'");
		searchPage.selectToDropdownByName(driver, "cid", category);
		
		log.info("Search_08 - Step 04: Click to Radio button 'Automatically search sub categories' ");
		searchPage.clicktoRadioButtonByLabel(driver, "Automatically search sub categories");
		
		log.info("Search_08 - Step 05: Select Dropdown Category with value is '" + manufacturerA + "'");
		searchPage.selectToDropdownByName(driver, "mid", manufacturerA);
		
		log.info("Search_08- Step 06: Click to 'Search' button ");
		searchPage.clickToButtonByText(driver, "Search");
		
		log.info("Search_08- Step 07: Verify Search result ");
		Assert.assertTrue(searchPage.isSearchResultAbsoluteDisplayed(appleName));
		
	}
		
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
