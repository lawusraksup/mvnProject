package com.mvnProject.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

import com.mvnProject.util.TestUtil;

public class testClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		String url = "http://www.freecrm.com";
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_WAIT_TIMEOUT, TimeUnit.SECONDS);
		
		
		//driver.findElement(By.linkText("Sign Up")).click();
		//driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
		//LoginPage loginpage= new LoginPage();
		
		
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("laralara");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Freecrmpassword123");
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		loginBtn.click();
		
		
		driver.switchTo().frame("mainpanel");
		
		
		WebElement contactsTab = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		WebElement newContactsLink = driver.findElement(By.xpath("//a[contains(text(),'New Contact')]"));
		
		
		
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(contactsTab).build().perform();
		Thread.sleep(1000);
		newContactsLink.click();
		Thread.sleep(1000);
		driver.close();
		
		
		
		/*
		contactsTab.click();
		WebElement tbl = driver.findElement(By.xpath("//a[@_name='Tom Jerry']"));
		//tbl.getText();
		System.out.println(tbl.getText());
		
		String TESTDATA_SHEET_PATH = "src/main/java/com/mvnProject/testdata/Testdata.xlsx";
		
		FileInputStream file;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			System.out.println(file.getClass());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		

	}

}
