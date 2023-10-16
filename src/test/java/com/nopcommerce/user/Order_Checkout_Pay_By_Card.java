package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.CheckoutPageObject;
import pageObjects.nopCommerce.user.OrderPageObject;
import pageObjects.nopCommerce.user.ShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserComputersPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserDesktopsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserProductsNamePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Order_Checkout_Pay_By_Card extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, validPassword, emailAddress;
	private String day, month, year;
	private String productName1;

	private String billingNewAddressCity, billingNewAddress1, billingZipPostalCode, billingPhoneNumber, billingCountryId, billingStateId;
	private String shippingNewAddressCity, shippingNewAddress1, shippingZipPostalCode, shippingPhoneNumber, shippingCountryId, shippingStateId;
	private String billingAddress, orderNumber;
	private String creditCardType, cardHolderName, cardNumber, expirationDate_Month, expirationDate_Year, cardCode;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserComputersPageObject computersPage;
	private UserDesktopsPageObject desktopsPage;
	private UserProductsNamePageObject productsNamePage;
	private ShoppingCartPageObject shoppingCartPage;
	private CheckoutPageObject checkoutPage;
	private UserCustomerInforPageObject customerInforPage;
	private OrderPageObject orderPage;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browerName, String environmentName) {

		driver = getBrowserDriver(browerName, environmentName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		validPassword = "1234556";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		day = "10";
		month = "May";
		year = "1998";
		productName1 = "Lenovo IdeaCentre 600 All-in-One PC";

		billingNewAddressCity = "Dallas";
		billingNewAddress1 = "08 Logan Way";
		billingZipPostalCode = "75221";
		billingPhoneNumber = "+1 (972) 417-4199";
		billingCountryId = "United States";
		billingStateId = "Texas";

		shippingNewAddressCity = "Dallas";
		shippingNewAddress1 = "08 Long Line";
		shippingZipPostalCode = "75221";
		shippingPhoneNumber = "+1 (972) 417-4188";
		shippingCountryId = "United States";
		shippingStateId = "Texas";

		billingAddress = firstName + " " + lastName + ", " + billingNewAddress1 + ", " + billingNewAddressCity + ", " + billingStateId + " " + billingZipPostalCode + ", " + billingCountryId;
		
		creditCardType = "Visa";
		cardHolderName  = "Guest Ward";
		cardNumber  = "4633513588256742";
		expirationDate_Month  = "04";
		expirationDate_Year  = "2026";
		cardCode  = "362";

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

		log.info("Precondition - Step 20: Verify 'Computers' title is displayed ");
		Assert.assertTrue(computersPage.isPageTitleByText(driver, "Computers"));

		log.info("Precondition - Step 21: Swith to 'Desktops' page");
		desktopsPage = (UserDesktopsPageObject) computersPage.openpageAtComputersPageByName( "Desktops");

		log.info("Precondition - Step 22: Verify 'Desktops' title is displayed ");
		Assert.assertTrue(desktopsPage.isPageTitleByText(driver, "Desktops"));

		log.info("Precondition - Step 23: Click Product name  with  title " + productName1);
		productsNamePage = desktopsPage.clickToProductByText(driver, productName1);

		log.info("Precondition - Step 24: Click to Add To Cart button");
		productsNamePage.clickAddToCartAtOverviewClass();

		log.info("Precondition - Step 25: Verify add to cart success message is displayed ");
		Assert.assertTrue(productsNamePage.getAddSuccessMessage(driver).contains("The product has been added"));

		log.info("Precondition - Step 26: Click to Close add to Cart success message");
		productsNamePage.clickToCloseAtToCartSuccessMessage();

		log.info("Precondition - Step 27: Navigate to 'Shopping Cart' page");
		shoppingCartPage = productsNamePage.openShoppingCartPage();

		log.info("Precondition - Step 28: Enter to 'Qty' product is '5' is displayed ");
		shoppingCartPage.inputToQtyByColumnAtRowNumberatShoppingCart("Qty.", "1", "5");

		log.info("Precondition - Step 29: Click to 'Update  Shopping Cart' button");
		shoppingCartPage.clicktoShoppingCartButtonByTextName("Update shopping cart");

		log.info("Precondition - Step 30: Verify 'Qty' product is '5' is displayed ");
		Assert.assertEquals(shoppingCartPage.getValueTextBoxProductByColumnAtRowNumberatShoppingCart("Qty.", "1"), "5");

		log.info("Precondition - Step 31: Verify 'Total' product is '$2,500.00' is displayed ");
		Assert.assertEquals(shoppingCartPage.getTextProductByColumnAtRowNumberatShoppingCart("Total", "1"), "$2,500.00");

	}

	@Test
	public void Order_Pay_Card_01_Checkout_Shopping_Cart_Pay_By_VISA_Card() {

		log.info("Order_Pay_Card_01 - Step 01: Click to 'Terms Of Service' checkbox");
		shoppingCartPage.ClickToTermsOfService();

		log.info("Order_Pay_Card_01 - Step 02: Click to Checkout button");
		checkoutPage = shoppingCartPage.ClickToCheckoutButton();

		log.info("Order_Pay_Card_01 - Step 03: Click to Checkbox 'Ship to the same address' ");
		checkoutPage.unClickToCheckboxByLabelAtCheckoutPage("Ship to the same address");

		log.info("Order_Pay_Card_01 - Step 04: Select Dropdown 'Country' with value is '" + billingCountryId + "'");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.CountryId", billingCountryId);

		log.info("Order_Pay_Card_01 - Step 05: Select Dropdown 'State Province' with value is '" + billingStateId + "'");
		checkoutPage.selectToDropdownByName(driver, "BillingNewAddress.StateProvinceId", billingStateId);

		log.info("Order_Pay_Card_01 - Step 06: Enter to City textbox with value is '" + billingNewAddressCity + "'");
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_City", billingNewAddressCity);

		log.info("Order_Pay_Card_01 - Step 07: Enter to Address1 textbox with value is '" + billingNewAddress1 + "'");
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_Address1", billingNewAddress1);

		log.info("Order_Pay_Card_01 - Step 08: Enter to ZipPostalCode textbox with value is '" + billingZipPostalCode + "'");
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_ZipPostalCode", billingZipPostalCode);

		log.info("Order_Pay_Card_01 - Step 09: Enter to PhoneNumber textbox with value is '" + billingPhoneNumber + "'");
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_PhoneNumber", billingPhoneNumber);

		log.info("Order_Pay_Card_01 - Step 10: Click to 'Continue' button at Billing step");
		checkoutPage.clickToButtonByIDAtCheckoutPage("checkout-step-billing", "Continue");

		log.info("Order_Pay_Card_01 - Step 11: Verify 'shipping Address'  is displayed ");
		Assert.assertEquals(checkoutPage.getdefaultDropdownValueByName(driver, "shipping_address_id"), billingAddress);

		log.info("Order_Pay_Card_01 - Step 12: Select Dropdown 'Select a shipping address from your address book or enter a new address.' with value is 'New Address'");
		checkoutPage.selectToDropdownByName(driver, "shipping_address_id", "New Address");

		log.info("Order_Pay_Card_01 - Step 13: Select Dropdown 'Country' with value is '" + shippingCountryId + "'");
		checkoutPage.selectToDropdownByName(driver, "ShippingNewAddress.CountryId", shippingCountryId);

		log.info("Order_Pay_Card_01 - Step 14: Select Dropdown 'State Province' with value is '" + shippingStateId + "'");
		checkoutPage.selectToDropdownByName(driver, "ShippingNewAddress.StateProvinceId", shippingStateId);

		log.info("Order_Pay_Card_01 - Step 15: Enter to City textbox with value is '" + shippingNewAddressCity + "'");
		checkoutPage.inputToTextboxByID(driver, "ShippingNewAddress_City", shippingNewAddressCity);

		log.info("Order_Pay_Card_01 - Step 16: Enter to Address1 textbox with value is '" + shippingNewAddress1 + "'");
		checkoutPage.inputToTextboxByID(driver, "ShippingNewAddress_Address1", shippingNewAddress1);

		log.info("Order_Pay_Card_01 - Step 17: Enter to ZipPostalCode textbox with value is '" + shippingZipPostalCode + "'");
		checkoutPage.inputToTextboxByID(driver, "ShippingNewAddress_ZipPostalCode", shippingZipPostalCode);

		log.info("Order_Pay_Card_01 - Step 18: Enter to PhoneNumber textbox with value is '" + shippingPhoneNumber + "'");
		checkoutPage.inputToTextboxByID(driver, "ShippingNewAddress_PhoneNumber", shippingPhoneNumber);

		log.info("Order_Pay_Card_01 - Step 19: Click to 'Continue' button at Shipping step");
		checkoutPage.clickToButtonByIDAtCheckoutPage("checkout-step-shipping", "Continue");

		log.info("Order_Pay_Card_01 - Step 20: Click to Radio button 'Ground ($0.00)' shipping method name");
		registerPage.clicktoRadioButtonByLabel(driver, "Ground ($0.00)");

		log.info("Order_Pay_Card_01 - Step 21: Click to 'Continue' button at Shipping method");
		checkoutPage.clickToButtonByIDAtCheckoutPage("checkout-step-shipping-method", "Continue");

		log.info("Order_Pay_Card_01 - Step 22: Click to Radio button 'Credit Card' payment method name");
		registerPage.clicktoRadioButtonByLabel(driver, "Credit Card");
			
		log.info("Order_Pay_Card_01 - Step 23: Click to 'Continue' button at Payment method");
		checkoutPage.clickToButtonByIDAtCheckoutPage("checkout-step-payment-method", "Continue");
		
		log.info("Order_Pay_Card_01 - Step 24: Select Dropdown CreditCardType with value is '" + creditCardType + "'");
		checkoutPage.selectToDropdownByName(driver, "CreditCardType", creditCardType);
		
		log.info("Order_Pay_Card_01 - Step 25: Enter to Cardholder Name textbox with value is '" + cardHolderName + "'");
		checkoutPage.inputToTextboxByID(driver, "CardholderName", cardHolderName);
		
		log.info("Order_Pay_Card_01 - Step 26: Enter to Card Number textbox with value is '" + cardNumber + "'");
		checkoutPage.inputToTextboxByID(driver, "CardNumber", cardNumber);
		
		log.info("Order_Pay_Card_01 - Step 27: Select Dropdown Expiration Date with value is '" + expirationDate_Month + "'");
		checkoutPage.selectToDropdownByName(driver, "ExpireMonth", expirationDate_Month);
		
		log.info("Order_Pay_Card_01 - Step 28: Select Dropdown Expiration Date with value is '" + expirationDate_Year + "'");
		checkoutPage.selectToDropdownByName(driver, "ExpireYear", expirationDate_Year);	

		log.info("Order_Pay_Card_01 - Step 29: Enter to Card code textbox with value is '" + cardCode + "'");
		checkoutPage.inputToTextboxByID(driver, "CardCode", cardCode);
	
		log.info("Order_Pay_Card_01 - Step 30: Click to 'Continue' button at Payment info");
		checkoutPage.clickToButtonByIDAtCheckoutPage("checkout-step-payment-info", "Continue");

		log.info("Order_Pay_Card_01 - Step 25: Verify 'Payment' title is displayed ");
		Assert.assertTrue(checkoutPage.isTitleByClassNameAtComfirmOrder("payment-method-info"));

		log.info("Order_Pay_Card_01 - Step 26: Verify payment-method is 'Check / Money Order' is displayed ");
		Assert.assertTrue(checkoutPage.getOrderReviewDataByNameAtComfirmOrder("payment-method").contains("Credit Card"));

		log.info("Order_Pay_Card_01 - Step 27: Verify 'Shipping' title is displayed ");
		Assert.assertTrue(checkoutPage.isTitleByClassNameAtComfirmOrder("shipping-method-info"));

		log.info("Order_Pay_Card_01 - Step 28: Verify Shipping method is 'Ground' is displayed ");
		Assert.assertTrue(checkoutPage.getOrderReviewDataByNameAtComfirmOrder("shipping-method").contains("Ground"));

		log.info("Order_Pay_Card_01 - Step 29: Verify 'Billing Address' title is displayed ");
		Assert.assertTrue(checkoutPage.isTitleByClassNameAtComfirmOrder("billing-info"));

		log.info("Order_Pay_Card_01 - Step 30: Verify 'Name of Billing Address' is displayed with value " + firstName + " " + lastName);
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "name").contains(firstName + " " + lastName));

		log.info("Order_Pay_Card_01 - Step 31: Verify 'Email of Billing Address' is displayed with value Email: " + emailAddress);
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "email").contains("Email: " + emailAddress));

		log.info("Order_Pay_Card_01 - Step 32: Verify 'Phone of Billing Address' is displayed with value Phone: " + billingPhoneNumber);
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "phone").contains("Phone: " + billingPhoneNumber));

		log.info("Order_Pay_Card_01 - Step 33: Verify 'Fax of Billing Address' is displayed with value 'Fax:'");
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "fax").contains("Fax:"));

		log.info("Order_Pay_Card_01 - Step 34: Verify 'Address1 of Billing Address' is displayed with value " + billingNewAddress1);
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "address1").contains(billingNewAddress1));

		log.info("Order_Pay_Card_01 - Step 35: Verify 'City_State_Zip of Billing Address' is displayed with value " + billingNewAddressCity + ", " + billingStateId + ", " + billingZipPostalCode);
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "city-state-zip").contains(billingNewAddressCity + "," + billingStateId + "," + billingZipPostalCode));

		log.info("Order_Pay_Card_01 - Step 36: Verify 'Country of Billing Address' is displayed with value " + billingCountryId);
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "country").contains(billingCountryId));

		log.info("Order_Pay_Card_01 - Step 37: Verify 'Shipping Address' title is displayed ");
		Assert.assertTrue(checkoutPage.isTitleByClassNameAtComfirmOrder("shipping-info"));

		log.info("Order_Pay_Card_01 - Step 38: Verify 'Name of Shipping Address' is displayed with value " + firstName + " " + lastName);
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "name").contains(firstName + " " + lastName));

		log.info("Order_Pay_Card_01 - Step 39: Verify 'Email of Shipping Address' is displayed with value Email: " + emailAddress);
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "email").contains("Email: " + emailAddress));

		log.info("Order_Pay_Card_01 - Step 40: Verify 'Phone of Shipping Address' is displayed with value Phone: " + shippingPhoneNumber);
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "phone").contains("Phone: " + shippingPhoneNumber));

		log.info("Order_Pay_Card_01 - Step 41: Verify 'Fax of Shipping Address' is displayed with value 'Fax:'");
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "fax").contains("Fax:"));

		log.info("Order_Pay_Card_01 - Step 42: Verify 'Address1 of Shipping Address' is displayed with value " + shippingNewAddress1);
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "address1").contains(shippingNewAddress1));

		log.info("Order_Pay_Card_01 - Step 43: Verify 'City_State_Zip of Shipping Address' is displayed with value " + shippingNewAddressCity + ", " + shippingStateId + ", " + shippingZipPostalCode);
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "city-state-zip").contains(shippingNewAddressCity + "," + shippingStateId + "," + shippingZipPostalCode));

		log.info("Order_Pay_Card_01 - Step 44: Verify 'Country of Shipping Address' is displayed with value " + shippingCountryId);
		Assert.assertTrue(checkoutPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "country").contains(shippingCountryId));

		log.info("Order_Pay_Card_01 - Step 45: Verify 'LE_IC_600' SKU  is displayed ");
		Assert.assertEquals(checkoutPage.getTextProductByColumnAtRowNumberAtCheckOutPage("SKU", "1"), "LE_IC_600");

		log.info("Order_Pay_Card_01 - Step 46: Verify " + productName1 + " title product is displayed ");
		Assert.assertEquals(checkoutPage.getTextLinkNameProductByColumnAtRowNumberAtCheckOutPage("Product(s)", "1"), productName1);

		log.info("Order_Pay_Card_01 - Step 47: Verify '$500.00' Price is displayed ");
		Assert.assertEquals(checkoutPage.getTextProductByColumnAtRowNumberAtCheckOutPage("Price", "1"), "$500.00");

		log.info("Order_Pay_Card_01 - Step 48: Verify '5' Qty is displayed ");
		Assert.assertEquals(checkoutPage.getTextProductByColumnAtRowNumberAtCheckOutPage("Qty.", "1"), "5");

		log.info("Order_Pay_Card_01 - Step 49: Verify '$2,500.00' Total is displayed ");
		Assert.assertEquals(checkoutPage.getTextProductByColumnAtRowNumberAtCheckOutPage("Total", "1"), "$2,500.00");

		log.info("Order_Pay_Card_01 - Step 50: Verify 'Gift wrapping' with value is displayed with value 'No'");
		Assert.assertTrue(checkoutPage.getSelectedCartOptionAtComfirmOrder().contains("Gift wrapping: No"));

		log.info("Order_Pay_Card_01 - Step 51: Verify 'Cart Total' Price At Table Cart Total is '$2500.00' displayed ");
		Assert.assertEquals(checkoutPage.getCartTotalInfoByLableAtComfirmOrder("Sub-Total:"), "$2,500.00");

		log.info("Order_Pay_Card_01 - Step 52: Verify 'Shipping Cost' Price At Table Cart Total is '$0.00' displayed ");
		Assert.assertEquals(checkoutPage.getCartTotalInfoByLableAtComfirmOrder("Shipping:"), "$0.00");

		log.info("Order_Pay_Card_01 - Step 53: Verify 'Tax' Price At Table Cart Total is '$0.00' displayed ");
		Assert.assertEquals(checkoutPage.getCartTotalInfoByLableAtComfirmOrder("Tax:"), "$0.00");

		log.info("Order_Pay_Card_01 - Step 54: Verify 'Order Total' Price At Table Cart Total is '$2500.00' displayed ");
		Assert.assertEquals(checkoutPage.getCartTotalInfoByLableAtComfirmOrder("Total:"), "$2,500.00");

		log.info("Order_Pay_Card_01 - Step 55: Verify 'Earn reward points' At Table Cart Total is '250 points' displayed ");
		Assert.assertEquals(checkoutPage.getCartTotalInfoByLableAtComfirmOrder("You will earn:"), "250 points");

		log.info("Order_Pay_Card_01 - Step 56: Click to 'Confirm' button at Confirm order");
		checkoutPage.clickToButtonByIDAtCheckoutPage("checkout-step-confirm-order", "Confirm");

		log.info("Order_Pay_Card_01 - Step 57: Verify 'Thank you' title is displayed ");
		Assert.assertTrue(checkoutPage.isPageTitleByText(driver, "Thank you"));

		log.info("Order_Pay_Card_01 - Step 58: Verify 'title' is displayed with value 'Your order has been successfully processed!'");
		Assert.assertTrue(checkoutPage.isTextByClassAtCheckoutPage("title"));

		log.info("Order_Pay_Card_01 - Step 59: Verify 'order number' is displayed ");
		Assert.assertTrue(checkoutPage.isTextByClassAtCheckoutPage("order-number"));

		log.info("Order_Pay_Card_01 - Step 60: Get  'order number' ");
		orderNumber = checkoutPage.getTextByClassAtCheckoutPage("order-number");

		log.info("Order_Pay_Card_01 - Step 61: Navigate to 'Home' page ");
		homePage = checkoutPage.clickToContinueButtonAtOrderCompletedPage();

		log.info("Order_Pay_Card_01 - Step 62: Navigate to 'My Account' page ");
		customerInforPage = homePage.openMyAccountPage(driver);

		log.info("Order_Pay_Card_01 - Step 63: Navigate to 'Orders' page ");
		orderPage = (OrderPageObject) customerInforPage.openpageAtMyAccountByName(driver, "Orders");

		log.info("Order_Pay_Card_01 - Step 64: Verify 'Orders' title is displayed ");
		Assert.assertTrue(orderPage.isPageTitleByText(driver, "My account - Orders"));

		log.info("Order_Pay_Card_01 - Step 65: Verify 'Orders name' title is displayed with value " + orderNumber);
		Assert.assertEquals(orderPage.getOrderNumberNameAtOrderPage(), orderNumber);

		log.info("Order_Pay_Card_01 - Step 66: Click to 'Details' button ");
		orderPage.clickToButtonByText(driver, "Details");

		log.info("Order_Pay_Card_01 - Step 66: Verify 'Orders Number' at Order Overview is displayed with value " + orderNumber);
		Assert.assertEquals(orderPage.getOrderNumberNameInOrderOverViewAtOrderPage(), orderNumber);

