package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BasePage {

	public Loginpage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy (xpath="//input[@name='email']")
	WebElement txt_email;
	@FindBy (xpath="//input[@name='password']")
	WebElement txt_pwd;
	@FindBy (xpath="//input[@class='btn btn-primary']")
	WebElement login_btn;
	
	//Actions Method
	
	public void email(String email) {
		txt_email.sendKeys(email);
		
	}
	
	public void password(String pwd) {
		txt_pwd.sendKeys(pwd);
		
	}
	
	public void clicklogin() {
		login_btn.click();
	}

}
