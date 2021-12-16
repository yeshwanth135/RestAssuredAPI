package DifferentWays;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreatProjectUsingFileTest {
	@Test
	public void usingFile()
	{
		File file = new File("./data.json");
		
		given()
			.contentType(ContentType.JSON)
			.body(file)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}
}
