package WithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeletingProjectTest {
	@Test(enabled = false)
	public void deletingProject()
	{
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_817")
		.then()
			.assertThat()
			.statusCode(204)
			.and()
			.contentType(ContentType.JSON)
			.log()
			.all();
	}

}
