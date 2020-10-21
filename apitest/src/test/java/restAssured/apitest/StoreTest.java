package restAssured.apitest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class StoreTest {
	
	String jsonArrayPayload = "{\r\n" + 
			"  \"id\": 2,\r\n" + 
			"  \"petId\": 3,\r\n" + 
			"  \"quantity\": 5,\r\n" + 
			"  \"shipDate\": \"2020-10-21T15:55:29.710+0000\",\r\n" + 
			"  \"status\": \"placed\",\r\n" + 
			"  \"complete\": true\r\n" + 
			"}";
		
	@Test
	public void CreateStore() {
		
		RestAssured.baseURI="https://petstore.swagger.io/";
		   given()
			  .contentType(ContentType.JSON)
			  .body(jsonArrayPayload)
			  .log()
			  .all()
		
		   .when()
			   .post("v2/store/order")
		
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
	}

	
}

