package TestCase;


import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.LogIn;
import base.TestBase;
import utility.ScreenShots;
public  class loginTestcase extends TestBase
{
    LogIn log;
	@BeforeMethod(alwaysRun = true)
	public void setup() 	
	{
	  inti();
	  log = new LogIn();
	  
	}
	@Test(groups = "alpha")
	public void testtitle()
	{
		String exptitle = "Swag Labs";
		String acttitle = log.gettitle();
		Assert.assertEquals(exptitle, acttitle);
	}
	@Test(groups = "Beta")
	public void testurl()
	{
		String expurl = "https://www.saucedemo.com/";
		String accurl = log.geturl();
		Assert.assertEquals(expurl, accurl);
	}
	
	@Test(groups = "Gama")
	public void logintoapplicatio()
	{
		String expurl = "https://www.saucedemo.com/inventory.html";
		String acturl = log.getidanspass();
		Assert.assertEquals(acturl, expurl);
	}
	
	@Test(dataProvider = "testdata")
	public void verifymullogin(String un , String pass)
	{
		SoftAssert s = new SoftAssert();
		String expurl = "https://www.saucedemo.com/inventory.html";
		String aclurl = log.getmulidandpass(un, pass);
		s.assertEquals(expurl,aclurl);
		s.assertAll();
	}
	@DataProvider(name="testdata")
	public Object [][] getdata()
	{
		return new Object[][]
				{
		{"standard_user","secret_sauce"},
		{"locked_out_user","secret_sauce"},		
		{"problem_user","secret_sauce"},		
		{"performance_glitch_user","secret_sauce"},		
		{"error_user","secret_sauce"},		
		{"visual_user","secret_sauce"}
				};

	}
	@AfterMethod(alwaysRun = true)
	public void closebrowser(ITestResult it) throws IOException
	{
		if(ITestResult.FAILURE==it.getStatus())
		{
			ScreenShots.cs(it.getName());
		}
		report.flush();
		driver.close();
	}

}
