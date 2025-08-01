package hansen.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hansen.drivers.DriverManager;
import hansen.enums.WaitStrategy;

public class WaitFactory {

	
public static WebElement waitForElements(By Locator, WaitStrategy waitStrategy) {
		
		WebElement element = null;
		WebDriverWait  wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(20));
		
		if(WaitStrategy.CLICKABLE==waitStrategy) {
			
			element = wait.until(ExpectedConditions.elementToBeClickable(Locator));
			
		}else if (WaitStrategy.PRESENCE==waitStrategy) {
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
			
		}else if (WaitStrategy.VISIBLE==waitStrategy) {
			
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			
		}else if (WaitStrategy.NONE==waitStrategy) {
			
			element =DriverManager.getDriver().findElement(Locator);
			
		}
		
		return element;
		
	}
}
