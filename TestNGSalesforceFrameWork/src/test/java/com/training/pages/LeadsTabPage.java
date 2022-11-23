package com.training.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class LeadsTabPage extends BasePage {
	public LeadsTabPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath=("//a[@title='Leads Tab']"))
	WebElement leads;
	
	@FindBy(id="fcf")
	WebElement leadsdpdn;
	
	@FindBy(xpath=("//option[@value='00BDn000004cmmH']"))
	WebElement dvclick;
	
	@FindBy(xpath=("//input[@title='Go!']"))
	WebElement go;
	

	@FindBy(xpath=("//option[@value='00BDn000004cmmV']"))
	WebElement tdLd;
	
	@FindBy(xpath=("//input[@title='New']"))
	WebElement leadnew;
	
	@FindBy(id=("name_lastlea2"))
	WebElement ldFN;
	@FindBy(id=("lea3"))
	WebElement ldCN;
	@FindBy(xpath=("//input[@title='Save']"))
	WebElement ldsave;
	
	
	//TC20 leadstab
	public void leadsTab(){
		leads.click();
	}
	//TC21 Validate 'View' drop down list contents
	public void leadsdropdown(){
		waitForElement(10, leadsdpdn);
		leadsdpdn.click();
		Select view = new Select(leadsdpdn);
		 List<WebElement> vew = view.getOptions();
		 // Loop to print one by one
		    for (int j = 0; j < vew.size(); j++) {
		        System.out.println(vew.get(j).getText());

		    }
		    
	}
	
	//TC22 Functionality of the Go Button and default view (Todays leads)
	public void defaultview() {
		waitForElement(10, leadsdpdn);
		leadsdpdn.click();
		Select view = new Select(leadsdpdn);
		 List<WebElement> vew = view.getOptions();
		 // Loop to print one by one
		    for (int j = 0; j < vew.size(); j++) {
		        System.out.println(vew.get(j).getText());

		    }
		    dvclick.click();
		    
	}
	public void defaultviewGo() {
		defaultview();
		go.click();
	}
	public void todayLeads() {
		tdLd.click();
		waitForElement(10, go);
		go.click();
		
	}
	public void leadsNew() {
		waitForElement(10, leadnew);
		leadnew.click();
		waitForElement(10, ldFN);
		ldFN.sendKeys("ABCD");
		ldCN.sendKeys("ABCD");
		ldsave.click();
	}
	}


