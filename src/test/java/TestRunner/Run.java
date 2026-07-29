package TestRunner;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//	@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//Features/Customer.feature", ".//Features/LoginPage.feature"}, // run multiple feature file
 //features = ".//Features/LoginPage.feature",
	//			features= ".//Features/Customer.feature",
 //	  features = ".//Features/", // to run all the feature file 
    glue = "StepDefination",
    dryRun = false,           // if it is true then it map the feature file to the step defination file 
    monochrome = true,       // used to make out is readable format
    tags="@Sanity",     //scenario under @sanity will be executed
 // tags="@Sanity or @Regression", // will Run Scenario tagged with sanity or regression 
 // tags="@Sanity and @Regression", // will Run Scenario tagged with sanity as well as regression 
 // tags="@Sanity and not @Regression", // will Run Scenario tagged with sanity but not regression 
    plugin = {"pretty","html:target/cucumber-reports/customer.html"}
)

//plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
//plugin = {"pretty","json:target/cucumber-reports/report_json.json"}
public class Run extends AbstractTestNGCucumberTests  {

}
