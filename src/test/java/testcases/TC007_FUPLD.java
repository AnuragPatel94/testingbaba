package testcases;

import java.awt.AWTException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basepage.BasePage;
import pages.CommonNavigation;
import pages.FileUpload;

public class TC007_FUPLD extends BasePage {

	FileUpload page;
	CommonNavigation navigation;

	@BeforeClass
	public void createObject() 
	{
		page = new FileUpload(driver);
		navigation = new CommonNavigation(driver);

		navigation.clickonClose();
		navigation.clickOnPracticeBtn();
		navigation.clickOnElementsBtn();
	}

	@Test(priority = 17)
	public void fileupload() throws AWTException 
	{
		page.clickupload();
	}
}