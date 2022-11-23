package com.training.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class RandowScenariosPage extends BasePage {
	public RandowScenariosPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = ("//a[contains(text(),'Home')]"))
	WebElement Home;

	@FindBy(xpath = ("//a[contains(text(),'vijaya ABCDE')]"))
	WebElement userNLink;

	@FindBy(xpath = "//a[contains(text(),'My Profile')]")
	WebElement myProfile;

	@FindBy(xpath = "//img[@title='Edit Profile']")
	WebElement edituserNLink;
	// li[@id='aboutTab']
	// @FindBy(id = "aboutTab") // li[@id='aboutTab']
	// WebElement editaboutTab;

	@FindBy(xpath = ("//img[@class='allTabsArrow']"))
	WebElement allTab;

	@FindBy(xpath = ("//input[@class='btnImportant']"))
	WebElement customizeTab;
	// option[@value='AppLauncher']
	@FindBy(xpath = ("//option[@value='AppLauncher']"))
	WebElement selectApp;
	// img[@class='leftArrowIcon']
	@FindBy(xpath = ("//img[@class='leftArrowIcon']"))
	WebElement removeApp;
	// input[@title='Save']
	@FindBy(xpath = ("//input[@title='Save']"))
	WebElement save;
	// a[@href='/00U/c?md3=319&md0=2022'
	@FindBy(xpath = ("//a[@href='/00U/c?md3=319&md0=2022']"))
	WebElement date;

	@FindBy(xpath = ("//a[@href='/00U/e?retURL=%2F00U%2Fc%3Fmd3%3D319%26md0%3D2022&aid=005Dn0000018y47&anm=vijaya+ABCDE&evt4=11%2F15%2F2022&evt13=8%3A00+AM&RecurrenceStartDateTime=11%2F15%2F2022']"))
	WebElement eightOclk;

	@FindBy(xpath = ("//img[@class='comboboxIcon']"))
	WebElement comboboxIcon;

	// @FindBy(xpath = ("//li[@class='listItem4']"))
	@FindBy(xpath = ("//a[@href='javascript:pickValue(4);']"))
	WebElement comboBoxOther;

	@FindBy(xpath = "//input[@id='EndDateTime']")
	WebElement endDate;

	@FindBy(xpath = "//input[@id='EndDateTime_time']")
	WebElement endDateTime;

	@FindBy(xpath = "//tr[@id='calRow2']//td[contains(@class,'weekday')][contains(text(),'6')]")
	WebElement pickingDate;

	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement save1;

	@FindBy(id = "aboutTab")
	WebElement aboutTab;

	@FindBy(id = "lastName")
	WebElement accountlastname;

	@FindBy(xpath = "//input[@value='Save All']")
	WebElement accountSaveAll;

	@FindBy(xpath = "//a[contains(@class,'contactInfoLaunch editLink')]")
	WebElement edit;

	@FindBy(id = "contactInfoContentId")
	WebElement iframeAbout;

	@FindBy(xpath="//a[@href='/00U/e?retURL=%2F00U%2Fc%3Fmd3%3D320%26md0%3D2022&aid=005Dn0000018y47&anm=vijaya+Abcd&evt4=11%2F16%2F2022&evt13=4%3A00+PM&RecurrenceStartDateTime=11%2F16%2F2022']")
	WebElement nineOclock;
	
	@FindBy(xpath="//div[@id='timePickerItem_38']")
	WebElement sevenOclock;
	
	@FindBy(xpath="//input[@id='IsRecurrence']")
	WebElement recurrence;
	
	@FindBy(xpath="//input[@id='rectypeftw']")
	WebElement weekly;
	//input[@id='8']
	
	@FindBy(xpath="//input[@id='RecurrenceEndDateOnly']")
	WebElement enddate;
	//TC33 Verify if the firstname and lastname of the loggedin user is displayed

	public void homeTabLink() {
		Home.click();
		waitForElement(10, userNLink);
		userNLink.click();

	}

	public void profilePage() {
		myProfile.click();
	}

	// TC34 Verify the edited lastname is updated at various places
	// not finished

	public WebElement myProfileUsermenu() {

		waitForElement(20, edit);
		edit.click();
		waitForElement(20, edit);
		return iframeAbout;
	}

	public void editHomeTabLink() {
		waitForElement(10, aboutTab);
		aboutTab.click();
		System.out.println("aboutTab: " + aboutTab.getText());
		accountlastname.clear();
		waitForElement(10, accountlastname);
		accountlastname.sendKeys("Abcd");
		waitForElement(10, accountSaveAll);
		accountSaveAll.click();
	}

	// TC35 Verify the tab customization
	public void tabCustomization() {
		allTab.click();
		waitForElement(10, customizeTab);
		customizeTab.click();
		waitForElement(10, selectApp);
		selectApp.click();
		removeApp.click();
		save.click();
	}

	// TC36 Blocking an event in the calender
	public void BlockingCalender() {
		waitForElement(10, date);
		date.click();
		// String display= date.getText();
		// System.out.println("calender link is: "+display);
		waitForElement(10, eightOclk);
		eightOclk.click();
		waitForElement(10, comboboxIcon);
		comboboxIcon.click();

		Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		// waitForElement(10, comboboxIcon);

		// choiceBox.click();
		comboBoxOther.click();
		driver.switchTo().window(currentHandle);
		save.click();

	}

	// TC37 Blocking an event in the calender with weekly recurrance
	public void BlockingCalenderweekly() {
		waitForElement(10, date);
		date.click();
		waitForElement(10, nineOclock);
		nineOclock.click();
		Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		comboBoxOther.click();
		driver.switchTo().window(currentHandle);
		waitForElement(10, sevenOclock);
		sevenOclock.click();
		recurrence.click();
		 weekly.click();
		 enddate.sendKeys("11/30/2022");
		 save.click();
		

	}
}