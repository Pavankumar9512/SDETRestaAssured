package responseValidation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {

	@Test
	public void dynamicvalidation() {
		
		// Expected results
			String expProjectName = "rmgyantra806";
						
		Response resp = when()
		.get("http://localhost:8084/projects");
		
		List<String> proName = resp.jsonPath().get("projectName");
		
	//	boolean flag = false;
		String actuaProjectName = null;
		for(String s : proName)
		{
			if(s.equals(expProjectName))
			{
				//flag=true;
				actuaProjectName=s;
				break;
			}
		}
		
		//Assert.assertEquals(flag,true);
		Assert.assertEquals(expProjectName, actuaProjectName);
		resp.then()
		     .assertThat()
		     .statusCode(200)
		     .contentType(ContentType.JSON)
		     .log().all();
		
	}
	
}
