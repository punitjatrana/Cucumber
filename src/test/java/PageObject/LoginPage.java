package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	// xpath
   @FindBy(xpath="//input[@placeholder='Username']")
   WebElement email;

   @FindBy(xpath="//input[@placeholder='Password']")
   WebElement password;

   @FindBy(xpath="//button[@type='submit']")
   WebElement btnLogin;
   
 
   
   @FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
   WebElement logoutdrop;

   @FindBy(xpath="//a[normalize-space()='Logout']")
   WebElement logoutbtn;
	
   
   // action methods
   public void enterEmail(String emailAdd) {
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	} 
	public void clickLogin()  {
		btnLogin.click();
			
	}
	
	public void clickLogout() {
		logoutdrop.click();
		logoutbtn.click();
	}
	
	
}
