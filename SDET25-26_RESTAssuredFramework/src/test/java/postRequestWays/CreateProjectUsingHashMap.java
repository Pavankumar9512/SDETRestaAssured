package postRequestWays;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class CreateProjectUsingHashMap {

	@Test
	public void createProjectUsingHashMap()
	{
		
		baseURI = "http://localhost";
		port = 8084;
		
		// Prepare request body
		HashMap map = new HashMap();
		map.put("createdBy", "Chaitra");
		map.put("projectName", "Tyss");
		map.put("status", "Created");
		map.put("teamSize",5);
		
		// preconditions
		given()
		.contentType(ContentType.JSON)
		.body(map)
		
	    .when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	
	}
}
