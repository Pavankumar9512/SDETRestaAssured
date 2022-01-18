package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtils.BaseAPIClass;
import com.genericUtils.EndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import sdet25_26_POJOClass.PojoProjectLibrary;


public class CreateResource extends BaseAPIClass{

	@Test
	public void createResource() throws SQLException
	{
		//create random number
		  int randomNum = jUtil.getRandomNumber();
		  String expectedProjectName = "civil"+randomNum;
		
		// pass the request body using pojo library
		  PojoProjectLibrary pojo = new PojoProjectLibrary("lingraj", expectedProjectName, "OnGoing", 12);
		  
		  Response resp = given()
			.contentType(ContentType.JSON)
			.body(pojo)
		  
		  .when()
		  	.post(EndPoints.ADD_PROJECT);
		  
		  // fetch data from response body
		   String resopnseActualProjectName = jsonUtil.getJsonValueData(resp, "projectName");
		   resp.then()
		   	.assertThat()
		    .contentType(ContentType.JSON)
		    .statusCode(201)
		    .log().all();
		   
		   //database value verification
		   String query = "select * from project";
		   String dbActualProjectName = dbUtil.getAndVerifyTheData(query,4, expectedProjectName);
		   
		   //verifications
		   Assert.assertEquals(resopnseActualProjectName, expectedProjectName);
		   Assert.assertEquals(dbActualProjectName, expectedProjectName);
		
	}
}
