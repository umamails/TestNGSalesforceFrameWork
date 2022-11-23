package com.training.base;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void waitForElement(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/*public static void switchFrame( WebDriver driver,WebElement obj) {
		 
	    if(obj.isDisplayed()) {
	     driver.switchTo().frame(obj);
	     System.out.println("Pass: we can switch to the "+obj+ " frame");
//	     logger.log(LogStatus.PASS,  "Switch to frame" );
	     
	    }else {
	     System.out.println("fail: we can't switch to the "+obj+ " frame");
	

}
	}*/
	
}
