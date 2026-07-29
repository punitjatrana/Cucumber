package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewCustomerPage {

WebDriver driver;
	
	
	public AddNewCustomerPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='PIM']")
	WebElement PIM;
	
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement ADDEmp;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement EnterFirstname;
	
	@FindBy(xpath="//input[@type='file' and contains(@class,'file')]")
	WebElement fileInput;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement EnterLastname;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement savebtn;
	
	// action method 
	
	public void clickPim() {
		PIM.click();
	}
	
	public void clickadd() {
		ADDEmp.click();
	    
	}
	
	public void addFirstName(String firstname) {
		EnterFirstname.sendKeys(firstname);
	}
	
	public void ImgAdd(String image) {

	    WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));

	    // Make hidden element visible
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].style.display='block';", fileInput);

	    // Upload file
	    fileInput.sendKeys(image);
	}
	public void addLastName(String lastName) {
		EnterLastname.sendKeys(lastName);
	}
	
	public void saveData() {
		savebtn.click();
	}
	
	
}
