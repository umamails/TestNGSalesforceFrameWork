package com.training.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static com.training.utilities.Constants.USER_DIR;
import static com.training.utilities.Constants.FILE_SEPARATOR;
import static com.training.utilities.Constants.SCREENSHOT_PATH;
//import static com.training.utilities.Constants.*;
public class BaseTest {
	
	private WebDriver driver;
	
	public WebDriver getDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		 	WebDriverManager.firefoxdriver().setup();
		 	driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		return driver;
		
	}
	public void takeScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		File scrFile=screenshot.getScreenshotAs(OutputType.FILE);
		Date currentDate=new Date();
		String timeStamp= new SimpleDateFormat("MM-dd-yyyy HH-mm-ss").format(currentDate);
		
		String reportFilePath=USER_DIR+FILE_SEPARATOR+SCREENSHOT_PATH+FILE_SEPARATOR;
		//String fileSeparator=System.getProperty("file.separator");
		//String reportFilePath=System.getProperty("user.dir")+fileSeparator+"screenshots"+fileSeparator;

		String fileName="Salesforce"+timeStamp+".png";
		String filepath=reportFilePath+fileName;
		File destFile=new File(filepath);
		FileUtils.copyFile(scrFile, destFile); 
	}
	//This method is to verify if the file is downloaded or not
		public boolean isFileDownloaded(String downloadPath, String fileName) {
			boolean flag = false;
			File dir = new File(downloadPath);
			File[] dir_contents = dir.listFiles();
		
				for(int i=0; i<dir_contents.length; i++) {
					if(dir_contents[i].getName().equalsIgnoreCase(fileName)) {
					return flag = true;
				}
			}
			return flag;
		}

}
