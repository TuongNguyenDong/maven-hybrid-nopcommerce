package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DockerGridFactory {
	private WebDriver driver;
	private String browserName;
//	private String osName;
//	private String nodeName;
//	private String ipAddress;
//	private String portNumber;


	public DockerGridFactory(String browserName ) {
		this.browserName = browserName;
//		this.osName = osName;
//		this.nodeName = nodeName;
//		this.ipAddress = ipAddress;
//		this.portNumber = portNumber;
	

	}
	
	public WebDriver createDriverUser() {
//		DesiredCapabilities capability = null;


		switch (browserName) {
			case "firefox" :
//				capability = DesiredCapabilities.firefox();
//				capability.setBrowserName("firefox");
//				capability.setPlatform(Platform.ANY);
			
				
				FirefoxOptions fOptions = new FirefoxOptions();
				fOptions.setPlatformName(Platform.ANY.name());
				fOptions.setAcceptInsecureCerts(true);
				driver = createRemoteWebDriver(fOptions);
//				fOptions.merge(capability);
				break;
				
			case "chrome" :
				
//				capability = DesiredCapabilities.chrome();
//				capability.setBrowserName("chrome");
//				capability.setPlatform(Platform.ANY);
				
				ChromeOptions cOptions = new ChromeOptions();
				cOptions.setPlatformName(Platform.ANY.name());
				
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				prefs.put("autofill.profile_enabled", false);
				prefs.put("autofill.credit_card_enabled", false);
				cOptions.setExperimentalOption("prefs", prefs);
				
//				capability.setCapability(ChromeOptions.CAPABILITY, cOptions);
				cOptions.setAcceptInsecureCerts(true);
				 driver = createRemoteWebDriver(cOptions);
//				cOptions.merge(capability);
				break;
			
				
			case "edge" :
//				capability = DesiredCapabilities.edge();
//				capability.setBrowserName("edge");
//				capability.setPlatform(Platform.ANY);

				EdgeOptions eOptions = new EdgeOptions();
				eOptions.setPlatformName(Platform.ANY.name());
				driver = createRemoteWebDriver(eOptions);
//				eOptions.merge(capability);
				break;
				
			default :
				throw new RuntimeException("Browser is not valid!");
		}

		
//		try {
////			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}

		
	return  driver;	
	}
	
	public WebDriver createDriverAdmin() {
//		DesiredCapabilities capability = null;
		
		switch (browserName) {
			case "firefox" :
//				capability = DesiredCapabilities.firefox();
//				capability.setBrowserName("firefox");
//				capability.setPlatform(Platform.ANY);
			
				
				FirefoxOptions fOptions = new FirefoxOptions();
				fOptions.setPlatformName(Platform.ANY.name());
				fOptions.setAcceptInsecureCerts(true);
				driver = createRemoteWebDriver(fOptions);
//				fOptions.merge(capability);
				break;
				
			case "chrome" :
//				capability = DesiredCapabilities.chrome();
//				capability.setBrowserName("chrome");
//				capability.setPlatform(Platform.ANY);
				
	
				ChromeOptions cOptions = new ChromeOptions();
				
				cOptions.setPlatformName(Platform.ANY.name());
				
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				prefs.put("autofill.profile_enabled", false);
				prefs.put("autofill.credit_card_enabled", false);
				cOptions.setExperimentalOption("prefs", prefs);
//				capability.setCapability(ChromeOptions.CAPABILITY, cOptions);
				cOptions.setAcceptInsecureCerts(true);
				driver = createRemoteWebDriver(cOptions);
//				cOptions.merge(capability);
				break;
				
			case "edge" :
//				capability = DesiredCapabilities.edge();
//				capability.setBrowserName("edge");
//				capability.setPlatform(Platform.ANY);

				EdgeOptions eOptions = new EdgeOptions();
				eOptions.setPlatformName(Platform.ANY.name());
				driver = createRemoteWebDriver(eOptions);
//				eOptions.merge(capability);
				break;
				
			default :
				throw new RuntimeException("Browser is not valid!");
		}

//		try {
////			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
//			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}

		
	return  driver;	
	}

	private WebDriver createRemoteWebDriver(Object options) {
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), (Capabilities) options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL for the Grid is incorrect!", e);
        }
    }
}
