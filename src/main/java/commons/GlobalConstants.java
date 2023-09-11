package commons;

import java.io.File;



public class GlobalConstants {
	public static final String PORTAL_PAGE_ULR = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_ULR = "https://admin-demo.nopcommerce.com";
	// tro ve 1 thu muc mac dinh cua User
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name").toLowerCase();
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAP_DROP_HTML5 = PROJECT_PATH + File.separator + "drapDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGImages" + File.separator;
	public static final String EXTENT_PATH = PROJECT_PATH + File.separator + "ExtentV2" + File.separator;
	
	// xu ly authentication Alert or upload bang auto IT
	//Popup len moi uploaf
	//Headless browser
	// Jenkins service ( File cai dat) -Headless
	// Jenkins (.wars) Bat Browser
	//Database coount/ User/ Pass/ Port	
	public static final String DB_DEV_URL = "92.168.9.15:9850";
	public static final String DB_DEV_USER = "automationfc";
	public static final String DB_DEV_PASS = "12345678x@X";
	public static final String DB_TEST_URL = "91.168.9.15:9850";
	public static final String DB_TEST_USER = "automationfc";
	public static final String DB_TEST_PASS = "12345678x@X";	
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;
	
	
	
	

}
