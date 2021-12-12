package genericUtility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {

	DataBaseUtility dUtil =new DataBaseUtility();
	
	@BeforeSuite
	public void connectToDB()
	{
		dUtil.connectToDataBase();
		System.out.println("Connect to Database");
	}
	
	@AfterSuite
	public void CloseConnection() throws Throwable
	{
		dUtil.closeConnection();
		System.out.println("Disconnect from Database");
	}
}
