package com.orangehrm.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pageObjects.AdminPage;
import com.orangehrm.pageObjects.LoginPage;

public class TC_002_AdminPage extends BaseClass {
	
	@Test
	public TC_003_PimTest adminTest() throws Exception {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(passWord);
		lp.clickOnLogin();
		
		Thread.sleep(2000);
		
		AdminPage ap=new AdminPage(driver);
		ap.clickOnAdmin();
		ap.userName("suresh");
		ap.employeName("babu");
		Thread.sleep(2000);
		ap.userRole("Admin");
		ap.status("Enabled");
		
		
		if(ap.search_btn()==true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
		
		return new TC_003_PimTest(driver);
	}
	
}
