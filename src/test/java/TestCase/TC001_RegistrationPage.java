package TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.RegistrationPage;
import TestBase.BaseClass;

public class TC001_RegistrationPage extends BaseClass
{
	
	@Test(groups= {"Sanity","Master","Regression"})
	
public void Registration_page() throws InterruptedException{

	HomePage hp=new HomePage(driver);
	hp.MyAccountclick();
	hp.Registrationclick();
	
	RegistrationPage rp=new RegistrationPage(driver);
	rp.setfirstname(RandomString().toUpperCase());
	rp.setlastname(RandomString().toUpperCase());
	rp.email(RandomString()+"@gmail.com");
	rp.telephone(RandomNumber());
	
	String password= RandomString();
	rp.password(password);
	rp.confirm_password(password);
	rp.agree_btn();
	rp.cntn_btn();
	String confirm_msg=rp.getConfirmationmsg();
	Assert.assertEquals(confirm_msg, "Your Account Has Been Created!");
		

	
}
}