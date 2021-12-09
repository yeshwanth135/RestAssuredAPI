package Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameterTest {
	@Test
	public void queryParameter()
	{
		given()
		.queryParam("page", "2")
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.log()
		.all();
	}

}
