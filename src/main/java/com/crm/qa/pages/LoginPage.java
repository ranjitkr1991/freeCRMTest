package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or Object Repository
	@FindBy(name = "email")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement psw;
	
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement logBtn;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement forgotLink;
	
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//a[@class='navbar-brand']//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Intilization Object repository
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public HomePage doLogin(String un, String pw) {
		
		userName.sendKeys(un);
		psw.sendKeys(pw);
		logBtn.click();
		
		return new HomePage();
	}
	
	public void clickSignUp() {
		signUpBtn.click();
	}
	
	public boolean verifyCRMLogo() {
		
		return crmLogo.isDisplayed();
		 
	}
	
	
	
	

}
