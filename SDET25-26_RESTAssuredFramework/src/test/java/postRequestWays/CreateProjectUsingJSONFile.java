package postRequestWays;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateProjectUsingJSONFile {

	@Test
	public void createProjectUsingJSONFile()
	{
		baseURI = "http://localhost";
		port= 8084;
		
		// prepare request body through json file
		File datafile = new File ("./requestdata.json");
		
		given()
		.contentType(ContentType.JSON)
		.body(datafile)
		
		.when()
		.post("/addProject")
		
		.then()
		.statusCode(201)
		.log().all();
		
	 
	}
}
