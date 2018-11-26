package com.mvnProject.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mvnProject.base.baseClass;
import com.mvnProject.pages.ContactsPage;
import com.mvnProject.pages.HomePage;
import com.mvnProject.pages.LoginPage;
import com.mvnProject.pages.NewContactPage;
import com.mvnProject.util.TestUtil;

public class HomePageTest extends baseClass {

	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	TestUtil testUtil;
	NewContactPage newContactpage;
	
	
	public  HomePageTest(){
		super();
		
		//homepage = new HomePage();
		
	}
	
	@BeforeMethod
	public void userLogin(){
		initializeBrowser();
		loginpage = new LoginPage();
		testUtil = new TestUtil();
		homepage = loginpage.LoginPageUserLogin(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrameName("mainpanel");
		
		
	}
	
	@Test 
	public void HomePageTitleTest(){
		String homepagetitle = homepage.HomePageTitle();
		String expectedtitle = testUtil.HOME_PAGE_TITLE;
		Assert.assertEquals(homepagetitle, expectedtitle);
	}
	
	
	@Test (enabled = false)
	public void HomePageUserNameDisplayTest(){
		String usernamelbl = (homepage.HomePageUsernameLbl()).trim();
		
		String firstname = prop.getProperty("firstname"); 
		String lastname = prop.getProperty("lastname");
		String expectedUsernamelbl = "User: " + firstname + " " + lastname;
		System.out.println(expectedUsernamelbl);
		Assert.assertEquals(usernamelbl, expectedUsernamelbl);
	}
	
	@Test(enabled = false)
	public void HomePageContactsTabTest(){
		contactspage = homepage.HomePageClickOnContacts();
		Assert.assertTrue(contactspage.ContactsPageContactTblText().contains("Contacts"));
		
	}
	
	@Test
	public void HomePageNewContactsTabTest(){
		
		newContactpage = homepage.HomePageClickOnNewContact();
		Assert.assertTrue(newContactpage.ContactsPageNewContactPageIsDisplayed());
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	
	
}
