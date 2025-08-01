package hansen.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	
	 static XSSFWorkbook wb ;
	 static XSSFSheet sh ;
	
	public ExcelUtil(String path, String sheetName) {
		
		File file = new File(path);
		try {
			wb = new XSSFWorkbook(file);
			sh= wb.getSheet(sheetName);
		} catch (InvalidFormatException e) {
			 
			e.printStackTrace();
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
	}
	
     public int getRowNum() {
    	 
    	 return sh.getLastRowNum();
     }
     
     public int getColNum() {
    	 
    	 return sh.getRow(0).getLastCellNum();
     }
     
     public String readCellData(int row, int col) {
    	 return sh.getRow(row).getCell(col).getStringCellValue();
     }
} 
