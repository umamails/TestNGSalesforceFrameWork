package com.training.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.CreateAccountPage;
import com.training.pages.CreateOptyPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class CreateOptyTest extends BaseTest {
	WebDriver driver;
	String url;
	CommonUtilities common = new CommonUtilities();
	String email;
	String browser;
	String password;
	String expectedViewOptyDropDown;
	String oppName;
	LoginPage login;
	HomePage home;
	CreateOptyPage createOpty;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		url = common.getproperty("url");
		browser = common.getproperty("browser");
		email = common.getproperty("email");
		password = common.getproperty("password");
		expectedViewOptyDropDown = common.getproperty("expectedViewOptyDropDown");
		oppName = common.getproperty("oppName");
		driver = getDriver(browser);
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		createOpty = new CreateOptyPage(driver);
	}

	// TC15 opportunities drop down
	@Test
	public void tc15OpportunitiesDropDown() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		createOpty.clickOpty();
		String actualViewOptyDropDown = createOpty.viewOptyDropDown();
		assertEquals(actualViewOptyDropDown, expectedViewOptyDropDown);
	}
	
	@Test
	public void tc16CreateNewOpty() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		createOpty.clickOpty();
		createOpty.clickNewOpty();
		createOpty.createNew(oppName);
	}

	@Test
	public void tc17OptyPipeline() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		createOpty.clickOpty();
		createOpty.clickOptyPipeline();
	}
	
	@Test
	public void tc18StuckOpp() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		createOpty.clickOpty();
		createOpty.clickStuckOpp();
	}
	@Test
	public void tc19QuarterlySummary() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		createOpty.clickOpty();
		createOpty.quarterlySummary();
	}
	
	@AfterMethod
	public void teardown() throws IOException {
		takeScreenShot(driver);
		driver.close();
	}
}
