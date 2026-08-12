package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basepage.BasePage;
import pages.CheckBox;


public class TC003_CB extends BasePage {
   CheckBox page;

	@BeforeClass
	public void createObject() {

		page = new CheckBox(driver);

	}
	
	@Test(priority = 13)
	public void closePopup() {

		page.clickonClose();

	}

	@Test(priority = 14)
	public void clickPractice() {

		page.clickOnPracticeBtn();

	}

	@Test(priority = 15)
	public void clickElements() {

		page.clickOnElementsBtn();
	}
	
	@Test(priority = 16)
	public void verifyCheckBoxes()  {

	    CheckBox page = new CheckBox(driver);

	    page.clickCheckBoxBtn();

	    page.clickMobileCheckBox();
	    page.clickLaptopCheckBox();
	    page.clickDesktopCheckBox();

	    page.switchToMainPage();
	}

}
