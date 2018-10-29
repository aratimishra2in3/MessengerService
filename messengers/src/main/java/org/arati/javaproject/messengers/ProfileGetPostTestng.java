package org.arati.javaproject.messengers.profile.test;



import  io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ProfileGetPostTestng {
	
	@Test(enabled=false)
	public void getProfile() {
		
	Response resp	= RestAssured.get("http://localhost:8080/messengers/webapi/profile/Arati");
				String data = resp.asString();
				int code = resp.getStatusCode();
		Assert.assertEquals(code, 200);
		System.out.println(data);
		
		
	}
	
	@Test
	public void postProfileTest() throws ParseException {
	RequestSpecification request= 	RestAssured.given();
	
	request.header("Content-Type","application/json");
	
	JSONObject profile =new JSONObject();
	
	profile.put("firstName", "Arati3");
	profile.put("lastName", "Mishra3");
	profile.put( "profileName", "Arati3");
	
	request.body(profile.toJSONString());
	
	Response createProfileResponse = request.post("http://localhost:8080/messengers/webapi/profile");
	int code = createProfileResponse.getStatusCode();
	Assert.assertEquals(code, 200);
	String respString = createProfileResponse.asString();
	
	System.out.println(profile.get("firstName"));
	
	
//	Response getProfileResponse	= RestAssured.get("http://localhost:8080/messengers/webapi/profile/Arati3");
//	String respString = getProfileResponse.asString();
//	
	JSONParser parser = new JSONParser();
	JSONObject json = (JSONObject) parser.parse(respString);

	//Assertions
	
	Assert.assertEquals(json.get("firstName"), "Arati3");
	Assert.assertEquals(json.get("lastName"), "Mishra3");
	Assert.assertEquals(json.get("profileName"), "Arati3");
	System.out.println(respString);

	}
	


}
