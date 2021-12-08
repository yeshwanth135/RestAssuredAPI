package FirstPackage;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectUsingPutTest {
	@Test
	public void updateProjectUsingPut()
	{
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Roja");
		jObj.put("projectName", "TYSS-02");
		jObj.put("status", "Finished");
		jObj.put("teamSize", 7);
		
		RequestSpecification reqSpe = RestAssured.given();
		reqSpe.contentType(ContentType.JSON);
		reqSpe.body(jObj);
		
		Response rsps = reqSpe.put("http://localhost:8084/projects/TY_PROJ_1602");
		ValidatableResponse vResp = rsps.then();
		
		vResp.assertThat().statusCode(200);
		vResp.log().all();
	}

}
