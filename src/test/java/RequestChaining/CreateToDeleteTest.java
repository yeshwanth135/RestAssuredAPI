package RequestChaining;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.RMGYantra.pojoLibrary.POJOLibrary;

import FirstPackage.CreateProjectTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateToDeleteTest {

	@Test
	public void createToDelete()
	{
		Random r = new Random();
		int rNum = r.nextInt(2000);
		POJOLibrary p = new POJOLibrary("Surya", "Sandhya"+rNum, "Finished", 2);
		
		Response data = given()
		.contentType(ContentType.JSON)
		.body(p)
		.when()
		.post("http://localhost:8084/addProject");
		String d = data.jsonPath().get("projectId");
		
		given().pathParam("ProId", d)
		.when()
		.delete("http://localhost:8084/projects/{ProId}")
		.then()
		.assertThat()
		.statusCode(204)
		.log()
		.all();	
	}
}
