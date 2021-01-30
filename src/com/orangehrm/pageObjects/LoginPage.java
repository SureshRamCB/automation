package com.orangehrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private  WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "txtUsername")
	private WebElement txtUsername;

	@FindBy(name = "txtPassword")
	private WebElement txtPassword;

	@FindBy(id = "btnLogin")
	private WebElement btnLogin;

	public void setUserName(String userName) {
		txtUsername.sendKeys(userName);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickOnLogin() {
		btnLogin.click();
	}

	public String valididateLogin() {
		return ldriver.getTitle();
	}

	public void loginmethod(String username, String password) {
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}
}
