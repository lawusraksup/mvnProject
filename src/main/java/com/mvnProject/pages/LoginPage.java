package com.mvnProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mvnProject.base.baseClass;
import com.mvnProject.util.TestUtil;

public class LoginPage extends baseClass {

	TestUtil testUtil;
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
	}
	
	//page facgory -- OR
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement signUpLink;
	
	
	public String LoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean LoginPageCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public SignUpPage LoginPageClickOnSignUpLink(){
		//Thread.sleep(3000);
		//testUtil.explicitWaitUntilClickable(signUpLink);
		signUpLink.click();
		return new SignUpPage();
	}
	
	public HomePage LoginPageUserLogin(String uname, String pwd){
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	
	
	
	
	

}
