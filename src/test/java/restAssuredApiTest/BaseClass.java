package restAssuredApiTest;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public void BaseClass(String path) {
		RestAssured.baseURI = "http://httpbin.org";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,path);
		String jsonstr = response.getBody().asString();
		System.out.println(jsonstr);
		int code= response.getStatusCode(); 
		String str = response.header("server");
		System.out.println(str);
		Assert.assertEquals(code,200);
	
		
	}
	
	

}
