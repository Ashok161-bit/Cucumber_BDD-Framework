package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.hc.client5.http.config.RequestConfig;
import org.openqa.selenium.WebDriver;

import PageObjects.AddNewCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.core.logging.Logger;



/*Parent Class*/
public class BaseClass {
	public static  WebDriver driver;
	public LoginPage lg;
	public SearchCustomerPage search;
	public AddNewCustomerPage cust;
	public static Logger log;
	public ReadConfig readConfig;
	//generate unique email id
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
	
}
