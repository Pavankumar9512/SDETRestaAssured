package parametersAndAuthentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BarierToken {

	@Test
	public void barierToken()
	{
		
		// methods>>> auth followed by oauth2
	    given()
	    	.auth().oauth2("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")
	    .when()
	    	.get("https://api.github.com/user/repos")
	    .then()
	    	.assertThat().statusCode(200).log().all();
	}
}
