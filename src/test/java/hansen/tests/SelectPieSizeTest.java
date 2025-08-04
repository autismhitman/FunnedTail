package hansen.tests;

import java.time.Duration;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import hansen.dataproviders.ExcelDataReader;
import hansen.pages.LoginPage;

public class SelectPieSizeTest extends BaseTest {
	
	
	@Test()
	public void selectPieTest(HashMap<String, String> data) {
		
		boolean result =new LoginPage().enterLoginCreds(data.get("uname"),data.get("pwd")).scrollElement()
				.selectSize("Large").addToCart().validateItemPresent();
		Assert.assertEquals(result, true);
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
	}

}
