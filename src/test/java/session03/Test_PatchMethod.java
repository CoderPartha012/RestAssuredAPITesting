package session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PatchMethod {

	@Test
	public void test05() {
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Akhil");
		jsonData.put("Job", "Data Science");

		RestAssured.baseURI = "https://reqres.in/api/users/303";
		RestAssured.given().header("Cotent-type", "application/json")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.when()
		.patch()
		.then()
		.statusCode(200)
		.log().all();
	}
}
