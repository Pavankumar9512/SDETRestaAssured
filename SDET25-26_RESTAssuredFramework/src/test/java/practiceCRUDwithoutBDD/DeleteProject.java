package practiceCRUDwithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {

	@Test
	public void deleteProject()
	{
		// Action - DELETE request
			Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_605");
		
		// Expected results
			int expstatus = 204;
				
		// Actual results
			int actstatus = resp.getStatusCode();
				
		// Validate	
			Assert.assertEquals(actstatus, expstatus);
			System.out.println(resp.prettyPeek());
	}
}
