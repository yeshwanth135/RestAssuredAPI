package RequestChaining;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetToDeleteTest {

	@Test
	public void getToDelete()
	{		
		Response rsps = when().get("http://localhost:8084/projects");
		String pId = rsps.jsonPath().get("[0].projectId");
		
		
		given().pathParam("ProId", pId)
		.when().delete("http://localhost:8084/projects/{ProId}")
		.then().assertThat().statusCode(204).log().all();
	}
}
