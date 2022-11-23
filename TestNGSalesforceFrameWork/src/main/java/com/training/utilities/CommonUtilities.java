package com.training.utilities;

import java.io.FileInputStream;
import static com.training.utilities.Constants.*;
import java.io.IOException;
import java.util.Properties;

public class CommonUtilities {
	
	public String getproperty(String key) throws IOException {
		
		//filepath
		//String spath = "C:\\Users\\aruma\\eclipse-workspace\\TestNGSalesforceFrameWork\\properties\\application.properties";
		//fileInputStream
		String spath=USER_DIR+FILE_SEPARATOR+APPLICATION_PROPERTIES;
		FileInputStream fileput = new FileInputStream(spath);
		Properties prop = new Properties();
		prop.load(fileput);
		String value = prop.getProperty(key);
		return value;
	}

}
