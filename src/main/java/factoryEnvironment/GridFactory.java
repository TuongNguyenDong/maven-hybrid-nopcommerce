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
//import org.openqa.selenium.remote.DesiredCapabilities;
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
	
	public WebDriver createDriverUser() {
//		DesiredCapabilities capability = null;
		Platform platform;

		if (osName.contains("windows")) {
			platform = Platform.ANY;
			
		} else {
			platform = Platform.MAC;
		}

		switch (browserName) {
			case "firefox" :
//				capability = DesiredCapabilities.firefox();
//				capability.setBrowserName("firefox");
//				capability.setPlatform(platform);
//				capability.setCapability("applicationName",(String.format("%s", nodeName)));
				
				FirefoxOptions fOptions = new FirefoxOptions();
	            fOptions.setPlatformName(platform.name());
	            fOptions.setCapability("applicationName", String.format("%s", nodeName));
	            driver = createRemoteWebDriver(fOptions);
	            
//				fOptions.merge(capability);
				break;
				
			case "chrome" :
//				capability = DesiredCapabilities.chrome();
//				capability.setBrowserName("chrome");
//				capability.setPlatform(platform);
//				capability.setCapability("applicationName",(String.format("%s", nodeName)));
				
				ChromeOptions cOptions = new ChromeOptions();
	            cOptions.setPlatformName(platform.name());
	            cOptions.setCapability("applicationName", String.format("%s", nodeName));
	            
	            Map<String, Object> prefs = new HashMap<>();
	            prefs.put("credentials_enable_service", false);
	            prefs.put("profile.password_manager_enabled", false);
	            prefs.put("autofill.profile_enabled", false);
	            prefs.put("autofill.credit_card_enabled", false);
	            
	            cOptions.setExperimentalOption("prefs", prefs);
	            cOptions.setAcceptInsecureCerts(true);
	            driver = createRemoteWebDriver(cOptions);
				
//				Map<String, Object> prefs = new HashMap<String, Object>();
//				prefs.put("credentials_enable_service", false);
//				prefs.put("profile.password_manager_enabled", false);
//				prefs.put("autofill.profile_enabled", false);
//				prefs.put("autofill.credit_card_enabled", false);
//				
//				cOptions.setExperimentalOption("prefs", prefs);
//				
//
//				cOptions.setAcceptInsecureCerts(true);
//				cOptions.merge(capability);
				break;
				
			case "edge" :
//				capability = DesiredCapabilities.edge();
//				capability.setBrowserName("edge");
//				capability.setPlatform(platform);

				EdgeOptions eOptions = new EdgeOptions();
				eOptions.setPlatformName(platform.name());
		        eOptions.setCapability("applicationName", String.format("%s", nodeName));
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
		Platform platform = osName.contains("windows") ? Platform.WINDOWS : Platform.MAC;

		switch (browserName) {
			case "firefox" :
//				capability = DesiredCapabilities.firefox();
//				capability.setBrowserName("firefox");
//				capability.setPlatform(platform);
//				capability.setCapability("applicationName",(String.format("%s", nodeName)));
				
				FirefoxOptions fOptions = new FirefoxOptions();
				fOptions.setPlatformName(platform.name());
                fOptions.setCapability("applicationName", String.format("%s", nodeName));
                fOptions.setAcceptInsecureCerts(true);
                driver = createRemoteWebDriver(fOptions);
                
				break;
				
			case "chrome" :
//				capability = DesiredCapabilities.chrome();
//				capability.setBrowserName("chrome");
//				capability.setPlatform(platform);
//				capability.setCapability("applicationName",(String.format("%s", nodeName)));
	
				ChromeOptions cOptions = new ChromeOptions();
//				Map<String, Object> prefs = new HashMap<String, Object>();
//				prefs.put("credentials_enable_service", false);
//				prefs.put("profile.password_manager_enabled", false);
//				prefs.put("autofill.profile_enabled", false);
//				prefs.put("autofill.credit_card_enabled", false);
//				cOptions.setExperimentalOption("prefs", prefs);
//				cOptions.addArguments("--incognito");
//				cOptions.addArguments("--disable-notifications");
//				cOptions.addArguments("--disable-single-click-autofill"); 
//				cOptions.addArguments("--disable-popup-blocking");
//				capability.setCapability(ChromeOptions.CAPABILITY, cOptions);
//				cOptions.setAcceptInsecureCerts(true);
//				cOptions.merge(capability);
				
				cOptions.setPlatformName(platform.name());
                cOptions.setCapability("applicationName", String.format("%s", nodeName));

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("autofill.profile_enabled", false);
                prefs.put("autofill.credit_card_enabled", false);
                cOptions.setExperimentalOption("prefs", prefs);

                cOptions.setAcceptInsecureCerts(true);
                driver = createRemoteWebDriver(cOptions);
                break;
				
				
			case "edge" :
//				capability = DesiredCapabilities.edge();
//				capability.setBrowserName("edge");
//				capability.setPlatform(platform);

				EdgeOptions eOptions = new EdgeOptions();
				 eOptions.setPlatformName(platform.name());
	             eOptions.setCapability("applicationName",   String.format("%s", nodeName));
	             driver = createRemoteWebDriver(eOptions);
				break;
				
			default :
				throw new RuntimeException("Browser is not valid!");
		}

	
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
