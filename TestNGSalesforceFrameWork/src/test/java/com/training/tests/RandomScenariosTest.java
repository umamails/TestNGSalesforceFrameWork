package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.RandowScenariosPage;
import com.training.utilities.CommonUtilities;

public class RandomScenariosTest extends BaseTest {
	WebDriver driver;
	String url;
	CommonUtilities common = new CommonUtilities();
	String email;
	String browser;
	String password;
	LoginPage login;
	HomePage home;
	RandowScenariosPage randow;

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
		randow = new RandowScenariosPage(driver);
	}

	@Test
	public void TC33homeUserNameLink() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		randow.homeTabLink();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		home.usernameHomepage();
		randow.profilePage();
	}

	@Test
	public void TC34editUserName() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		randow.homeTabLink();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(randow.myProfileUsermenu());
		randow.editHomeTabLink();

	}

	@Test
	public void TC35tabCustomization() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		randow.tabCustomization();
		home.usernameHomepage();
		home.logoutHomepage();
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
	}

	@Test
	public void TC36BlockingCalender() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickHome();
		randow.BlockingCalender();
	}
	@Test
	public void TC37BlockingCalender() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickHome();
		randow.BlockingCalenderweekly();
		
	}

	@AfterMethod
	public void teardown() throws IOException {
		takeScreenShot(driver);
		driver.close();
	}
}