package session03;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PostMethod {

	@Test
	public void test03() {
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Partha Rakshit");
		jsonData.put("Job", "Quaity Analyst");
		
		RestAssured.baseURI = "https://reqres.in/api/users?";
		RestAssured.given().header("Cotent-type", "application/json")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.when().post()
		.then().statusCode(201)
		.log().all();
	}
}
