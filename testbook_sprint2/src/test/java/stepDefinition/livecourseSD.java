package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pages.Liveandcourses;
import pages.commonpage;

import org.junit.runner.RunWith;
import base.Testbook_Base;


public class livecourseSD {
	
	commonpage tp1=new commonpage();
	LoginwithemailSD lg=new LoginwithemailSD();
	Liveandcourses lc=new Liveandcourses();
		
	//live classes btn disp
    @Given("^user on home page$")
    public void user_on_home_page() throws Throwable {
       tp1.onhomepage();
    }

    @Then("^live classes displayed on right$")
    public void live_classes_displayed_on_right() throws Throwable {
    	lc.liveicondisp();
    }
    
    //livedisp
    @When("^click on live classes$")
    public void click_on_live_classes() throws Throwable {
        //System.out.println("sd clicking onlive classes");
        lc.liveclassesclick();

    }

    @Then("^live classes are shown$")
    public void live_classes_are_shown() throws Throwable {
        //System.out.println("sd show onlive classes");
    	lc.liveclassesshow();
    }
    
    //liveclassesaccess
    @Given("^user in live classes tab$")
    public void user_in_live_classes_tab() throws Throwable {
        System.out.println("User already on live classes Waiting to click a live videos");
    }

    @When("^click on one live class$")
    public void click_on_one_live_class() throws Throwable {
    	lc.clicklivevideo();
    }

    @Then("^user can attend live class$")
    public void user_can_attend_live_class() throws Throwable {
       System.out.print("user can attend live class");
    }

 

}