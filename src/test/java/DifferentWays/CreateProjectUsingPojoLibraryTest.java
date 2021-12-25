package DifferentWays;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.RMGYantra.pojoLibrary.POJOLibrary;

import io.restassured.http.ContentType;

public class CreateProjectUsingPojoLibraryTest {

	@Test
	public void createUsingPost()
	{		
		Random r = new Random();
		int randomNum = r.nextInt(2000);
		
		POJOLibrary pojo = new POJOLibrary("Arun", "Surya"+randomNum, "Completed", 5);
		
		given()
			.contentType(ContentType.JSON)
			.body(pojo)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}
}
