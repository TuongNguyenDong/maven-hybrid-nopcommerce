package commons;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import factoryEnvironment.DockerGridFactory;
import factoryEnvironment.EnvironmentList;
import factoryEnvironment.GridFactory;
import factoryEnvironment.LocalFactory;

public class BaseTest {
private static ThreadLocal<WebDriver> driver =  new  ThreadLocal<WebDriver>();
//	private WebDriver driver;
//	protected final Log log;
	protected final Logger log;

	protected BaseTest() {
//		log = LogFactory.getLog(getClass());
		log = LogManager.getLogger(getClass());
	}

//	private String projectPath = System.getProperty("user.dir");

//	protected WebDriver getBrowserDriver(String browserName) {
//
//		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
//
//		if (browserList == BrowserList.FIREFOX) {
//
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//
//		} else if (browserList == BrowserList.H_FIREFOX) {
//
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions options = new FirefoxOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1366x768");
//			driver = new FirefoxDriver(options);
//
//		} else if (browserList == BrowserList.CHROME) {
//
//			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.args", "--disable-logging");
//			System.setProperty("webdriver.chrome.silentOutput", "True");
//			ChromeOptions options = new ChromeOptions();
//			Map<String, Object> prefs = new HashMap<String, Object>();
//			prefs.put("credentials_enable_service", false);
//			prefs.put("profile.password_manager_enabled", false);
//			prefs.put("autofill.profile_enabled", false);
//			prefs.put("autofill.credit_card_enabled", false);
//			options.setExperimentalOption("prefs", prefs);
//			options.setAcceptInsecureCerts(true);
//			driver = new ChromeDriver(options);
//		} else if (browserList == BrowserList.H_CHROME) {
//
//			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.args", "--disable-logging");
//			System.setProperty("webdriver.chrome.silentOutput", "True");
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1366x768");
//			driver = new ChromeDriver(options);
//
//		} else if (browserList == BrowserList.EDGE) {
//
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//
//		} else if (browserList == BrowserList.OPERA) {
//
//			WebDriverManager.operadriver().setup();
//			driver = new OperaDriver();
//
//		} else if (browserList == BrowserList.IE) {
//			WebDriverManager.iedriver().arch32().setup();
//			driver = new InternetExplorerDriver();
//
//		} else if (browserList == BrowserList.COCCOC) {
//
//			WebDriverManager.chromedriver().driverVersion("").setup();
//			ChromeOptions options = new ChromeOptions();
//			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
//				options.setBinary("C:\\Users\\nguyen\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
//			} else {
//				options.setBinary("");
//			}
//			driver = new ChromeDriver(options);
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
//		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get(GlobalConstants.ADMIN_PAGE_ULR);
//
//		return driver;
//	}

//	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
//		if (browserName.equals("firefox")) {
//
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions options = new FirefoxOptions();
//			options.setAcceptInsecureCerts(true);
//			driver = new FirefoxDriver(options);
//
//		} else if (browserName.equals("h-firefox")) {
//
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions options = new FirefoxOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1366x768");
//			driver = new FirefoxDriver(options);
//
//		} else if (browserName.equals("chrome")) {
//
//			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.args", "--disable-logging");
//			System.setProperty("webdriver.chrome.silentOutput", "True");
//			ChromeOptions options = new ChromeOptions();
//			Map<String, Object> prefs = new HashMap<String, Object>();
//
//			prefs.put("credentials_enable_service", false);
//			prefs.put("profile.password_manager_enabled", false);
//			prefs.put("autofill.profile_enabled", false);
//			prefs.put("autofill.credit_card_enabled", false);
//			options.setExperimentalOption("prefs", prefs);
//			options.setAcceptInsecureCerts(true);
//			driver = new ChromeDriver(options);
//			
//		} else if (browserName.equals("h-chrome")) {
//
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1366x768");
//			driver = new ChromeDriver(options);
//
//		} else if (browserName.equals("edge")) {
//
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//
//		} else if (browserName.equals("opera")) {
//
//			WebDriverManager.operadriver().setup();
//			driver = new OperaDriver();
//
//		} else if (browserName.equals("ie")) {
//			WebDriverManager.iedriver().arch32().setup();
//			driver = new InternetExplorerDriver();
//
//		} else if (browserName.equals("coccoc")) {
//
//			WebDriverManager.chromedriver().driverVersion("").setup();
//			ChromeOptions options = new ChromeOptions();
//			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
//				options.setBinary("C:\\Users\\nguyen\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
//			} else {
//				options.setBinary("");
//			}
//			driver = new ChromeDriver(options);
//
//		} else if (browserName.equals("brave")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\operadriver.exe");
//			ChromeOptions options = new ChromeOptions();
//			options.setBinary("");
//			driver = new ChromeDriver(options);
//
//		} else {
//			throw new RuntimeException("Please input with correct browser name");
//		}
//		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get(getEnvironmentUrl(appUrl));
//		return driver;
//
//	}

    protected WebDriver getBrowserDriver(String browserName,String appurl, String envName, String osName,String nodeName) {
		
		switch (envName) {
		case "localAdmin":
			driver.set(new  LocalFactory(browserName).createDriverAdmin());
			break;
		case "localUser":
			driver.set(new LocalFactory(browserName).createDriverUser());
			break;
		case "gridUser":
			driver.set(new GridFactory(browserName, osName,nodeName).createDriverUser());
			break;
		case "gridAdmin":
			driver.set(new GridFactory(browserName, osName,nodeName).createDriverAdmin());
			break;
			
		case "dockerGridUser":
			driver.set(new DockerGridFactory(browserName).createDriverUser());
			break;
			
		case "dockerGridAdmin":
			driver.set(new DockerGridFactory(browserName).createDriverAdmin());
			break;

		case "browserStack":

			break;

		case "sauselab":

			break;

		case "crossbrowser":

			break;
			
		case "lambda":

			break;
			
		default:
			driver.set(new LocalFactory(browserName).createDriverUser());
			break;
		}
		
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.getGlobalConstants().getLongTimeout()));
		driver.get().manage().window().maximize();
		if (envName.equals("localAdmin")|| envName.equals("gridAdmin") || envName.equals("dockerGridAdmin")) {
			driver.get().get(GlobalConstants.getGlobalConstants().getAdminPageUrl());
		} else {
			driver.get().get(getEnvironmentUrl(appurl));
		}
		return driver.get();
	}
	
	public WebDriver getDriverInstance() {
		return this.driver.get();
	}

	protected String getEnvironmentUrl(String serverName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		if (environment == EnvironmentList.DEV) {
			envUrl = "https://demo.nopcommerce.com/";

		} else if (environment == EnvironmentList.TESTING) {
			envUrl = "https://demo.nopcommerce.com/";

		} else if (environment == EnvironmentList.STAGING) {
			envUrl = "";

		} else if (environment == EnvironmentList.PRODUCTION) {
			envUrl = "";
		}
		return envUrl;
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = GlobalConstants.getGlobalConstants().getOsName();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.get().toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.get().manage().deleteAllCookies();
				driver.get().quit();
				driver.remove();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	protected String getCurrentDate() {
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return String.valueOf(month);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return String.valueOf(now.getYear());
	}

	protected String getCurrentDay() {
		return getCurrentDate() + "/" + getCurrentMonth() + "/" + getCurrentYear();
	}
}
