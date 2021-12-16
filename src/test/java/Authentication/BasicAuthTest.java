package Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicAuthTest {
	
	@Test
	public void basicAuth()
	{
		given()
			.auth().basic("rmgYantra", "rmgy@9999")
		.when()
			.get("http://localhost:8084/login")
		.then()
			.log().all();
	}

}