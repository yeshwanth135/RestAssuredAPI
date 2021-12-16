package Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuthTest{
	
	@Test
	public void oAuth()
	{
		Response rsps = given()
			.formParam("client_id", "ApplicationArun")
			.formParam("client_secret", "92b9463300cf414123bf23eabfef126d")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "http://example.com")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		
		//System.out.println(rsps.prettyPrint());
		String token = rsps.jsonPath().get("access_token");
		
		given()
			.auth().oauth2(token)
			.pathParam("UserId", "2570")
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{UserId}/eggs-count")
		.then()
			.log().all();
	}
}