package practiceCRUDwithoutBDD;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {

	@Test
	public void createProject()
	{
		
		// Prepare request body - read all the necessary data
			JSONObject jobj = new JSONObject();
		//	HashMap jobj = new HashMap();
			jobj.put("createdBy","PavanSagar");
			jobj.put("projectName","SDET2645");
			jobj.put("status","Completed");
			jobj.put("teamSize",72);
		
		// Provide request body using given()
			RequestSpecification request = RestAssured.given();
			request.contentType(ContentType.JSON);
			request.body(jobj);
		 
		// Action - POST request
			Response resp = request.post("http://localhost:8084/addProject");
		 
		// Expected results
			int expstatus = 201;
			String expProjectName = "SDET2645";
		 
		// Actual results
			int actstatus = resp.getStatusCode();
			String actProjectName = resp.jsonPath().get("projectName");
					
		// validate	
			Assert.assertEquals(actstatus, expstatus);
			Assert.assertEquals(expProjectName, actProjectName);
			
			System.out.println(resp.prettyPeek());
		  
	}
}

