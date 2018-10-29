package org.arati.javaproject.messengers.message.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MessageGetPostTestNG {

	@Test
	public void getMessage() {
		
		Response resp = RestAssured.get("http://localhost:8080/messengers/webapi/message");
		
		String data = resp.asString();
		
	int code = resp.getStatusCode();
	
	Assert.assertEquals(code, 200);
		
	System.out.println(data);
	}
	
	public void postMessage() {
		
		RequestSpecification request = 	RestAssured.given();
		
//	request.header(headerName, headerValue)
	}
}
