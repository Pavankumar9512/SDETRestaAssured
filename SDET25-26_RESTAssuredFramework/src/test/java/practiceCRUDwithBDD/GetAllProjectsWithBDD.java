package practiceCRUDwithBDD;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllProjectsWithBDD {

	@Test
	public void getAllProjects() {
		
		// precondition
		when()
		.get("http://localhost:8084/projects") 
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
