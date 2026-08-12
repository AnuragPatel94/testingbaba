package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basepage.BasePage;
import pages.RBPractice;

public class TC002_RB extends BasePage {

	RBPractice page;

	@BeforeClass
	public void createObject() {

		page = new RBPractice(driver);

	}

	@Test(priority = 8)
	public void closePopup() {

		page.clickonClose();

	}

	@Test(priority = 9)
	public void clickPractice() {

		page.clickOnPracticeBtn();

	}

	@Test(priority = 10)
	public void clickElements() {

		page.clickOnElementsBtn();

	}

	@Test(priority = 11)
	public void clickRadioButtonMenu() {

		page.clickRadioButtonMenu();

	}
	
	@Test(priority = 12)
	public void selectRadioButtons() throws InterruptedException {

		page.selectRadioButtons();

	}
	

}
