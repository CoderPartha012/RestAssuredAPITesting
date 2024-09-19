package session03;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class Test_GetMethod_BDD {

    @Test
    public void shouldReturnUserList() {
        // Given
        String url = "https://reqres.in/api/users?page=2";

        // When
        Response response = given()
                                .log().all() // Log the request details
                                .when()
                                .get(url)
                                .then()
                                .log().all() // Log the response details
                                .extract()
                                .response();

        // Then
        // Print additional information
        System.out.println("Response code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
        System.out.println("Response Time: " + response.getTime());
        System.out.println("Response Header: " + response.getHeader("Content-Type"));

        // Validate status code
        int expectedStatusCode = 200;
        int actualStatusCode = response.getStatusCode();
        assertEquals(actualStatusCode, expectedStatusCode);

        // Additional validations (optional)
        response.then()
                .statusCode(200)
                .header("Content-Type", containsString("application/json"));
    }
}
