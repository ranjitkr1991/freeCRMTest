package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class HomePage extends TestBase{
	
	//Page Factor Object Repository
	
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	WebElement homeLink;
	
	@FindBy(xpath = "//span[contains(text(),'Ranjit kumar')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//div[@id='main-nav']")
	WebElement mouseHoverOnLeftMenu;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	
	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath ="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	@FindBy(xpath = "(//div[@class='menu-item-wrapper']/button)[2]/i")
	WebElement contactPlusIcon;
	
	//Intilization the all above objects
	public HomePage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyCorrectUserName() {
		return userNameLabel.getText();
	}
	
	public void moveToMenu() {
		
		TestUtil.mouseHover(mouseHoverOnLeftMenu);
		
	}
	
	public ContactsPage clickOnContactLink() {
		
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTaskLink() {
		tasksLink.click();
		return new TaskPage();
	}
	
	public CreateNewContactPage clickContactPlusIcon() {
		//contactPlusIcon.click();
		//Actions action=new Actions(driver);
		//action.moveToElement(contactPlusIcon).click().perform();
		
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click()", contactPlusIcon);
		 
		
		return new CreateNewContactPage();
	}
	
	public void clickHomeLink() throws InterruptedException {
		Thread.sleep(2000);
		homeLink.click();
	}
	
	
	

}
