package hansen.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import hansen.dataproviders.ExcelDataReader;
import hansen.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	/*
    
		@Test//(enabled= true,dataProviderClass=ExcelDataProvider.class,dataProvider="getData")
		public void loginValidationTest(String uname, String pwd) {
			
			String message = new LoginPage().enterLoginCreds(uname, pwd).getMessage();		
			Assert.assertEquals(message, "Welcome back, "+uname+"!");
		}	
    
    */
	
	@Test()
	public void loginValidationTest1(HashMap<String, String> data) {
		
		String message = new LoginPage().enterLoginCreds(data.get("uname"), data.get("pwd")).getMessage();
		
		Assert.assertEquals(message, "Welcome back, "+data.get("uname")+"!");
	}
	
	/*
	
		@Test(enabled= true,dataProviderClass=ExcelDataProvider.class,dataProvider="getData2")
		public void loginValidationTest2(Users u) {
			
			String message = new LoginPage().enterLoginCreds(u.getUname(), u.getPwd()).getMessage();
			
			Assert.assertEquals(message, "Welcome back, "+u.getUname()+"!");
		}
    */

}
