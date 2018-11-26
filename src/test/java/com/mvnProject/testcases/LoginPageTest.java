package com.mvnProject.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mvnProject.base.baseClass;
import com.mvnProject.pages.HomePage;
import com.mvnProject.pages.LoginPage;
import com.mvnProject.pages.SignUpPage;
import com.mvnProject.util.TestUtil;

public class LoginPageTest extends baseClass{
	
	
	LoginPage loginpage;
	TestUtil testUtil;
	HomePage homepage;
	SignUpPage signuppage;
	
	
	public LoginPageTest(){
		super();
		
	}
	
	
	
	
	@BeforeMethod
	public void setUp(){
		initializeBrowser();
		testUtil = new TestUtil();
		loginpage = new LoginPage();
	}
	
	
	@Test 
	public void LoginPageTitleTest(){
		String loginpagetitle = loginpage.LoginPageTitle();
		String expectedtitle = testUtil.LOGIN_PAGE_TITLE;
		Assert.assertTrue(false);
		//Assert.assertEquals(loginpagetitle,expectedtitle );
	}
	
	@Test (enabled = false)
	void LoginTest(){
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		homepage = loginpage.LoginPageUserLogin(uname, pwd);
	}
	
	@Test (enabled = false)
	void LoginPageLogoTest(){
		boolean logostatus = loginpage.LoginPageCRMImage();
		Assert.assertEquals(logostatus, true);
	}
	
	@Test (enabled = false)
	public void LoginPageSignUpLinkTest(){
		
		loginpage.LoginPageClickOnSignUpLink();
		
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		Thread.sleep(1000);
		driver.close();
	}
	
	
	

}
