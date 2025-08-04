package hansen.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hansen.frameworkconstants.Constants;

public class ExcelDataUtils {

	
	public static List<Map< String, String>> getListOfDataFromExcel(String sheetName) {
		
		List<Map< String, String>> list = new ArrayList<>();
		
		ExcelUtil ex = new ExcelUtil(Constants.getExcelpath(),sheetName);
		int row = ex.getRowNum();
		int col = ex.getColNum();
		
		Map<String, String> hmap = null;
		
		for( int i= 1; i<=row; i++) {
			
			hmap = new HashMap<>();
			
			for ( int j= 0; j<col; j++) {
				
				String key = ex.readCellData(0, j);
		        String value  = ex.readCellData(i, j);
		        hmap.put(key, value);
			}
			list.add(hmap);
			
		}
		return list;
	}
}
