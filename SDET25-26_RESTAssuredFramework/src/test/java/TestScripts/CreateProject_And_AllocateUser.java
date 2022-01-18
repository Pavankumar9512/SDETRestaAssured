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
import sdet25_26_POJOClass.PojoUserLibrary;

public class CreateProject_And_AllocateUser extends BaseAPIClass{


	@Test
	public void createProject_And_AllocateUser() throws SQLException
	{
		//create random number
		  int randomNum = jUtil.getRandomNumber();
		  String expectedProjectName = "TROOP"+randomNum;
		  String expectedStatus= "Created";
		
		// pass the request body using pojo library
		  PojoProjectLibrary pojo = new PojoProjectLibrary("Pride", expectedProjectName,expectedStatus, 12);
		  
		  Response resp = given()
			.contentType(ContentType.JSON)
			.body(pojo)
		  
		  .when()
		  	.post(EndPoints.ADD_PROJECT);
		  
		  // fetch data from response body
		   String resopnse1ActualProjectName = jsonUtil.getJsonValueData(resp, "projectName");
		   String resopnse1ActualStatus = jsonUtil.getJsonValueData(resp, "status");
		 
		   resp.then()
		   	.assertThat()
		    .contentType(ContentType.JSON)
		    .statusCode(201)
		    .log().all();
		   
		   //database value verification
		   String query = "select * from project";
		   String dbActualStatus = dbUtil.getAndVerifyTheData(query,5, expectedStatus);
		   
		   //verifications
		   Assert.assertEquals(resopnse1ActualProjectName, expectedProjectName);
		   Assert.assertEquals(resopnse1ActualStatus, expectedStatus);
		   Assert.assertEquals(dbActualStatus, expectedStatus);
		   
		
		   //create random number
			  String ExpectedUserName = "Thagedhele"+randomNum;
			  String expectedmsg= "Employee Added Successfully";
			
			
			// Using ProjectName from first response pass it into user request body using pojo library
			  PojoUserLibrary pojo2 = new PojoUserLibrary("Syndicate","12/12/1995","pushpa@gmail.com", "PushpaRaju",12,"1234569879",resopnse1ActualProjectName,"Hero", ExpectedUserName);
			  
			  Response resp2 = given()
				.contentType(ContentType.JSON)
				.body(pojo2)
			  
			  .when()
			  	.post(EndPoints.ADD_USER);
			  
			  // fetch data from response body
			  String resopnseActualMsg = jsonUtil.getJsonValueData(resp2, "msg");
			  String resopnseActualUserName = jsonUtil.getJsonValueData(resp2, "username");
			  String resopnseActualUserId = jsonUtil.getJsonValueData(resp2, "employeeId");
			  String expectedUserId= resopnseActualUserId;
			   resp2.then()
			   	.assertThat()
			    .contentType(ContentType.JSON)
			    .statusCode(201)
			    .log().all();
			   
			   //database value verification
			   String query2 = "select * from employee";
			   String dbActualUserName = dbUtil.getAndVerifyTheData(query2,11, ExpectedUserName);
			   String dbActualUserId = dbUtil.getAndVerifyTheData(query2,1, expectedUserId);
			   
			   //verifications
			   Assert.assertEquals(resopnseActualUserName,ExpectedUserName);
			   Assert.assertEquals(resopnseActualUserId, expectedUserId);
			   Assert.assertEquals(dbActualUserName, ExpectedUserName);
			   Assert.assertEquals(dbActualUserId, expectedUserId);
		
	}
}
