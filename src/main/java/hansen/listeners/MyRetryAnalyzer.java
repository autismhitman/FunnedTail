package hansen.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer{
    
	private int count; 
	private int retryCount =2 ;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<retryCount) {
			count++;
			return true;
		}
		return false;
	}

}
