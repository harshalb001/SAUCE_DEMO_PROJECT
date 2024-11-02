package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.mongodb.diagnostics.logging.Logger;

import base.TestBase;

public class LogIn extends TestBase
{
	
	@FindBy(xpath="//input[@id='user-name']")  private WebElement usrtxtbox;
	@FindBy(xpath="//input[@id='password']") private WebElement passtxtbox;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginbtn;
	
	public LogIn()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String gettitle() 
	{
		return driver.getTitle();
	}
	
	public String geturl() 
	{
		return driver.getCurrentUrl();
	}
	
	public String getmulidandpass(String un , String pass) 
	{
		usrtxtbox.sendKeys(un);
		passtxtbox.sendKeys(pass);
		loginbtn.click();
		return driver.getCurrentUrl();
		
	}
	
	public String getidanspass()
	{
		logger = report.createTest("Log In To Sauce Lab Application");
		usrtxtbox.sendKeys("standard_user");
		logger.log(Status.INFO,"User Name Entered");
		passtxtbox.sendKeys("secret_sauce");
		logger.log(Status.INFO,"Pass is entered");
		loginbtn.click();
		logger.log(Status.INFO,"LogIn Button is Clicked");
		logger.log(Status.PASS,"Login Succesfull");
		return driver.getCurrentUrl();
	}

}
