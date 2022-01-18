package TestScripts;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtils.BaseAPIClass;
import com.genericUtils.EndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet25_26_POJOClass.PojoProjectLibrary;

public class AddProjectWithCreatedStatus extends BaseAPIClass{


	@Test
	public void addProjectWithCreatedStatus() throws SQLException
	{
		//create random number
		  int randomNum = jUtil.getRandomNumber();
		  String expectedProjectName = "pavan"+randomNum;
		  String expectedStatus= "Created";
		
		// pass the request body using pojo library
		  PojoProjectLibrary pojo = new PojoProjectLibrary("Pride", expectedProjectName,expectedStatus, 12);
		  
		  Response resp = given()
			.contentType(ContentType.JSON)
			.body(pojo)
		  
		  .when()
		  	.post(EndPoints.ADD_PROJECT);
		  
		  // fetch data from response body
		   String resopnseActualProjectName = jsonUtil.getJsonValueData(resp, "projectName");
		   String resopnseActualStatus = jsonUtil.getJsonValueData(resp, "status");
		 
		   resp.then()
		   	.assertThat()
		    .contentType(ContentType.JSON)
		    .statusCode(201)
		    .log().all();
		   
		   //database value verification
		   String query = "select * from project";
		   String dbActualStatus = dbUtil.getAndVerifyTheData(query,5, expectedStatus);
		   
		   //verifications
		   Assert.assertEquals(resopnseActualProjectName, expectedProjectName);
		   Assert.assertEquals(resopnseActualStatus, expectedStatus);
		   Assert.assertEquals(dbActualStatus, expectedStatus);
		
	}
}
