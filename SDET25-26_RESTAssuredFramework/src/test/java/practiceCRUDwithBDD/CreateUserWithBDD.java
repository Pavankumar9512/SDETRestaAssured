package practiceCRUDwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateUserWithBDD {

	@Test
	public void createUserWithBBD()
	{
		
		baseURI = "http://localhost";
		port=8084;
		
		// prepare the request body
		HashMap map = new HashMap();
		map.put("designation", "SDET");
		map.put("dob", "12/12/1995");
		map.put("email", "PAVAN@GMAIL.COM");
		map.put("empName", "SAFAR");
		map.put("experience", "4");
		map.put("mobileNo", "1234567897");
		map.put("project", "TYSS");
		map.put("role", "TestEr");
		map.put("username", "Pavanpp");
		
		given()
		.contentType(ContentType.JSON)
		.body(map)

		.when()
		.post("/employees")
		
		.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	
	}

}
