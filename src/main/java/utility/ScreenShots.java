package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class ScreenShots extends TestBase
{
	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-YYYYss-mm-hh").format(new Date());
	}
	public static void cs(String nameofmethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\HP\\eclipse-workspace\\first_project\\Screenshot\\" +nameofmethod+"--"+getDate()+".jpeg");
	    FileHandler.copy(source, dest);
	}

}
