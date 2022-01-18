package parametersAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameters {

	@Test
	public void pathParameters()
	{
		given()
		.pathParam("proName","TY_PROJ_809")
		
		.when()
		.delete("http://localhost:8084/projects/{proName}")
		
		.then().contentType(ContentType.JSON).statusCode(204).log().all();
	}
}
