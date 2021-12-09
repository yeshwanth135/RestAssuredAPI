package Response;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateDynamicResponseTest
{
	@Test
	public void dynamicResponse()
	{
		String expData = "Eswar702";
		
		Response rsps = when().get("http://localhost:8084/projects");
		
		rsps.then().assertThat().statusCode(200);
		
		List<String> listData = rsps.jsonPath().get("projectName");
		
		for(String oneData:listData)
		{
			if(oneData.equals(expData))
			{
				System.out.println(oneData+" is Present");
				break;
			}
		}
	}
}
