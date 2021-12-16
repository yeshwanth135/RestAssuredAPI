package DifferentWays;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RMGYantra.pojoLibrary.POJOLibrary;

import io.restassured.http.ContentType;

public class CreateProjectMultipleTimesTest
{
	@DataProvider
	public Object[][]  providingData()
	{
		Object[][] obj = new Object[2][4];
		
		obj[0][0] = "Steve";
		obj[0][1] = "Pratap";
		obj[0][2] = "On Going";
		obj[0][3] = 12;
		
		obj[1][0] = "SteveJobs";
		obj[1][1] = "Rana";
		obj[1][2] = "Completed";
		obj[1][3] = 13;
		
		return obj;
	}
	
	@Test(dataProvider = "providingData")
	public void createProject(String createdBy, String projectName, String status, int teamSize)
	{
		Random r = new Random();
		int randomNum = r.nextInt(2000);
		
		POJOLibrary pojo = new POJOLibrary(createdBy, projectName+randomNum, status, teamSize);
		
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
