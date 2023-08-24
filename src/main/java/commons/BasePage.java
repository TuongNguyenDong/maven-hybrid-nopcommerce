package commons;


import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserProductsNamePageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;

public class BasePage {
	
	public static BasePage getBasePageOject() {
		return new BasePage();
		
	}
	
	public void openPageUrl(WebDriver driver, String pageurl) {

		driver.get(pageurl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();

	}

	public String getPageUrl(WebDriver driver) {

		return driver.getCurrentUrl();

	}

	public String getPageSourceCode(WebDriver driver) {

		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {

		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {

		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {

		driver.navigate().refresh();

	}

	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public void setCookies (WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}
	
		public Alert waitForAlertPresence(WebDriver driver) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());

	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {

		Set<String> allWindowsIDs = driver.getWindowHandles();
		for (String id : allWindowsIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				break;
			}
		}
		sleepInSecond(2);
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedPageTitle) {

		Set<String> allWindowsIDs = driver.getWindowHandles();
		for (String id : allWindowsIDs) {
			driver.switchTo().window(id);
			String currentPageTitle = driver.getTitle();
			if (currentPageTitle.equals(expectedPageTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {

		Set<String> allWindowsIDs = driver.getWindowHandles();
		for (String id : allWindowsIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);

	}

//	private By getByXpath(String locatorType) {
//		return By.xpath(locatorType);
//	}
	private By getByLocator(String locatorType) {
		By by = null ;
		
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=")) {
			by = By.id(locatorType.substring(3));
			
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=")) {
			by = By.className(locatorType.substring(6));

		}else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=")) {
			by = By.name(locatorType.substring(5));

		}else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=")) {
			by = By.cssSelector(locatorType.substring(4));

		}else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")|| locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));

		}else {
			throw new RuntimeException("Locator type is not supported!");
		}
		
		return by;
		
	}
	// neu truyen vao locator type la xpath = dung
	// trutyen vao locator type # xpath = sai
	
	private String getDynamicXpath(String locatorType, String... dynamicValues) {
		//System.out.println("Locator Type Before "+ locatorType );
		
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")|| locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[])dynamicValues);
		}
		
		return locatorType;
	}
	
	private WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));

	}

	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));

	}

	public void clickToELement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();

	}

	public void clickToELement(WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();

	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}
	

	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}
	
	public void clearValueInElementByPressKey(WebDriver driver, String locatorType ) {
		WebElement element = getWebElement(driver, locatorType);
		element.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	}
	
	public void clearValueInElementByPressKey(WebDriver driver, String locatorType, String... dynamicValues ) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();

	}
	
	public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();

	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}

	public String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();

	}
	
	public String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType,  String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return select.getFirstSelectedOption().getText();

	}

	public boolean isDropdownMutiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	public void selectItemInCustomDropDown(WebDriver driver, String parentLocator, String ChildLocator,
			String expectedItem) {

		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);

		List<WebElement> allDropdownItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(ChildLocator)));

		for (WebElement item : allDropdownItems) {
			String actualTextItem = item.getText();
			System.out.println("Item text" + actualTextItem);
			if (actualTextItem.equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(4);
				item.click();
				sleepInSecond(2);
				break;
			}
		}
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {

		return getWebElement(driver, locatorType).getAttribute(attributeName);

	}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName, String... dynamicValues) {

		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getAttribute(attributeName);

	}

	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {

		return getWebElement(driver, locatorType).getCssValue(propertyName);

	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();

	}

	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValues) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();

	}

	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public void overrideImplicitlyTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locatorType) {
		System.out.println("Start Time =" + new Date().toString());
		overrideImplicitlyTimeout(driver, shortTimeout);
		List<WebElement> elements =getListWebElement(driver,locatorType);
		// neu nhu minh gan bang 5 no se apply cho tat cac cac step sau do. findElement/ findElements
		overrideImplicitlyTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("End time =" + new Date().toString());
			return true;
			
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/ displayed");
			System.out.println("End time =" + new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			return false;

		}
		
		
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		System.out.println("Start Time =" + new Date().toString());
		overrideImplicitlyTimeout(driver, shortTimeout);
		List<WebElement> elements =getListWebElement(driver,getDynamicXpath(locatorType, dynamicValues));
		// neu nhu minh gan bang 5 no se apply cho tat cac cac step sau do. findElement/ findElements
		overrideImplicitlyTimeout(driver, longTimeout);
		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("End time =" + new Date().toString());
			return true;
			
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/ displayed");
			System.out.println("End time =" + new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			return false;

		}
		
		
	}

	public boolean isELementDisplayed(WebDriver driver, String locatorType) {
		try {
			// Tim thay element:
			// case 1 : displayed - tra ve true
			// case 2 : Undisplayed - tra ve false
			return getWebElement(driver, locatorType).isDisplayed();
		} catch (NoSuchElementException e) {
			// case 3 : Undisplayed - tra ve false
		return false;
		}
	}
	
	public boolean isELementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}

	public boolean isELementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	public boolean isELementSelected(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isSelected();
	}

	public boolean isELementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isELementEnabled(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isEnabled();
	}

	public void switchToFrameIFrame(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));

	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();

	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {

		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();

	}
	
	public void pressKeyElement(WebDriver driver, String locatorType, Keys key) {

		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}

	public void pressKeyElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {

		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}
	
	public void highlightElement(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}
	

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}
	
	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
		
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isImageLoaded(WebDriver driver, String locator, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, getDynamicXpath(locator, dynamicValues)));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));

	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));

	}

	public void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));

	}
	/*
	 * Wait for Element Undisplayed in DOM or not in DOM and override implicitly timeout
	 */
	public void waitForElementUndisplayed(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrideImplicitlyTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideImplicitlyTimeout(driver, longTimeout);

	}

	public void waitForElementInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));

	}

	public void waitForAllElementInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues))));

	}
	
	public void waitForAllElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));

	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);

		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues ) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);

		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	
