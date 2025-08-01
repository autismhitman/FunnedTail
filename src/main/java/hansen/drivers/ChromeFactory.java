package hansen.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import hansen.utils.ConfigLoader;

public class ChromeFactory implements BrowserFactory{
	
	
	private boolean isRemote;

    public ChromeFactory(boolean isRemote) {
        this.isRemote = isRemote;
    }

    @Override
    public WebDriver createDriver(){

		WebDriver driver = null;

		  if(isRemote) 
		  {
          
			try {
				ChromeOptions browserOptions = new ChromeOptions();
				browserOptions.setPlatformName("Windows 10");
				browserOptions.setBrowserVersion("138");
				HashMap<String, Object> ltOptions = new HashMap<String, Object>();
				ltOptions.put("username", ConfigLoader.getInstance().getProperty("username"));
				ltOptions.put("accessKey", ConfigLoader.getInstance().getProperty("accesskey"));
				ltOptions.put("project", "HANSEN");
				ltOptions.put("w3c", true);
				ltOptions.put("plugin", "java-testNG");
				browserOptions.setCapability("LT:Options", ltOptions);

				driver = new RemoteWebDriver(new URL(ConfigLoader.getInstance().getProperty("huburl")), browserOptions);

			} catch (MalformedURLException e) {

				e.printStackTrace();
			}
		} else {

			driver = new ChromeDriver();

		}
		return driver;

	}

}
