package com.training.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class ContactsPage extends BasePage {
	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = ("//*[@id='Contact_Tab']"))
	WebElement contactclick;

	@FindBy(xpath = ("//input[@title='New']"))
	WebElement contactNew;

	@FindBy(id = "name_lastcon2")
	WebElement contactLN;

	@FindBy(id = "con4")
	WebElement contactAN;

	@FindBy(xpath = ("//input[@title='Save']"))
	WebElement contactSave;
	
	@FindBy(xpath = ("//input[@title='Save & New']"))
	WebElement contactSavenNew;

	@FindBy(xpath = ("//input[@title='Cancel']"))
	WebElement contactCancel;

	@FindBy(xpath = ("//a[@href='/ui/list/FilterEditPage?ftype=c&retURL=%2F003&cancelURL=%2F003%2Fo']"))
	WebElement contactNV;

	@FindBy(id = "fname")
	WebElement contactVN;

	@FindBy(id = "devname")
	WebElement contactUN;

	@FindBy(xpath = ("//select[@id='hotlist_mode']"))
	WebElement contactPage;

	@FindBy(xpath = ("//select[@id='fcf']"))
	WebElement contactPagedp;

	@FindBy(xpath = ("//input[@title='Go!']"))
	WebElement contactPagedpGo;
	// a[contains(text(),'Test')]
	@FindBy(xpath = ("//a[contains(text(),'Test')]"))
	WebElement rCN;

	@FindBy(xpath = ("//div[contains(text(),'You must enter a value')]"))
	WebElement errUCN;

	// TC25 Create new contact
	public void contactClick() {
		contactclick.click();
	}

	public void newContact(String lName, String accName) {
		contactclick.click();
		waitForElement(10, contactclick);
		contactNew.click();
		contactLN.sendKeys(lName);
		contactAN.sendKeys(accName);
		waitForElement(10, contactAN);
		contactSave.click();
	}

	// TC26 Create new vIEw in the Contact Page
	public void contactNewView(String conViewN, String conUniN) {
		contactclick.click();
		waitForElement(10, contactNV);
		contactNV.click();
		waitForElement(10, contactVN);
		contactVN.sendKeys(conViewN);
		contactUN.sendKeys(conUniN);
		waitForElement(10, contactUN);
		contactSave.click();
	}

	// TC27 Check recently created contact in the Contact Page
	public void newContactPage(String conP) {
		waitForElement(10, contactPage);
		contactPage.click();
		Select select = new Select(contactPage);
		select.selectByVisibleText(conP);
	}

	// Tc28 Check 'My contacts' vIEw in the Contact Page
	public void myContactPage(String myC) {
		waitForElement(10, contactPagedp);
		contactPagedp.click();
		Select select = new Select(contactPagedp);
		select.selectByVisibleText(myC);
		waitForElement(10, contactPagedpGo);
		contactPagedpGo.click();
	}

	// TC29 VIEw a contact in the contact Page
	public void viewContactPage() {
		waitForElement(10, rCN);
		rCN.click();

	}

	// TC30 Check the Error message if, the required information is not entered
	// while creating a New vIEw in Contacts
	public String errorNewcontact(String un) {
		waitForElement(10, contactNV);
		contactNV.click();
		contactUN.sendKeys(un);
		contactSave.click();
		waitForElement(10, errUCN);
		return errUCN.getText();
	}

	public String newView(String un, String contactViewName) {
		waitForElement(10, contactNV);
		contactNV.click();
		waitForElement(10, contactVN);
		contactVN.sendKeys(contactViewName);
		contactUN.sendKeys(un);
		waitForElement(10, contactCancel);
		contactCancel.click();
		waitForElement(10, contactPagedp);
		contactPagedp.click();
		Select select = new Select(contactPagedp);
		try {
		select.selectByVisibleText(un);
		} catch (NoSuchElementException e) {
			return e.getMessage();
		}
		return contactViewName;
	}
	public void newContactSavenNew(String lName, String accName) {
		contactclick.click();
		waitForElement(10, contactclick);
		contactNew.click();
		contactLN.sendKeys(lName);
		contactAN.sendKeys(accName);
		waitForElement(10, contactAN);
		contactSavenNew.click();
		
	}
}
