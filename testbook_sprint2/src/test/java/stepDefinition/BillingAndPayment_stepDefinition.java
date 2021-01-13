package stepDefinition;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pages.BillingandPayments;
import pages.commonpage;
import org.junit.runner.RunWith;
import org.openqa.selenium.interactions.Actions;

import base.Testbook_Base;


public class BillingAndPayment_stepDefinition extends Testbook_Base{

	commonpage tp=new commonpage();
	BillingandPayments bl=new BillingandPayments();
   
    
	//courses
    @Given("^user on testbook pass page$")
    public void user_on_testbook_pass_page() throws Throwable 
    {
    	System.out.println("user on testbook pass page");
    }

    @When("^purchased through courses$")
    public void purchased_through_courses() throws Throwable 
    {
    	System.out.println("Courses button");
    	bl.courses1();
    	System.out.println("Courses button function clicked");

    }

    @Then("^payments options should displayed$")
    public void payments_options_should_displayed() throws Throwable 
    {
    	System.out.println("viewpaymentoptfromcourses");
        bl.viewpaymentoptfromcourses();
    }
	
	//passbtndisp
	@Given("^user is on testbook home page$")
    public void user_is_on_testbook_home_page() throws Throwable {
        //tp.onhomepage();
    }

    @Then("^get pass button is displayed$")
    public void get_pass_button_is_displayed() throws Throwable {
    	bl.getpassdisp();
    }

    //getpassclick
    @Given("^user is on testbook buy page$")
    public void user_is_on_testbook_buy_page() throws Throwable {
    	System.out.println("user is on Testbook buy page");
    	//tp.onhomepage();
    }

    @When("^click on get pass$")
    public void click_on_get_pass() throws Throwable {
        bl.getpassclick();
    }

    @Then("^able to view all purchase plan$")
    public void able_to_view_all_purchase_plan() throws Throwable {
        bl.viewplans();
    }

    //paymentplans
    @Given("^user is on testbook pass page$")
    public void user_is_on_testbook_pass_page() throws Throwable {
        bl.viewplans();
    }

    @When("^click on buy pass$")
    public void click_on_buy_pass() throws Throwable {
       bl.pass99();
    }

    @Then("^able to view different payment options$")
    public void able_to_view_different_payment_options() throws Throwable {
    	bl.viewpaymentoptfromgetpass();
    }
    
    
    //creditdetails  
    @Given("^user select card payment option$")
    public void user_select_card_payment_option() throws Throwable {
        System.out.println("User selecting a payment option SD");
    }

    @When("^enter details of(.+)(.+)(.+)$")
    public void enter_details_of(String cardname,String cvv,String exdate) throws Throwable {
    	System.out.println("Calling choosepaymentoption from sd");
        bl.choosepaymentoption(cardname,cvv,exdate);
    }

    @Then("^able to pay$")
    public void able_to_pay() throws Throwable {
        System.out.println("Paying");
    }
	
 
	
    @Given("^user is on home page$")
    public void user_is_on_home_page() throws Throwable {
      System.out.println("onhomepage for clicking for actor icon");
       //tp.clickactor();
       }
    @When("^click on actor profile$")
    public void click_on_actor_profile() throws Throwable {
          	bl.actorclick();
    }
    @Then("^transactions option is display$")
    public void transactions_option_is_display() throws Throwable {
       bl.transdisp();
    }
    
    

    @Given("^transactions option clicked$")
    public void transactions_option_clicked() throws Throwable {
       bl.transclick();
    }
    @Then("^Transaction details are displayed$")
    public void transaction_details_are_displayed() throws Throwable {
        
    }
    

    @Given("^user is on transaction page$")
    public void user_is_on_transaction_page() throws Throwable {
      
    } 
    @When("^Search by name (.+)$")
    public void search_by_name(String plan) throws Throwable {
        
    } 
   @Then("^plans details should be displayed$")
    public void plans_details_should_be_displayed() throws Throwable {
     
    }
   
   
}


