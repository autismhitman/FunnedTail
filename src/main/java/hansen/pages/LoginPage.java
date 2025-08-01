package hansen.pages;

import org.openqa.selenium.By;

import hansen.reports.ExtentLogger;
import hansen.utils.SeleniumUtils;

public class LoginPage {
	
	private By USERNAME_TEXT_FIELD = By.id("username");
	private By PASSWORD_TEXT_FIELD= By.id("password");
	private By LGN_BTN = By.xpath("//input[@type='submit' and @id='loginButton']");
	
	
	private LoginPage enterUserName(String text) {
		ExtentLogger.info("Entering the username " + text);
		SeleniumUtils.sendKeys(USERNAME_TEXT_FIELD, text);
		return this;
	}
	
	private LoginPage enterPassword(String text) {
		ExtentLogger.info("Entering the passsword " + text);
		SeleniumUtils.sendKeys(PASSWORD_TEXT_FIELD, text);
		return this;
	}
	
	private DashboardPage clickonLoginBtn() {
		ExtentLogger.info("Clicking on the login button");
		SeleniumUtils.click(LGN_BTN);
		return new DashboardPage();
	}
	
	public DashboardPage enterLoginCreds(String text1, String text2) {
		 
		return  enterUserName(text1)
				.enterPassword(text2)
				.clickonLoginBtn();
		
		
	}

}
