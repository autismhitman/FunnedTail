package hansen.pages;

import org.openqa.selenium.By;

import hansen.reports.ExtentLogger;
import hansen.utils.SeleniumUtils;

public class DashboardPage {
	
	By welcomeMsh = By.cssSelector("div#welcomeMessage");
	By pie = By.xpath("//h4[contains(text(),'Classic Apple Pie')]");
	By applePie = By.cssSelector("#size-1");
	By addToCartBtn = By.cssSelector("a[data-id='1']");
	
	By cart = By.xpath("//a[@href='cart.html']");
	
	public String getMessage() {
		ExtentLogger.info(" Capturing the test " + SeleniumUtils.captureText(welcomeMsh) );
		return SeleniumUtils.captureText(welcomeMsh);
	}
	
	public DashboardPage scrollElement() {
		ExtentLogger.info("Scrolling to the element");
		SeleniumUtils.scrollToElement(pie);
		return this;
	}
	
	public DashboardPage selectSize(String text) {
		ExtentLogger.info("Selecting the pie size");
		SeleniumUtils.selectElement(applePie, text);
		return this;
		
	}
	
	public CartPage  addToCart() {
		ExtentLogger.info("Adding to the cart");
		SeleniumUtils.click(addToCartBtn);
		ExtentLogger.info("Navigating to the cart");
		SeleniumUtils.click(cart);
		return new CartPage();
	}
	
	
	

}
