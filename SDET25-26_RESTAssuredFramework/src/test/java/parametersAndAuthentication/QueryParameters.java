package parametersAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class QueryParameters {

	@Test
	public void queryParameters()
	{
		given()
		.queryParam("delay", 3)
		
		.when()
		.get("https://reqres.in/api/users")
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		
	}

}
