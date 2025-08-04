package hansen.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import hansen.utils.ExcelDataUtils;

public class MyMethodInterceptor implements IMethodInterceptor{
	

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
	    
		List<IMethodInstance> result  = new ArrayList<>();
		
		List<Map< String, String>> dataList = ExcelDataUtils.getListOfDataFromExcel("RunManager");
		
		for( int i= 0; i<methods.size(); i++) {
			
			 for( int j = 0; j<dataList.size(); j++) {
				 
				 if(methods.get(i).getMethod().getMethodName()
						 .equalsIgnoreCase(dataList.get(j).get("TestCaseName"))
								 && dataList.get(j).get("Execute").equalsIgnoreCase("yes")) {
					 
					
					 result.add(methods.get(i));
				 }
			 }
		}
		
		
		
		return result;
	}



	 

}
