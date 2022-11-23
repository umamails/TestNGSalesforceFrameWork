package com.training.pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.training.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Home']")
	WebElement Home;

	@FindBy(id = "name")
	WebElement Name;

	@FindBy(xpath = "//span[@id='userNavLabel']")
	WebElement username;

	@FindBy(xpath = "//a[@title='Logout']")
	WebElement logout;
	// a[contains(text(),'About')]

	// @FindBy(xpath="//span[@id='userNavLabel']")
	// @FindBy(xpath="//*[@class='mbrMenuItems']")
	// @FindBy(xpath = "//div[@class='menuButton menuButtonRounded']")
//"//iframe[@id='contactInfoContentId']"
	@FindBy(id = "userNavMenu")
	WebElement usermenu;

	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement myProfile;

	@FindBy(xpath = "//a[contains(@class,'contactInfoLaunch editLink')]")
	WebElement edit;

	@FindBy(id = "contactInfoContentId")
	WebElement iframeAbout;

	@FindBy(id = "aboutTab")
	WebElement aboutTab;

	@FindBy(id = "lastName")
	WebElement accountlastname;

	@FindBy(xpath = "//input[@value='Save All']")
	WebElement accountSaveAll;

	@FindBy(id = "publisherAttachTextPost")
	WebElement post;

	@FindBy(xpath = "//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]")
	WebElement postIframe;
	
	//@FindBy(xpath = "//body[@class='chatterPublisherRTE cke_editable cke_editable_themed cke_contents_ltr cke_show_borders placeholder']")
	//@FindBy(id="publisherAttachTextPost")
	@FindBy(xpath="//html[1]/body[1]")
	WebElement postsendtext;

	@FindBy(id="publishersharebutton")
	WebElement postShareButton;
	
	@FindBy(xpath="//a[@title='My Settings']")
	WebElement mySettings;
	
	@FindBy(xpath="//*[@id='PersonalInfo_font']")
	WebElement mySettingsPersonalbutton;
	
	@FindBy(xpath="//a[@id='LoginHistory_font']")
	WebElement personalbuttonLoginHistory;
	
	@FindBy(xpath="//*[@id='RelatedUserLoginHistoryList_body']")
	WebElement loginHistoryDownload;
	
	@FindBy(xpath="//a[contains(text(),'Developer Console')]")
	WebElement developerConsole;
	
	@FindBy(xpath="//*[@id='publishersharebutton']")
	WebElement sharebutton;
	
	
	
	public void clickHome() {
		waitForElement(10, Home);
		Home.click();
	}

	public void enterIntoName(String fName) {
		Name.sendKeys(fName);
	}

	public void usernameHomepage() {
		username.click();
	}

	public void logoutHomepage() {
		waitForElement(10, logout);
		logout.click();
		//waitForElement(10,logout);
	}

	public void usermenudropdown() {
		// username.click();
		waitForElement(10, usermenu);
		String display = usermenu.getText();
		System.out.println("username menu name is " + display);
	}

	public WebElement myProfileUsermenu() {
		myProfile.click();
		waitForElement(20, edit);
		edit.click();
		waitForElement(20, edit);
		return iframeAbout;

	}

	public void myProfileAboutTab() {
		waitForElement(10, aboutTab);
		aboutTab.click();
		// System.out.println("aboutTab: " + aboutTab.getText());
		accountlastname.clear();
		waitForElement(10, accountlastname);
		accountlastname.sendKeys("ABCDE");
		System.out.println(" new last name is updated");
		waitForElement(10, accountSaveAll);
		accountSaveAll.click();
	}

	public WebElement myProfileEditPost() {
		waitForElement(10, post);
		post.click();
		waitForElement(10,postIframe);
		return postIframe;
		
	}
	public void myProfileEditPost1() {
		postsendtext.click();
		postsendtext.sendKeys("Hi");
		waitForElement(10, postsendtext);
		sharebutton.click();
	}
	
	public void mySettingsUsermenu(String downloadPath){
		waitForElement(10, mySettings);
		mySettings.click();
		waitForElement(10,mySettingsPersonalbutton );
		mySettingsPersonalbutton.click();
		waitForElement(10,mySettingsPersonalbutton );
		personalbuttonLoginHistory.click();
		loginHistoryDownload.click();
		
	}
	public void developerConsoleUsermenu() {
		waitForElement(10, developerConsole);
		developerConsole.click();
		
		
	}
	
	}

