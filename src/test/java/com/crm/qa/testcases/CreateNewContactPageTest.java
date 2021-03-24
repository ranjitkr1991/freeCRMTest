package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class CreateNewContactPageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	CreateNewContactPage createNewContactPage;
	
	String sheetName="contacts";
	
	public CreateNewContactPageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initilization();
		loginPage=new LoginPage();
		homePage=loginPage.doLogin(config.getProperty("userName"), config.getProperty("password"));
		contactPage=homePage.clickOnContactLink();
		Thread.sleep(2000);
		createNewContactPage=contactPage.clickOnNewLink();
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1, dataProvider = "getCRMTestData")
	public void createNewContactTest(String firstName, String lastName) throws InterruptedException {
		
		//createNewContactPage.createContact("test1", "test2");
		createNewContactPage.createContact(firstName, lastName);
		homePage.clickHomeLink();
		homePage.clickOnContactLink();
		contactPage.clickOnPhone();
	
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();;
	}
	
	

}
