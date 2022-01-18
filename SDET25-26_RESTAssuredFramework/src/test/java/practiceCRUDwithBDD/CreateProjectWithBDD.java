package practiceCRUDwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectWithBDD {

	@Test
	public void createProject() {
		
		// Prepare request body
		HashMap jobj = new HashMap();
		jobj.put("createdBy","Pavanpp");
		jobj.put("projectName","SDET26454");
		jobj.put("status","Completed");
		jobj.put("teamSize",52);
		
		// precondition
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}
}
