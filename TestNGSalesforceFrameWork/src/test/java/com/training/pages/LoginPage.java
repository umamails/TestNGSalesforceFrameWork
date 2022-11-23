package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LoginPage extends BasePage {
	
	 public LoginPage(WebDriver driver) {
		 super(driver);
	 }
	
	
		@FindBy(id="username")
		WebElement email;
		
		@FindBy(xpath="//input[@id='password']")
		WebElement password;
		
		@FindBy(id="Login")
		WebElement loginButton;
		
		@FindBy(id="error")
		WebElement loginErrormessage;
		
		@FindBy(xpath="//input[@id='rememberUn']")
		WebElement rememberMe;
		
		@FindBy(xpath=("//a[contains(text(),'Forgot Your Password')]"))
		WebElement forgotpassword;
		
		@FindBy(xpath=("//input[@id='continue']"))
		WebElement passwordContinue;
		
		@FindBy(xpath=("//input[@id='un']"))
		WebElement un;
		
		
	
	public void enterIntoEmail(String stremail) {
		waitForElement(20,email);
		email.sendKeys(stremail);
	}
	
	
	public void enterIntoPassword(String strpassword) {
		password.sendKeys(strpassword);
	}
	
	public void clickOnLogin() {
		loginButton.click();
	}
	public String errorMessage()
	{
		waitForElement(20,loginErrormessage);
		return loginErrormessage.getText();
	}
	public void rememberMeCheckbox()
	{
		rememberMe.click();
	
	}
	public void loginForgotPassword() {
		forgotpassword.click();
	}
	public void loginPasswordContiune() {
		passwordContinue.click();
	}
	public void unForgotPassword(String email) {
		waitForElement(20,un);
		un.sendKeys(email);
	}
}
