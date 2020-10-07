package restAssured.apitest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class PetstoreApi {

	String user1="vijayanand4";
	String user2="vijayanand5";
	String password1="123457";
	String password2="345678";
	
	
	@Test(priority=1, enabled=true)
	public void createUserArrayList()
	{
		Map<String,Object> user = new HashMap<String,Object>();
		user.put("id", 1);
		user.put("username", user1);
		user.put("firstName", "vijay");
		user.put("lastName", "anand");
		user.put("email", "abc@gmail.com");
		user.put("password", password1);
		user.put("phone", "1234567890");
		user.put("userStatus", 10);
		
		
		Map<String,Object> user1 = new HashMap<String,Object>();
		user1.put("id", 2);
		user1.put("username", user2);
		user1.put("firstName", "vijay1");
		user1.put("lastName", "anand1");
		user1.put("email", "abc11@gmail.com");
		user1.put("password", password2);
		user1.put("phone", "1234567891");
		user1.put("userStatus", 11);
		
		List<Map<String,Object>> jsonArrayPayload = new ArrayList<>();
		
		jsonArrayPayload.add(user);
		jsonArrayPayload.add(user1);
		
		//GIVEN
		
		RestAssured.baseURI="https://petstore.swagger.io";
		   given()
			  .contentType(ContentType.JSON)
			  .body(jsonArrayPayload)
			  .log()
			  .all()
		// WHEN
		   .when()
			   .post("v2/user/createWithArray")
		// THEN
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
		
	}
	
	@Test(priority=2)
	public void getuser()
	{
		
		//GIVEN
		RestAssured
		   .given()
			  .baseUri("https://petstore.swagger.io/v2")
			  .header("Content-Type","application/json")
			  .log()
			  .all()
		// WHEN
		   .when()
			   .get("user/user1")
		// THEN
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
		
	}
	
	// https://petstore.swagger.io/v2/user/login?username=vijayanand1&password=12345
	
	
	@Test(priority=3)
	public void loginUser()
	{
		
		//GIVEN
		RestAssured
		   .given()
			  .baseUri("https://petstore.swagger.io/v2/user/login")
			  .contentType(ContentType.JSON)
			  .queryParam("username", user1)
			  .queryParam("password", password1)
			  .log()
			  .all()
		// WHEN
		   .when()
			   .get()
		// THEN
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
		
	}
	
	@Test(priority=4)
	public void logoutUser()
	{
		
		//GIVEN
		RestAssured
		   .given()
			  .baseUri("https://petstore.swagger.io/v2/user/logout")
			  .contentType(ContentType.JSON)
			  .log()
			  .all()
		// WHEN
		   .when()
			   .get()
		// THEN
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
		
	}
	
	
	//https://petstore.swagger.io/v2/user/vijayanand1
	
	@Test(priority=5)
	public void deleteUser()
	{
		
		//GIVEN
		RestAssured
		   .given()
			  .baseUri("https://petstore.swagger.io/v2/user")
			  .contentType(ContentType.JSON)
			  .log()
			  .all()
		// WHEN
		   .when()
			   .delete(user1)
		// THEN
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
		
	}
	
}
