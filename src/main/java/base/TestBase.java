package base;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReport;

public class TestBase 
{
	public static ExtentReports report=ExtentReport.getreportinstnce();
	public ExtentTest logger;
	public static ChromeDriver driver;
	public static void inti() 
	{
		WebDriverManager.chromedriver();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/inventory.html");
	}

}
