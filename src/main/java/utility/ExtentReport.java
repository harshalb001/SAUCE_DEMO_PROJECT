package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class ExtentReport extends TestBase 
{
	static ExtentReports report ;
	public static ExtentReports getreportinstnce()
	{
		if(report==null)
		{
			String reportname = new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
			ExtentHtmlReporter htmlrepoter = new ExtentHtmlReporter("C:\\Users\\HP\\eclipse-workspace\\first_project\\Extent Report"+reportname+".html");
			report = new ExtentReports();
			report.attachReporter(htmlrepoter);
			report.setSystemInfo("os","Windows");
			report.setSystemInfo("Enviroment","SIT");
			report.setSystemInfo("Build","102.02.02.1234");
			report.setSystemInfo("Browser","Chrome");
			htmlrepoter.config().setDocumentTitle("UI Testing Documents");
			htmlrepoter.config().setReportName("UI Test Report");	
		}
		return report;
		
	}

	
}
