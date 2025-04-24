package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends BasePage {

	public Myaccountpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locator
	@FindBy (xpath="//h2[text()='My Account']")
	WebElement MyAccount_text;
	
	@FindBy (xpath="//a[@class='list-group-item'][text()='Logout']")
	WebElement Logout;
	
	//Action Methods
	
	public boolean Myaccount() {
		
		
		try {
			return(MyAccount_text.isDisplayed());
		}
		
		catch (Exception e)
		{
			return false;
		}
	
				
	}
	
	public void logout() {
		Logout.click();
	}
	
	

}
