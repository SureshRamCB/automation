package com.orangehrm.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pageObjects.AdminPage;
import com.orangehrm.pageObjects.LoginPage;

public class TC_002_AdminPage extends BaseClass {

	public LoginPage lp;
	public AdminPage ap;

	@Test
	public void adminTest() throws Exception {
		lp = new LoginPage(driver);
		lp.loginmethod(userName, passWord);//I created login method

		Thread.sleep(2000);

		ap = new AdminPage(driver);
		ap.clickOnAdmin();
		ap.userName("suresh");
		ap.employeName("babu");
		Thread.sleep(2000);
		ap.userRole("Admin");
		ap.status("Enabled");

		if (ap.search_btn() == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(true);
		}
	}
}
