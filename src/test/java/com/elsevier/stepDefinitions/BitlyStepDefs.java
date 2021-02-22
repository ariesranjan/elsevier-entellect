package com.elsevier.stepDefinitions;


import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;

import com.elsevier.dataProviders.ConfigFileReader;
import com.elsevier.utils.RequestBuilder;
import com.elsevier.utils.URLBuilder;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

	public class BitlyStepDefs {
		
		RequestBuilder reqBuilder = new RequestBuilder();
		private Response response;
		private ValidatableResponse json;
		private RequestSpecification request;
		ConfigFileReader config = new ConfigFileReader();
		private URLBuilder urlBuilder = new URLBuilder();
	    private String AUTHENTICATION_TOKEN = config.getConfig("authToken");
	    private String GROUP_ID = config.getConfig("groupId");

		@Given("base uri sets for (.*) api")
		public void base_uri_set(String service){
			switch(service) {
				case "Get Group":
					request = urlBuilder.getBaseURI("/v4/groups/"+GROUP_ID);
					request = request.header("Authorization", AUTHENTICATION_TOKEN);
					break;
				case "Get Group Invalid Token":
					request = urlBuilder.getBaseURI("/v4/groups/"+GROUP_ID);
					request = request.header("Authorization", AUTHENTICATION_TOKEN+"1");
					break;
				case "Get Invalid Group":
					request = urlBuilder.getBaseURI("/v4/groups/"+GROUP_ID+"1");
					request = request.header("Authorization", AUTHENTICATION_TOKEN);
					break;
				case "Get Group Invalid endpoint":
					request = urlBuilder.getBaseURI("/v4/group/"+GROUP_ID);
					request = request.header("Authorization", AUTHENTICATION_TOKEN);
					break;
				case "Sorted Bitlinks":
					request = urlBuilder.getBaseURI("/v4/groups/"+GROUP_ID+"/bitlinks/clicks");
					request = request.header("Authorization", AUTHENTICATION_TOKEN).param("unit", "month");
					break;
				case "Get Sorted Bitlinks Invalid Token":
					request = urlBuilder.getBaseURI("/v4/groups/"+GROUP_ID+"/bitlinks/clicks");
					request = request.header("Authorization", AUTHENTICATION_TOKEN+"1").param("unit", "month");
					break;
				case "Get Sorted Bitlinks For Invalid Group":
					request = urlBuilder.getBaseURI("/v4/groups/"+GROUP_ID+"1"+"/bitlinks/clicks");
					request = request.header("Authorization", AUTHENTICATION_TOKEN).param("unit", "month");
					break;
				case "Get Sorted Bitlinks Invalid endpoint":
					request = urlBuilder.getBaseURI("/v4/group/"+GROUP_ID+"/bitlinks/clicks");
					request = request.header("Authorization", AUTHENTICATION_TOKEN).param("unit", "month");
					break;
				case "Get Sorted Bitlinks Invalid Params":
					request = urlBuilder.getBaseURI("/v4/groups/"+GROUP_ID+"/bitlinks/clicks");
					request = request.header("Authorization", AUTHENTICATION_TOKEN).param("unit", "year");
					break;
				case "Create Bitlinks":
					request = urlBuilder.getBaseURI("/v4/bitlinks");
					request = request.header("Authorization", AUTHENTICATION_TOKEN).accept(ContentType.JSON).contentType("application/json");
					break;
			}
		}

		@When("a user retrieves the group by group id")
		public void a_user_retrieves_the_group_by_group_id(){
			
			response = request.when().get();
		}
		
		@When("a user retrieves sorted Bitlinks for Group")
		public void a_user_retrieves_sorted_Bitlinks_for_Group(){
			
			response = request.when().get();
		}
		
		@When("a user creates bitlink using post method")
		public void a_user_creates_bitlink(){
			JSONObject createRequest = reqBuilder.requestBuilder("createBitlinksRequest.json");
			request = request.body(createRequest.toJSONString());
			response = request.post();
		}

		@Then("the status code is (\\d+)")
		public void verify_status_code(int statusCode){
			json = response.then().statusCode(statusCode);
		}
		
		@And("validates get group API response schema$")
		public void validates_get_group_API_response_schema(){
			response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("testData/retrieveGroupSchema.json"));
		}
		
		@And("validates get sorted bitlinks for group API response schema$")
		public void validates_get_sorted_bitlinks_for_group_group_API_response_schema(){
			response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("testData/retrieveSortedBitlinksGroupSchema.json"));
		}

		@And("response includes the following$")
		public void response_equals(Map<String,String> responseFields){
			for (Map.Entry<String, String> field : responseFields.entrySet()) {
				if(StringUtils.isNumeric(field.getValue())){
					json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
				}
				else{
					json.body(field.getKey(), equalTo(field.getValue()));
				}
			}
		}

}
