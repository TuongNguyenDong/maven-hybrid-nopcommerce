package factoryBrowser;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
//		WebDriverManager.chromedriver().clearResolutionCache();
//		WebDriverManager.chromedriver().clearDriverCache();
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "True");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("autofill.profile_enabled", false);
		prefs.put("autofill.credit_card_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		options.setAcceptInsecureCerts(true);
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//		options.addArguments("--user-data-dir=C:\\Users\\Admin\\AppData\\Local\\Google\\Chrome\\User Data");
//		options.addArguments("--profile-directory=Profile 3");
		
		return new ChromeDriver(options);
		
	}

}
