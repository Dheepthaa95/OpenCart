package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement txt_firstname;
	@FindBy (xpath="//input[@name='lastname']")
	WebElement txt_lastname;
	@FindBy (xpath="//input[@name='email']")
	WebElement txt_email;
	@FindBy (xpath="//input[@name='telephone']")
	WebElement txt_telephone;
	@FindBy (xpath="//input[@name='password']")
	WebElement txt_pwd;
	@FindBy (xpath="//input[@name='confirm']")
	WebElement txt_Confirm_pwd;
	@FindBy (xpath="//input[@name='agree']")
	WebElement agree_btn;
	@FindBy (xpath="//input[@class='btn btn-primary']")
	WebElement cont_btn;
	@FindBy (xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirm_msg;
	
	//Actions
	
	public void setfirstname(String fname) {
		
		txt_firstname.sendKeys(fname);
		
	}
	
public void setlastname(String lname) {
		
	txt_lastname.sendKeys(lname);
		
	}
	public void email(String Email) {
		
		txt_email.sendKeys(Email);
		
	}
	
	public void telephone(String tel) {
		
		txt_telephone.sendKeys(tel);
		
	}
	
 public void password(String pwd) {
		
	txt_pwd.sendKeys(pwd);
		
	}
 
 public void confirm_password(String pwd) throws InterruptedException {
	 
	 Thread.sleep(3000);
	 txt_Confirm_pwd.sendKeys(pwd);
			
		}
	public void agree_btn() {
		agree_btn.click();
		
	}
	
	public void  cntn_btn() throws InterruptedException {
		 Thread.sleep(3000);
		cont_btn.click();
	}
	
	public String getConfirmationmsg() {
		
		try
		{
			return(confirm_msg.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}

			

}
