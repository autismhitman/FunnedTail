package hansen.pages;

import org.openqa.selenium.By;

import hansen.reports.ExtentLogger;
import hansen.utils.SeleniumUtils;

public class CartPage {
	
	By large = By.xpath("//div[@id='cartItems'][.//strong[contains(text(),'Classic Apple Pie')] and contains(.,'Large')]");
	
	
	public boolean validateItemPresent() {
		ExtentLogger.info("Element is present");
		return SeleniumUtils.elementPresent(large);
	}

}
