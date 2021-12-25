package SimpleWay;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateUsingPostTest {

	@Test
	public void createUsingPost()
	{
		Random r = new Random();
		int rNum = r.nextInt(2000);
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Chari14156");
		jObj.put("projectName", "TYSS"+rNum);
		jObj.put("status", "On Going");
		jObj.put("teamSize", 5);

		given()
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log()
		.all();
		
	}
}
