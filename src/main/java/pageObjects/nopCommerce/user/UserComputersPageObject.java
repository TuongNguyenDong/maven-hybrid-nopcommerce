package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.UserComputersPageUI;

public class UserComputersPageObject extends BasePage {

	private WebDriver driver;

	public UserComputersPageObject(WebDriver driver) {
		this.driver = driver;

	}


	public BasePage openpageAtComputersPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserComputersPageUI.LISTBOX_LINK_AT_COMPUTERS_PAGE, pageName);
		clickToELement(driver, UserComputersPageUI.LISTBOX_LINK_AT_COMPUTERS_PAGE, pageName);
		switch (pageName) {
		case "Desktops":
			return PageGeneratorManager.getUserDesktopsPage(driver);
		case "Notebooks":
			return PageGeneratorManager.getUserNotebooksPage(driver);
		
		default:
			throw new RuntimeException("Invalid page name at Home Page menu");

		}

	}
}
