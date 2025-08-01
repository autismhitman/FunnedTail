package hansen.utils;

import java.util.Properties;

import hansen.frameworkconstants.Constants;

public class ConfigLoader {
	
	
	private static ConfigLoader loader =null;
	private Properties properties;
	
    
	private ConfigLoader() {
		
		properties = PropUtil.getProperty(Constants.getConfigpath());
	}

	public static ConfigLoader getInstance() {
		
		if(loader==null) {
			
			loader= new ConfigLoader();
		}
		return loader;
	}
	
	public String getProperty(String key) {
        return properties.getProperty(key);
    }

   
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
