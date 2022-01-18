package postRequestWays;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import sdet25_26_POJOClass.PojoProjectLibrary;

public class CreateProjectUsingPOJO {

	@Test
	public void createProjectUsingPOJO()
	{
		baseURI = "http://localhost";
		port= 8084;
		
		// prepare request body through pojo class
			PojoProjectLibrary pLib = new PojoProjectLibrary("Sai","Sundarprojets","OnGoing",12);
			
         given()
         .contentType(ContentType.JSON)
         .body(pLib)
         
         .when()
         .post("/addProject")
         
         .then().statusCode(201).log().all();
         
         
			
			
			
	}
}
