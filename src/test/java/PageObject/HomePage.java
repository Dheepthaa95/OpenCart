package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}



//Locator
	@FindBy(xpath="//span[text()='My Account']")
	WebElement MyAccount_Link;
	
	 @FindBy (xpath="//a[text()='Register']")
     WebElement Register_Link;

     @FindBy (xpath="//a[text()='Login']")
      WebElement Login_Link;
     
     
     //Actions Methods
     
     
     public void MyAccountclick() {
    	 MyAccount_Link.click();
     }
     
     public void Registrationclick() {
    	 Register_Link.click();
     }
     
     public void Loginclick() {
    	 Login_Link.click();
     }
     
     

}