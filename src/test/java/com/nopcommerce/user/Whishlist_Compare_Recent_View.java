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
import pageObjects.nopCommerce.user.CompareProductsPageObject;
import pageObjects.nopCommerce.user.RecentlyViewedProductsPageObject;
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
	private CompareProductsPageObject  compareProductsPage;
	private RecentlyViewedProductsPageObject  recentlyViewedProductsPage;

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

		log.info("Precondition - Step 09: Click to Checkbox 'Newsletter' ");
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
		
		log.info("Precondition - Step 19: Swith to 'Computers' page");
		computersPage = (UserComputersPageObject) homePage.openpageAtHomePageByName(driver, "Computers");
		
		log.info("Precondition - Step 20: Verify 'Computers' title is displayed " );
		Assert.assertTrue(computersPage.isPageTitleByText(driver, "Computers"));
		
		log.info("Precondition - Step 21: Swith to 'Notebooks' page");
		notebooksPage = (UserNotebooksPageObject) computersPage.openpageAtComputersPageByName("Notebooks");
		
		log.info("Precondition - Step 22: Verify 'Notebooks' title is displayed " );
		Assert.assertTrue(notebooksPage.isPageTitleByText(driver, "Notebooks"));
		
		log.info("Precondition - Step 23: Click Product name  with  title 'Apple MacBook Pro 13-inch' " );
		productsNamePage = notebooksPage.clickToProductByText(driver, "Apple MacBook Pro 13-inch");

	}

	@Test
	public void Whishlist_Compare_Recent_View_01_Add_To_Wishlist() {
		
		log.info("Whishlist_Compare_Recent_View_01 - Step 01: Click 'Add to wishlist'" );
		productsNamePage.clickToOverviewButtonByText("Add to wishlist");
		
		log.info("Whishlist_Compare_Recent_View_01 - Step 02: Verify add to wishlist success message is displayed ");
		Assert.assertTrue(productsNamePage.getAddToWishlistSuccessMessage().contains("The product has been added"));
		
		log.info("Whishlist_Compare_Recent_View_01 - Step 03: Close 'Change Password' success message ");
		productsNamePage.clickToCloseSuccessMessage();
		
		log.info("Whishlist_Compare_Recent_View_01 - Step 04: Navigate to 'Wishlist' page");
		wishlistPage = productsNamePage.openWishlistPage();
		
		log.info("Whishlist_Compare_Recent_View_01 - Step 05: Get 'Wishlist' page Url");
		wishlistUrl = wishlistPage.getPageUrl(driver);
		
		log.info("Whishlist_Compare_Recent_View_01 - Step 06: Verify 'Wishlist' title is displayed " );
		Assert.assertTrue(wishlistPage.isPageTitleByText(driver, "Wishlist"));
		
		log.info("Whishlist_Compare_Recent_View_01 - Step 07: Verify 'Apple MacBook Pro 13-inch' product is displayed " );
		Assert.assertEquals(wishlistPage.getTextProductByColumnAtRowNumber("Product(s)", "1"), "Apple MacBook Pro 13-inch");
		
		log.info("Whishlist_Compare_Recent_View_01 - Step 08: Click  To 'Your wishlist URL for sharing:'" );
		wishlistPage.clickToWishlistSharingLink();
		
		log.info("Whishlist_Compare_Recent_View_01 - Step 09: Verify 'Wishlist of fullName' title is displayed " );
		Assert.assertTrue(wishlistPage.isPageTitleByText(driver, "Wishlist of Automation FC"));
		
	}

	@Test
	public void Whishlist_Compare_Recent_View_02_Add_To_Car_From_Wishlist() {
		log.info("Whishlist_Compare_Recent_View_02 - Step 01: Open 'Wishlist' page");
		wishlistPage = wishlistPage.openWishlistPageUrl(wishlistUrl);
		
		log.info("Whishlist_Compare_Recent_View_02 - Step 01: Click  To 'Add to cart'checkbox" );
		wishlistPage.checkToCheckboxByColumnNameAtRowNumber("Add to cart", "1");
		
		log.info("Whishlist_Compare_Recent_View_02 - Step 02: Click  To 'Add to cart'button" );
		shoppingCartPage = wishlistPage.clickToAddToCartButton();
		
		log.info("Whishlist_Compare_Recent_View_02 - Step 03: Verify 'Shopping cart' title is displayed " );
		Assert.assertTrue(shoppingCartPage.isPageTitleByText(driver, "Shopping cart"));
		
		log.info("Whishlist_Compare_Recent_View_02 - Step 04: Verify 'Apple MacBook Pro 13-inch' product is displayed " );
		Assert.assertEquals(shoppingCartPage.getTextLinkNameProductByColumnAtRowNumberatShoppingCart("Product(s)", "1"), "Apple MacBook Pro 13-inch");
		
		log.info("Whishlist_Compare_Recent_View_02 - Step 05: Open 'Wishlist' page");
		wishlistPage = shoppingCartPage.openWishlistPage();
		
		log.info("Whishlist_Compare_Recent_View_02 - Step 06: Verify 'Wishlist is empty' is displayed " );
		Assert.assertTrue(wishlistPage.isWishlistEmptyMessage());
		

	}

	@Test
	public void Whishlist_Compare_Recent_View_03_Remove_Product_Wishlist() {
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 01: Swith to 'Computers' page");
		computersPage = (UserComputersPageObject) wishlistPage.openpageAtHomePageByName(driver, "Computers");
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 02: Verify 'Computers' title is displayed " );
		Assert.assertTrue(computersPage.isPageTitleByText(driver, "Computers"));
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 03: Swith to 'Notebooks' page");
		notebooksPage = (UserNotebooksPageObject) computersPage.openpageAtComputersPageByName("Notebooks");
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 04: Verify 'Notebooks' title is displayed " );
		Assert.assertTrue(notebooksPage.isPageTitleByText(driver, "Notebooks"));
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 05: Click Product name  with  title 'Asus N551JK-XO076H Laptop' " );
		productsNamePage = notebooksPage.clickToProductByText(driver, "Asus N551JK-XO076H Laptop");
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 06: Click 'Add to wishlist'" );
		productsNamePage.clickToOverviewButtonByText("Add to wishlist");
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 07: Verify add to wishlist success message is displayed ");
		Assert.assertTrue(productsNamePage.getAddToWishlistSuccessMessage().contains("The product has been added"));
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 08: Close 'add to wishlist' success message ");
		productsNamePage.clickToCloseSuccessMessage();
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 09: Navigate to 'Wishlist' page");
		wishlistPage = productsNamePage.openWishlistPage();
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 10: Get 'Wishlist' page Url");
		wishlistUrl = wishlistPage.getPageUrl(driver);
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 11: Verify 'Wishlist' title is displayed " );
		Assert.assertTrue(wishlistPage.isPageTitleByText(driver, "Wishlist"));
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 12: Verify 'Asus N551JK-XO076H Laptop' product is displayed " );
		Assert.assertEquals(wishlistPage.getTextProductByColumnAtRowNumber("Product(s)", "1"), "Asus N551JK-XO076H Laptop");
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 13: ClickTo Remove Button with Product name 'Asus N551JK-XO076H Laptop' " );
		wishlistPage.clickToRemoveButtonByProductName("Asus N551JK-XO076H Laptop");
		
		log.info("Whishlist_Compare_Recent_View_03 - Step 14: Verify 'Wishlist is empty' is displayed " );
		Assert.assertTrue(wishlistPage.isWishlistEmptyMessage());
		
	}
	
	@Test
	public void Whishlist_Compare_Recent_View_04_Add_to_Compare() {
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 01: Swith to 'Computers' page");
		computersPage = (UserComputersPageObject) wishlistPage.openpageAtHomePageByName(driver, "Computers");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 02: Verify 'Computers' title is displayed " );
		Assert.assertTrue(computersPage.isPageTitleByText(driver, "Computers"));
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 03: Swith to 'Notebooks' page");
		notebooksPage = (UserNotebooksPageObject) computersPage.openpageAtComputersPageByName("Notebooks");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 04: Verify 'Notebooks' title is displayed " );
		Assert.assertTrue(notebooksPage.isPageTitleByText(driver, "Notebooks"));
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 05: Click Add To Compare List  with product title 'Asus N551JK-XO076H Laptop' " );
		notebooksPage.clickToAddToCompareListByProductTitile(driver, "Asus N551JK-XO076H Laptop");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 06: Verify add to compare list success message is displayed ");
		Assert.assertTrue(notebooksPage.getAddSuccessMessage(driver).contains("The product has been added"));
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 07: Click Add To Compare List  with product title 'HP Spectre XT Pro UltraBook' " );
		notebooksPage.clickToAddToCompareListByProductTitile(driver, "HP Spectre XT Pro UltraBook");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 08: Verify add to compare list success message is displayed ");
		Assert.assertTrue(notebooksPage.getAddSuccessMessage(driver).contains("The product has been added"));
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 09: Navigate to 'Compare Products' page");
		compareProductsPage = (CompareProductsPageObject) notebooksPage.openpageAtFooterByName(driver, "Compare products list");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 10: Verify 'Compare products' title is displayed " );
		Assert.assertTrue(compareProductsPage.isPageTitleByText(driver, "Compare products"));
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 11: Verify 'HP Spectre XT Pro UltraBook' product name is displayed " );
		Assert.assertEquals(compareProductsPage.getTextProductByRowAtColumnNumber("Name", "2"), "HP Spectre XT Pro UltraBook");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 12: Verify 'Asus N551JK-XO076H Laptop' product name is displayed " );
		Assert.assertEquals(compareProductsPage.getTextProductByRowAtColumnNumber("Name", "3"), "Asus N551JK-XO076H Laptop");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 13: Verify 'Price' of HP Spectre XT Pro UltraBook is displayed " );
		Assert.assertEquals(compareProductsPage.getPriceProductByRowAtColumnNumber("Price", "2"), "$1,350.00");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 14: Verify 'Price'of Asus N551JK-XO076H Laptop is displayed " );
		Assert.assertEquals(compareProductsPage.getPriceProductByRowAtColumnNumber("Price", "3"), "$1,500.00");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 15: Verify 'Screensize'of HP Spectre XT Pro UltraBook is displayed " );
		Assert.assertEquals(compareProductsPage.getSpecificationProductByRowAtColumnNumber("Screensize", "2"), "13.3'"+"'");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 16: Verify 'Screensize'of Asus N551JK-XO076H Laptop is displayed " );
		Assert.assertEquals(compareProductsPage.getSpecificationProductByRowAtColumnNumber("Screensize", "3"), "15.6'"+"'");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 17: Verify 'CPU Type' of HP Spectre XT Pro UltraBook is displayed " );
		Assert.assertEquals(compareProductsPage.getSpecificationProductByRowAtColumnNumber("CPU Type", "2"), "Intel Core i5");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 18: Verify 'CPU Type'of Asus N551JK-XO076H Laptop is displayed " );
		Assert.assertEquals(compareProductsPage.getSpecificationProductByRowAtColumnNumber("CPU Type", "3"), "Intel Core i7");

		log.info("Whishlist_Compare_Recent_View_04 - Step 17: Verify 'Memory' of HP Spectre XT Pro UltraBook is displayed " );
		Assert.assertEquals(compareProductsPage.getSpecificationProductByRowAtColumnNumber("Memory", "2"), "4 GB");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 18: Verify 'Memory'of Asus N551JK-XO076H Laptop is displayed " );
		Assert.assertEquals(compareProductsPage.getSpecificationProductByRowAtColumnNumber("Memory", "3"), "16 GB");

		log.info("Whishlist_Compare_Recent_View_04 - Step 17: Verify 'Hard drive' of HP Spectre XT Pro UltraBook is displayed " );
		Assert.assertEquals(compareProductsPage.getSpecificationProductByRowAtColumnNumber("Hard drive", "2"), "128 GB");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 18: Verify 'Hard drive'of Asus N551JK-XO076H Laptop is displayed " );
		Assert.assertEquals(compareProductsPage.getSpecificationProductByRowAtColumnNumber("Hard drive", "3"), "1 TB");
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 19: Verify 'Remove Button' of HP Spectre XT Pro UltraBook is displayed " );
		Assert.assertTrue(compareProductsPage.getRemoveButtonRTextByColumnNumber("2").contains("Remove"));
		
		log.info("Whishlist_Compare_Recent_View_04 - Step 20: Verify 'Remove Button'of Asus N551JK-XO076H Laptop is displayed " );
		Assert.assertTrue(compareProductsPage.getRemoveButtonRTextByColumnNumber("3").contains("Remove"));

		log.info("Whishlist_Compare_Recent_View_04 - Step 21: Click To 'Clear List'");
		compareProductsPage.clickToClearList();

		log.info("Whishlist_Compare_Recent_View_04 - Step 22: Verify 'Compare List is empty' is displayed ");
		Assert.assertTrue(compareProductsPage.isCompareProductsEmptyMessage());

	}

	@Test
	public void Whishlist_Compare_Recent_View_05_Recently_Reviewd_Products() {
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 01: Swith to 'Computers' page");
		computersPage = (UserComputersPageObject) compareProductsPage.openpageAtHomePageByName(driver, "Computers");
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 02: Verify 'Computers' title is displayed " );
		Assert.assertTrue(computersPage.isPageTitleByText(driver, "Computers"));
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 03: Swith to 'Notebooks' page");
		notebooksPage = (UserNotebooksPageObject) computersPage.openpageAtComputersPageByName("Notebooks");
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 04: Verify 'Notebooks' title is displayed " );
		Assert.assertTrue(notebooksPage.isPageTitleByText(driver, "Notebooks"));
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 05: Click Product name  with  title 'Apple MacBook Pro 13-inch' " );
		productsNamePage = notebooksPage.clickToProductByText(driver, "Apple MacBook Pro 13-inch");
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 06: Swith to 'Notebooks' page From UserProducts Page");
		notebooksPage = (UserNotebooksPageObject) productsNamePage.openPageAtUserProductsPageByName( "Notebooks");
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 07: Click Product name  with  title 'Asus N551JK-XO076H Laptop' " );
		productsNamePage = notebooksPage.clickToProductByText(driver, "Asus N551JK-XO076H Laptop");
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 08: Swith to 'Notebooks' page From UserProducts Page");
		notebooksPage = (UserNotebooksPageObject) productsNamePage.openPageAtUserProductsPageByName( "Notebooks");
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 09: Click Product name  with  title 'HP Envy 6-1180ca 15.6-Inch Sleekbook' " );
		productsNamePage = notebooksPage.clickToProductByText(driver, "HP Envy 6-1180ca 15.6-Inch Sleekbook");
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 10: Swith to 'Notebooks' page From UserProducts Page");
		notebooksPage = (UserNotebooksPageObject) productsNamePage.openPageAtUserProductsPageByName( "Notebooks");
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 11: Click Product name  with  title 'HP Spectre XT Pro UltraBook' " );
		productsNamePage = notebooksPage.clickToProductByText(driver, "HP Spectre XT Pro UltraBook");
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 12: Swith to 'Notebooks' page From UserProducts Page");
		notebooksPage = (UserNotebooksPageObject) productsNamePage.openPageAtUserProductsPageByName( "Notebooks");
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 13: Click Product name  with  title 'Lenovo Thinkpad X1 Carbon Laptop' " );
		productsNamePage = notebooksPage.clickToProductByText(driver, "Lenovo Thinkpad X1 Carbon Laptop");
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 14: Open 'Recently viewed products' page");	
		recentlyViewedProductsPage = (RecentlyViewedProductsPageObject) productsNamePage.openpageAtFooterByName(driver, "Recently viewed products");
	
		log.info("Whishlist_Compare_Recent_View_05 - Step 15: Verify 'Recently viewed products' title is displayed " );
		Assert.assertTrue(recentlyViewedProductsPage.isPageTitleByText(driver, "Recently viewed products"));
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 16: Verify 'Lenovo Thinkpad X1 Carbon Laptop' product Name is displayed " );
		Assert.assertTrue(recentlyViewedProductsPage.getProductNameByTextAtRViewedPage("Lenovo Thinkpad X1 Carbon Laptop"));
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 17: Verify 'HP Spectre XT Pro UltraBook' product Name is displayed " );		
		Assert.assertTrue(recentlyViewedProductsPage.getProductNameByTextAtRViewedPage("HP Spectre XT Pro UltraBook"));
		
		log.info("Whishlist_Compare_Recent_View_05 - Step 18: Verify 'HP Envy 6-1180ca 15.6-Inch Sleekbook' product Name is displayed " );
		Assert.assertTrue(recentlyViewedProductsPage.getProductNameByTextAtRViewedPage("HP Envy 6-1180ca 15.6-Inch Sleekbook"));
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {

		closeBrowserDriver();
	}

}
