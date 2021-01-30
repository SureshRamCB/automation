package com.orangehrm.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.orangehrm.pageObjects.LoginPage;
import com.orangehrm.testData.Data;
import com.orangehrm.utilities.Reporter;

public class TC_001_LoginTest extends BaseClass {

	public LoginPage lp;

	@Test
	public void loginTest() {
		// driver.get(baseUrl);
		// Data.logger.info("Launching url");
		lp = new LoginPage(driver);

		lp.loginmethod(userName, passWord);
		Data.logger.info("Entered username and password and clicked on login button");

		if (lp.valididateLogin().equals("OrangeHRM")) {
			Assert.assertTrue(true);
			Data.logger.info("Login test passed");
			Reporter.writeReport(Status.PASS, "Application verify", driver, "App_Tittle");

		} else {
			Assert.assertTrue(false);
			Data.logger.info("Login test failed");
		}
	}

}
