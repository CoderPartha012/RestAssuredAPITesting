package session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PutMethod {
	
	@Test
	public void test04() {
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Nishant Kumar");
		jsonData.put("Job", "Sales Executive");
		
		RestAssured.baseURI = "https://reqres.in/api/users/303";
		RestAssured.given().header("Cotent-type", "application/json")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.when().put()
		.then().statusCode(200)
		.log().all();
	}
}
