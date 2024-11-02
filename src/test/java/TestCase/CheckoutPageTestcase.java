package TestCase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Cart;
import Pages.CheckoutPage;
import Pages.LogIn;
import Pages.inventory;
import base.TestBase;
import utility.ScreenShots;

public class CheckoutPageTestcase extends TestBase
{
	static LogIn log;
	static inventory inv;
	static Cart crt;
	static CheckoutPage chk;
	@BeforeMethod(alwaysRun = true)
	public static void setup()
	{

		inti();
		log = new LogIn();
		log.getidanspass();
		inv = new inventory();
		inv.add6elments();
		inv.clickcart();
		crt = new Cart();
		crt.verifychkbtn();
		chk = new CheckoutPage();
	}

	@Test(groups = "Beta")
	public void verifylabelable()
	{
		String explabel = "Checkout: Your Information";
		Object actlabel = chk.verichecklabel();
		Assert.assertEquals(explabel,actlabel);	
	}
	
	@Test(groups = {"Beta","Gama"})
	public void inputinfo() throws EncryptedDocumentException, IOException
	{
		String expurl = "https://www.saucedemo.com/checkout-step-two.html";
		String aclurl = chk.inputinfo();
		Assert.assertEquals(expurl, aclurl);
	}
	
	@Test(groups = "Beta")
	public void veriftcanvelbtn()
	{
		String expurl = "https://www.saucedemo.com/cart.html";
		Object aclurl = chk.Cancelntn();
		Assert.assertEquals(expurl, aclurl);
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
