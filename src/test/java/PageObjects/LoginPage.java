package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		//initiallzation
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="Email")
	@CacheLookup
	WebElement userEmail;
	 
	@FindBy(id="Password")
	@CacheLookup
	WebElement userpassword;
	 
	@FindBy(xpath="//button[@class='button-1 login-button']")
	@CacheLookup
	WebElement Login;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement logout;
	
	public void SetUserName(String uname) {
		userEmail.clear();
		userEmail.sendKeys(uname);
	}
	public void SetUserPassword(String Pwd) {
		userpassword.clear();
		userpassword.sendKeys(Pwd);
	}
	public void clicklogin() {
		Login.click();
	}
	public void ClickLogout() {
		logout.click();
	}
}
