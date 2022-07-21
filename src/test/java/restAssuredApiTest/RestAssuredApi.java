package restAssuredApiTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredApi {
	
	@Test
	public void PostApiDeatails() {
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
		RequestSpecification request = RestAssured.given();
		JSONObject jsobject = new JSONObject();
		jsobject.put("employee_name","Warner");
		jsobject.put("employee_salary","250000");
		jsobject.put("employee_age","30");
		jsobject.put("profile_image","");
		request.header("Content-Type","application/json");
		request.body(jsobject.toJSONString());
		Response response = request.request(Method.POST,"/create");
		String text = response.body().asString();
		String content=response.header("Content-Tyepe");
		System.out.println("Content type is : "+ content);
		System.out.println("body text is: "+ text);
		
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
		
		String line = response.getStatusLine();
		System.out.println("status line is: "+ line);
	
	
	}
 

}
