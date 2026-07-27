package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	
WebDriver driver;
	
	
	public SearchCustomerPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement fullname;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchbtn;
	
	
	
	public void enterName(String name) {
		fullname.sendKeys(name);
	}
	
	public void clickOnSearchBtn() {
		searchbtn.click();
	}
}
