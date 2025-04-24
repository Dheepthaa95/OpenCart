package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.Loginpage;
import PageObject.Myaccountpage;
import TestBase.BaseClass;

public class TC002_Loginpage extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	
	public void login() {
		
		try {
		HomePage hp=new HomePage(driver);
		hp.MyAccountclick();
		hp.Loginclick();
		
		Loginpage lp= new Loginpage(driver);
		lp.email(p.getProperty("email"));
		lp.password(p.getProperty("pwd"));
		lp.clicklogin();
		
		Myaccountpage maccp=new  Myaccountpage(driver);
		boolean targetpage= maccp.Myaccount();
		Assert.assertTrue(targetpage);
		
		maccp.logout();
		}
		
		catch(Exception e) {
			
			Assert.fail();
		}
		
		
	}
	
}
