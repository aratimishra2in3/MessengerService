package org.arati.javaproject.messengers.profile.test;



import  io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ProfileGetDeleteTestNG {
	
	@Test
	public void getProfile() {
		
	Response resp	= RestAssured.get("http://localhost:8080/messengers/webapi/profile");
				String data = resp.asString();
				int code = resp.getStatusCode();
				Assert.assertEquals(code, 200);
				System.out.println(data);
		

		
	}
	
	@AfterMethod
	public void postProfileTest() {
	RequestSpecification request= 	RestAssured.given();
	
	
	Response resp = request.delete("http://localhost:8080/messengers/webapi/profile/Arati3");
	int code =resp.getStatusCode();
	Assert.assertEquals(code, 204);
	System.out.println("Deleted Successfully");
	}
	


}
