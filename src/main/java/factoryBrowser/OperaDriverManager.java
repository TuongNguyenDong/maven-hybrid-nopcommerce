package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OperaDriverManager implements BrowserFactory {
	

	
	@Override
	public WebDriver getBrowserDriver() {

		WebDriverManager.operadriver().setup();
		
		return new OperaDriver();
		
	}

}
