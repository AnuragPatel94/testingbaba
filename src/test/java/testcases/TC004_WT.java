package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basepage.BasePage;
import pages.CommonNavigation;
import pages.WebTable;

public class TC004_WT extends BasePage{

	WebTable page;
	CommonNavigation navigation;

	@BeforeClass
	public void createObject() 
	{
		page = new WebTable(driver);
		navigation = new CommonNavigation(driver);

		navigation.clickonClose();
		navigation.clickOnPracticeBtn();
		navigation.clickOnElementsBtn();
	}

	@Test(priority=8)
	public void clickonwebtable() 
	{
		page.clickonwebtable();
	}

	@Test(priority=9)
	public void filldata() 
	{
		page.fillDetails();
	}

	@Test(priority=10)
	public void verifyFillDetails() 
	{
		page.verifyFillDetails();
	}
}


