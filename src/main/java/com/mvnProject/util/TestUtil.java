package com.mvnProject.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mvnProject.base.baseClass;

public class TestUtil extends baseClass {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long PAGE_WAIT_TIMEOUT = 10;
	public static String LOGIN_PAGE_TITLE = "#1 Free CRM software in the cloud for sales and service";
	public static String HOME_PAGE_TITLE = "CRMPRO";
	public static String TESTDATA_SHEET_PATH = "src/main/java/com/mvnProject/testdata/Testdata.xlsx";
	public static String SCREENSHOT_PATH = "screenshots/";
	
	public void explicitWaitUntilClickable(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		//WebElement element = driver.findElement(By.name("name"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
		//Fluent wait
		
		/*
		WebElement locator = driver.findElement(By.name("name"));
		
		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
									 
				                     .withTimeout(30, TimeUnit.SECONDS)
				                     .pollingEvery(5,TimeUnit.SECONDS)
				                     .ignoring(NoSuchElementException.class);
		
		WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.id("foo"));
		     }
		   });
		   
		   */
	}
	
	
	public void switchToFrameName(String fName){
		driver.switchTo().frame(fName);
	}
	
	public void takeScreenshot(String ssCaption) throws IOException{
		TakesScreenshot ss = (TakesScreenshot)driver;
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		File desFile = new File(SCREENSHOT_PATH + ssCaption);
		FileUtils.copyFile(srcFile,desFile);
		
	}
	
	
}
