package practiceCRUDwithBDD;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProjectWithBDD {

	@Test
	public void updateProject() {
		
		// Prepare request body
		HashMap jobj = new HashMap();
		jobj.put("createdBy","Saraskumud");
		jobj.put("projectName","SDET265");
		jobj.put("status","OnGoing");
		jobj.put("teamSize",52);
		
		// precondition
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_606")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
