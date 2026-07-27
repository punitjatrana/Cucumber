package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
//import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass {
//	public WebDriver driver;
//	public LoginPage loginpg;
//	public AddNewCustomerPage addnewcustomerpage;
//	public SearchCustomerPage customerPage;
//	public ReadConfig readConfig;
	
	@Before("@Sanity")
	public void setup1() throws IOException  {
		readConfig = new ReadConfig();
		
		String browser = readConfig.getBrowser();
		switch(browser.toLowerCase()) {
		case "chrome" : 
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 break;
		case "firefox" :	
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); break;
		case "edge" :
   //			WebDriverManager.edgedriver().setup();
			 System.setProperty("webdriver.edge.driver",
		                "C:\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default : System.out.println("Invalid Browser name"); return;
		}
		
		 log = LogManager.getLogger("StepDef");
	     System.out.println("setup1  method is executed");
		
		 log.info("setup 1 executed");
	}
	
	/*
	 * @Before("@Regression") public void setup2() {
	 * System.out.println("setup2 method is executed");
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); }
	 */
	
	@Given("User launches Chrome browser")
	public void user_launches_chrome_browser() {
		
		 loginpg = new LoginPage(driver);
		 addnewcustomerpage = new AddNewCustomerPage(driver);
		 customerPage = new SearchCustomerPage(driver);
		 log.info("user launch browser ");
		 
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
	   driver.get(url);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	   log.info("URL open");
	}

	

	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String emailadd, String passwordadd) {
		loginpg.enterEmail(emailadd);
		loginpg.enterPassword(passwordadd);
		 log.info("enter email and password");
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		loginpg.clickLogin();
		Thread.sleep(2000);
		 log.info("click on login");
	}

	@Then("User should see home page url as {string}")
	public void user_should_see_home_page_url_as(String expectedUrl) throws InterruptedException {
		 String actualTitle = driver.getCurrentUrl();
		   System.out.println(actualTitle);
		   Assert.assertEquals(expectedUrl, actualTitle);
		   log.info("home is opened");
		   
	}

	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() {
		loginpg.clickLogout();
		 log.info("logout from page");
	}
	
	
	
	
	///////////////////// Add New Customer///////////////////////////
	

@When("User navigates to the PIM module")
public void user_navigates_to_the_pim_module() throws InterruptedException {
	addnewcustomerpage.clickPim();
	Thread.sleep(3000);
}

@When("User clicks on the Add Employee button")
public void user_clicks_on_the_add_employee_button() throws InterruptedException {
	addnewcustomerpage.clickadd();
	Thread.sleep(3000);
}


@When("User enters employee details")
public void user_enters_employee_details() throws InterruptedException {
	//addnewcustomerpage.addFirstName("TTester");
	addnewcustomerpage.addFirstName(generateFirst());
	addnewcustomerpage.ImgAdd("C:\\Users\\Admin\\Pictures\\Punit.jpg");
	
	addnewcustomerpage.addLastName("QA");
	 log.info("customer information enter");
}

@When("User clicks on the Save button")
public void user_clicks_on_the_save_button() throws InterruptedException {
	addnewcustomerpage.saveData();
	
}

/////////////////////// Search Employee////////////////
	
@When("user enter employee Name")
public void user_enter_employee_name() throws InterruptedException {
	customerPage.enterName("TTester");
	Thread.sleep(3000);
	 log.info("search employee"); 
}

@When("user click on search button")
public void user_click_on_search_button() {
	customerPage.clickOnSearchBtn();
}

@After( )  // execute 1st
public void teardown(Scenario sc) {
	System.out.println("teardown method is executed");
	if(sc.isFailed()==true) {
		// convert webdriver object to Takescreenshot
		String fileWithPath = "C:\\Users\\Admin\\eclipse-workspace\\CucumberJava\\Screenshot\\failure.png";
		TakesScreenshot srcShot = ((TakesScreenshot)driver);
		
		// call getScreenshot method to create image file
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		
		// copy file at destination
		try {
			FileUtils.copyFile(srcFile, DestFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}

/*
 * @After(order=1) // execute 2nd public void teardown2() {
 * System.out.println("teardown method is executed"); driver.quit(); }
 */

// execute before and after each step in scenario file 

//@BeforeStep
//public void beforeStepMethod() {
//	System.out.println("This is before step..");
//}
//
//@AfterStep
//public void afterStepMethod() {
//	System.out.println("This is after step..");
//}
}
