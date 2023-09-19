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
import pageObjects.nopCommerce.user.UserDesktopsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserProductsNamePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Order extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, validPassword, emailAddress;
	private String day, month, year;


	
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserComputersPageObject computersPage;
	private UserDesktopsPageObject desktopsPage;
	private UserProductsNamePageObject productsNamePage;
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
		
		log.info("Precondition - Step 21: Swith to 'Desktops' page");
		desktopsPage = (UserDesktopsPageObject) computersPage.openpageAtComputersPageByName(driver, "Desktops");
		
		log.info("Precondition - Step 22: Verify 'Desktops' title is displayed " );
		Assert.assertTrue(desktopsPage.isPageTitleByText(driver, "Desktops"));
		
		log.info("Precondition - Step 23: Click Product name  with  title 'Build your own computer' " );
		productsNamePage = desktopsPage.clickToProductByText(driver, "Build your own computer");

	}

	@Test
	public void TC_01_Add_Product_To_Cart() {
		
		log.info("TC_01 - Step 01: Select Dropdown 'Processor' with value is '2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]'");
		productsNamePage.selectToDropdownByNameAtProductNamePage( "Processor", "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		
		log.info("TC_01 - Step 02: Select Dropdown 'RAM' with value is '2 GB'");
		productsNamePage.selectToDropdownByNameAtProductNamePage( "RAM", "2 GB");
		
		log.info("TC_01 - Step 03: Click to 'HDD' Radio button with value is '400 GB [+$100.00]'");
		productsNamePage.clicktoRadioButtonByButtonNameAndValueName( "HDD","400 GB [+$100.00]");		
		
		log.info("TC_01 - Step 04: Click to 'OS' Radio button with value is 'Vista Premium [+$60.00]'");
		productsNamePage.clicktoRadioButtonByButtonNameAndValueName( "OS","Vista Premium [+$60.00]");
		
		log.info("TC_01 - Step 05: Click to 'Software' Checkbox with value is 'Acrobat Reader [+$10.00]'");
		productsNamePage.clicktoCheckboxByButtonNameAndValueName( "Software","Acrobat Reader [+$10.00]");
			
		log.info("TC_01 - Step 06: Click to 'Software' Checkbox with value is 'Total Commander [+$5.00]'");
		productsNamePage.clicktoCheckboxByButtonNameAndValueName( "Software","Total Commander [+$5.00]");
		
		log.info("TC_01 - Step 07: Click to Add To Cart button");
		productsNamePage.clickAddToCartAtOverviewClass();
		
		log.info("TC_01 - Step 08: Verify add to cart success message is displayed ");
		Assert.assertTrue(productsNamePage.getAddSuccessMessage(driver).contains("The product has been added"));
		
		log.info("TC_01 - Step 09: Click to Close add to Cart success message");
		productsNamePage.clickToCloseAtToCartSuccessMessage();
		
		log.info("TC_01 - Step 10: Verify Quantity Shopping Cart link is '1' is displayed " );
		Assert.assertEquals(productsNamePage.isShoppingCartQtyByText("Shopping cart"), "(1)");
		
		log.info("TC_01 - Step 11:Hover to Shopping Cart Link");
		productsNamePage.hoverToShoppingCartLink();
			
		log.info("TC_01 - Step 12: Verify Mini Shopping Cart count is 'There are 1 item(s) in your cart.' is displayed " );
		Assert.assertEquals(productsNamePage.isMiniShoppingCartCount(), "There are 1 item(s) in your cart.");
		
		log.info("TC_01 - Step 13: Verify Mini Shopping Cart name is 'Build your own computer' is displayed " );
		Assert.assertEquals(productsNamePage.isMiniShoppingCartName(), "Build your own computer");
		
		log.info("TC_01 - Step 14: Verify Mini Shopping Cart Price is '$1,440.00' is displayed ");
		Assert.assertEquals(productsNamePage.isMiniShoppingCartPrice(), "$1,440.00");

		log.info("TC_01 - Step 15: Verify Mini Shopping Cart Quantity is '1' is displayed ");
		Assert.assertEquals(productsNamePage.isMiniShoppingCartQuantity(), "1");
		
		log.info("TC_01 - Step 16: Verify Mini Shopping Cart Sub Total is '$1,440.00' is displayed ");
		Assert.assertEquals(productsNamePage.isMiniShoppingCartSubTotal(), "$1,440.00");
		
		log.info("TC_01 - Step 17: Verify Mini Shopping Cart Attribute is 'Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]' is displayed ");
		Assert.assertTrue(productsNamePage.isMiniShoppingCartAttribute().contains("Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]"));
		
		log.info("TC_01 - Step 18: Verify Mini Shopping Cart Attribute is 'RAM: 2 GB' is displayed ");
		Assert.assertTrue(productsNamePage.isMiniShoppingCartAttribute().contains("RAM: 2 GB"));
		
		log.info("TC_01 - Step 19: Verify Mini Shopping Cart Attribute is 'HDD: 400 GB [+$100.00]' is displayed ");
		Assert.assertTrue(productsNamePage.isMiniShoppingCartAttribute().contains("HDD: 400 GB [+$100.00]"));
		
		log.info("TC_01 - Step 20: Verify Mini Shopping Cart Attribute is 'OS: Vista Premium [+$60.00]' is displayed ");
		Assert.assertTrue(productsNamePage.isMiniShoppingCartAttribute().contains("OS: Vista Premium [+$60.00]"));
		
		log.info("TC_01 - Step 21: Verify Mini Shopping Cart Attribute is 'Software: Microsoft Office [+$50.00]' is displayed ");
		Assert.assertTrue(productsNamePage.isMiniShoppingCartAttribute().contains("Software: Microsoft Office [+$50.00]"));
		
		log.info("TC_01 - Step 22: Verify Mini Shopping Cart Attribute is 'Software: Acrobat Reader [+$10.00] is displayed ");
		Assert.assertTrue(productsNamePage.isMiniShoppingCartAttribute().contains("Software: Acrobat Reader [+$10.00]"));

		log.info("TC_01 - Step 23: Verify Mini Shopping Cart Attribute is 'Software: Total Commander [+$5.00]' is displayed ");
		Assert.assertTrue(productsNamePage.isMiniShoppingCartAttribute().contains("Software: Total Commander [+$5.00]"));

	}
	
	@Test
	public void TC_02_Edit_Product_To_Cart() {
		
		log.info("TC_02 - Step 01: Navigate to 'Shopping Cart' page");
		shoppingCartPage = productsNamePage.openShoppingCartPage();
		
	}
	
	@AfterClass
	public void afterClass() {

		//closeBrowserDriver();
	}

}
