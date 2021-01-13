package pages;

import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import base.Testbook_Base;

public class LoginTestbook extends Testbook_Base
{
	
	static @FindBy(xpath="//a[text()='Login']") WebElement logbtn;
	static @FindBy(id="loginUsername") WebElement email;
	static @FindBy(xpath="//img[@class='circle-img']") WebElement actoricon;
	static @FindBy(xpath="//button[@ng-click='proceedToLogin(user)']") WebElement proc;
	static @FindBy(name="pswd") WebElement pswd;
	static @FindBy(xpath="//button[text()='Login']") WebElement loginn;
	
	public LoginTestbook()
	{
		
		//initialize();
		PageFactory.initElements(driver,this);

	}
	public void checkloginpage()
	{
		//logbtn.click();
		String t = driver.getTitle();
		if(t.equals("Sign Up Now & Get Free Mock Tests | Testbook.com"))
		{
			log=ext.createTest("on_loginpage");
			log.log(Status.PASS, "loginpage title is correct");
			takescreenshot("loginpage.png");
			System.out.println("user on login page");
		}
	}
	//valid email password
	public void validemailpass(String em,String pass) throws Exception
	{
		
		email.sendKeys(em);
		proc.click();
		pswd.sendKeys(pass);
		loginn.click();
		//Thread.sleep(5000);
		//new Actions(driver).click().perform();
		String t = driver.getTitle();
		if(t.equals("Dashboard | Testbook"))		
		{
			log = ext.createTest("valid login by email credentials");
			log.log(Status.PASS, "valid credentials");
			takescreenshot("valid cred.png");
			System.out.println("User on homepage after giving valid credentials");
	    }
		else
		{
			log = ext.createTest("error msg for invalid");
			log.log(Status.PASS, "not entered homepage");
			takescreenshot("invalidcredentials.png");
			System.out.println("User cannot enter homepage");

		}
		
	}
	
	
	public void excelcred() throws Exception 
	{
		System.out.println("Taking from excel BEFORE");
		FileInputStream fin=new FileInputStream("C:\\demo\\eclipse\\sprint2logincred.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet ws = wb.getSheet("Sheet1");
		Row row;
		String str;
		for (int r=1;r<=ws.getLastRowNum();r++)
		{
			//Thread.sleep(5000);
			//new Actions(driver).click().perform();
			row=ws.getRow(r);
			email.sendKeys(row.getCell(0).getStringCellValue());
			System.out.println("Taking from excel");
			Thread.sleep(2000);
			proc.click();	
			pswd.click();
			try {
				pswd.sendKeys(row.getCell(1).getStringCellValue());
			}
			catch(Exception e)
			{
				System.out.println("no password given");
			}
			loginn.click();
			
			if(r<=(ws.getLastRowNum()-1))
			{
				
				log = ext.createTest("givingemail credentials");
				log.log(Status.PASS, "giving credentials");
				takescreenshot("emailcred.png");
				System.out.println("Giving credentials in loop from excel");
				driver.navigate().refresh();
			}	
			Thread.sleep(5000);			
		}
		Thread.sleep(15000);
		new Actions(driver).click().perform();
		String t = driver.getTitle();
		if(t.equals("Dashboard | Testbook"))		
		{
			log = ext.createTest("valid login by email credentials");
			log.log(Status.PASS, "valid credentials");
			takescreenshot("valid cred.png");
			System.out.println("User on homepage after giving valid credentials");
	    }
		else
		{
			log = ext.createTest("error msg for invalid");
			log.log(Status.PASS, "not entered homepage");
			takescreenshot("invalidcredentials.png");
			System.out.println("User cannot enter homepage");

		}
		
		
	}
	
	
	
	public void invpass(String em,String pass) throws Exception
	{
		Thread.sleep(3000);
		driver.navigate().to("testbook.com/login");
		System.out.print("User again on homepage");
		email.sendKeys(em);
		proc.click();
		pswd.sendKeys(pass);
		loginn.click();
		Thread.sleep(10000);
		new Actions(driver).click().perform();
	}
	
	public void ssofinvalid()
	{
		
	}
	
}
	
	