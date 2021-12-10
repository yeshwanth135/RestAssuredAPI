package Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GitHubPathParameterTest
{
	@Test
	public void gitHubPathParameter()
	{
		given()
		.pathParam("username", "Arun18297")
		.queryParam("sort", "created")
		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then()
		.log()
		.all();	
	}
}