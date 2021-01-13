package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pages.LoginTestbook;
import pages.commonpage;

import org.junit.runner.RunWith;
import base.Testbook_Base;


public class LoginwithemailSD {

	commonpage tp1=new commonpage();
	LoginTestbook lg=new LoginTestbook();
	
	
    @Given("^user on login page$")
    public void user_on_login_page() throws Throwable {
    	tp1.url();
        lg.checkloginpage();
        
        }
    
    @When("^enter valid email and valid password$")
    public void enter_valid_email_and_valid_password() throws Throwable {
        lg.excelcred();
    	//lg.validemailpass(email,password);
        
        
    }
    
    @Then("^Testbook home page display$")
    public void testbook_home_page_display() throws Throwable {
    	tp1.onhomepage();
    }
    
//invalid email.    
    
    @When("^enter valid email and invalid password (.+) (.+)$")
    public void enter_valid_email_and_invalid_password(String email, String password) throws Throwable {
    //lg.invpass(email, password);
    }
    
    @Then("^Error message is displayed$")
    public void error_message_is_displayed() throws Throwable {
       
    }
    
    
 //facebook login
    

    @When("^use click on login with facebook$")
    public void use_click_on_login_with_facebook() throws Throwable {
       
    }

    @Then("^Facebook login page should open$")
    public void facebook_login_page_should_open() throws Throwable {
        
    }
    
    //google login

    @When("^click on login with google$")
    public void click_on_login_with_google() throws Throwable {
      
    }

    @Then("^user should choose an acc$")
    public void user_should_choose_an_acc() throws Throwable {
  
    }

}


