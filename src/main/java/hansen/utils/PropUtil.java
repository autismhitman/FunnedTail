package hansen.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class PropUtil {
	


    public static Properties getProperty(String path) {
        Properties prop = new Properties();
        try (FileReader reader = new FileReader(path)) {
            prop.load(reader);
        } catch (FileNotFoundException e) {
            System.err.println("Error: Property file not found at " + path);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error: Could not read property file from " + path);
            e.printStackTrace();
        }
        return prop;
    }
	

}
