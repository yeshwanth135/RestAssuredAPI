package WithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjectTest
{
	@Test
	public void deleteProject()
	{
		Response rsps = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1613");
		System.out.println(rsps.getStatusCode()); // 204
		
		ValidatableResponse vResp = rsps.then();
		vResp.assertThat().statusCode(204); // PASSED: deleteProject
		vResp.log().all();
	}
}