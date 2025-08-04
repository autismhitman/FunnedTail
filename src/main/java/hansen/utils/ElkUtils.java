package hansen.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class ElkUtils {

	
public static void getElkDocs(String testCaseName, String status) {
		
		Map<String, String> hmap = new HashMap<>();
		hmap.put("TestCaseName", testCaseName);
		hmap.put("Status", status);
		hmap.put("ExecutionTime", LocalDateTime.now().toString());
		
		given()
		.header("Content-Type","application/json") 
		.body(hmap)
		.post("")
		.then()
		.statusCode(201);
		
	}
}
