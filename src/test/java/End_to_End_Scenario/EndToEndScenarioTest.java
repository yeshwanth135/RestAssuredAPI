package End_to_End_Scenario;

import static io.restassured.RestAssured.*;

import java.sql.ResultSet;

import org.testng.annotations.Test;

import com.RMGYantra.pojoLibrary.POJOLibrary;

import genericUtility.BaseAPIClass;
import genericUtility.DataBaseUtility;
import genericUtility.EndPoints;
import genericUtility.JSONUtility;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndScenarioTest extends BaseAPIClass implements EndPoints
{
	@Test
	public void endToEndScenario() throws Throwable
	{
		
		baseURI = "http://localhost";
		port = 8084;

		JavaUtility jUtil = new JavaUtility();
		POJOLibrary pl = new POJOLibrary("RRR", "Quentiga" + jUtil.randomNumber(), "Created", 8);

		Response rsps = given().contentType(ContentType.JSON).body(pl).when().post(EndPoints.createProject);

		String projectid = rsps.jsonPath().get("projectId");
		System.out.println(projectid);

		Response rsps1 = given().pathParam("ProId", projectid).when().get("http://localhost:8084/projects/{ProId}");

		JSONUtility jsonUtil = new JSONUtility();
		String projectName = jsonUtil.jsonPathFinder("projectName", rsps1);
		System.out.println(projectName);

		DataBaseUtility dUtil = new DataBaseUtility();
        dUtil.connectToDataBase();
		ResultSet result = dUtil.executingQuery("select * from project;");
		while (result.next())
		{
			if ((result.getString(4)).equals(projectName))
			{
				System.out.println(projectName + " is matching");
			}
		}
		dUtil.closeConnection();
	}
}
