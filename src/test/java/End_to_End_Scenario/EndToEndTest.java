package End_to_End_Scenario;

import static io.restassured.RestAssured.*;

import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.RMGYantra.pojoLibrary.POJOLibrary;

import genericUtility.BaseAPIClass;
import genericUtility.DataBaseUtility;
import genericUtility.EndPoints;
import genericUtility.JSONUtility;
import genericUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndTest extends BaseAPIClass implements EndPoints{

	@Test
	public void endToEnd() throws Throwable
	{
		JavaUtility javaUtil = new JavaUtility();
		JSONUtility jsonUtil = new JSONUtility();
		DataBaseUtility dbUtil = new DataBaseUtility();

		POJOLibrary pojoLib = new POJOLibrary("RRR", "Quentiga" + javaUtil.randomNumber(), "Created", 8);

		baseURI ="http://localhost";
		port = 8084;
		// Create Project
		Response rsps1 = given().contentType(ContentType.JSON).body(pojoLib).when().post(EndPoints.createProject);
		
		// Verify The Created Project
		rsps1.then().assertThat().statusCode(201).and().time(Matchers.lessThan(5L), TimeUnit.SECONDS).log().all();
		
		// Take projectId from Response
		String pId = jsonUtil.jsonPathFinder("projectId", rsps1);
		
		// get project using projectId
		Response rsps2 = given().pathParam("proId", pId).when().get("http://localhost:8084/projects/{proId}");
		
		// Take projectName from Response
		String pName = jsonUtil.jsonPathFinder("projectName", rsps2);
		
		// Connect the Database
		dbUtil.connectToDataBase();
		ResultSet res = dbUtil.executingQuery("select * from project;");

		while (res.next()) {
			if (pName.equals(res.getString(4))) {
				System.out.println(pName + " is matching");
			}
		}
		
		Response rsps3 = given().pathParam("proId", pId).when().delete("http://localhost:8084/projects/{proId}");
		
		rsps3.then().assertThat().statusCode(204);
	}
}
