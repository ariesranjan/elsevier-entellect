package com.elsevier.dataProviders;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	
	private final String filePath = "src/main/java/com/elsevier/configs/configurations.properties";
	

	public ConfigFileReader(){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			properties = new Properties();
			try{
			properties.load(reader);
			reader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties file not found at "+ filePath);
		}
	}
	
	
	public String getConfig(String configKey){
		String configValue = properties.getProperty(configKey);
		return configValue;
	}
}

