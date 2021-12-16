package End_to_End_Scenario;

import static io.restassured.RestAssured.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import genericUtility.BaseAPIClass;
import genericUtility.DataBaseUtility;
import genericUtility.EndPoints;
import io.restassured.response.Response;

public class DeleteAllResourcesTest //extends BaseAPIClass
{
//	@Test
	public void deleteAllResources()
	{
		DataBaseUtility dbUtil = new DataBaseUtility();
		baseURI = "http://localhost";
		port = 8084;
		
		Response rsps = when().get(EndPoints.getAllProjects);
		List<String> allId = rsps.jsonPath().get("projectId");
		//dbUtil.connectToDataBase();
		try {
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	DriverManager.getConnection("", DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH)
		
		
		
	}
}
