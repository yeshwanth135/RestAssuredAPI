package DifferentWays;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.RMGYantra.pojoLibrary.POJOLibrary;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectUsingJsonObjectTest
{
	@Test
	public void usingJsonObject()
	{
		Random r = new Random();
		int rNum = r.nextInt(2000);
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Roja");
		jObj.put("projectName", "TYSS-02"+rNum);
		jObj.put("status", "Finished");
		jObj.put("teamSize", 7);
		
//		POJOLibrary pojo = new POJOLibrary("Arun", "Surya"+randomNum, "Completed", 5);
		
		RequestSpecification reqSpe = RestAssured.given();
		reqSpe.contentType(ContentType.JSON);
		reqSpe.body(jObj);
		
		Response rsps = reqSpe.post("http://localhost:8084/addProject");
		ValidatableResponse vResp = rsps.then();
		vResp.assertThat().statusCode(201);
		vResp.log().all();
		
	}
}
