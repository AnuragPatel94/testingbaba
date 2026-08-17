package testcases;


import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basepage.BasePage;
import pages.Buttons;

public class TC005_BTN extends BasePage{
	Buttons page;

	@BeforeClass
	public void createobject() {
		page=new Buttons(driver);
	}

	@Test(priority = 22)
	public void closePopup() {

		page.clickonClose();

	}

	@Test(priority = 23)
	public void clickPractice() {

		page.clickOnPracticeBtn();

	}

	@Test(priority = 24)
	public void clickElements() {

		page.clickOnElementsBtn();
	}

	@Test(priority=25)

	public void clickButtons() {
		page.clickonButtons();
	}

	@Test(priority=26)
	public void clickondblbtn() {
		page.clickondblbtn();
	}

	@Test(priority=27)
	public void clickonrightbtn() {
		page.clickonrightbtn();
	}

	@Test(priority=28)
	public void clickonclickmebtn() {
		page.clickonclickmebtn();
	}

}
