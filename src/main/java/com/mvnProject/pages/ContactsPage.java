package com.mvnProject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mvnProject.base.baseClass;

public class ContactsPage extends baseClass {
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsTableHeader;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	
	
	
	
	
	
	
	public String ContactsPageContactTblText(){
		return contactsTableHeader.getText();
	}
	
	
	public void ContacsPageSelectCheckBox(String contact){
		driver.findElement(By.xpath("//a[@_name='" + contact + "']//parent::td/preceding-sibling::td//input[@type='checkbox']")).click();
		//driver.findElement(By.xpath("//a[text()='" + contact + "']//parent::td[@class = 'datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public boolean ContactPageIsSaved(String contact){
		List<WebElement> contactInfo = driver.findElements(By.xpath("//a[@_name='"+ contact + "']"));
		if(contactInfo.size()>0){
			return true;
		}else{
			return false;
		}
		
	}
	
	

}
