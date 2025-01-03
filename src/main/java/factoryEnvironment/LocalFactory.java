package factoryEnvironment;

import org.openqa.selenium.WebDriver;

import factoryBrowser.BrowserList;
import factoryBrowser.BrowserNotSupportedException;
import factoryBrowser.ChromeDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import factoryBrowser.HeadlessChromeDriverManager;
import factoryBrowser.HeadlessFirefoxDriverManager;
import factoryBrowser.OperaDriverManager;
import factoryBrowser.SafariDriverManager;


public class LocalFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {

		this.browserName = browserName;
	}
	
	public WebDriver createDriverUser() {
		// run maven command line
//		 browserName = System.getProperty("browser");
//		if (driver == null) {
//
//			if (browserName == null) {
//
//				browserName = System.getenv("browser");
//				if (browserName == null) {
//
//					browserName = "edge";
//				}
//			}
//		}

		switch (browserName) {
		case "firefox":
			driver = new FirefoxDriverManager().getBrowserDriver();
			break;
		case "h-firefox":
			driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
			break;
		case "chrome":
			driver = new ChromeDriverManager().getBrowserDriver();
			break;
		case "h-chrome":
			driver = new HeadlessChromeDriverManager().getBrowserDriver();
			break;
		case "edge":
			driver = new EdgeDriverManager().getBrowserDriver();
			break;
		case "safari":
			driver = new SafariDriverManager().getBrowserDriver();
			break;
		case "opera":
			driver = new OperaDriverManager().getBrowserDriver();
			break;

		default:
			throw new BrowserNotSupportedException(browserName);

		}

		return driver;
	}
	
	
	public WebDriver createDriverAdmin() {

		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		
		switch (browserList) {
		case FIREFOX:
			driver = new FirefoxDriverManager().getBrowserDriver();
			break;
		case H_FIREFOX:
			driver = new FirefoxDriverManager().getBrowserDriver();
			break;
		case CHROME:
			driver = new ChromeDriverManager().getBrowserDriver();
			break;
		case H_CHROME:
			driver = new FirefoxDriverManager().getBrowserDriver();
			break;
		case EDGE:
			driver = new EdgeDriverManager().getBrowserDriver();
			break;
		case SAFARI:
			driver = new SafariDriverManager().getBrowserDriver();
			break;

		default:
			throw new BrowserNotSupportedException(browserName);

		}
		
		

//		if (browserList == BrowserList.FIREFOX) {
//
//			// System.setProperty("webdriver.gecko.driver", projectPath +
//			// "\\browserDrivers\\geckodriver.exe");
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//
//		} else if (browserList == BrowserList.H_FIREFOX) {
//
//			// System.setProperty("webdriver.gecko.driver", projectPath +
//			// "\\browserDrivers\\geckodriver.exe");
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions options = new FirefoxOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1366x768");
//			driver = new FirefoxDriver(options);
//
//		} else if (browserList == BrowserList.CHROME) {
//
//			// System.setProperty("webdriver.chrome.driver", projectPath +
//			// "\\browserDrivers\\chromedriver.exe");
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//
//		} else if (browserList == BrowserList.H_CHROME) {
//
//			// System.setProperty("webdriver.chrome.driver", projectPath +
//			// "\\browserDrivers\\chromedriver.exe");
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
////		options.setHeadless(true);
//			options.addArguments("--headless");
////		options.addArguments("--headless=new");
//			options.addArguments("window-size=1366x768");
//			driver = new ChromeDriver(options);
//
//		} else if (browserList == BrowserList.EDGE) {
//
//			// System.setProperty("webdriver.edge.driver", projectPath +
//			// "\\browserDrivers\\msedgedriver.exe");
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//
//		} else if (browserList == BrowserList.OPERA) {
//
//			// System.setProperty("webdriver.opera.driver", projectPath +
//			// "\\browserDrivers\\operadriver.exe");
//			WebDriverManager.operadriver().setup();
//			driver = new OperaDriver();
//			// COCcoc driver giam di 6 version driver
//		} else if (browserList == BrowserList.IE) {
//			WebDriverManager.iedriver().arch32().setup();
//			driver = new InternetExplorerDriver();
//
//		} else if (browserList == BrowserList.COCCOC) {
//			// System.setProperty("webdriver.chrome.driver", projectPath +
//			// "\\browserDrivers\\chromedriver_93.exe");
//			WebDriverManager.chromedriver().driverVersion("").setup();
//			ChromeOptions options = new ChromeOptions();
//			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
//				options.setBinary("C:\\Users\\nguyen\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
//			} else {
//				options.setBinary("");
//			}
//			driver = new ChromeDriver(options);
//			// brave version nao thi tai chromeDriver version do
//
//		} else if (browserList == BrowserList.BRAVE) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\operadriver.exe");
//			ChromeOptions options = new ChromeOptions();
//			options.setBinary("");
//			driver = new ChromeDriver(options);
//
//		} else {
//			throw new RuntimeException("Please input with correct browser name");
//		}
		return driver;
	}


}
