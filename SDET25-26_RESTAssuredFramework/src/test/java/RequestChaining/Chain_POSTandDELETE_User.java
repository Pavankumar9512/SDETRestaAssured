package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Chain_POSTandDELETE_User {

	@Test
	public void chain_POSTandDELETE_User() {
		
		baseURI = "http://localhost";
		port=8084;

		// Prepare request body
		HashMap map = new HashMap();
		map.put("designation", "SDET");
		map.put("dob", "12/12/1995");
		map.put("email", "PAVAN@GMAIL.COM");
		map.put("empName", "SAFAR21");
		map.put("experience", "4");
		map.put("mobileNo", "1234567897");
		map.put("project", "TYSS");
		map.put("role", "TestEr");
		map.put("username", "PushpaRaj");
		
		// precondition
		Response resp = given()
				.contentType(ContentType.JSON)
				.body(map)
		
		.when()
		.post("/employees");
		String empId = resp.jsonPath().get("employeeId");
		
		given()
			.pathParam("eId", empId)
		
		.when()
			.delete("/employees/{eId}")
		
		.then()
			.assertThat()
			.statusCode(204)
			.log().all();
	}
}
