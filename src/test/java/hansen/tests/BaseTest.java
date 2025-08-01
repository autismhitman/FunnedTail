package hansen.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import hansen.drivers.Drivers;

public class BaseTest {
	
	
	@BeforeMethod
	protected void setup() {
		
		Drivers.initDriver();
	}
	
	
	@AfterMethod
	protected void teardown() {
		
		Drivers.closeDriver();
	}

}
