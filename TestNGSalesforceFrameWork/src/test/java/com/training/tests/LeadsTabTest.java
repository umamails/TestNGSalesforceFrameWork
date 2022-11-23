package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LeadsTabPage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class LeadsTabTest extends BaseTest {
	WebDriver driver;
	String url;
	CommonUtilities common = new CommonUtilities();
	String email;
	String browser;
	String password;
	LoginPage login;
	HomePage home;
	LeadsTabPage leads;

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
		leads = new LeadsTabPage(driver);

	}

	@Test
	public void TC20leadsTab() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		leads.leadsTab();
	}

	@Test
	public void TC21leadsTab() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		leads.leadsTab();
		leads.leadsdropdown();
	}

	@Test
	public void TC22ledsTab() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		leads.leadsTab();
		leads.leadsdropdown();
		leads.defaultview();
		home.usernameHomepage();
		home.usermenudropdown();
		home.logoutHomepage();
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		leads.leadsTab();
		leads.defaultviewGo();
	}

	@Test
	public void TC23todayleads() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		leads.leadsTab();
		leads.leadsdropdown();
		leads.todayLeads();
	}

	@Test
	public void TC24leadsNew() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		leads.leadsTab();
		leads.leadsNew();
	}

	@AfterMethod
	public void teardown() throws IOException {
		takeScreenShot(driver);
		driver.close();
	}
}
