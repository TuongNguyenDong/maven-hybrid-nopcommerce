package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IEDriverManager implements BrowserFactory {
	

	
	@Override
	public WebDriver getBrowserDriver() {

		WebDriverManager.iedriver().arch32().setup();
		
		return new InternetExplorerDriver();
		
	}

}
