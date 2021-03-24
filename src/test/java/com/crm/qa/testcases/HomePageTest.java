package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.utils.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	TestUtil testUtil;

	ContactsPage contactsPage;
	DealsPage dealsPage;
	TaskPage taskPage;
	CreateNewContactPage createNewContactPage;

	public HomePageTest() {
		super();
	}

	// Test cases should be always seperated or Independent to each other
	// means dependency should not be ther b/w one Test case to another test case
	// Before each test case-- lunch the browser and login
	// @test--execute the test case
	// after each test case-- close the browser
	@BeforeMethod
	public void setUp() {
		initilization();
		testUtil = new TestUtil();

		loginPage = new LoginPage();
		homePage = loginPage.doLogin(config.getProperty("userName"), config.getProperty("password"));
		contactsPage = new ContactsPage();
		taskPage=new TaskPage();
		createNewContactPage=new CreateNewContactPage();
	}

	@Test(enabled = false)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "", "Home Page title is not Matched");
	}

	@Test(priority = 1, enabled = false)
	public void verifyUserNametest() throws InterruptedException {
		String actual = homePage.verifyCorrectUserName();
		Assert.assertEquals(actual, "Ranjit kumar", "User name is not matching");

	}

	@Test(priority = 2)
	public void clickOnContactTest() {
		homePage.moveToMenu();

	}

	@Test(priority = 3, enabled = false)
	public void clickOnContactsLikTest() {
		contactsPage = homePage.clickOnContactLink();
	}

	@Test(priority = 4, enabled = false)
	public void clickOnDelaspageTest() {
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority = 5, enabled = false)
	public void clickOntaskLinkTest() {
		taskPage=homePage.clickOnTaskLink();
	}
	
	@Test(priority = 6, enabled = false)
	public void clickNewContactIconTest() {
		homePage.clickContactPlusIcon();
	}

	

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
