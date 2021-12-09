package FirstPackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProjectsTest {
	@Test
	public void getAllProjects() {
		Response rsps = RestAssured.get("http://localhost:8084/projects");

//		System.out.println(rsps.asString()); // randomly printing
		Reporter.log(rsps.prettyPrint(), true);
		Reporter.log(rsps.getContentType(), true); // application/json
		System.out.println(rsps.getStatusCode()); // 200
		
		ValidatableResponse vResp = rsps.then();

//		vResp.assertThat().statusCode(201); // we get java.lang.AssertionError: 1 expectation failed.
		vResp.assertThat().statusCode(200); // PASSED: getAllProjects
		vResp.assertThat().contentType("application/json"); // PASSED: getAllProjects
		vResp.log().all(); // shows all details
	}
}