package com.elsevier.utils;

import org.json.simple.JSONObject;

public class RequestBuilder {
	
	JsonFileReader jsonReader = new JsonFileReader();
	
	RandomDataGeneration dataGenerator = new RandomDataGeneration();
	
	public JSONObject requestBuilder(String fileName){
		
		JSONObject request = (JSONObject) jsonReader.josnReader(fileName);
		return request;
	}

}
