package com.training.tests;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeTest extends BaseTest {
	WebDriver driver;
	String url;
	CommonUtilities common = new CommonUtilities();
	String email;
	String browser;
	String password;
	LoginPage login;
	HomePage home;
	String downloadPath;
	
	
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
		downloadPath=common.getproperty("downloadPath");
	
	}
	//TC05 Select user menu for <username> drop down
	@Test
	public void userMenuDropDown() throws InterruptedException {
		
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		home.usermenudropdown();	
	}
	//TC06 Select "My Profile" option from user menu for <username> drop down
	//not finished
	@Test
	public void MyProfiledropdown() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		home.usermenudropdown();
		driver.switchTo().frame(home.myProfileUsermenu());
		home.myProfileAboutTab();
		driver.switchTo().frame(home.myProfileEditPost());
		home.myProfileEditPost1();
		driver.switchTo().frame("");
		
	}
	//TC07 Select "My settings" option from user menu for <username> drop down
	@Test
	public void mysettingsdropdown() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		home.usermenudropdown();
		home.mySettingsUsermenu(downloadPath);
		//isFileDownloaded(String downloadPath, String fileName);
	}
	//TC08 Select "Developers Console" option from user menu for <username> drop down
	@Test
	public void DeveloperConsoledropDown() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		home.usermenudropdown();
		home.developerConsoleUsermenu();		
		Set<String> getAllWindows=driver.getWindowHandles();
		String[] window=getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(window[1]).close();
		driver.switchTo().window(window[0]);
		
		System.out.println("TC_8_Selectdeveloperconsole completed");
	}
	
	//TC09 Select "Logout" option from user menu for <username> drop down
	@Test
	public void logOutdropDown() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		home.usermenudropdown();
	    home.logoutHomepage();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void teardown() throws IOException {
		takeScreenShot(driver);
		driver.close();
	}
}
