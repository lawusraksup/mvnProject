package com.mvnProject.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mvnProject.base.baseClass;
import com.mvnProject.pages.ContactsPage;
import com.mvnProject.pages.HomePage;
import com.mvnProject.pages.LoginPage;
import com.mvnProject.util.TestUtil;

public class ContactsPageTest extends baseClass {

	LoginPage loginpage;
	ContactsPage contactspage;
	TestUtil testUtil;
	HomePage homepage;
	
	public ContactsPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void userLogin(){
		initializeBrowser();
		loginpage = new LoginPage();
		testUtil = new TestUtil();
		homepage = loginpage.LoginPageUserLogin(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrameName("mainpanel");
		contactspage = homepage.HomePageClickOnContacts();
		
	}
	
	@Test
	public void ContactPageSelectContactTest(){
		contactspage.ContacsPageSelectCheckBox("abc xyz");
	}
	

	@Test
	public void ContactPageSelectMultipleContactTest(){
		contactspage.ContacsPageSelectCheckBox("abc xyz");
		contactspage.ContacsPageSelectCheckBox("Lara lara");
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		Thread.sleep(1000);
		driver.close();
	}
	
	
	
	
	
	
}
