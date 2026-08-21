package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basepage.BasePage;
import pages.Buttons;
import pages.CommonNavigation;

public class TC005_BTN extends BasePage{
	Buttons page;
	CommonNavigation navigation;

	@BeforeClass
	public void createobject() 
	{
		page=new Buttons(driver);
		navigation=new CommonNavigation(driver);

		navigation.clickonClose();
		navigation.clickOnPracticeBtn();
		navigation.clickOnElementsBtn();
	}


	@Test(priority=11)
	public void clickonButtons() 
	{
		page.clickonButtons();
	}

	@Test(priority=12)
	public void clickondblbtn() 
	{
		page.clickondblbtn();
	}

	@Test(priority=13)
	public void clickonrightbtn() 
	{
		page.clickonrightbtn();
	}

	@Test(priority=14)
	public void clickonclickmebtn()
	{
		page.clickonclickmebtn();
	}

}
