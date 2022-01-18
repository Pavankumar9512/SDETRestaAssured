package responseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import sdet25_26_POJOClass.PojoProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateResourceUsingMultipleData {

	@Test(dataProvider = "getData")
	public void createResourceUsingMultipleData(String createdBy, String projectName, String status , int teamSize )
	{
		 PojoProjectLibrary pojo = new PojoProjectLibrary(createdBy, projectName, status, teamSize);
		 
		 given()
		  	.contentType(ContentType.JSON)
		  	.body(pojo)
		 .when()
		 	.post("http://localhost:8084/addProject")
		 .then()
		 	.assertThat()
		 	.contentType(ContentType.JSON)
		 	.statusCode(201)
		 	.log().all();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] obj = new Object[2][4];
		
		obj[0][0] = "pavan";
		obj[0][1] = "amazon1";
		obj[0][2] = "Created";
		obj[0][3] = 14;
		
		
		obj[1][0] = "raj";
     	obj[1][1] = "flipkart1";
		obj[1][2] = "Completed";
		obj[1][3] = 45;
														
		return obj ;
		
	}
}
