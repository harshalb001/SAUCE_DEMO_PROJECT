package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.HandleDropdownlist;

public class inventory extends TestBase
{
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpack;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikelight;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement tshirt;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacket;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitter;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropdwnlist;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cart;
	//@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cart;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement carticon;

	
	public inventory()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String gettitle()
	{
		return driver.getTitle();
	}
	
	public boolean twitrlogo() 
	{
		twitter.click();
		return twitter.isDisplayed();
	}
	
	public String add6elments()
	{
		//HandleDropdownlist.dropdownlist(dropdwnlist,"Price (low to high)");
		backpack.click();
		tshirt.click();
		jacket.click();
		return cart.getText();	
	}
	
	public void clickcart()
	{
		carticon.click();
	}

}
