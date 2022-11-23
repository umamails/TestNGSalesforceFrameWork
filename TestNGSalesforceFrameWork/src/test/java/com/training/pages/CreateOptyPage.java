package com.training.pages;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class CreateOptyPage extends BasePage {
	public CreateOptyPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//li[@id='Opportunity_Tab']")
	WebElement accTab;
	
	
	@FindBy(xpath="//select[@id='fcf']")
	WebElement viewOpty;
	
	@FindBy(xpath="//input[contains(@title,'New')]")
	WebElement newButton;
	
	@FindBy(id="opp3")
	WebElement oppName;
	
	@FindBy(id="opp4")
	WebElement accName;
	
	@FindBy(xpath="//img[@title='Account Name Lookup (New Window)']")
	WebElement lookupWindow;
	
	@FindBy(id="lksrch")
	WebElement lksrch;
	
	@FindBy(xpath="//input[@name='go']")
	WebElement go;
	
	@FindBy(xpath="//tr[@class='dataRow even last first']/th/a")
	WebElement dataRow;
	
	@FindBy(id="opp9")
	WebElement closeDate;
	
	@FindBy(xpath="//a[@class='calToday']")
	WebElement today;
	
	@FindBy(xpath="//select[@id='opp11']")
	WebElement stage;
	
	@FindBy(xpath="//input[@id='opp12']")
	WebElement probability;
	
	@FindBy(xpath="//select[@id='opp6']")
	WebElement leadSource;
	
	@FindBy(xpath="//input[@title='Save']")
	WebElement save;
	
	@FindBy(xpath="//img[@title='Primary Campaign Source Lookup (New Window)']")
	WebElement prmyCampaignSource;
	
	@FindBy(xpath="//a[contains(text(),'Opportunity Pipeline')]")
	WebElement optyPipeline;
	
	@FindBy(xpath="//a[contains(text(),'Stuck Opportunities')]")
	WebElement stuckOpp;
	
	@FindBy(xpath="//select[@id='quarter_q']")
	WebElement interval;	
	
	@FindBy(xpath="//select[@id='open']")
	WebElement include;
	
	@FindBy(xpath="//input[@title='Run Report']")
	WebElement runReport;
	
	public void clickOpty() {
		accTab.click();
		
	}

	public String viewOptyDropDown() {
		waitForElement(10, viewOpty);
		viewOpty.click();
		return viewOpty.getText();
	}

	public void clickNewOpty() {
		waitForElement(10, newButton);
		newButton.click();
		
	}

	public void createNew(String oppName2) {
		waitForElement(10, oppName);
		oppName.click();
		oppName.sendKeys(oppName2);
		lookupWindow.click();
		Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		driver.switchTo().frame("searchFrame");
		lksrch.sendKeys("light");
		go.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
		waitForElement(10, dataRow);
		dataRow.click();
		driver.switchTo().window(currentHandle);
		waitForElement(10, closeDate);
		closeDate.click();
		today.click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		stage.click();
		Select stageDropDown = new Select(stage);
		stageDropDown.selectByValue("Qualification");
		//probability.sendKeys("80");
		leadSource.click();
		Select leadSourceDD = new Select(leadSource);
		leadSourceDD.selectByValue("Phone Inquiry");
		prmyCampaignSource.click();
		windowHandles = driver.getWindowHandles();
		currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		driver.switchTo().frame("searchFrame");
		lksrch.sendKeys("GC Product Webinar - Jan 7, 2002");
		go.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
		waitForElement(10, dataRow);
		dataRow.click();
		driver.switchTo().window(currentHandle);
		save.click();
	}

	public void clickOptyPipeline() {
		waitForElement(10, optyPipeline);
		optyPipeline.click();
	}

	public void clickStuckOpp() {
		waitForElement(10, stuckOpp);
		stuckOpp.click();
		
	}

	public void quarterlySummary() {
		waitForElement(10, interval);
		interval.click();
		Select intervalDropDown = new Select(interval);
		intervalDropDown.selectByValue("current");
		include.click();
		Select includeDropDown = new Select(include);
		includeDropDown.selectByValue("open");
		runReport.click();
		
	}

}

