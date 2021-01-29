package com.orangehrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.testCases.BaseClass;
import com.orangehrm.testData.Data;
import com.orangehrm.utilities.EventMethods;

public class AdminPage  {


public 	WebDriver ldriver;
	public AdminPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);

	}


	@FindBy(xpath = "//a[contains(@id,'menu_admin_viewAdminModule')]")
	WebElement admin_link;

	@FindBy(xpath = "//div[contains(@id,'systemUser-information')]/div[2]/descendant::li/input[@id='searchSystemUser_userName']")
	WebElement txt_Username;

	@FindBy(xpath = "//select[@id='searchSystemUser_userType']")
	WebElement dd_userRole;

	@FindBy(xpath = "//div[contains(@id,'systemUser-information')]/div[2]/descendant::li/input[contains(@id,'searchSystemUser_employeeName_empName')]")
	WebElement txt_employeeName;

	@FindBy(xpath = "//div[contains(@id,'systemUser-information')]/div[2]/descendant::li/select[contains(@id,'searchSystemUser_status')]")
	WebElement dd_status;

	@FindBy(xpath = "//div[contains(@id,'systemUser-information')]/div[2]/descendant::fieldset/p/input[@id='searchBtn']")
	WebElement btn_search;

	@FindBy(xpath = "//table/tbody/tr/td[contains(text(),'No Records Found')]")
	WebElement no_records_found;


	public void clickOnAdmin() {
		admin_link.click();
	}
	public void userName(String system_username) {
		txt_Username.sendKeys(system_username);
	}
	public void employeName(String empName) {
		txt_employeeName.sendKeys(empName);
	}
	public void userRole(String role) {
		dd_userRole.click();
		Select select=new Select(dd_userRole);
		select.selectByVisibleText(role);

	}
	public void status(String stats) {
		Select select=new Select(dd_status);
		select.selectByVisibleText(stats);

	}

	public boolean search_btn() {
		boolean isElementPresent=false;

		btn_search.click();
		try {
			EventMethods.waitforElement_to_enable(no_records_found, 20);
			isElementPresent=true;
		} catch (Exception e) {
			System.out.println("Record found");
		}

		return isElementPresent;
	}
}
