package hansen.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import hansen.drivers.Drivers;

public class BaseTest {
	
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setup(Object[] data) {
		
		Map<String, String> hmap = (Map<String, String>) data[0];
	 
		Drivers.initDriver(hmap.get("browser"));
	}
	
	
	@AfterMethod
	protected void teardown() {
		
		Drivers.closeDriver();
	}

}
