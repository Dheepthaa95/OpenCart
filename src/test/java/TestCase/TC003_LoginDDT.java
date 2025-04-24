package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.Loginpage;
import PageObject.Myaccountpage;
import TestBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="Logindata",dataProviderClass=DataProviders.class)
	
	public void verify_Login(String email,String pwd,String exp) throws InterruptedException {
		
		try {
		 HomePage hp=new HomePage(driver);
		 hp.MyAccountclick();
		 hp.Loginclick();
		 
		 Loginpage lp=new Loginpage(driver);
		 lp.email(email);
		 lp.password(pwd);
		 lp.clicklogin();
		 
		 Myaccountpage macc= new Myaccountpage(driver);
		 boolean targetpage=macc.Myaccount();
		 
		 if(exp.equalsIgnoreCase("Valid")) {
			 if(targetpage==true) {
				 macc.logout();
				 Assert.assertTrue(true);
			 }
			 
			 else {
				 Assert.assertTrue(false);;
			 }
		 }
		 
		 if (exp.equalsIgnoreCase("Invalid")) {
			 if(targetpage==true) {
				 Assert.assertTrue(false);
			 }
			 else {
				 Assert.assertTrue(true);
			 }
		 }
		}
		catch(Exception e) {
			Assert.fail();
		}
		 
		 Thread.sleep(3000);
		 
		 
	}
	
	

}
