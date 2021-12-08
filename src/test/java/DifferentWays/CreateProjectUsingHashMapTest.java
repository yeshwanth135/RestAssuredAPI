package DifferentWays;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMapTest {
	@Test
	public void createProjectUsingHashMap()
	{
		HashMap hm = new HashMap();
		hm.put("createdBy", "Mapped");
		hm.put("projectName", "Hash007");
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
