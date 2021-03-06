package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Testbook_Base
{
	 public static WebDriver driver;
	 public static Properties prop;
	 public static ExtentHtmlReporter htmlreport;
	 public static ExtentReports ext;
	 public static ExtentTest log;
	
	@BeforeSuite
	public void before_scenario()
	{
		
		try {
			prop = new Properties();
			prop.load(new FileInputStream("src/test/resources/config.properties"));
		}catch (Exception e) {}
		
		htmlreport = new ExtentHtmlReporter(prop.getProperty("reportlocation")+"\\TESTBOOK.html");
		 ext = new ExtentReports();
		 ext.attachReporter(htmlreport);
		 ext.setSystemInfo("Host Name", "Mysystem");
		 ext.setSystemInfo("Environment", "Test Env");
		 ext.setSystemInfo("User Name", "Bhagyashree");
		   
		 htmlreport.config().setDocumentTitle("title");
		 htmlreport.config().setReportName("testbook functional testing");
		 htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
		 htmlreport.config().setTheme(Theme.STANDARD);	
		   
		   
		String browser=prop.getProperty("browser");
		if(browser.matches("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		if(browser.matches("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		System.out.println(".................before");
	}
	
	public void takescreenshot(String imagename)
	{
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		try
		{
		FileUtils.copyFile(f, new File(prop.getProperty("screenshots")+"\\"+imagename));	
		log.addScreenCaptureFromPath(prop.getProperty("screenshots")+"\\"+imagename);	
		}catch(Exception e) {}
		
	}
	
	
	@AfterSuite
	public void after_scenario()
	{
		System.out.println(".................after");
		ext.flush(); 
		driver.quit(); 
		try
		{
		Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");//kill the geckodriver process
		}catch(Exception e) {}
		
	}

}
