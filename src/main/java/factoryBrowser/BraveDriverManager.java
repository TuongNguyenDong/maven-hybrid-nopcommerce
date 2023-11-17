package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BraveDriverManager implements BrowserFactory {
	
	private String projectPath = System.getProperty("user.dir");
	
	@Override
	public WebDriver getBrowserDriver() {

		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\operadriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("");
		
		return new ChromeDriver(options);
		
	}

}
