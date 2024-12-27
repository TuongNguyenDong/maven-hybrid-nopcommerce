package commons;

import java.io.File;

import lombok.Getter;
import lombok.Setter;


@Getter
public class GlobalConstants {
	private static GlobalConstants globalInstance;
	private GlobalConstants() {
		
	}
	public static synchronized GlobalConstants getGlobalConstants() {
		if (globalInstance == null) {
			globalInstance  = new GlobalConstants();
		}
		return globalInstance;
	}
	
	private final String portalPageUrl = "https://demo.nopcommerce.com/";
	private final String adminPageUrl = "https://admin-demo.nopcommerce.com";
	
	// tro ve 1 thu muc mac dinh cua User
	private final String projectPath = System.getProperty("user.dir");
	private final String osName = System.getProperty("os.name").toLowerCase();
	private final String javaVersion = System.getProperty("java.version");
	private final String uploadFile = projectPath + File.separator + "uploadFiles" + File.separator;
	private final String downloadFile = projectPath + File.separator + "downloadFiles";
	private final String browserLog = projectPath + File.separator + "browserLogs";
	private final String drapDropHTML5 = projectPath + File.separator + "drapDropHTML5";
	private final String autoItScript = projectPath + File.separator + "autoIT";
	private final String reportingScreenshot = projectPath + File.separator + "ReportNGImages" + File.separator;
	private final String extentPath = projectPath + File.separator + "ExtentV2" + File.separator;
	
	// xu ly authentication Alert or upload bang auto IT
	//Popup len moi uploaf
	//Headless browser
	// Jenkins service ( File cai dat) -Headless
	// Jenkins (.wars) Bat Browser
	//Database coount/ User/ Pass/ Port	
	private final String dbDevUrl = "92.168.9.15:9850";
	private final String dbDevUser = "automationfc";
	private final String DbDevPass = "12345678x@X";
	private final String DbTestUrl = "91.168.9.15:9850";
	private final String DbTestUser = "automationfc";
	private final String DbTestPass = "12345678x@X";
	
	private final long shortTimeout = 5;
	private final long longTimeout = 30;
	private final long retryTestFail = 3;


}
