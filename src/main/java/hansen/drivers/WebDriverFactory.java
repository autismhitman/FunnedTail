package hansen.drivers;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	
	
	public static WebDriver getDriver(String browserName, boolean isRemote) {
		
		BrowserFactory factory;
		
		switch(browserName.toLowerCase()) {
		
		case "chrome":
			   factory = new ChromeFactory(isRemote);
			   break;
		case "edge":
			   factory = new EdgeFactory(isRemote);	
			   break;
		default:
             throw new IllegalArgumentException("Unsupported browser type: " + browserName);
            
		   
		}
		return factory.createDriver();
		
	}

}
