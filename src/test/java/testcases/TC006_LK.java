package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basepage.BasePage;
import pages.CommonNavigation;
import pages.Links;

public class TC006_LK extends BasePage{

	Links page;
	CommonNavigation navigation;

	@BeforeClass
	public void createobject() {
		page=new Links(driver);
		navigation=new CommonNavigation(driver);

		navigation.clickonClose();
		navigation.clickOnPracticeBtn();
		navigation.clickOnElementsBtn();
	}

	@Test(priority=15)
	public void clickonlink() 
	{
		page.clickonlink();
	}

	@Test(priority=16)
	public void clickOnDemo() 
	{
		page.clickOnDemo();
	}
	
	@Test(priority=17)
	public void verifycreatedlink() 
	{
		page.clickOnCreatedLink();
	}

}



