package hansen.dataproviders;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;

import hansen.pojos.Users;
import hansen.utils.ExcelUtil;
import hansen.utils.JsonUtil;

public class ExcelDataProvider {
	
	@DataProvider
	public Object[][] getData() {
		
      ExcelUtil excelUtil = new ExcelUtil("./src/test/resources/data/testData.xlsx","Sheet1");      
      int row = excelUtil.getRowNum();
      int col = excelUtil.getColNum();      
      Object[][] data = new Object[row][col];

       for( int i=1; i<=row; i++) {
    	   
    	   for( int j= 0; j<col; j++) {
    		   
    		  data[i-1][j]= excelUtil.readCellData(i, j);
    	   }
       }
       return data;
	}
	
	@DataProvider
	public Object[][] getData1() {
		
      ExcelUtil excelUtil = new ExcelUtil("./src/test/resources/data/testData.xlsx","Sheet1");      
      int row = excelUtil.getRowNum();
      int col = excelUtil.getColNum();      
      Object[][] data = new Object[row][1];
      
      HashMap<String,String> table = null; 

       for( int i=1; i<=row; i++) {
    	   
    	   table = new HashMap<>();
    	   
    	   for( int j= 0; j<col; j++) {
    		   
    		  String key = excelUtil.readCellData(0, j);
    		  String value = excelUtil.readCellData(i, j);
    		  table.put(key, value);
    	   }
    	   
    	   data[i-1][0]= table;
       }
       return data;
	}
	
	
	@DataProvider
	public Object[][] getData2(){
		
		List<Users> ulist  = JsonUtil.getData("./src/test/resources/data/user.json", new TypeReference<List<Users>>(){});
		 Object[][] data = new Object[ulist.size()][1];

	       
	        for (int i = 0; i < ulist.size(); i++) {
	            data[i][0] = ulist.get(i);
	        }

	        return data;
		
	}
	
	
	
	
	
	
	
}
