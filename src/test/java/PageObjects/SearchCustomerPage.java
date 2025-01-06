package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	public WebDriver driver;

	public SearchCustomerPage(WebDriver driver) {

		//initiallzation
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(id="SearchEmail")
	WebElement emailAdd;

	@FindBy(id="search-customers")
	WebElement searchBtn;

	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(id="SearchFirstName")
	WebElement firstName;

	@FindBy(id="SearchLastName")
	WebElement lastName;

	///action Methods////
	public void enterEmailAdd(String email) {
		emailAdd.sendKeys(email);
	}
	public void SearchButton () {
		searchBtn.click();
	}
	public boolean searchcustomerByEmail(String email) {

		boolean found=false;
		//total no of rows
		int ttRows= tableRows.size();

		for(int i=2;i<ttRows;i++) {

			WebElement WebElementEmail=driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+ i +"]/td[2]"));
			String actualEmail=WebElementEmail.getText();

			if(actualEmail.equals(email)) {
				found=true;
			}

		}

		return found;
	}
	///// Search customer by Name/////

	public void FirstName(String firstNameText) {
		firstName.sendKeys(firstNameText);

	}

	public void lastName(String lastNameText) {
		lastName.sendKeys(lastNameText);

	}
	public boolean searchcustomerByName(String Name) {

		boolean found=false;
		//total no of rows
		int ttRows= tableRows.size();

		for(int i=2;i<ttRows;i++) {

			WebElement WebElementName=driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+ i +"]/td[3]"));
			String actualName=WebElementName.getText();

			if(actualName.equals(Name)) {
				found=true;
				
			}

		}

		return found;
	}

}
