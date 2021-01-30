package com.orangehrm.testCases;

import org.testng.annotations.Test;

import com.orangehrm.pageObjects.LoginPage;
import com.orangehrm.pageObjects.PimPage;

public class TC_003_PimTest extends BaseClass {

	public LoginPage lp;
	public PimPage pp;

	@Test
	public void pimTest() {

		lp = new LoginPage(driver);
		lp.loginmethod(userName, passWord);//I created login method

		pp = new PimPage(driver);
		pp.clickOnPim();
		pp.empFirstName("Suresh");
		pp.empMiddleName("Babu");
		pp.empLastName("CB");
		pp.empId("27A1");
	}
}
