package apiTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class PetstoreUserApiTest {

	String user1="vijayanand6";
	String user2="vijayanand7";
	String password1="123457";
	String password2="345678";
	
	
	List<Map<String,Object>> jsonArrayPayload = new ArrayList<>();
	
	@BeforeTest
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
		
		
		jsonArrayPayload.add(user);
		jsonArrayPayload.add(user1);
	
		
		RestAssured.baseURI="https://petstore.swagger.io";
		   given()
			  .contentType(ContentType.JSON)
			  .body(jsonArrayPayload)
			  .log()
			  .all()
		
		   .when()
			   .post("v2/user/createWithArray");
		
	}
	
	@Test
	public void CreateUser() {
		
		RestAssured.baseURI="https://petstore.swagger.io";
		   given()
			  .contentType(ContentType.JSON)
			  .body(jsonArrayPayload)
			  .log()
			  .all()
		
		   .when()
			   .post("v2/user/createWithArray")
		
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
	}
	
	@Test
	public void getuser()
	{
		
		
		RestAssured
		   .given()
			  .baseUri("https://petstore.swagger.io/v2")
			  .header("Content-Type","application/json")
			  .log()
			  .all()
		
		   .when()
			   .get("user/vijayanand7")
		
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
		
	}
	
	
	@Test
	public void loginUser()
	{
		
		
		RestAssured
		   .given()
			  .baseUri("https://petstore.swagger.io/v2/user/login")
			  .contentType(ContentType.JSON)
			  .queryParam("username", user1)
			  .queryParam("password", password1)
			  .log()
			  .all()
		
		   .when()
			   .get()
		
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
		
	}
	
	@Test(dependsOnMethods= "loginUser")
	public void logoutUser()
	{
		
		
		RestAssured
		   .given()
			  .baseUri("https://petstore.swagger.io/v2/user/logout")
			  .contentType(ContentType.JSON)
			  .log()
			  .all()
		
		   .when()
			   .get()
		
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
		
	}
	
	
	
	@Test
	public void deleteUser()
	{
		
		
		RestAssured
		   .given()
			  .baseUri("https://petstore.swagger.io/v2/user")
			  .contentType(ContentType.JSON)
			  .log()
			  .all()
		
		   .when()
			   .delete(user1)
		
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
		
	}
	
}
