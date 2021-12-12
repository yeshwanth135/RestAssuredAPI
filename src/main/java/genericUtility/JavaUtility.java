package genericUtility;

import java.util.Random;

public class JavaUtility
{
	public int randomNumber()
	{
		Random r = new Random();
		int randomNum = r.nextInt(2000);
		return randomNum;
	}
}
