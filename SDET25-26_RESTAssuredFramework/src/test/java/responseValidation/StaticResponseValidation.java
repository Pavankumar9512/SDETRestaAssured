package responseValidation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class StaticResponseValidation {

	@Test
	public void getAllProjectAndVerify() {
		
		// Expected results
			String expProjectName = "rmgyantra806";
								
				Response resp = when()
				.get("http://localhost:8084/projects");
				
				String actuaProjectName = resp.jsonPath().get("[0].projectName");
				
				Assert.assertEquals(expProjectName, actuaProjectName);

				resp.then()
				     .assertThat()
				     .statusCode(200)
				     .contentType(ContentType.JSON)
				     .log().all();
				
				
				
	
	}
}
