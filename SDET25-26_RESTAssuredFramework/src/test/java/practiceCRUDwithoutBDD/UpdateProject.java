package practiceCRUDwithoutBDD;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	@Test
	public void updateProject()
	{
		// Prepare request body - read all the necessary data
	    //  JSONObject jobj = new JSONObject();
			HashMap jobj = new HashMap();
			jobj.put("createdBy","KUMUD");
			jobj.put("projectName","SDET264");
			jobj.put("status","Created");
			jobj.put("teamSize",72);
				
		// Provide request body using given()
			 RequestSpecification request = RestAssured.given();
			 request.contentType(ContentType.JSON);
			 request.body(jobj);
				 
		// Action - PUT request
			 Response resp = request.put("http://localhost:8084/projects/TY_PROJ_604");
				 
		// Expected results
			int expstatus = 200;
			String expProjectName = "SDET264";
			String expCreatedBy = "KUMUD";
			 
		// Actual results
			int actstatus = resp.getStatusCode();
			String actProjectName = resp.jsonPath().get("projectName");
			String actCreatedBy = resp.jsonPath().get("createdBy");
						
		// validate	
			Assert.assertEquals(actstatus, expstatus);
			Assert.assertEquals(expProjectName, actProjectName);
			Assert.assertEquals(expCreatedBy, actCreatedBy);
				
			System.out.println(resp.prettyPeek());
				 
				 
	}
}
