package Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PathParameterTest
{
	@Test
	public void pathParameter()
	{
		RequestSpecification rsps = given().contentType(ContentType.JSON).pathParam("proId", "TY_PROJ_2203");
		Response vRes = rsps.when().get("http://localhost:8084/projects/{proId}");
		vRes.then().log().all();
		
		
		when()
		.delete("http://localhost:8084/projects/"+vRes)
		.then()
		.assertThat()
		.statusCode(204)
		.and()
		.contentType(ContentType.JSON)
		.log()
		.all();
	}
}
