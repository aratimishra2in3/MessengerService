package org.arati.javaproject.messengers.profile.test;



import  io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ProfileGetPutTestNG {
	
	@Test(enabled=false)
	public void getProfile() {
		
	Response resp	= RestAssured.get("http://localhost:8080/messengers/webapi/profile");
				String data = resp.asString();
				int code = resp.getStatusCode();
				Assert.assertEquals(code, 200);
				System.out.println(data);
		
		
	}
	
	@Test
	public void postProfileTest() {
	RequestSpecification request= 	RestAssured.given();
	
	request.header("Content-Type","application/json");
	
	JSONObject json =new JSONObject();
	
	json.put("firstName", "Arati31");
	json.put("id", "3");
	json.put("lastName", "Mishra31");
	json.put( "profileName", "Arati3");
	
	request.body(json.toJSONString());
	
	Response resp = request.put("http://localhost:8080/messengers/webapi/profile/Arati3");
	int code = resp.getStatusCode();
	Assert.assertEquals(code, 200);
	System.out.println(resp.asString());
	}
	


}
