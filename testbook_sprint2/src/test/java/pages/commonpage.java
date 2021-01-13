package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import base.Testbook_Base;

public class commonpage extends Testbook_Base
{
	
	static @FindBy(xpath="//a[text()='Login']") WebElement logbtn;
	static @FindBy(id="loginUsername") WebElement email;
	static @FindBy(xpath=("//img[@class='circle-img'])[2]")) WebElement actoricon;
	static @FindBy(xpath="//button[@ng-click='proceedToLogin(user)']") WebElement proc;
	static @FindBy(name="pswd") WebElement pass;
	static @FindBy(xpath="//button[text()='Login']") WebElement loginn;
	
	
	
	public commonpage()
	{
		
		//initialize();
		PageFactory.initElements(driver,this);

	}

	public void url() throws InterruptedException
	{
		driver.get(prop.getProperty("url"));
		System.out.println("user opened url");
	}
	public void translogin() throws InterruptedException
	{
		logbtn.click();
		
		Thread.sleep(15000);
		email.sendKeys("bpt0804@gmail.com");
		proc.click();
		pass.sendKeys("StepupTest@3248");
		loginn.click();
		Thread.sleep(15000);
		new Actions(driver).click().perform();
		System.out.println("user is logged in");

	}
	
	public void onhomepage()
	{
		String t = driver.getTitle();
		Assert.assertEquals("Dashboard | Testbook",t);	
		
			log = ext.createTest("Homepage_matchtitle");
			log.log(Status.PASS, "Homepage title is correct");
			takescreenshot("Homepage.png");
			System.out.println("User on homepageusing assert");
	  
			

		
	}
	
	
	
	
	public void clickactor()
	{
		actoricon.click();
	}
	
	
	
	
	
}

	