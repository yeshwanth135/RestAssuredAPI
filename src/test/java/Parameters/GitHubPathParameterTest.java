package Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GitHubPathParameterTest
{
	@Test
	public void gitHubPathParameter()
	{
		given().pathParam("username", "Arun18297")
		
		.when().get("https://api.github.com/users/{username}/repos")
		
		.then().log().all();	
	}
	
	@Test
	public void gitHubPathAndQueryParameter()
	{
		given().pathParam("username", "Arun18297").queryParam("sort", "full_name")
		
		.when().get("https://api.github.com/users/{username}/repos")
		
		.then().log().all();	
	}
}