package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		features= { "C:\\demo\\eclipse\\testbook_sprint2\\src\\test\\resources\\featurefiles\\1loginwithemail.feature",
					"C:\\demo\\eclipse\\testbook_sprint2\\src\\test\\resources\\featurefiles\\2livecourse.feature",
					"C:\\demo\\eclipse\\testbook_sprint2\\src\\test\\resources\\featurefiles\\3transactions.feature"}
		,glue= {"stepDefinition","base"}
		//,tags= "@login,@livedisp,@liveattend,@liveaccess,@passbtndisp,@getpassclick,@paymentplans,@creditdetails,@courses"
		,tags="@login,@livecourses,@transactionsBAP"
		)

public class testRunner extends AbstractTestNGCucumberTests {

}
//C:\\demo\\eclipse\\testbook_sprint2\\src\\test\\resources\\featurefiles\\sprint2.feature

//