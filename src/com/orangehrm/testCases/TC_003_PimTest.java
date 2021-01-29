package com.orangehrm.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.orangehrm.pageObjects.PimPage;

public class TC_003_PimTest {
	public WebDriver driver;

	public TC_003_PimTest(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@Test
	public void pimTest() {

		PimPage pp = new PimPage(driver);
		pp.clickOnPim();
		pp.empFirstName("Suresh");
		pp.empMiddleName("Babu");
		pp.empLastName("CB");
		pp.empId("27A1");

	}

}
