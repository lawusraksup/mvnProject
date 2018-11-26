package com.mvnProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mvnProject.base.baseClass;

public class HomePage extends baseClass {

	
	
	@FindBy(xpath = "//td[contains(text(),'Lara lara')]")
	WebElement userLbl;
	
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsTab;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	
	
	
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	

	public String HomePageUsernameLbl(){
		return userLbl.getText();
	}
	
	
	public String HomePageTitle(){
		return driver.getTitle();
		
	}
	
	public ContactsPage HomePageClickOnContacts(){
		contactsTab.click();
		return new ContactsPage();
	}
	
	public NewContactPage HomePageClickOnNewContact(){
		
		Actions action = new Actions(driver);
		Action moveTo = action.moveToElement(contactsTab).build();
		moveTo.perform();
		
		newContactsLink.click();
		return new NewContactPage();
		
		
	}
	
	
	
	
	

}
