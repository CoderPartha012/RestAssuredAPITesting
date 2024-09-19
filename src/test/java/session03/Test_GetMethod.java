package session03;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test_GetMethod {

	@Test
	public void test01() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println("Response code:" + response.getStatusCode());
		System.out.println("Response body:" + response.getBody().asString());
		System.out.println("Response Time:" + response.getTime());
		System.out.println("Response Header:" + response.getHeader("Content-Type"));
		
		// Validate now actual and expected status code
		int Expected_Status_Code = 200;
		int Actual_Status_Code = response.getStatusCode();
		Assert.assertEquals(Expected_Status_Code, Actual_Status_Code);
		
		
	}
	
	@Test
	public void test02() {
		// given, when, then(then is used for result)
		baseURI = "https://reqres.in/api/users?";
		given().queryParam("page", "2")
		.when().get()
		.then().statusCode(200);
	}
}
