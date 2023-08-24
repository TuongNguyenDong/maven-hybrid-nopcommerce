package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
	
	private  WebDriver driver;
	
	public UserSearchPageObject(WebDriver driver) {
		this.driver =driver;
		
	}
	
	/**
	 * Get value in SearchErrorMessage 
	 * @author Tuong Nguyen
	 * @param 
	 * @param 
	 * @return
	 */
	public String getSearchMessage()  {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_MESSAGE );
		return getElementText(driver, UserSearchPageUI.SEARCH_MESSAGE);
	}
	
	/**
	 * CLick To Search textbox 
	 * @author Tuong Nguyen
	 * @param 
	 * @param 
	 * @return
	 */
	public void inputToSearchText(String textSearch)  {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_TEXT_BY_LABLE,textSearch );
		sendkeyToElement(driver, UserSearchPageUI.SEARCH_TEXT_BY_LABLE,textSearch);
	}
	
	/**
	 * Verify Search result
	 * @author Tuong Nguyen
	 * @param  nameSearch
	 * @param 
	 * @return
	 */
	
	public Boolean isSearchResultUndisplayed(String nameSearch)  {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_RESULT_BY_NAME, nameSearch);
		return isElementUndisplayed(driver, UserSearchPageUI.SEARCH_RESULT_BY_NAME, nameSearch);
	}
	
	/**
	 * Verify Search result
	 * @author Tuong Nguyen
	 * @param  nameSearch
	 * @param 
	 * @return
	 */

	public Boolean isSearchResultAbsoluteDisplayed(String nameSearch)  {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_RESULT_ABSOLUTE_BY_NAME, nameSearch);
		return isELementDisplayed(driver, UserSearchPageUI.SEARCH_RESULT_ABSOLUTE_BY_NAME, nameSearch);
	}

}
