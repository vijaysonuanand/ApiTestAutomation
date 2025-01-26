package apiTest;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PetstorePetApiTest {
	
	String jsonArrayPayload = "{\r\n" + 
			"  \"id\": 1,\r\n" + 
			"  \"category\": {\r\n" + 
			"    \"id\": 2,\r\n" + 
			"    \"name\": \"string\"\r\n" + 
			"  },\r\n" + 
			"  \"name\": \"doggie\",\r\n" + 
			"  \"photoUrls\": [\r\n" + 
			"    \"string\"\r\n" + 
			"  ],\r\n" + 
			"  \"tags\": [\r\n" + 
			"    {\r\n" + 
			"      \"id\": 3,\r\n" + 
			"      \"name\": \"string\"\r\n" + 
			"    }\r\n" + 
			"  ],\r\n" + 
			"  \"status\": \"available\"\r\n" + 
			"}";
		
	@Test
	public void CreatePet() {
		
		RestAssured.baseURI="https://petstore.swagger.io/";
		   given()
			  .contentType(ContentType.JSON)
			  .body(jsonArrayPayload)
			  .log()
			  .all()

		   .when()
			   .post("v2/pet")

		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
	}
	
}
