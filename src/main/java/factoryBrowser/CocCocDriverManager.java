package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CocCocDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {

		WebDriverManager.chromedriver().driverVersion("").setup();
		ChromeOptions options = new ChromeOptions();
		if (GlobalConstants.OS_NAME.startsWith("Windows")) {
			options.setBinary("C:\\Users\\nguyen\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
		} else {
			options.setBinary("");
		}
		
		return new ChromeDriver(options);
		
	}

}
