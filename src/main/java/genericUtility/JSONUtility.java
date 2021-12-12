package genericUtility;

import io.restassured.response.Response;

public class JSONUtility
{
	public String jsonPathFinder(String jsonPath, Response rsps)
	{
		String text = rsps.jsonPath().getString(jsonPath);
		return text;
	}
}
