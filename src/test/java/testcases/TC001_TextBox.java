package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basepage.BasePage;
import pages.CommonNavigation;
import pages.TextBoxPractice;

public class TC001_TextBox extends BasePage {

	TextBoxPractice page;
	CommonNavigation navigation;

	@BeforeClass
	public void createObject() 
	{
		page = new TextBoxPractice(driver);
		navigation = new CommonNavigation(driver);

		navigation.clickonClose();
		navigation.clickOnPracticeBtn();
		navigation.clickOnElementsBtn();
	}

	@Test(priority = 1)
	public void clickTextBox() 
	{
		page.clickTextBox();
	}

	@Test(priority = 2)
	public void enterData() 
	{
		page.fillDetails();
	}

	@Test(priority = 3)
	public void submit() 
	{
		page.clickSubmit();
	}

	@Test(priority = 4)
	public void verifyDetails() 
	{
		page.verifyFillDetails();
	}
}







