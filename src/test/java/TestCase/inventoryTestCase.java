package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LogIn;
import Pages.inventory;
import base.TestBase;
import utility.ScreenShots;

public class inventoryTestCase extends TestBase
{
	inventory ivn;
	LogIn log;
	@BeforeMethod(alwaysRun = true)
	public void setup()
	{
		inti();
		ivn = new inventory();
		log = new LogIn();
		log.getidanspass();
	}
    
	@Test(groups = "Gama")
	public void verifytitle()
	{
		String expurl = "Swag Labs";
		String acturl = ivn.gettitle();
		Assert.assertEquals(acturl, expurl);
	}
	
	
	@Test(groups = "alpha")
	public void verifytwitter()
	{
		 boolean result = ivn.twitrlogo();
		 Assert.assertEquals(result,true);
	}
	
	@Test(groups = "Beta")
	public void verifycart()
	{
		String expcount = "3";
		String actcount=ivn.add6elments();
		Assert.assertEquals(expcount, actcount);
		 Reporter.log(actcount);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closebrowser(ITestResult it) throws IOException
	{
		if(ITestResult.FAILURE==it.getStatus())
		{
			ScreenShots.cs(it.getName());
		}
	driver.close();
	}

}
