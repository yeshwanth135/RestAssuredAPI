package HamCrest;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ValidateHamCrestTest {

	@Test
	public void validationHamcrest()
	{
		when().get("http://localhost:8084/projects")
		
		.then()
			.assertThat()
			.time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS)
			.and().body("[1].projectName", Matchers.equalTo("deepak_pro-1"))
			.log().all();
	}
}
