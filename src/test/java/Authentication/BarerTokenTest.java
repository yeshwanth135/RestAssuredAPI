package Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BarerTokenTest {
	@Test
	public void barerToken()
	{
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com")
		.then().log().all();
	}
}
