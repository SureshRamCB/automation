package com.orangehrm.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.orangehrm.pageObjects.LoginPage;
import com.orangehrm.testData.Data;
import com.orangehrm.utilities.Reporter;

public class TC_001_LoginTest extends BaseClass {

	@Test
	public void loginTest() {
		//driver.get(baseUrl);
		//Data.logger.info("Launching url");
		LoginPage lp=new LoginPage(driver);

		lp.setUserName(userName);
		Data.logger.info("Enterd username");
		
		lp.setPassword(passWord);
		Data.logger.info("Enterd password");
		
		lp.clickOnLogin();
		Data.logger.info("Cleck on login button");
		
		if(lp.valididateLogin().equals("OrangeHRM")) {
			Assert.assertTrue(true);
			Data.logger.info("Login test passed");
			Reporter.writeReport(Status.PASS, "Application verify", driver, "App_Tittle");
			
		}else {
			Assert.assertTrue(false);
			Data.logger.info("Login test failed");
		}
		
		
	}
	
	

}
