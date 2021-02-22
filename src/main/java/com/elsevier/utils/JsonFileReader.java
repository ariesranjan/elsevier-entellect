package com.elsevier.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.elsevier.dataProviders.ConfigFileReader;

public class JsonFileReader {


	static ConfigFileReader config = new ConfigFileReader();
	
	private String dataFilePath = config.getConfig("testDataPath");

	JSONParser jsonParser = new JSONParser();

	
	public Object josnReader(String fileName) {
		try (FileReader reader = new FileReader(dataFilePath+fileName)) {
			JSONObject obj = (JSONObject) jsonParser.parse(reader);
			return obj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
