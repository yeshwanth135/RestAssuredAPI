package Response;

import static io.restassured.RestAssured.*;

import genericUtility.EndPoints;

public class StaticTest implements EndPoints{

	public void dynamic()
	{
		baseURI = "http://localhost";
		port = 8084;
		when()
			.get(EndPoints.getAllProjects);
	}
}
