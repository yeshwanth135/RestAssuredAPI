package DifferentWays;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMapTest {
	@Test
	public void usingHashMap()
	{
		Random r = new Random();
		int rNum = r.nextInt(2000);
		
		HashMap hm = new HashMap();
		hm.put("createdBy", "Mapped");
		hm.put("projectName", "Hash"+rNum);
		hm.put("status", "Continue");
		hm.put("teamSize", 5);
		
		given()
		.contentType(ContentType.JSON)
		.body(hm)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}
}
