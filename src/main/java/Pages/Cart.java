package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart extends TestBase 
{
	
	@FindBy(xpath="//span[text()='Your Cart']") private WebElement cartlabel;
	@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button ']") private WebElement chkbtn;
	@FindBy(xpath="//button[@class='btn btn_secondary back btn_medium']") private WebElement cntbtn;
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-backpack']") private WebElement backpack;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikelight;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement tshirt;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cart;


	
	public Cart()
	{
		PageFactory.initElements(driver,this);
	}
	
	public static String verifytitle()
	{
		return driver.getTitle();
	}
	
	public String vrifyurl()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifychkbtn()
	{
		chkbtn.click();
		return driver.getCurrentUrl();
	}
	
	public String verifycntbtn()
	{
		cntbtn.click();
		return driver.getCurrentUrl();
	}
	
	public String add6elments()
	{
		backpack.click();
		bikelight.click();
		tshirt.click();
		return 	cart.getText();
	}

}
