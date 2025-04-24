package utilities;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;

public class ExtendReportManager implements ITestListener{
	public ExtentSparkReporter SparkReporter;
	public ExtentReports Extent;
	public ExtentTest test;
	
	String repname;
	
	public void onStart(ITestContext context) {
		// for time stamp
		/*
		 * simpleDateFormat df=new simpleDateFormat("yyyy.MM.dd.HH.mm.ss");//use to give time format
		 *Date dt= new Date();// class in java for date
		 *String currentdate=df.format(dt);
		 */
		//instead of 3 lines we can do like below
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		//giving report name
		repname= "Test Report-"+timestamp+".html";
		SparkReporter= new ExtentSparkReporter(".\\report\\"+repname);
		
		SparkReporter.config().setDocumentTitle("Opencart Report");
		SparkReporter.config().setReportName("Test case result");
		SparkReporter.config().setTheme(Theme.DARK);
		
		Extent=new ExtentReports();
		Extent.attachReporter(SparkReporter);
		Extent.setSystemInfo("Application", "Open Cart");
		Extent.setSystemInfo("Username",System.getProperty("user.name"));//to get the name of user
		Extent.setSystemInfo("Environment", "QA");
		
		String os= context.getCurrentXmlTest().getParameter("os");//getting OS name from xml file
		Extent.setSystemInfo("Operating System", os);
		
		String browser=context.getCurrentXmlTest().getParameter("browser");
		Extent.setSystemInfo("browser", browser);
		
		List<String> includeGroups= context.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroups.isEmpty()){
			
			Extent.setSystemInfo("Groups",includeGroups.toString());
		}
		}
	public void onTestSuccess(ITestResult result) {
			test=Extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());//to display groups in report
			test.log(Status.PASS, result.getName() + " Test Case is Passed:");
		}
	public void onTestFailure(ITestResult result) {
		test=Extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+" Test Case is Failed :");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
	
	//attaching SS 
	
	try {
		String imgpath= new BaseClass().CaptureScreenshot(result.getName());
		test.addScreenCaptureFromPath(imgpath);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public void onTestSkipped(ITestResult result) {
		test=Extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" Test Case  is Skipped:");
		test.log(Status.INFO,result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext context) {
		Extent.flush();
		
		//open the report automatically
		String pathOFExtentReport=System.getProperty("user.dir")+"\\Report\\"+repname;
		File ExtentReport= new File(pathOFExtentReport);
		
		try {
			Desktop.getDesktop().browse(ExtentReport.toURI());//open the report on browser
		}
		
		catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
		
	

}
