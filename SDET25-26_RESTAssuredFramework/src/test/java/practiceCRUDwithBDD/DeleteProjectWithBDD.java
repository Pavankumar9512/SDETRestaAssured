package practiceCRUDwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProjectWithBDD {

	@Test
	public void deleteProjectWithBDD() {

        baseURI = "http://localhost";
        port= 8084;
        
        given()
        .pathParam("pname", "TY_PROJ_264")
        
        .when()
        .delete("/projects/{pname}")
        
        .then()
        .assertThat().statusCode(204).contentType(ContentType.JSON).log().all();
        
	}


}
