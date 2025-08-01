package hansen.drivers;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import hansen.utils.ConfigLoader;

public class Drivers {
	
	 
	public static void initDriver() {
		if(Objects.isNull(DriverManager.getDriver())) {
			
			
			WebDriver driver =WebDriverFactory.getDriver("edge", true);
			DriverManager.setDriver(driver);
			DriverManager.getDriver().manage().window().maximize();
			System.out.println(ConfigLoader.getInstance().getProperty("url"));
			DriverManager.getDriver().get(ConfigLoader.getInstance().getProperty("url"));
		 }
		
		 
	}
	
	public static void closeDriver() {
		
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
