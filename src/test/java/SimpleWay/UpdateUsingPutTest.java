package SimpleWay;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateUsingPutTest {
	@Test
	public void updateUsingPut()
	{
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Azadhi");
		jObj.put("projectName", "TYS");
		jObj.put("status", "Done");
		jObj.put("teamSize", 11);
		
		given()
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1608")
		.then()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
	}

}
