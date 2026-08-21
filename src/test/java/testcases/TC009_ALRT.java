package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basepage.BasePage;
import pages.Alerts;
import pages.CommonNavigation;

public class TC009_ALRT extends BasePage{

	Alerts page;
	CommonNavigation navigation;

	@BeforeClass
	public void createObject()
	{
		page = new Alerts(driver);
		navigation = new CommonNavigation(driver);
		navigation.clickonClose();
		navigation.clickOnPracticeBtn();
		//navigation.clickOnElementsBtn();
	}

	@Test(priority=23)
	public void alertwindow() 
	{
		page.clickalrtwindows();
	}


	@Test(priority=24)
	public void clickonalert() 
	{
		page.clickalertbtn();
	}

	@Test(priority=25)
	public void clickonalert1() 
	{
		page.clickalertbtn1();
	}

	@Test(priority=26)
	public void clickonalert2() throws InterruptedException 
	{
		page.clickalertbtn2();
	}

	@Test(priority=27)
	public void clickonalert3() 
	{
		page.clickalertbtn3();
	}

	@Test(priority=28)
	public void clickonalert4() 
	{
		page.clickalertbtn4();
	}}

