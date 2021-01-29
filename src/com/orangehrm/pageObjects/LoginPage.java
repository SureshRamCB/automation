package com.orangehrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(name="txtUsername")
	WebElement txtUsername;

	@FindBy(name="txtPassword")
	WebElement txtPassword;

	@FindBy(id="btnLogin")
	WebElement btnLogin;


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


}

