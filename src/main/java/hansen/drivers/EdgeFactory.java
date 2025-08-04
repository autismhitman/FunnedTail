package hansen.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import hansen.utils.ConfigLoader;

public class EdgeFactory implements BrowserFactory{

	private boolean isRemote;
	
	
	public EdgeFactory(boolean isRemote) {
		
		this.isRemote= isRemote;
	}
	
	@Override
	public WebDriver createDriver() {
		 
		WebDriver driver = null;

			if (isRemote){
				
				try {
					  EdgeOptions browserOptions = new EdgeOptions();
					  browserOptions.setPlatformName("Windows 10");
					  browserOptions.setBrowserVersion("127");
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

				driver = new EdgeDriver();

			}
			return driver;

		}

	

	
}
