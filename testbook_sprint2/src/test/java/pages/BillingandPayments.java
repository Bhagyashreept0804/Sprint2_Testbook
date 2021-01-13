package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import base.Testbook_Base;

public class BillingandPayments extends Testbook_Base 
{

	@FindBy(xpath="//a[@class='btn text-white btn-success outline-none px-4 ng-scope']") WebElement getpassbtn;
	@FindBy(xpath="//button[@class='btn btn-block btn--pass']") WebElement pass99;
	@FindBy(xpath="//iframe[@class='razorpay-checkout-frame']") WebElement paymentframe;
	@FindBy(xpath=("(//img[@class='circle-img'])[2]")) WebElement actoricon;
	@FindBy(xpath="//a[@class='btn ui-btn w-100 btn-success ng-scope ng-binding']") WebElement coursegetpass;
	
	@FindBy(xpath="//a[text()='Get Testbook Pass']") WebElement tbpass;
	@FindBy(xpath="//div[text()='Monthly Testbook ']") WebElement monthlypass;
	@FindBy(xpath="//a[text()='Buy Pass']") WebElement buypass;
	@FindBy(xpath="//input[@value='Yearly Testbook']") WebElement radiobtn;
	
	@FindBy(xpath=("(//li[@ng-if='tbHeader.isShowNav('/transactions')'])")) WebElement transdisp;
	@FindBy(xpath="//ul[@class='side-list']/li[3]/a[1]") WebElement coursesbtn;
	@FindBy(xpath="//div[@class='search-box__input']/input") WebElement coursessearch;
	@FindBy(xpath=("//*[@id=\"allCoursesDetails\"]/a[1]/div[1]")) WebElement selcourse;
	@FindBy(xpath="//h3[text()='Cards, UPI & More']") WebElement paymentoptions;
	@FindBy(xpath="//div[@id='modal-close']") WebElement frameclose;
	@FindBy(xpath="//div[text()='Card']") WebElement card;
	@FindBy(id="card_number") WebElement cardno;
	@FindBy(id="card_expiry") WebElement expiry;
	@FindBy(id="card_cvv") WebElement cvv1;
	@FindBy(id="footer-cta") WebElement pay;


	public BillingandPayments() 
	{		
		//initialize();
		PageFactory.initElements(driver,this);
	}
	
	public void courses1() throws Exception
	{
		System.out.println("inside courses1 btn clicked");
		new Actions(driver).click().perform();
		Thread.sleep(3000);
		coursesbtn.click();
		System.out.println("courses btn clicked");
		Thread.sleep(3000);
		String t = driver.getTitle();
		
		coursessearch.sendKeys("SSC");
		if(t.equals("Online video Courses for Govt. Exams: SSC, Railways, Banking"))
		{
			log=ext.createTest("courses page displayed");
			log.log(Status.PASS, "courses pagedisplayed");
			takescreenshot("coursepage.png");
		}
		else
		{

			log=ext.createTest("courses page displayed");
			log.log(Status.FAIL, "courses pagedisplayed");
			takescreenshot("coursepage.png");
		}
		selcourse.click();
		System.out.println("courses part");
	}
	
	
	public void getpassdisp()
	{
		
		if(getpassbtn.isDisplayed())
		{
			log=ext.createTest("getpass_btn_Display");
			log.log(Status.PASS, "get pass btn is displayed on screeen");
			takescreenshot("getpassvisible.png");
			System.out.println("get pass is displayed");			
		}
		else
		{
			
			log=ext.createTest("getpass_btn_Display");
			log.log(Status.FAIL, "get pass btn is displayed on screeen");
			takescreenshot("getpassvisible.png");
			System.out.println("get pass is NOT displayed");		
			
		}
	}
		
	public void getpassclick()
	{
		getpassbtn.click();
				
	}
	
