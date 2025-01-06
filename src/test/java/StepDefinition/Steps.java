package StepDefinition;

import java.util.logging.LogManager;

import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.AddNewCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.core.logging.Logger;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class Steps extends BaseClass {

	

	@Before
	public void setup1()
	{
		readConfig = new ReadConfig();	
		
		//initialise logger
		log = Logger.getLogger("Steps");

		System.out.println("Setup-Sanity method executed..");

		String browser = readConfig.getBrowser();
		
		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

	
		log.fatal("Setup1 executed...");


	}

	
	
  
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		Log.info("url open");
	}

	@When("User enters Email as\"admin@yourstore.com\" and Password as\"admin\"")
	public void user_enter_Email_password(String email, String password) throws InterruptedException {
		lg.SetUserName(email);
		lg.SetUserPassword(password);
		Thread.sleep(3000);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		lg.clicklogin();
		Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String actualtitle) {

		if(driver.getPageSource().contains("Login was unsuccessful")) {
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(actualtitle, driver.getTitle());
		}

	}

	@When("user click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		lg.ClickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	}

	//////Add new Customer///////


	@Then("user can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle=cust.getPageTitle();
		String expectedTitle="Dashboard / nopCommerce administration";
		if(actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}

	@When("user click on customer menu")
	public void user_click_on_customer_menu() {
		cust.clickOnCustomersMenu();

	}

	@When("click on customer Menu Item")
	public void click_on_customer_menu_item() {
		cust.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		cust.clickOnAddnew();
	}

	@Then("user can view Add new Customer Page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle=cust.getPageTitle();
		String expectedTitle="Add a new customer / nopCommerce administration";
		if(actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true); //pass
		} else {
			Assert.assertTrue(false); //fail
		}
	}

	@When("user  enter custmer Info")
	public void user_enter_custmer_info() {
		//cust.enterEmail("test1@gmail.com");
		cust.enterEmail(generateEmailId() + "@gmail.com");
		cust.enterPassword("test1");
		cust.enterFirstName("Ashok");
		cust.enterLastName("Pinninti");
		cust.enterGender("Male");
		cust.enterDob("6/4/1995");
		cust.enterCompanyName("Code Studio");
		cust.enterAdminContent("Admin contant");
		cust.enterManagerOfVendor("vendor2");

	}

	@When("click on save button")
	public void click_on_save_button() {
		cust.clickOnSave();
	}

	@Then("user can view confirmation message\"The new customer has been added successfuly\"")
	public void user_can_view_confirmation_message_the_new_customer_has_been_added_successfuly(String expectedconfMess) {

		String bodyTag= driver.findElement(By.tagName("Body")).getText();
		if(bodyTag.contains(expectedconfMess)) {
			Assert.assertTrue(true); //pass
		}else {
			Assert.assertTrue(false); //fail
		}
	}

	///// search customer page/////

	@When("Enter customer EMail")
	public void enter_customer_e_mail() {

		search.enterEmailAdd("Victoria_victoria@nopcommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		search.SearchButton();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail="Victoria_victoria@nopcommerce.com";

		if(  search.searchcustomerByEmail(expectedEmail)==true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}


	}


	///Search customer By Name////

	@When("Enter customer FirstName")
	public void enter_customer_first_name() {

		search.FirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		search.lastName("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName="Victoria Terces";

		if(  search.searchcustomerByName(expectedName)==true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}



	}


	@Then("close broswer")
	public void close_broswer() {


	}


}
