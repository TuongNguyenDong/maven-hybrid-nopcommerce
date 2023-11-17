package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;
	private String nodeName;
//	private String ipAddress;
//	private String portNumber;


	public GridFactory(String browserName, String osName , String nodeName ) {
		this.browserName = browserName;
		this.osName = osName;
		this.nodeName = nodeName;
//		this.ipAddress = ipAddress;
//		this.portNumber = portNumber;
	

	}
	
	public WebDriver createDriver() {
		DesiredCapabilities capability = null;
		Platform platform = null;

		if (osName.contains("windows")) {
			platform = Platform.WINDOWS;
		} else {
			platform = Platform.MAC;
		}

		switch (browserName) {
			case "firefox" :
				capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
				capability.setPlatform(platform);
				
				FirefoxOptions fOptions = new FirefoxOptions();
				fOptions.merge(capability);
				break;
				
			case "chrome" :
				capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				capability.setPlatform(platform);
				capability.setCapability("applicationName",(String.format("%s", nodeName)));
				
				ChromeOptions cOptions = new ChromeOptions();
				cOptions.merge(capability);
				break;
				
			case "edge" :
				capability = DesiredCapabilities.edge();
				capability.setBrowserName("edge");
				capability.setPlatform(platform);

				EdgeOptions eOptions = new EdgeOptions();
				eOptions.merge(capability);
				break;
				
			default :
				throw new RuntimeException("Browser is not valid!");
		}

		try {
//			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
			driver = new RemoteWebDriver(new URL("http://192.168.1.4:4444/wd/hub"), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		
	return  driver;	
	}

}
