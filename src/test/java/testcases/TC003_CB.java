package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basepage.BasePage;
import pages.CheckBox;
import pages.CommonNavigation;


public class TC003_CB extends BasePage {
	CheckBox page;
	CommonNavigation navigation;

	@BeforeClass
	public void createObject()
	{
		page = new CheckBox(driver);
		navigation = new CommonNavigation(driver);

		navigation.clickonClose();
		navigation.clickOnPracticeBtn();
		navigation.clickOnElementsBtn();

	}


	@Test(priority = 7)
	public void verifyCheckBoxes()  
	{
		page.clickCheckBoxBtn();
		page.clickMobileCheckBox();
		page.clickLaptopCheckBox();
		page.clickDesktopCheckBox();
		page.switchToMainPage();
	}

}
