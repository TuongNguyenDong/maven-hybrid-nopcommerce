package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;;

public class EdgeDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
//		if (!IS_OS_WINDOWS || !IS_OS_MAC) {
//			throw new BrowserNotSupportedException("Edge  is not supported on " + System.getProperty("os.name"));
//		}
		WebDriverManager.edgedriver().clearResolutionCache();
		WebDriverManager.edgedriver().clearDriverCache();
//		WebDriverManager.edgedriver().setup();
		System.setProperty("webdriver.edge.args", "--disable-logging");
		System.setProperty("webdriver.edge.silentOutput", "True");
		System.setProperty("webdriver.edge.verboseLogging", "true");
		EdgeOptions options = new EdgeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("autofill.profile_enabled", false);
		prefs.put("autofill.credit_card_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		options.setAcceptInsecureCerts(true);
		options.setExperimentalOption("prefs", Map.of(
	            "credentials_enable_service", false,
	            "profile.password_manager_enabled", false
	        ));
		options.addArguments("--disable-features=AutofillServerCommunication,Autofill"); 

		options.addArguments("--disable-features=AutofillSaveCardBubble");
		options.addArguments("--disable-features=SharedClipboardUI");
		options.addArguments("--enable-logging", "--v=1");
		options.addArguments("disable-features=PasswordManagerEnabled");
		options.addArguments("--disable-restore-session-state"); // turn off Restore Pages
        options.addArguments("--disable-session-crashed-bubble");
        options.addArguments("--disable-save-password-bubble");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		options.addArguments("--user-data-dir=C:\\Users\\Admin\\AppData\\Local\\Microsoft\\Edge\\User Data");
		options.addArguments("--profile-directory=Profile 3");

		return new EdgeDriver(options);

	}

}
