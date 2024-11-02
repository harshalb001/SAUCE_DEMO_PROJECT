package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class CheckoutPage extends TestBase
{
	@FindBy(xpath="//span[text()='Checkout: Your Information']") private WebElement CheckLabel;
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstname;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastname;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement zipcode ;
	@FindBy(xpath="//input[@id='continue']") private WebElement ctnbtn;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancelbtn;
	
	public CheckoutPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public Object verichecklabel()
	{
		return CheckLabel.getText();
	}
	
	public String inputinfo() throws EncryptedDocumentException, IOException
	{
		firstname.sendKeys("harshal");
		lastname.sendKeys("bhosale");
		zipcode.sendKeys("25688");
		ctnbtn.click();
		return driver.getCurrentUrl();
	}
	
	public String Cancelntn()
	{
		cancelbtn.click();
		return driver.getCurrentUrl();
	}

}