	public void viewplans()
	{
		String t = driver.getTitle();
		if(t.equals("Buy Testbook Pass for 200+ Govt Exams Get 12000+ Mock Test"))
		{
			log=ext.createTest("purchase plans title matched");
			log.log(Status.PASS, "purchase plans title matched");
			takescreenshot("purchase plans.png");
			System.out.println("purchase plans title displayed");
		}
		else
		{
			log=ext.createTest("purchase plans title matched");
			log.log(Status.FAIL, "purchase plans title matched");
			takescreenshot("purchaseplans.png");
			System.out.println("purchase plans title matched");
		
		}
	}
	
	public void pass99() throws Exception
	{
		pass99.click();
		System.out.println("clicked on one pass through get pass");
		Thread.sleep(3000);
	}
	
	public void viewpaymentoptfromgetpass() throws Exception
	{
		//coursegetpass.click();
		driver.switchTo().frame(paymentframe);		 
		if(paymentoptions.isDisplayed())
		{
			 System.out.println("Payment options frame is displayed succesfully");
			 log=ext.createTest("Payment Options");
			 log.log(Status.PASS,"Payment Options are visible");
			 takescreenshot("PaymentOption.png");
			 System.out.println("complete- payment options");
		}		
		Thread.sleep(7000);
	}
	
	public void choosepaymentoption(String cardn,String cvv,String exp) throws Exception 
	{
				card.click(); 				
		 		cardno.click();
				cardno.sendKeys(cardn);
				Thread.sleep(2000);
				expiry.click();	
				expiry.sendKeys(exp);
				cvv1.click();
				cvv1.sendKeys(cvv);		
				pay.click();		
				Thread.sleep(9000);
				log=ext.createTest("Payment invalid credentials courses");
				log.log(Status.PASS,"Error message is visible");
				takescreenshot("cardinvalidcred.png");
				Thread.sleep(5000);
				frameclose.click();
				driver.switchTo().parentFrame();
				//Thread.sleep(5000);
	}
	
	
	public void viewpaymentoptfromcourses() throws Exception
	{		
		tbpass.click();
		System.out.println("course passes");
		log=ext.createTest("Weekly/Monthly Pass");
		log.log(Status.PASS,"Passes Options are visible");
		takescreenshot("CoursePasses.png");
		monthlypass.click();
		buypass.click();
		driver.switchTo().frame(paymentframe);
		if(paymentoptions.isDisplayed())
		{
			 System.out.println("Payment options frame  through courses is displayed succesfully");
			 log=ext.createTest("Payment Options courses");
			 log.log(Status.PASS,"Payment Options are visible");
			 takescreenshot("PaymentOption.png");
			 System.out.println("complete- payment options from courses");
		}		
		card.click();
		cardno.sendKeys("123412341234");
		expiry.click();
		expiry.sendKeys("1212");
		cvv1.click();
		cvv1.sendKeys("212");
		pay.click();
		Thread.sleep(3000);
		 log=ext.createTest("invalid credentials through courses gives error");
		 log.log(Status.PASS,"invalid credentials through courses gives error");
		 takescreenshot("courseinvalidcred.png");
		
		Thread.sleep(5000);
		frameclose.click();
		driver.switchTo().parentFrame();

	}

	public void actorclick()
	{		
		actoricon.click();
		System.out.println("actor click");
		
	}
	
	public void transdisp()
	{
	
		if(transdisp.isDisplayed())
		{
			log=ext.createTest("transactions option displayed");
			log.log(Status.PASS, "transactionsoption displayed");
			takescreenshot("transactionssoption.png");
			System.out.println("transactrions options displayed");
		}
		else
		{
			log=ext.createTest("transactions option displayed");
			log.log(Status.FAIL, "transactionsoption displayed");
			takescreenshot("transactionsNOTsoption.png");
			System.out.println("transactrions options displayed");
		}
	
	}
	
	public void transclick()
	{
		transdisp.click();
		log=ext.createTest("transactions options displayed");
		log.log(Status.PASS, "transactionsoptions displayed");
		takescreenshot("transactionssoptions.png");
	}
	
	
	
	
	
			
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
	






