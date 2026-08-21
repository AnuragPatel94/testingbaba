package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basepage.BasePage;
import pages.BrowserWindow;
import pages.CommonNavigation;


public class TC008_BRSWIN extends BasePage{
	BrowserWindow page;
	CommonNavigation navigation;
	
	@BeforeClass
	public void createObject()
	{
		page = new BrowserWindow(driver);
		navigation = new CommonNavigation(driver);

		navigation.clickonClose();
		navigation.clickOnPracticeBtn();
		//navigation.clickOnElementsBtn();
	}
	
	
	@Test(priority=18)
	public void alertwindow() 
	{
	    page.clickalrtwindows();
	}

	@Test(priority=19)
	public void clickbrowserwindow() 
	{
	    page.clickbrowserwindow();
	}

	@Test(priority = 20)
	public void verifyNewTab() 
	{
	     page.clickNewTab();
	}
	
	@Test(priority = 21)
	public void verifyNewWindow() 
	{
	    page.clickNewWindow();
	}
	
	
	@Test(priority = 22)
	public void verifyNewWindowMessage()
	{
	   page.clickNewWindowMessage();
	}
}