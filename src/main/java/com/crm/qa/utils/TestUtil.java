package com.crm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long page_Load_TimeOut = 40;
	public static long implicit_Wait = 20;

	public static final String TESTDATA_SHEET_PATH = "./src/test/resources/excel/freeCrmTest.xlsx";
	static Workbook book;
	static Sheet sheet;

	public void switchToFrame(String frame) {
		driver.switchTo().frame(frame);

	}

	public static void mouseHover(WebElement we) {
		Actions action = new Actions(driver);
		action.moveToElement(we).perform();
	}

	public static void waitElementVisible(WebElement element) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));

	}

	public static Object[][] getTestData(String sheetName) {

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getSheetName());
		// System.out.println(sheet.getLastRowNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				// System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}

		return data;

	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir+"/screenshot/"+System.currentTimeMillis()+".png"));
		
		
	}
}
