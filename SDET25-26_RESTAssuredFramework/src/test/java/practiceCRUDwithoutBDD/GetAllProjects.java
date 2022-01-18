package practiceCRUDwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {

	@Test
	public void getAllProjects()
	{
		// Action - GET request
			Response resp = RestAssured.get("http://localhost:8084/projects");
		
		// Expected results
			int expstatus = 200;
		
		// Actual results
			int actstatus = resp.getStatusCode();
		
		// Validate	
			Assert.assertEquals(actstatus, expstatus);
			System.out.println(resp.prettyPeek());
	}
}
