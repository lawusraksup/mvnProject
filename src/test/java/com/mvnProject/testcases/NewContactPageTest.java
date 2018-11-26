package com.mvnProject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mvnProject.base.baseClass;
import com.mvnProject.pages.ContactsPage;
import com.mvnProject.pages.HomePage;
import com.mvnProject.pages.LoginPage;
import com.mvnProject.pages.NewContactPage;
import com.mvnProject.util.ExcelUtils;
import com.mvnProject.util.TestUtil;

//import udemy.selenium.dataproviderClass;

public class NewContactPageTest extends baseClass {
	
	
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	TestUtil testUtil;
	NewContactPage newContactpage;
	ExcelUtils excelUtils;
	
	
	public  NewContactPageTest(){
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
		//contactspage = homepage.HomePageClickOnContacts();
		newContactpage = homepage.HomePageClickOnNewContact();
		
		
		
	}
	
	@Test(dataProvider ="credentials")
	public void NewContactPageCreateNewContactTest( String title, String fname, String lname){
		newContactpage.createNewContact(title, fname, lname);
		contactspage = homepage.HomePageClickOnContacts();
		Assert.assertTrue(contactspage.ContactPageIsSaved(fname + " " + lname));
	}
	
		
	
	
	@DataProvider(name = "credentials")
	public  Object[][] dataprovidermethod() throws Exception{
		Object[][] data = excelUtils.getTableArray(testUtil.TESTDATA_SHEET_PATH, "contact");
		return data;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	

}
