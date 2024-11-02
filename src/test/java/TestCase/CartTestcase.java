package TestCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Cart;
import Pages.LogIn;
import Pages.inventory;
import base.TestBase;
import utility.ScreenShots;

public class CartTestcase extends TestBase
{
	LogIn log;
	inventory inv;
	Cart crt;
	@BeforeMethod(alwaysRun = true)
	public void setup()
	{
		inti();
		log = new LogIn();
		log.getidanspass();
		inv = new inventory();
		inv.add6elments();
		inv.clickcart();
		crt = new Cart();
	}
	
	@Test(priority = 3,groups = "alpha")
	public void verifytitle() throws EncryptedDocumentException, IOException
	{
		String exptitle = "Swag Labs";
		String acttitle = Cart.verifytitle();
		Assert.assertEquals(exptitle, acttitle);
	}
	
	@Test(priority = 2,groups = "Gama")
	public void verifychchbtn()
	{
		String expurl = "https://www.saucedemo.com/checkout-step-one.html";
		String acturl = crt.verifychkbtn();
		Assert.assertEquals(expurl, acturl);
	}
	
	@Test(priority = 1,groups = {"alpha","Beta"})
	public void verifyctnbtn()
	{
		String expurl = "https://www.saucedemo.com/inventory.html";
		String scturl = crt.verifycntbtn();
		Assert.assertEquals(expurl, scturl);
	}
	
	@AfterMethod(alwaysRun = true)
	public void close(ITestResult it) throws IOException
	{
		if(ITestResult.FAILURE==it.getStatus())
		{
			ScreenShots.cs(it.getName());
		}
		driver.close();
	}

}
