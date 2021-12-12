package End_to_End_Scenario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.RMGYantra.pojoLibrary.POJOLibrary;
import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HardCodingEndToEndTest {
	@Test
	public void hardCodingEndToEnd() throws Throwable {
		Random r = new Random();
		int ranNum = r.nextInt(2000);

		POJOLibrary pojoLib = new POJOLibrary("RRR", "Quentiga" + ranNum, "Created", 8);

		// Create Project
		Response rsps1 = given().contentType(ContentType.JSON).body(pojoLib).when().post("http://localhost:8084/addProject");
		
		// Verify The Created Project
		rsps1.then().assertThat().statusCode(201).and().time(Matchers.lessThan(5L), TimeUnit.SECONDS).log().all();
		
		// Take projectId from Response
		String pId = rsps1.jsonPath().get("projectId");
		
		// get project using projectId
		Response rsps2 = given().pathParam("proId", pId).when().get("http://localhost:8084/projects/{proId}");
		
		// Take projectName from Response
		String pName = rsps2.jsonPath().get("projectName");
		
		// Connect the Database
		Driver dref = new Driver();
		DriverManager.registerDriver(dref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery("select * from project;");

		while (res.next()) {
			if (pName.equals(res.getString(4))) {
				System.out.println(pName + " is matching");
			}
		}
		con.close();
	}
}
