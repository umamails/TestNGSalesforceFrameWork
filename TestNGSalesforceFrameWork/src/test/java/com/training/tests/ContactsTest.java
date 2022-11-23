package com.training.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.ContactsPage;
import com.training.pages.HomePage;
import com.training.pages.LeadsTabPage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class ContactsTest extends BaseTest {
	WebDriver driver;
	String url;
	CommonUtilities common = new CommonUtilities();
	String email;
	String browser;
	String password;
	LoginPage login;
	HomePage home;
	ContactsPage contact;
	String conViewN;
	String conUniN;
	String conP;
	String myC;
	String un;
	String exptECUN;
	String viewName;
	String lName;
	String accName;

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
		contact = new ContactsPage(driver);
		conViewN = common.getproperty("contactViewName");
		conUniN = common.getproperty("contactUniqueName");
		conP = common.getproperty("NewContactSelect");
		myC = common.getproperty("mycontactDropDown");
		un = common.getproperty("errorcontactUniqueName");
		exptECUN = common.getproperty("expterrorcontactUniqueName");
		viewName = common.getproperty("viewName");
		lName=common.getproperty("lName");
		accName=common.getproperty("accName");
	}

	@Test
	public void TC25newcontact() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		contact.newContact(lName, accName);
	}

	@Test
	public void TC26newViewcontact() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		contact.contactNewView(conViewN, conUniN);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void TC27newcontactPage() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		contact.contactClick();
		contact.newContactPage(conP);
	}

	@Test
	public void TC28Mycontacts() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		contact.contactClick();
		contact.myContactPage(myC);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void TC29Mycontacts() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		contact.contactClick();
		contact.viewContactPage();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void TC30Mycontacts() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();
		contact.contactClick();
		String actualECUN = contact.errorNewcontact(un);

		assertEquals(exptECUN, actualECUN);
		System.out.println("error message is: " + actualECUN);
	}

	@Test
	public void TC31CheckCancel() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();

		contact.contactClick();
		String errorMessage = contact.newView(un, viewName);
		assertNotEquals(errorMessage, viewName);
	}

	@Test
	public void TC32SaveNewContact() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.usernameHomepage();

		contact.newContactSavenNew(lName, accName);
	}
	@AfterMethod
	public void teardown() throws IOException {
		takeScreenShot(driver);
		driver.close();
	}

}
