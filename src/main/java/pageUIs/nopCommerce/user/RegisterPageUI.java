package pageUIs.nopCommerce.user;

public class RegisterPageUI {
	public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
//	public static final String LOGOUT_BUTTON = "xpath=//a[@class='ico-logout']";
	public static final String FIRSTNAME_TEXTBOX = "css=input#FirstName";
	public static final String LASTNAME_TEXTBOX = "css=input#LastName";
	public static final String EMAIL_TEXTBOX = "id=Email";
	public static final String PASSWORD_TEXTBOX = "id=Password";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "xpath=//input[@id='ConfirmPassword']";

	public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//div[@class='result']";
	public static final String EXISTING_EMAIL_ERROR_MESSAGE = "xpath=//div[contains(@class,'message-error')]//li";
	

}
