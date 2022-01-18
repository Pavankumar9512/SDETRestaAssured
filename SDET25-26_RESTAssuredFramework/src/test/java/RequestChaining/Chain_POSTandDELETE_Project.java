package RequestChaining;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Chain_POSTandDELETE_Project {

	@Test
	public void chaining() {
		

		// Prepare request body
		HashMap jobj = new HashMap();
		jobj.put("createdBy","PushpaRaj");
		jobj.put("projectName","RedSandalWood12");
		jobj.put("status","Completed");
		jobj.put("teamSize",40);
		
		// precondition
		Response resp = given()
				.contentType(ContentType.JSON)
				.body(jobj)
		
		.when()
			.post("http://localhost:8084/addProject");
		String proId = resp.jsonPath().get("projectId");
		
		given()
			.pathParam("pId", proId)
		
		.when()
			.delete("http://localhost:8084/projects/{pId}")
		
		.then()
			.assertThat()
			.statusCode(204)
			.log().all();
	}
}
