package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.ShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserComputersPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserNotebooksPageObject;
import pageObjects.nopCommerce.user.UserProductsNamePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.WishlistPageObject;

public class Whishlist_Compare_Recent_View extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, validPassword, emailAddress;
	private String day, month, year;
	private String wishlistUrl;

	
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserComputersPageObject computersPage;
	private UserNotebooksPageObject notebooksPage;
	private UserProductsNamePageObject  productsNamePage;
	private WishlistPageObject  wishlistPage;
	private ShoppingCartPageObject  shoppingCartPage;

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
		notebooksPage = (UserNotebooksPageObject) computersPage.openpageAtComputersPageByName(driver, "Notebooks");
		
		log.info("Precondition - Step 22: Verify 'Notebooks' title is displayed " );
		Assert.assertTrue(notebooksPage.isPageTitleByText(driver, "Notebooks"));
		
		log.info("Precondition - Step 23: Click Product name  with  title 'Apple MacBook Pro 13-inch' " );
		productsNamePage = notebooksPage.clickToProductByText(driver, "Apple MacBook Pro 13-inch");

	}

	@Test
	public void TC_01_Add_To_Wishlist() {
		log.info("TC_01 - Step 01: Click 'Add to wishlist'" );
		productsNamePage.clickToOverviewButtonByText("Add to wishlist");
		
		log.info("TC_01 - Step 02: Verify add to wishlist success message is displayed ");
		Assert.assertTrue(productsNamePage.getAddToWishlistSuccessMessage().contains("The product has been added"));
		
		log.info("TC_01 - Step 03: Close 'Change Password' success message ");
		productsNamePage.clickToCloseSuccessMessage();
		
		log.info("TC_01 - Step 04: Navigate to 'Wishlist' page");
		wishlistPage = productsNamePage.openWishlistPage();
		
		log.info("Create_Post - Step 02: Get 'Search Posts' page Url");
		wishlistUrl = wishlistPage.getPageUrl(driver);
		
		log.info("TC_01 - Step 05: Verify 'Wishlist' title is displayed " );
		Assert.assertTrue(wishlistPage.isPageTitleByText(driver, "Wishlist"));
		
		log.info("TC_01 - Step 06: Verify 'Apple MacBook Pro 13-inch' product is displayed " );
		Assert.assertEquals(wishlistPage.getTextProductByColumnAtRowNumber("Product(s)", "1"), "Apple MacBook Pro 13-inch");
		
		log.info("TC_01 - Step 07: Click  To 'Your wishlist URL for sharing:'" );
		wishlistPage.clickToWishlistSharingLink();
		
		log.info("TC_01 - Step 08: Verify 'Wishlist of fullName' title is displayed " );
		Assert.assertTrue(wishlistPage.isPageTitleByText(driver, "Wishlist of Automation FC"));
		

	}

	@Test
	public void TC_02_Add_To_Car_From_Wishlist() {
		log.info("TC_02 - Step 01: Open 'Wishlist' page");
		wishlistPage = wishlistPage.openWishlistPageUrl(wishlistUrl);
		
		log.info("TC_02 - Step 01: Click  To 'Add to cart'checkbox" );
		wishlistPage.checkToCheckboxByColumnNameAtRowNumber("Add to cart", "1");
		
		log.info("TC_02 - Step 02: Click  To 'Add to cart'button" );
		shoppingCartPage = wishlistPage.clickToAddToCartButton();
		
		log.info("TC_02 - Step 03: Verify 'Shopping cart' title is displayed " );
		Assert.assertTrue(shoppingCartPage.isPageTitleByText(driver, "Shopping cart"));
		
		log.info("TC_02 - Step 04: Verify 'Apple MacBook Pro 13-inch' product is displayed " );
		Assert.assertEquals(shoppingCartPage.getTextProductByColumnAtRowNumberatShoppingCart("Product(s)", "1"), "Apple MacBook Pro 13-inch");
		
		log.info("TC_02 - Step 05: Open 'Wishlist' page");
		wishlistPage = wishlistPage.openWishlistPageUrl(wishlistUrl);
		
		log.info("TC_02 - Step 06: Verify 'Wishlist is empty' is displayed " );
		Assert.assertTrue(wishlistPage.isWishlistEmptyMessage());
		

	}

	@Test
	public void TC_03_Remove_Product_Wishlist() {

	}
	
	@Test
	public void TC_04_Add_to_Compare() {
		
	}

	@Test
	public void TC_05_Recently_Reviewd_Products() {

	}

	@AfterClass
	public void afterClass() {

		//closeBrowserDriver();
	}

}
