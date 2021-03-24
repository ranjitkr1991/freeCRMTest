package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class CreateNewContactPage extends TestBase{
	
	
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath = "//button[contains(@class,'ui linkedin button')]")
	WebElement saveBtn;
	
	
	public CreateNewContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void createContact(String fn, String ln) {
		
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		saveBtn.click();
		
	}
	
	
	
	

}
