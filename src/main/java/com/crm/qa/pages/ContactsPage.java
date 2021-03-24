package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Ranjit kumar')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//div[@class='item']/div/following-sibling::a/button/i")
	WebElement newLink;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyUserName() {
		return userNameLabel.getText();
	}

	public void selectCheckBox(String name) throws InterruptedException {

		driver.findElement(By.xpath("//th[text()='Phone']")).click();

		/*
		 * WebElement element =
		 * driver.findElement(By.xpath("//a[contains(text(),'"+name+
		 * "')]/parent::td/preceding-sibling::td/div/input")); JavascriptExecutor
		 * executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click()", element);
		 */

		WebElement element = driver.findElement(
				By.xpath("//a[contains(text(),'" + name + "')]/parent::td/preceding-sibling::td/div/input"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

		// driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td/preceding-sibling::td/div/input")).click();
		
	}

	public void clickOnPhone() {
		driver.findElement(By.xpath("//th[text()='Phone']")).click();
		
	}
	public CreateNewContactPage clickOnNewLink() throws InterruptedException {
		//newLink.click();
		TestUtil.waitElementVisible(newLink);
		newLink.click();
		return new CreateNewContactPage();

	}

	public EditExistContactPage clickOnContactEdit(String name) {
		driver.findElement(
				By.xpath("(//a[contains(text(),'" + name + "')]/parent::td/following-sibling::td/a/button)[2]"))
				.click();
		return new EditExistContactPage();

	}

}