//	public void uploadMutipleFiles(WebDriver driver, String... fileNames) {
//		//Duong dan cua thu muc upload file
//		String filePath = GlobalConstants.UPLOAD_FILE;
//		String fullFileName = "";
//		for (String file : fileNames) {
//			fullFileName = fullFileName + filePath + file + "\n";
//		}
//		fullFileName = fullFileName.trim();
//		getWebElement(driver, BasePageJQueryUI.UPLOADFILE).sendKeys(fullFileName);
//
//	}
	//toi uu o bai hoc switch page level 07
	
	public UserCustomerInforPageObject openCustomerInfoPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.CUSTOMER_INFOR_LINK);
		clickToELement(driver, BasePageNopCommerceUI.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}
	
	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.ADDRESS_LINK);
		clickToELement(driver, BasePageNopCommerceUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	
	
	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
		clickToELement(driver, BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}
	
	
	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.REWARD_POINT_LINK);
		clickToELement(driver, BasePageNopCommerceUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}
	
	public UserCustomerInforPageObject openMyAccountPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.MY_ACCOUNT_LINK);
		clickToELement(driver, BasePageNopCommerceUI.MY_ACCOUNT_LINK);
		
		return PageGeneratorManager.getUserCustomerInforPage(driver);
		
	}
	
	// toi uu o bai hoc level_09_Dynamic_page  ( Pattern Object)
	public BasePage openpageAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_PAGES_AT_ACCOUNT_AREA, pageName);
		clickToELement(driver, BasePageNopCommerceUI.DYNAMIC_PAGES_AT_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInforPage(driver);
		case "Addresses":
			return PageGeneratorManager.getUserAddressPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
		case "Reward points":
			return PageGeneratorManager.getUserRewardPointPage(driver);
		case "Change password":
			return PageGeneratorManager.getUserChangePasswordPage(driver);
		default: 
			throw new RuntimeException("Invalid page name at My Account area");
			
		}
		
	}
	
	public BasePage openpageAtHomePageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_MENU_AT_HOME_PAGE, pageName);
		clickToELement(driver, BasePageNopCommerceUI.DYNAMIC_MENU_AT_HOME_PAGE, pageName);
		switch (pageName) {
		case "Computers":
			return PageGeneratorManager.getUserComputersPage(driver);	
		case "Electronics":
			return PageGeneratorManager.getUserElectronicsPage(driver);
		default: 
			throw new RuntimeException("Invalid page name at Home Page menu");
			
		}
		
	}
	
	public BasePage openpageAtFooterByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_FOOTER_MENU_NAME, pageName);
		clickToELement(driver, BasePageNopCommerceUI.DYNAMIC_FOOTER_MENU_NAME, pageName);
		switch (pageName) {
		case "Search":
			return PageGeneratorManager.getUserSearchPage(driver);	
		default: 
			throw new RuntimeException("Invalid page name at Home Page menu");
			
		}
		
	}
	
	// Pattern Object  ( Nopcommerce)
	/**
	 * Enter to dynamic Textbox by ID
	 * @author Tuong Nguyen
	 * @param driver
	 * @param textboxID
	 * @param value
	 */
	public void inputToTextboxByID(WebDriver driver,String textboxID, String value) {
		waitForElementVisible(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
		
		
	}
	
	/**
	 * Click to dynamic Button by Text
	 * @author Tuong Nguyen
	 * @param driver
	 * @param buttonText
	 */
	public void clickToButtonByText(WebDriver driver, String buttonText) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToELement(driver, BasePageNopCommerceUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		
	}
	
	/**
	 * Select item in dropdown by name attribute
	 * @author Tuong Nguyen
	 * @param driver
	 * @param dropdownAttributeName
	 *  @param itemvalue
	 */
	public void selectToDropdownByName(WebDriver driver, String dropdownAttributeName, String itemvalue) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
		selectItemInDefaultDropdown(driver, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, itemvalue, dropdownAttributeName);
		
	
	}
	
	/**
	 * Click to dynamic radio button by label 
	 * @author Tuong Nguyen
	 * @param driver
	 * @param radioButtonLabelName
	 */
	public void clicktoRadioButtonByLabel(WebDriver driver,String radioButtonLabelName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, radioButtonLabelName);
		checkToDefaultCheckboxOrRadio(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, radioButtonLabelName);
	
	}
	
	/**
	 * CLick to dynamic checkbox by label 
	 * @author Tuong Nguyen
	 * @param driver
	 * @param checkBoxLabelName
	 */
	public void clicktoCheckboxByLabel(WebDriver driver, String checkBoxLabelName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkBoxLabelName);
		checkToDefaultCheckboxOrRadio(driver, BasePageNopCommerceUI.DYNAMIC_CHECKBOX_BY_LABEL, checkBoxLabelName);	
		
	}
	
	/**
	 * Get value in textbox by TextboxID
	 * @param driver
	 * @param textboxID
	 * @return
	 */
	public String getTextboxValueByID(WebDriver driver, String textboxID) {
		waitForElementVisible(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, BasePageNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}
	
	/**
	 * Get value in defaultDropdown by dropdownName
	 * @author Tuong Nguyen
	 * @param driver
	 * @param dropdownName
	 * @return
	 */
	public String getdefaultDropdownValueByName(WebDriver driver, String dropdownName) {
		waitForElementVisible(driver, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownName);
		return getFirstSelectedItemDefaultDropdown(driver, BasePageNopCommerceUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownName);
	}
	
	/**
	 * Get value in defaultDropdown by dropdownName
	 * @author Tuong Nguyen
	 * @param driver
	 * @param dropdownName
	 * @return
	 */
	public Boolean isDefaultCheckboxOrRadioButtonSelectedByLable(WebDriver driver, String lableValue) {
		waitForElementVisible(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, lableValue);
		return isELementSelected(driver, BasePageNopCommerceUI.DYNAMIC_RADIO_BY_LABEL, lableValue);
	}
	
	/**
	 * Get value in ErrorMessage by messageFieldID
	 * @author Tuong Nguyen
	 * @param driver
	 * @param messagefieldID
	 * @return
	 */
	public String getErrorMessageByID(WebDriver driver, String messagefieldID) {
		waitForElementVisible(driver, BasePageNopCommerceUI.DYNAMIC_ERROR_MASSAGE, messagefieldID);
		return getElementText(driver, BasePageNopCommerceUI.DYNAMIC_ERROR_MASSAGE, messagefieldID);
	}
	
	/**
	 * Get value in Title by text
	 * @author Tuong Nguyen
	 * @param driver
	 * @param pageName
	 * @return
	 */
	public Boolean isPageTitleByText(WebDriver driver, String pageName) {
		waitForElementVisible(driver, BasePageNopCommerceUI.PAGE_TIILE_BY_TEXT, pageName);
		return isELementDisplayed(driver, BasePageNopCommerceUI.PAGE_TIILE_BY_TEXT, pageName);
	}
	
	/**
	 * Click to dynamic Button by Text
	 * @author Tuong Nguyen
	 * @param driver
	 * @param buttonText
	 * @return 
	 */
	public void clickToElementProductInPageBodyByText(WebDriver driver, String nameText) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_PRODUCT_PAGE_BODY_BY_TEXT, nameText);
		clickToELement(driver, BasePageNopCommerceUI.DYNAMIC_PRODUCT_PAGE_BODY_BY_TEXT, nameText);
		
	}
	
	/**
	 * Click to dynamic Element by Text
	 * @author Tuong Nguyen
	 * @param driver
	 * @param textName
	 */
	public UserProductsNamePageObject clickToProductByText(WebDriver driver, String textName) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_PRODUCT_NAME_BY_TEXT, textName);
		clickToELement(driver, BasePageNopCommerceUI.DYNAMIC_PRODUCT_NAME_BY_TEXT, textName);	
		return PageGeneratorManager.getUserProductsNamePage(driver);
	}
	

	
    //Level_08_Swich_Role
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.LOGOUT_LINK_AT_USER);
		clickToELement(driver, BasePageNopCommerceUI.LOGOUT_LINK_AT_USER);

		return PageGeneratorManager.getUserHomePage(driver);

	}

	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageNopCommerceUI.LOGOUT_LINK_AT_ADMIN);
		clickToELement(driver, BasePageNopCommerceUI.LOGOUT_LINK_AT_ADMIN);

		return PageGeneratorManager.getAdminLoginPage(driver);

	}
	// wordpress
//	public UserHomePO openEndUserSite(WebDriver driver, String endUserUrl) {
//		openPageUrl(driver, endUserUrl);
//		return pageObjects.wordpress.PageGeneratorManager.getUserHomePage(driver);
//	}
//	
//	public AdminDashboardPO openAdminSite(WebDriver driver, String adminUrl) {
//		openPageUrl(driver, adminUrl);
//		return pageObjects.wordpress.PageGeneratorManager.getAdminDashboardPage(driver);
//	}

	
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
}
