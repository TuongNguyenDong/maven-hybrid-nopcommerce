package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserComputersPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserDesktopsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserProductsNamePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class My_Account extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, validPassword, newPassword, emailAddress, updateEmail, updateFirstName, updateLastName;
	private String day, updateDay, month, updateMonth, year, updateYear, CountryId, cityName, address1,address2;
	private String company,posMy_Accountode,phoneNumber,faxNumber, reviewText, reviewTitle;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserComputersPageObject computersPage;
	private UserDesktopsPageObject desktopsPage;
	private UserProductsNamePageObject  productsNamePage;
	private UserMyProductReviewPageObject  myProductsReviewPage;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browerName, String environmentName) {
		driver = getBrowserDriver(browerName, environmentName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		updateFirstName = "Automation1";
		lastName = "FC";
		updateLastName = "FC1";
		validPassword = "1234556";
		newPassword = "1234567";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		updateEmail = "afc" + generateFakeNumber() + "@mail.vn";
		day = "10";
		month = "May";
		year = "1998";
		
		updateDay = "11";
		updateMonth = "March";
		updateYear = "1999";
		company = "Automation1 FC1";
		
		CountryId = "Viet Nam";
		cityName = "Ho Chi Minh";
		address1 = "123/4 Nghi Ngo";
		address2 = "123/5 Nghi Nha";
		
		posMy_Accountode = "7000000";
		phoneNumber = "0123456789";
		faxNumber = "0987654321";
		
		reviewText = "Build computer 01";
		reviewTitle ="Good for me";

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

	}

	@Test
	public void My_Account_01_Customer_info() {
		log.info("My_Account_01 - Step 01: Navigate to 'My Account' page");
		customerInforPage = homePage.openMyAccountPage(driver);

		log.info("My_Account_01 - Step 02: Verify 'Customer Infor' page is displayed ");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());

		log.info("My_Account_01 - Step 03: Click to Radio button 'Female'");
		customerInforPage.clicktoRadioButtonByLabel(driver, "Female");

		log.info("My_Account_01 - Step 04: Enter to FirstName textbox with value is '" + updateFirstName + "'");
		customerInforPage.inputToTextboxByID(driver, "FirstName", updateFirstName);

		log.info("My_Account_01 - Step 05: Enter to LastName textbox with value is '" + updateLastName + "'");
		customerInforPage.inputToTextboxByID(driver, "LastName", updateLastName);

		log.info("My_Account_01 - Step 06: Select Dropdown DateOfBirthDay with value is '" + updateDay + "'");
		customerInforPage.selectToDropdownByName(driver, "DateOfBirthDay", updateDay);

		log.info("My_Account_01 - Step 07: Select Dropdown DateOfBirthMonth with value is '" + updateMonth + "'");
		customerInforPage.selectToDropdownByName(driver, "DateOfBirthMonth", updateMonth);

		log.info("My_Account_01 - Step 08: Select Dropdown DateOfBirthYear with value is '" + updateYear + "'");
		customerInforPage.selectToDropdownByName(driver, "DateOfBirthYear", updateYear);

		log.info("My_Account_01 - Step 09: Enter to Email textbox with value is '" + updateEmail + "'");
		customerInforPage.inputToTextboxByID(driver, "Email", updateEmail);

		log.info("My_Account_01 - Step 09: Enter to Company textbox with value is '" + company + "'");
		customerInforPage.inputToTextboxByID(driver, "Company", company);

		log.info("My_Account_01 - Step 10: Click to 'Save' button ");
		customerInforPage.clickToButtonByText(driver, "Save");

		log.info("My_Account_01 - Step 11: Verify CustomerInfo success message is displayed ");
		Assert.assertEquals(customerInforPage.getCustomerInfoUpdateSuccessMessage(), "The customer info has been updated successfully.");

		log.info("My_Account_01 - Step 12: Verify Radio button 'Female' is updated ");
		Assert.assertTrue(customerInforPage.isDefaultCheckboxOrRadioButtonSelectedByLabel(driver, "Female"));

		log.info("My_Account_01 - Step 13: Verify FirstName textbox is updated with value '" + updateFirstName + "' ");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), updateFirstName);

		log.info("My_Account_01 - Step 14: Verify LastName textbox is updated with value '" + updateLastName + "' ");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), updateLastName);

		log.info("My_Account_01 - Step 15: Verify Dropdown DateOfBirthDay is updated with value  '" + updateDay + "'");
		Assert.assertEquals(customerInforPage.getdefaultDropdownValueByName(driver, "DateOfBirthDay"), updateDay);

		log.info("My_Account_01 - Step 16: Verify Dropdown DateOfBirthMonth is updated with value  '" + updateMonth + "'");
		Assert.assertEquals(customerInforPage.getdefaultDropdownValueByName(driver, "DateOfBirthMonth"), updateMonth);

		log.info("My_Account_01 - Step 17: Verify Dropdown DateOfBirthYear is updated with value  '" + updateYear + "'");
		Assert.assertEquals(customerInforPage.getdefaultDropdownValueByName(driver, "DateOfBirthYear"), updateYear);

		log.info("My_Account_01 - Step 18: Verify Email textbox is updated with value '" + updateEmail + "'");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Email"), updateEmail);

		log.info("My_Account_01 - Step 19: Verify Company textbox is updated with value '" + company + "'");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Company"), company);

	}

	@Test
	public void My_Account_02_Add_Addresses() {
		log.info("My_Account_02 - Step 01: Swith to  'Address' page");
		addressPage = (UserAddressPageObject)customerInforPage.openpageAtMyAccountByName(driver, "Addresses");
		
		log.info("My_Account_02 - Step 02: Click to 'Add new' button ");
		addressPage.clickToButtonByText(driver, "Add new");
		
		log.info("My_Account_02 - Step 03: Enter to FirstName textbox with value is '" + updateFirstName + "'");
		addressPage.inputToTextboxByID(driver, "Address_FirstName", updateFirstName);

		log.info("My_Account_02 - Step 04: Enter to LastName textbox with value is '" + updateLastName + "'");
		addressPage.inputToTextboxByID(driver, "Address_LastName", updateLastName);
		
		log.info("My_Account_02 - Step 05: Enter to Email textbox with value is '" + updateEmail + "'");
		addressPage.inputToTextboxByID(driver, "Address_Email", updateEmail);

		log.info("My_Account_02 - Step 06: Enter to Company textbox with value is '" + company + "'");
		addressPage.inputToTextboxByID(driver, "Address_Company", company);
		
		log.info("My_Account_01 - Step 07: Select Dropdown Address.CountryId with value is '" + CountryId + "'");
		customerInforPage.selectToDropdownByName(driver, "Address.CountryId", CountryId);
		
		log.info("My_Account_02 - Step 08: Enter to Address_City textbox with value is '" + cityName + "'");
		addressPage.inputToTextboxByID(driver, "Address_City", cityName);
		
		log.info("My_Account_02 - Step 09: Enter to Address_Address1 textbox with value is '" + address1 + "'");
		addressPage.inputToTextboxByID(driver, "Address_Address1", address1);
		
		log.info("My_Account_02 - Step 10: Enter to Address_Address2 textbox with value is '" + address2 + "'");
		addressPage.inputToTextboxByID(driver, "Address_Address2", address2);
		
		log.info("My_Account_02 - Step 11: Enter to Address_ZipPostalCode textbox with value is '" + posMy_Accountode + "'");
		addressPage.inputToTextboxByID(driver, "Address_ZipPostalCode", posMy_Accountode);
		
		log.info("My_Account_02 - Step 12: Enter to Address_PhoneNumber textbox with value is '" + phoneNumber + "'");
		addressPage.inputToTextboxByID(driver, "Address_PhoneNumber", phoneNumber);
		
		log.info("My_Account_02 - Step 13: Enter to Address_FaxNumber textbox with value is '" + faxNumber + "'");
		addressPage.inputToTextboxByID(driver, "Address_FaxNumber", faxNumber);
		
		log.info("My_Account_02 - Step 14: Click to 'Save' button ");
		addressPage.clickToButtonByText(driver, "Save");
		
		log.info("My_Account_02 - Step 15: Verify Address  add success message is displayed ");
		Assert.assertEquals(addressPage.getAddressAddSuccessMessage(), "The new address has been added successfully.");
		
		log.info("My_Account_02 - Step 16: Verify name is updated with value '" + updateFirstName +" "+ updateLastName + "' ");
		Assert.assertEquals(addressPage.getTextboxValueByName(driver, "name"), updateFirstName +" "+ updateLastName);
		
		log.info("My_Account_02 - Step 17: Verify Email is updated with value '" + updateEmail + "' ");
		Assert.assertTrue(addressPage.getTextboxValueByName(driver, "email").contains(updateEmail));
		
		log.info("My_Account_02 - Step 18: Verify Phone is updated with value '" + phoneNumber + "' ");
		Assert.assertTrue(addressPage.getTextboxValueByName(driver, "phone").contains(phoneNumber));
		
		log.info("My_Account_02 - Step 19: Verify Fax is updated with value '" + faxNumber + "' ");
		Assert.assertTrue(addressPage.getTextboxValueByName(driver, "fax").contains(faxNumber));
		
		log.info("My_Account_02 - Step 20: Verify company is updated with value '" + company + "' ");
		Assert.assertEquals(addressPage.getTextboxValueByName(driver, "company"), company);
		
		log.info("My_Account_02 - Step 21: Verify address1 is updated with value '" + address1 + "' ");
		Assert.assertEquals(addressPage.getTextboxValueByName(driver, "address1"), address1);
		
		log.info("My_Account_02 - Step 22: Verify address2 is updated with value '" + address2 + "' ");
		Assert.assertEquals(addressPage.getTextboxValueByName(driver, "address2"), address2);
		
		log.info("My_Account_02 - Step 23: Verify city-state-zip is updated with value '" + cityName +", "+ posMy_Accountode + "' ");
		Assert.assertEquals(addressPage.getTextboxValueByName(driver, "city-state-zip"), cityName +", "+ posMy_Accountode);
		
		log.info("My_Account_02 - Step 24: Verify country is updated with value '" + CountryId + "' ");
		Assert.assertEquals(addressPage.getTextboxValueByName(driver, "country"), CountryId);
	
	}

	@Test
	public void My_Account_03_Change_Password() {
		
		log.info("My_Account_03 - Step 01: Swith to  'Change password' page");
		changePasswordPage = (UserChangePasswordPageObject) addressPage.openpageAtMyAccountByName(driver, "Change password");
		
		log.info("My_Account_03 - Step 02: Enter to Old Password textbox with value is '" + validPassword + "'");
		changePasswordPage.inputToTextboxByID(driver, "OldPassword", validPassword);
		
		log.info("My_Account_03 - Step 03: Enter to New Password textbox with value is '" + newPassword + "'");
		changePasswordPage.inputToTextboxByID(driver, "NewPassword", newPassword);
		
		log.info("My_Account_03 - Step 04: Enter to Confirm Password textbox with value is '" + newPassword + "'");
		changePasswordPage.inputToTextboxByID(driver, "ConfirmNewPassword", newPassword);
		
		log.info("My_Account_03 - Step 05: Click to 'Change Password' button ");
		changePasswordPage.clickToButtonByText(driver, "Change password");
		
		log.info("My_Account_03 - Step 06: Verify Change Password success message is displayed ");
		Assert.assertEquals(changePasswordPage.getChangePasswordSuccessMessage(), "Password was changed");
		
		log.info("My_Account_03 - Step 07: Close 'Change Password' success message ");
		changePasswordPage.clickToCloseSuccessMessage();
		
		log.info("My_Account_03 - Step 08: Navigate to 'Home' page");
		homePage = changePasswordPage.getUserHomePage();
		
		log.info("My_Account_03 - Step 09: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("My_Account_03 - Step 10: Enter to Email textbox with value is '" + updateEmail + "'");
		loginPage.inputToTextboxByID(driver, "Email", updateEmail);

		log.info("My_Account_03 - Step 11: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("My_Account_03 - Step 12: Click to 'Log in' button");
		loginPage.clickLoginButton();
		
		log.info("My_Account_03 - Step 13:Verify Unsuccessfull message");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
		
		log.info("My_Account_03 - Step 14: Enter to Email textbox with value is '" + updateEmail + "'");
		loginPage.inputToTextboxByID(driver, "Email", updateEmail);

		log.info("My_Account_03 - Step 15: Enter to Password textbox with value is '" + newPassword + "'");
		loginPage.inputToTextboxByID(driver, "Password", newPassword);
		
		log.info("My_Account_03 - Step 16: Click to 'Log in' button");
		homePage= loginPage.clickLoginButton();
		
		log.info("My_Account_03 - Step 17: Verify 'My Account' link is displayed " );
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void My_Account_04_My_Product_Review() {
		
		log.info("My_Account_04 - Step 01: Swith to 'Computers' page");
		computersPage = (UserComputersPageObject) homePage.openpageAtHomePageByName(driver, "Computers");
		
		log.info("My_Account_04 - Step 02: Verify 'Computers' title is displayed " );
		Assert.assertTrue(computersPage.isPageTitleByText(driver, "Computers"));
		
		log.info("My_Account_04 - Step 03: Swith to 'Desktops' page");
		desktopsPage =  (UserDesktopsPageObject) computersPage.openpageAtComputersPageByName(driver, "Desktops");
		
		log.info("My_Account_04 - Step 04: Verify 'Desktops' title is displayed " );
		Assert.assertTrue(desktopsPage.isPageTitleByText(driver, "Desktops"));
		
		log.info("My_Account_04 - Step 05: Click Product name  with  title 'Build your own computer' " );
		productsNamePage = desktopsPage.clickToProductByText(driver, "Build your own computer");
		
		log.info("My_Account_04 - Step 06: Click 'Add your review'  at Desktops page " );
		productsNamePage.clickToElementProductInPageBodyByText(driver,"Add your review");
			
		log.info("My_Account_04 - Step 07: Enter to Review Title textbox  with value is '" + reviewTitle + "'" );
		productsNamePage.inputToTextboxByID(driver, "AddProductReview_Title", reviewTitle);
		
		log.info("My_Account_04 - Step 08: Enter to Review Text textbox  with value is '" + reviewText + "'" );
		productsNamePage.inputToTextareaReviewProduct(reviewText);
		
		log.info("My_Account_04 - Step 09: Click to Radio button by lable 'Good' ");
		productsNamePage.clickToRatingRadioButtonByLable("Good");
		
		log.info("My_Account_04 - Step 10: Click to 'Submit review' button ");
		productsNamePage.clickToButtonByText(driver, "Submit review");
		
		log.info("My_Account_04 - Step 11: Verify Product Review added success message is displayed ");
		Assert.assertTrue(productsNamePage.getProductReviewAddedSuccessMessage().contains("Product review is successfully added."));
		
		log.info("My_Account_04 - Step 12: Navigate to 'My Account' page");
		customerInforPage =productsNamePage.openMyAccountPage(driver);
		
		log.info("My_Account_04 - Step 13: Swith to  'My product reviews' page");
		myProductsReviewPage = (UserMyProductReviewPageObject)customerInforPage.openpageAtMyAccountByName(driver, "My product reviews");
		
		log.info("My_Account_04 - Step 14: Verify 'My account - My product reviews' title is displayed " );
		Assert.assertTrue(myProductsReviewPage.isPageTitleByText(driver, "My account - My product reviews"));
		
		log.info("My_Account_04 - Step 15: Verify 'Review product title' is displayed with product name 'Build your own computer' " );
		Assert.assertEquals(myProductsReviewPage.getReviewProductTilleByTextName("Build your own computer"), reviewTitle);
		
		log.info("My_Account_04 - Step 16: Verify 'Review product text'  is displayed with product name 'Build your own computer' " );
		Assert.assertEquals(myProductsReviewPage.getReviewProductTextByTextName("Build your own computer"), reviewText);
			
		log.info("My_Account_04 - Step 18: Verify 'Review product Rating'  is displayed with product name 'Build your own computer' " );
		Assert.assertEquals(myProductsReviewPage.getReviewProductRatingByTextName("Build your own computer"), "width: 80%;");
		
		


	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
