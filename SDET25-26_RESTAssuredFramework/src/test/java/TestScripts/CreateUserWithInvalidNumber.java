package TestScripts;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtils.BaseAPIClass;
import com.genericUtils.EndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import sdet25_26_POJOClass.PojoUserLibrary;

public class CreateUserWithInvalidNumber extends BaseAPIClass{

	@Test
	public void createUserWithInvalidNumber() throws SQLException
	{
		//create random number
		  int randomNum = jUtil.getRandomNumber();
		  String ExpectedProjectName = "REDSandalWood"+randomNum;
		  String ExpectedUserName = "Thagedhele"+randomNum;
		  String expectedStatus= "Created";
		  String expectedmsg= "Employee Added Successfully";
		 
		
		// pass the request body using pojo library
		  PojoUserLibrary pojo = new PojoUserLibrary("Syndicate","12/12/1995","pushpa@gmail.com", "PushpaRaju",12,"12345698791236",ExpectedProjectName,"Hero", ExpectedUserName);
		  
		  Response resp = given()
			.contentType(ContentType.JSON)
			.body(pojo)
		  
		  .when()
		  	.post(EndPoints.ADD_USER);
		  
		  // fetch data from response body
		  String resopnseActualMsg = jsonUtil.getJsonValueData(resp, "msg");
		  String resopnseActualUserName = jsonUtil.getJsonValueData(resp, "username");
		  String resopnseActualUserId = jsonUtil.getJsonValueData(resp, "employeeId");
		  String expectedUserId= resopnseActualUserId;
		   resp.then()
		   	.assertThat()
		    .contentType(ContentType.JSON)
		    .statusCode(201)
		    .log().all();
		   
		   //database value verification
		   String query = "select * from employee";
		   String dbActualUserName = dbUtil.getAndVerifyTheData(query,11, ExpectedUserName);
		   String dbActualUserId = dbUtil.getAndVerifyTheData(query,1, expectedUserId);
		   
		   //verifications
		   Assert.assertEquals(resopnseActualUserName, ExpectedUserName);
		   Assert.assertEquals(resopnseActualUserId, expectedUserId);
		   Assert.assertEquals(dbActualUserName, ExpectedUserName);
		   Assert.assertEquals(dbActualUserId, expectedUserId);
			
		
	}

}
