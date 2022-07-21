package AllApitypes;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.Method;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import restAssuredApiTest.BaseClass;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;



public class AllapiModeltests extends BaseClass{
	
	
	@Test
	public void Gogglemapapi() {
		Response res =
		
		given()
		.when()
		    .get("http://httpbin.org/headers")
		.then()
		    .statusCode(200)
		    .log().headers()
		    
		    .extract().response();
	String jsonstr = res.asString();
    			
		    
		
		
	}
	// Request the returns the incoming request headers
	
	@Test
	public void googlemaplist() {
		
		RestAssured.baseURI = "http://httpbin.org";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"/headers");
		String jsonstr = response.getBody().asString();
		System.out.println(jsonstr);
		int code=response.getStatusCode(); 
		String str = response.header("Content-Type");
		System.out.println(str);
		Assert.assertEquals(code,200);
		
		
	}
	// returns the request for ip adress
	
	@Test
	public void GetIPadress() {
	
		RestAssured.baseURI = "http://httpbin.org";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"/ip");
		String jsonstr = response.getBody().asString();
		System.out.println(jsonstr);
		int code=response.getStatusCode(); 
		String str = response.header("Server");
		System.out.println(str);
		Assert.assertEquals(code,200);
		
		
	}
	@Test
	public void GetCacheResponse() {
		 
		
		
//		RestAssured.baseURI = "http://httpbin.org";
//		RequestSpecification httprequest = RestAssured.given();
//		Response response = httprequest.request(Method.GET,"/headers");
		BaseClass bc = new BaseClass();
		bc.BaseClass("/cache");
		
		
}
	@Test
	public void Postrequest() {
//		RestAssured.baseURI= "http://httpbin.org/response-headers?freeform=";
//		RequestSpecification httprequest = RestAssured.given();
		HashMap data = new HashMap();
		data.put("Content-Length", "89");
		data.put("Content-Type", "application/json");
		data.put("freeform", "");
		
		given()
		    .contentType("application/json")
		    .body(data)
		.when()
		    .post("http://httpbin.org/response-headers?freeform=\"")
		.then()
		    .statusCode(200)
		    .log().body()
		    .log().headers();
		
		    
		
		     
		
	}
	@Test
	public void basicauthcrack() {
		given()
		.when()
		    .auth().basic("string", "string").get("http://httpbin.org/basic-auth/string/string")
		.then()
		     .statusCode(200)
		     .log().body()
		     .log().headers();
		     
		    
		
	}
	@Test
	public void BearerAuth() {
		Response res=
		
		given()
		.when()
		    .auth().oauth2("Authorization").get("http://httpbin.org/bearer")
		.then()
		     //.statusCode(200)
		     .log().body()
		     .extract().response();
		String jsonstr = res.getBody().asString();
		System.out.println(jsonstr);
				
		if(jsonstr.contains("true")) {
			System.out.println("You are Authorised user and Status code is "+ res.statusCode());
			
		}
		else {
			System.out.println("You are UnAuthorised user and Status code is "+ res.statusCode());
		}
	
	}
	@Test
	public void DigestAuth() {
		
		Response res=
				
				given()
				.when()
				    .auth().digest("string", "string").get("http://httpbin.org/digest-auth/string/string/string")
				.then()
				     //.statusCode(200)
				     .log().body()
				     .extract().response();
				String jsonstr = res.getBody().asString();
				System.out.println(jsonstr);
						
				if(jsonstr.contains("true")) {
					System.out.println("You are Authorised user and Status code is "+ res.statusCode());
					
				}
				else {
					System.out.println("You are UnAuthorised user and Status code is "+ res.statusCode());
				}
		
	}
}












