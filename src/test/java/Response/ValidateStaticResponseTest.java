package Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateStaticResponseTest
{
	@Test
	public void staticResponse()
	{
		String expData = "Eswar702";
		
		Response rsps = when().get("http://localhost:8084/projects");
		
		rsps.then().assertThat().statusCode(200);
		
		String actData = rsps.jsonPath().get("[4].projectName");
		
		Assert.assertEquals(actData, expData);
	}
}
