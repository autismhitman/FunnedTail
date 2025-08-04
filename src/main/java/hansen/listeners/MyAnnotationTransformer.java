package hansen.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import hansen.dataproviders.ExcelDataReader;

public class MyAnnotationTransformer implements IAnnotationTransformer{

	 
	  public void transform(
	      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	   
		  annotation.setDataProvider("getExcelData");
		  annotation.setDataProviderClass(ExcelDataReader.class);
		  annotation.setRetryAnalyzer(MyRetryAnalyzer.class);
	  }
 
}
