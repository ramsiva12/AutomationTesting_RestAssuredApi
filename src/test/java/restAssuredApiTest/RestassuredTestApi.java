package restAssuredApiTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestassuredTestApi {
	
	@Test
	public void getecomdetails() {
		
		RestAssured.baseURI = "https://www.nopcommerce.com/";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"/en");
		String text = response.body().asString();
		System.out.println("body text is : "+text);
		int code=response.getStatusCode();
		System.out.println("status code : "+ code);
		Assert.assertEquals(code, 200);
		
	}
	@Test
	public void listdetails() {
		RestAssured.baseURI = "https://admin-demo.nopcommerce.com/Admin/Customer";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"/List");
		String bodytext = response.body().asString();
		System.out.println("user details : "+ bodytext);
		
		int code = response.getStatusCode();
		System.out.println("Status code : "+ code);
		Assert.assertEquals(code,200);
	}
	

}
