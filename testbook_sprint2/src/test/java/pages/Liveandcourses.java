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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sun.org.apache.xpath.internal.operations.Bool;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import base.Testbook_Base;

public class Liveandcourses extends Testbook_Base
{
	 
	static @FindBy(xpath="//a[text()='Login']") WebElement logbtn;
	static @FindBy(id="loginUsername") WebElement email;
	static @FindBy(xpath="//img[@class='circle-img']") WebElement actoricon;
	static @FindBy(xpath="//button[@ng-click='proceedToLogin(user)']") WebElement proc;
	static @FindBy(name="pswd") WebElement pass;
	static @FindBy(xpath="//button[text()='Login']") WebElement loginn;
	static @FindBy(xpath="//div[@class='lp-tabs shows-bar pav-class-videosTabActive pav-class']") WebElement liveicon;
	static @FindBy(xpath="//div[@class='videos lp-tab pav-class-videosTabActive pav-class pav-class-videosLoader show']") WebElement liveshow;
	static @FindBy(xpath="//div[@class='video child-0']") WebElement firstlivevideo;

	//(By.xpath("(//img[@class='circle-img'])[2]"))

	
	
	public Liveandcourses()
	{
		
		//initialize();
		PageFactory.initElements(driver,this);
	}
	
	public void liveicondisp()
	{
		System.out.println("liveicon");
		Boolean liveicondisplay=liveicon.isDisplayed();
		System.out.println(liveicondisplay);		
			log=ext.createTest("liveclasses_icon_Display");
			log.log(Status.PASS, "live classes icon is displayed on screeen");
			takescreenshot("liveicon.png");
			System.out.println("Live icon is displayed");
			
	}
	
	public void liveclassesclick()
	{
		System.out.println("liveicon click");
		liveicon.click();
	}
	
	public void liveclassesshow() throws Exception
	{
		System.out.println("live classes show");
		boolean ls = liveshow.isDisplayed();
		System.out.println(ls);
		Thread.sleep(10000);
		if(ls == true)
		{
			log=ext.createTest("liveclasses_classes_Display");
			log.log(Status.PASS, "live classes is displayed on screeen");
			takescreenshot("live classes.png");
			System.out.println("Live icon is displayed");
		}
		else
		{
			log=ext.createTest("liveclasses_classes_Display");
			log.log(Status.FAIL, "live classes is displayed on screeen");
			takescreenshot("live classes.png");
		}

	}
	
	public void clicklivevideo() throws Exception
	{
		System.out.println(",clicking on one video");
		//WebDriverWait wait = new WebDriverWait(driver,5);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='video child-0']")));
		firstlivevideo.click();
		Thread.sleep(5000);
		log=ext.createTest("after clicking on live video");
		log.log(Status.PASS, "live video clicking");
		takescreenshot("live video.png");
		System.out.println("Live video is clicked");

		//System.out.println(",clicked on one video");
		
	}
	
	
}

