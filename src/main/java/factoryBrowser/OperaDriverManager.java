package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OperaDriverManager implements BrowserFactory {
	
	@Override
	public WebDriver getBrowserDriver() {

	WebDriverManager.operadriver().setup();
//		 OperaOptions options = new OperaOptions();
	 ChromeOptions options = new ChromeOptions();
//		
//		return new OperaDriver(options);
		return new ChromeDriver(options);
//		
	}

}
