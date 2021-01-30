package com.orangehrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimPage {

	public PimPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@id,'menu_pim_viewPimModule')]")
	private WebElement btn_pim;

	@FindBy(xpath = "//a[contains(@id,'menu_pim_addEmployee')]")
	private WebElement btn_addEmployee;

	@FindBy(xpath = "//input[contains(@id,'firstName')]")
	private WebElement input_firstName;

	@FindBy(xpath = "//input[contains(@id,'middleName')]")
	private WebElement input_middle;

	@FindBy(xpath = "//input[contains(@id,'lastName')]")
	private WebElement input_lastName;

	@FindBy(xpath = "//input[contains(@id,'employeeId')]")
	private WebElement input_empId;

	@FindBy(xpath = "//input[contains(@id,'btnSave')]")
	private WebElement btn_save;

	public void clickOnPim() {
		btn_pim.click();
	}
	public void empFirstName(String firstName) {
		input_firstName.sendKeys(firstName);
	}

	public void empLastName(String lastName) {
		input_lastName.sendKeys(lastName);
	}

	public void empMiddleName(String middleName) {
		input_middle.sendKeys(middleName);
	}

	public void empId(String empId) {
		input_empId.sendKeys(empId);
	}

	public void SaveBotton() {
		btn_save.click();
	}

}
