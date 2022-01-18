package practiceCRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetSingleProject {

	@Test
	public void getSingleProjects()
	{
		
		// Action - GET request
			Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_605");
		
		// Expected results
			int expstatus = 200;
			String expProjectid = "TY_PROJ_605";
		
		// Actual results
			int actstatus = resp.getStatusCode();
			String actProjectid = resp.jsonPath().get("projectId");
		
		// Validate	
			Assert.assertEquals(actstatus, expstatus);
			Assert.assertEquals(expProjectid, actProjectid);
			
			System.out.println(resp.prettyPeek());
	
	}
}
