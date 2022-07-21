package restAssuredApiTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredGETApi {
	
	@Test
	public void GetApiDetails() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"/employees");
		
		String bodytext = response.body().asString();
		System.out.println("All Employee details are: "+bodytext);
		
		int statuscode = response.getStatusCode();
		System.out.println("Status code is : "+200);
	}

}
