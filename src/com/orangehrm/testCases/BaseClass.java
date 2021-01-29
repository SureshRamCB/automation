package com.orangehrm.testCases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.orangehrm.testData.Data;
import com.orangehrm.utilities.ReadConfig;
import com.orangehrm.utilities.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getApplicationUrl();
	public String userName=readconfig.getuserName();
	public String passWord=readconfig.getPassword();
	public  WebDriver driver;
	
	
	
	@BeforeTest
	public static void beforeTest(ITestContext testContext) {
		Reporter.initilizeReporter(testContext.getCurrentXmlTest().getName());
		
	}
	
	@Parameters("browser")
	@BeforeClass
	public  void setup(String browser) {
		Data.logger=Logger.getLogger("automation");
		PropertyConfigurator.configure("Log4j.properties");

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Data.logger.info("Chrome driver launched sucessfully");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Data.logger.info("Firefox driver launched sucessfully");
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			Data.logger.info("Internet explorer driver launched sucessfully");
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			Data.logger.info("Edge driver launched sucessfully");
			break;

		default:
			System.out.println("The brouser that your enter "+browser+ "  is undefine please provide a valid browser");
			Assert.assertTrue(false);
			Data.logger.error("Unable to select the driver");
			System.exit(0);
			break;
		}
		driver.get(baseUrl);
		Data.logger.info("Launching Application");
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public static void  beforeMethod(Method method) {
		Reporter.createNodeForTestcase(method.getName());
	}
	//@AfterClass
	//public void teardown() {
	//	
	//	driver.quit();
//	}
	
	@AfterTest
	public static void afterTest() {
		Reporter.finalizeReport();
	}
}
