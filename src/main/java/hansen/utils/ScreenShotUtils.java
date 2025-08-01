package hansen.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import hansen.drivers.DriverManager;

public class ScreenShotUtils {
	
	
	public static String captureScreeshot() {
		
		return  ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
