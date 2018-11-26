package com.mvnProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mvnProject.base.baseClass;

public class NewContactPage extends baseClass{
	
	@FindBy(xpath = "//legend[contains(text(),'Contact Information')]")
	WebElement newContactHeader;
	
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "surname")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@type = 'submit' and @value = 'Save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//select[@name='title']")
	WebElement title;
	
	
	public NewContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean ContactsPageNewContactPageIsDisplayed(){
		return newContactHeader.isDisplayed();
	}
	
	
	public void selectDropDownByVisibleText(String visibleText){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(visibleText);
		
	}
	
	
	
	public void createNewContact(String title, String fName, String lName){
		selectDropDownByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		saveBtn.click();
	}
	
	
	
	
	

}
