package com.training.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class CreateAccountPage extends BasePage {
	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="Account_Tab")
	WebElement accTab;
	
	@FindBy(name="new")
	WebElement newAcc;
	
	@FindBy(id="acc2")
	WebElement newaccName;
	
	@FindBy(id="acc6")
	WebElement newaccType;
	
	@FindBy(id="00NDn000006w7WK")
	WebElement cuspriority;
	
	@FindBy(name="save")
	WebElement newaccSave;
	
	@FindBy(xpath=("//a[contains(text(),'Create New View')]"))
	WebElement accNewView;
	
	@FindBy(xpath=("//*[@id='fname']"))
	WebElement accViewName;
	
	@FindBy(xpath=("//*[@id='devname']"))
	WebElement accUniName;
	
	@FindBy(name="save")
	WebElement accnewvieSave;
	
	@FindBy(xpath="//*[@class='title']" )
	WebElement accviewList ;
	
	@FindBy(xpath="//select[@id='fcf']")
	WebElement accViewDD;
	
	@FindBy(linkText="Edit")
	WebElement edit;
	
	@FindBy(xpath="//select[@id='fcol1']")
	WebElement fieldList;
	
	@FindBy(xpath="//select[@id='fop1']")
	WebElement operator;
	
	@FindBy(id="fval1")
	WebElement value;
	//img[@class='rightArrowIcon']
	@FindBy(xpath="//img[@class='rightArrowIcon']")
	WebElement addright;
	//select[@id='colselector_select_0']
	@FindBy(xpath="//select[@id='colselector_select_0']")
	WebElement availableFields;
	
	@FindBy(xpath="//div[@title='Last Activity']")
	WebElement lastactivity;
	
	@FindBy(xpath="//a[@href='/merge/accmergewizard.jsp?retURL=%2F001%2Fo']")
	WebElement mergeAcc;
	
	@FindBy(id="srch")
	WebElement mergesearch;
	
	@FindBy(xpath="//input[@name='srchbutton']")
	WebElement findAccount;
	
	
	@FindBy(xpath="//input[@id='cid0']")
	WebElement acct1;
	
	@FindBy(xpath="//input[@id='cid1']")
	WebElement acct2;
	
	@FindBy(xpath="//div[contains(@class,'pbTopButtons')]//input[contains(@title,'Next')]")
	WebElement next;
	
	@FindBy(xpath="//input[@value=' Merge ']")
	WebElement mergebtn;
	
	@FindBy(xpath="//a[@href=\"/001Dn0000033K6U\"]")
	WebElement checkacct;
	
	@FindBy(xpath=("//a[contains(text(),'Accounts with last activity > 30 days')]"))
	WebElement lastActivity;
	
	public void accountTab() {

		accTab.click();
		waitForElement(10, accTab);
		newAcc.click();
		waitForElement(10, newaccName);
		newaccName.sendKeys("light");
		newaccType.click();
		Select select = new Select(newaccType);
		select.selectByVisibleText("Technology Partner");
		cuspriority.click();
		Select select1 = new Select(cuspriority);
		select1.selectByVisibleText("High");
		newaccSave.click();
			
	}
	//pending
	public void accountTabNewView() {
		accTab.click();
		waitForElement(10, accNewView);
		accNewView.click();
		waitForElement(20, accViewName);
		accViewName.sendKeys("Rose1");
		waitForElement(10, accUniName);
		accUniName.sendKeys("R2");
		accnewvieSave.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		accviewList.click();
		Select select = new Select(accviewList);
		List<WebElement> options = select.getOptions();
		
		for(int i=0; i<options.size(); i++) {
			if(options.get(i).getText().equals(accViewName())) {
				System.out.println("Account name is displayed in the dropdown");
			}
		}
		
	}//pending
	private String accViewName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String editView() {
		accTab.click();
		waitForElement(10, accViewDD);
		Select select = new Select(accViewDD);
		select.selectByVisibleText("Rose");
		waitForElement(10, edit);
		edit.click();
		waitForElement(10, accViewName);
		accViewName.clear();
		accViewName.sendKeys("Rose");
		fieldList.click();
		select = new Select(fieldList);
		select.selectByVisibleText("Account Name");
		operator.click();
		select = new Select(operator);
		select.selectByVisibleText("contains");
		value.sendKeys("a");
		select = new Select(availableFields);
		select.selectByVisibleText("Last Activity");
		addright.click();
		accnewvieSave.click();
		waitForElement(10, lastactivity);
		String lastact=lastactivity.getText();
		return lastact;
		
	}
	public String mergeAccount() {
		accTab.click();
		waitForElement(10, accViewDD);
		Select select = new Select(accViewDD);
		select.selectByVisibleText("Rose");
		 mergeAcc.click();
		 mergesearch.sendKeys("light");
		 findAccount.click();
		// acct1.click();
		 //acct2.click();
		 waitForElement(10, next);
		 next.click();
		 waitForElement(10, mergebtn);
		 mergebtn.click();
		 driver.switchTo().alert().accept();
		 return checkacct.getText();
	}
	
	//pending..
	public void accountReport() {
		accTab.click();
		waitForElement(10, accViewDD);
		Select select = new Select(accViewDD);
		select.selectByVisibleText("Rose");
		lastActivity.click();
	}
}

