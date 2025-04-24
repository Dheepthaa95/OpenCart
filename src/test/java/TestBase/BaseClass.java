package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Properties p;

	@BeforeClass (groups= {"Sanity","Master","Regression"})
	@Parameters({ "os", "browser" })

	public void SetUp(String os, String browser) throws IOException {
		
		//load file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser");
			return;
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();

	}

	@AfterClass(groups= {"Sanity","Master","Regression"})
	public void teardown() {
		driver.quit();
	}

	public String RandomString() {

		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;

	}

	public String RandomNumber() {

		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;

	}

	public String RandomAlphaNumber() {

		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return (generatedstring + generatednumber);

	}
	
	public String CaptureScreenshot(String tname) {
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetfilepath= System.getProperty("user.dir")+"\\screenshots\\"+tname+"-"+timeStamp+".png";
		File TargetFile= new File(targetfilepath);
		
		sourceFile.renameTo(TargetFile);
		return targetfilepath;
		
		
		
	}

}
