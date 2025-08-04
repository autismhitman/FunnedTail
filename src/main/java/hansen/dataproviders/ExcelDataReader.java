package hansen.dataproviders;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import hansen.utils.ExcelDataUtils;

public class ExcelDataReader {
	
	public static List<Map<String, String>> list = new ArrayList<>();
	
	
	@DataProvider(parallel=true)
	public Object[] getExcelData(Method m) {

		String testCaseName = m.getName();
		
		if(list.isEmpty()) {
			
			list = ExcelDataUtils.getListOfDataFromExcel("Sheet1");
		}
		
		List<Map<String, String>> smallList = new ArrayList<>();
		
		for( int i= 0; i<list.size(); i++) {
			
			 
				 
				 if(list.get(i).get("TestCaseName")
						 .equalsIgnoreCase(testCaseName)
								 && list.get(i).get("Execute").equalsIgnoreCase("yes")) {
					 
					
					 smallList.add(list.get(i));
				 }
			 
		}
		
		return smallList.toArray();
	}

}