//		log.info("Order_Pay_Card_01 - Step 67: Verify 'order-date' in OrderCOntent Area at Order Page is displayed with value Tuesday, September 26, 2023");
//		Assert.assertTrue(orderPage.getOrderContentInOrderOverviewAtOrderPage("order-date").contains("Tuesday, September 26, 2023"));

		log.info("Order_Pay_Card_01 - Step 68: Verify 'order-status' in OrderCOntent Area at Order Page is displayed with value Pending");
		Assert.assertTrue(orderPage.getOrderContentInOrderOverviewAtOrderPage("order-status").contains("Pending"));

		log.info("Order_Pay_Card_01 - Step 69: Verify 'order-total' in OrderCOntent Area at Order Page is displayed with value $2,500.00");
		Assert.assertTrue(orderPage.getOrderContentInOrderOverviewAtOrderPage("order-total").contains("$2,500.00"));

		log.info("Order_Pay_Card_01 - Step 70: Verify 'Payment' title is displayed ");
		Assert.assertTrue(orderPage.isTitleByClassNameAtOrderPage("payment-method-info"));

		log.info("Order_Pay_Card_01 - Step 71: Verify payment-method is 'Check / Money Order' is displayed ");
		Assert.assertTrue(orderPage.getOrderReviewDataByNameAtOrderPage("payment-method").contains("Credit Card"));

		log.info("Order_Pay_Card_01 - Step 72: Verify payment-method status is 'Pending' is displayed ");
		Assert.assertTrue(orderPage.getOrderReviewDataByNameAtOrderPage("payment-method-status").contains("Pending"));

		log.info("Order_Pay_Card_01 - Step 73: Verify 'Shipping' title is displayed ");
		Assert.assertTrue(orderPage.isTitleByClassNameAtOrderPage("shipping-method-info"));

		log.info("Order_Pay_Card_01 - Step 74: Verify Shipping method is 'Ground' is displayed ");
		Assert.assertTrue(orderPage.getOrderReviewDataByNameAtOrderPage("shipping-method").contains("Ground"));

		log.info("Order_Pay_Card_01 - Step 75: Verify Shipping status is 'Not yet shipped' is displayed ");
		Assert.assertTrue(orderPage.getOrderReviewDataByNameAtOrderPage("shipping-status").contains("Not yet shipped"));

		log.info("Order_Pay_Card_01 - Step 76: Verify 'Billing Address' title is displayed ");
		Assert.assertTrue(orderPage.isTitleByClassNameAtOrderPage("billing-info"));

		log.info("Order_Pay_Card_01 - Step 77: Verify 'Name of Billing Address' is displayed with value " + firstName + " " + lastName);
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "name").contains(firstName + " " + lastName));

		log.info("Order_Pay_Card_01 - Step 78: Verify 'Email of Billing Address' is displayed with value Email: " + emailAddress);
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "email").contains("Email: " + emailAddress));

		log.info("Order_Pay_Card_01 - Step 79: Verify 'Phone of Billing Address' is displayed with value Phone: " + billingPhoneNumber);
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "phone").contains("Phone: " + billingPhoneNumber));

		log.info("Order_Pay_Card_01 - Step 80: Verify 'Fax of Billing Address' is displayed with value 'Fax:'");
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "fax").contains("Fax:"));

		log.info("Order_Pay_Card_01 - Step 81: Verify 'Address1 of Billing Address' is displayed with value " + billingNewAddress1);
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "address1").contains(billingNewAddress1));

		log.info("Order_Pay_Card_01 - Step 82: Verify 'City_State_Zip of Billing Address' is displayed with value " + billingNewAddressCity + ", " + billingStateId + ", " + billingZipPostalCode);
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "city-state-zip").contains(billingNewAddressCity + "," + billingStateId + "," + billingZipPostalCode));

		log.info("Order_Pay_Card_01 - Step 83: Verify 'Country of Billing Address' is displayed with value " + billingCountryId);
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Billing Address", "country").contains(billingCountryId));

		log.info("Order_Pay_Card_01 - Step 84: Verify 'Shipping Address' title is displayed ");
		Assert.assertTrue(orderPage.isTitleByClassNameAtOrderPage("shipping-info"));

		log.info("Order_Pay_Card_01 - Step 85: Verify 'Name of Shipping Address' is displayed with value " + firstName + " " + lastName);
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "name").contains(firstName + " " + lastName));

		log.info("Order_Pay_Card_01 - Step 86: Verify 'Email of Shipping Address' is displayed with value Email: " + emailAddress);
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "email").contains("Email: " + emailAddress));

		log.info("Order_Pay_Card_01 - Step 87: Verify 'Phone of Shipping Address' is displayed with value Phone: " + shippingPhoneNumber);
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "phone").contains("Phone: " + shippingPhoneNumber));

		log.info("Order_Pay_Card_01 - Step 88: Verify 'Fax of Shipping Address' is displayed with value 'Fax:'");
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "fax").contains("Fax:"));

		log.info("Order_Pay_Card_01 - Step 89: Verify 'Address1 of Shipping Address' is displayed with value " + shippingNewAddress1);
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "address1").contains(shippingNewAddress1));

		log.info("Order_Pay_Card_01 - Step 90: Verify 'City_State_Zip of Shipping Address' is displayed with value " + shippingNewAddressCity + ", " + shippingStateId + ", " + shippingZipPostalCode);
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "city-state-zip").contains(shippingNewAddressCity + "," + shippingStateId + "," + shippingZipPostalCode));

		log.info("Order_Pay_Card_01 - Step 91: Verify 'Country of Shipping Address' is displayed with value " + shippingCountryId);
		Assert.assertTrue(orderPage.getTextboxValueByTitleNameAndNameClass("Shipping Address", "country").contains(shippingCountryId));

		log.info("Order_Pay_Card_01 - Step 92: Verify 'LE_IC_600' SKU  is displayed ");
		Assert.assertEquals(orderPage.getTextProductByColumnAtRowNumberAtOrderPage("SKU", "1"), "LE_IC_600");

		log.info("Order_Pay_Card_01 - Step 93: Verify " + productName1 + " title product is displayed ");
		Assert.assertEquals(orderPage.getTextLinkNameProductByColumnAtRowNumberAtOrderPage("Name", "1"), productName1);

		log.info("Order_Pay_Card_01 - Step 94: Verify '$500.00' Price is displayed ");
		Assert.assertEquals(orderPage.getTextProductByColumnAtRowNumberAtOrderPage("Price", "1"), "$500.00");

		log.info("Order_Pay_Card_01 - Step 94: Verify '5' Quantity is displayed ");
		Assert.assertEquals(orderPage.getTextProductByColumnAtRowNumberAtOrderPage("Quantity", "1"), "5");

		log.info("Order_Pay_Card_01 - Step 96: Verify '$2,500.00' Total is displayed ");
		Assert.assertEquals(orderPage.getTextProductByColumnAtRowNumberAtOrderPage("Total", "1"), "$2,500.00");

		log.info("Order_Pay_Card_01 - Step 97: Verify 'Gift wrapping' with value is displayed with value 'No'");
		Assert.assertTrue(orderPage.getSelectedCartOptionAtOrderPage().contains("Gift wrapping: No"));

		log.info("Order_Pay_Card_01 - Step 98: Verify 'Cart Total' Price At Table Cart Total is '$2500.00' displayed ");
		Assert.assertEquals(orderPage.getCartTotalInfoByLableAtOrderPage("Sub-Total:"), "$2,500.00");

		log.info("Order_Pay_Card_01 - Step 99: Verify 'Shipping Cost' Price At Table Cart Total is '$0.00' displayed ");
		Assert.assertEquals(orderPage.getCartTotalInfoByLableAtOrderPage("Shipping:"), "$0.00");

		log.info("Order_Pay_Card_01 - Step 100: Verify 'Tax' Price At Table Cart Total is '$0.00' displayed ");
		Assert.assertEquals(orderPage.getCartTotalInfoByLableAtOrderPage("Tax:"), "$0.00");

		log.info("Order_Pay_Card_01 - Step 101: Verify 'Order Total' Price At Table Cart Total is '$2,500.00' displayed ");
		Assert.assertEquals(orderPage.getCartTotalInfoByLableAtOrderPage("Order Total:"), "$2,500.00");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {

		 closeBrowserDriver();
	}

}
