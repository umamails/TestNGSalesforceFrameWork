package com.training.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.CreateAccountPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class CreateAccountTest extends BaseTest {
	WebDriver driver;
	String url;
	CommonUtilities common = new CommonUtilities();
	String email;
	String browser;
	String password;
	LoginPage login;
	HomePage home;
	CreateAccountPage account;
	String expectedlastactivity ;
	String expectedmergedacct;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		url = common.getproperty("url");
		browser = common.getproperty("browser");
		email = common.getproperty("email");
		password = common.getproperty("password");
		driver = getDriver(browser);
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		account = new CreateAccountPage(driver);
		expectedlastactivity=common.getproperty("expectedlastactivity");
	 expectedmergedacct=common.getproperty(expectedmergedacct);
	}

//TC10 Create an Account
	@Test

	public void createanAccount() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		account.accountTab();

	}

//TC11 Create new view
	@Test

	public void accountNewView() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		account.accountTabNewView();
	}
	
	//TC12 Create new view
		@Test
		public void tc12EditView() {
			login.enterIntoEmail(email);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.usernameHomepage();
			String lastact=account.editView();
			assertEquals(expectedlastactivity, lastact);
			
		}
		//Tc13 Merge accounts
		@Test
		public void tc13mergeAccount() {
			login.enterIntoEmail(email);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.usernameHomepage();
			String mrgacc=account.mergeAccount();
			assertEquals(expectedmergedacct, mrgacc);
		}
		//TC14 Create account report
		@Test
		public void tc14AccountReport() {
			login.enterIntoEmail(email);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.usernameHomepage();
		}

	@AfterMethod
	public void teardown() throws IOException {
		takeScreenShot(driver);
		driver.close();
	}
}
