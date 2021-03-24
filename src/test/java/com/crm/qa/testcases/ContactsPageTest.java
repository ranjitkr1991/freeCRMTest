package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	
	
	public ContactsPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage=new LoginPage();
		//contactPage=new ContactsPage();
		homePage=loginPage.doLogin(config.getProperty("userName"), config.getProperty("password"));
		contactPage=homePage.clickOnContactLink();
	}
	
	@Test(enabled = false )
	public void verifyUserNameTest() {
		//homePage.clickOnContactLink();
		contactPage.verifyUserName();
	}
	
	@Test(priority = 2)
	public void selectCheckBoxTest() throws InterruptedException {
		contactPage.selectCheckBox("vikash kumar");
	}
	
	@Test(priority = 3)
	public void clickOnEditTest() {
		contactPage.clickOnContactEdit("Ranjit kumar");
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	

}
