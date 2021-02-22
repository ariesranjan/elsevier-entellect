package com.elsevier.utils;

import com.elsevier.dataProviders.ConfigFileReader;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class URLBuilder {
	
	ConfigFileReader config = new ConfigFileReader();
	
	public RequestSpecification getBaseURI(String endPoint){
		RestAssured.baseURI = config.getConfig("BaseUrl")+endPoint;
		RequestSpecification request = RestAssured.given();
		return request;
	}

}
