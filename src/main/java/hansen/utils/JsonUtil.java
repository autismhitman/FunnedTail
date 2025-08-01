package hansen.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import hansen.pojos.Users;

public class JsonUtil {
	
	  private static final ObjectMapper objectMapper = new ObjectMapper();
	  
	 public static <T>T getData(String path, TypeReference<T> typeReference) {
		 
		      try {
		           	        
		            return  objectMapper.readValue(new File(path), typeReference );
		        } catch (IOException e) {
		            throw new RuntimeException("Failed to read JSON data from file: " + path, e);
		        }
		    }

}
