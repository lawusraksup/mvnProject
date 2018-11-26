package com.mvnProject.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.mvnProject.base.baseClass;
import com.mvnProject.pages.HomePage;
import com.mvnProject.pages.LoginPage;

public class testBase extends baseClass {

	LoginPage loginpage;
	HomePage homepage;
	
	
	public testBase(){
		super();
		loginpage = new LoginPage();
	}
	
	
	
	
	@BeforeMethod
	public void verifyLoginTest(){
		initializeBrowser();
		homepage = loginpage.LoginPageUserLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	
}
