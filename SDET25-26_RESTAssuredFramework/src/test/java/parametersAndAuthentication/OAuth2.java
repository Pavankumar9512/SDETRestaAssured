package parametersAndAuthentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OAuth2 {

	@Test
	public void oauth2()
	{
		
	  Response resp = given()
		  			.formParam("client_id", "SDET26Coop")
			  			.formParam("client_secret", "4afce3a75bfe0629839fe545188143b6")
			  			.formParam("grant_type", "client_credentials")
			  			.formParam("redirect_uri", "https://example.com")
	    .when()
	    	.post("http://coop.apps.symfonycasts.com/token");
	  
	   String token = resp.jsonPath().get("access_token");
	   System.out.println(token);
	    		    
	    given()
	    	.auth().oauth2(token)
	    	.pathParam("USER_ID", "2692")
	    
	    .when()
	    	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
	    
	    .then()
	    	.assertThat().statusCode(202).contentType(ContentType.JSON).log().all();
	    		
	}
}
