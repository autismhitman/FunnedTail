package hansen.tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import hansen.pages.LoginPage;

public class SelectPieSizeTest extends BaseTest {
	
	
	@Test(enabled=true)
	public void selectPieTest() {
		
		boolean result =new LoginPage().enterLoginCreds("jack", "test1234").scrollElement()
				.selectSize("Large").addToCart().validateItemPresent();
		Assert.assertEquals(result, true);
		 Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
	}

}
