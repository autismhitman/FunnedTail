package hansen.utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import hansen.drivers.DriverManager;
import hansen.enums.WaitStrategy;

public class SeleniumUtils {		 
	
	private static Logger logger =  LoggerUtil.getLogger(SeleniumUtils.class);
	
	public static void  sendKeys(By locator, String text) {	
		
		WebElement element = WaitFactory.waitForElements(locator, WaitStrategy.VISIBLE);
		logger.info("Sending text "+ text + " to the element" + element);
		element.sendKeys(text);
	}
	
	public static void click(By locator) {		
		WebElement element = WaitFactory.waitForElements(locator, WaitStrategy.CLICKABLE);
		logger.info("Clicking on the element" + element);
		element.click();
	}	
	
	public static String captureText(By locator) {		
		WebElement element = WaitFactory.waitForElements(locator, WaitStrategy.VISIBLE);
		logger.info("Capture text on "+element.getText() +" the element " + element);
		return element.getText();
	}	
	
	public static boolean elementPresent(By locator) {
		
		WebElement element = WaitFactory.waitForElements(locator, WaitStrategy.VISIBLE);
		if(element==null) {
			logger.info("Element not present " + element);
			return false;
		}
		logger.info("Element is present " + element);
		return true;
	}
	
	
	
	public static String captureTitle() {	
		logger.info("Title of the page "+DriverManager.getDriver().getTitle() );
		return DriverManager.getDriver().getTitle();
	}
	
	public static void selectElement(By locator, String text) {
		WebElement element = WaitFactory.waitForElements(locator, WaitStrategy.CLICKABLE);		
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
     
	
	public static void scrollToElement(By locator) {
		WebElement element = WaitFactory.waitForElements(locator, WaitStrategy.VISIBLE);
		JavascriptExecutor jse = ((JavascriptExecutor) DriverManager.getDriver());
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
