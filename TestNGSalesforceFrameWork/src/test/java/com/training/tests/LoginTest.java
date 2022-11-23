package com.training.tests;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.log.Log;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

//Tests - Sequence of Steps

public class LoginTest extends BaseTest {

	WebDriver driver;
	String url;
	CommonUtilities common = new CommonUtilities();
	String browser;
	String email;
	String password;
	LoginPage login;
	HomePage home;
	String exppassword;
	String invalidemail;
	String invalidpassword;
	String experrormessage;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		DOMConfigurator.configure("log4j.xml");
		url = common.getproperty("url");
		browser = common.getproperty("browser");
		email = common.getproperty("email");
		exppassword = common.getproperty("loginpassworderror");
		password = common.getproperty("password");
		invalidemail = common.getproperty("invalidemail");
		experrormessage = common.getproperty("experrormessage");
		invalidpassword = common.getproperty("invalidpassword");
		driver = getDriver(browser);
		Log.info("url of the application" +url);
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		Log.startTestCase("TestCase started");
		
	}

//TC01 Login Error Message - 1
	@Test
	public void loginwithinvalidUsername() {
		
		login.enterIntoEmail(email);
		login.enterIntoPassword("");
		login.clickOnLogin();
		String display = login.errorMessage();
		System.out.println("Error message is: " + display);
		Assert.assertEquals(exppassword, display);
		
	}

//TC02 Login to SFDC
	@Test
	public void loginwithValidUsername() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		// home.clickHome();
	}

//TC03 Test the remember username check box
	@Test
	public void loginRememberMe() throws InterruptedException {

		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.rememberMeCheckbox();
		login.clickOnLogin();
		home.usernameHomepage();
		home.logoutHomepage();
		Thread.sleep(2000);
	}

//TC04A Test forgot password
	@Test
	public void loginPageforgotpassword() {
		login.loginForgotPassword();
		login.unForgotPassword(email);
		login.loginPasswordContiune();
	}

//TC4B ValidateLoginErrorMessage
	@Test
	public void invalidUserInfo() {

		login.enterIntoEmail(invalidemail);
		login.enterIntoPassword(invalidpassword);
		login.clickOnLogin();
		String display = login.errorMessage();
		System.out.println("Error message is: " + display);
		Assert.assertEquals(experrormessage, display);
	}

	@AfterMethod
	public void teardown() throws IOException {
		Log.endTestCase("Testcase ended");
		takeScreenShot(driver);
		driver.close();
	}

}
