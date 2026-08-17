package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basepage.BasePage;
import pages.CheckBox;
import pages.WebTable;

public class TC004_WT extends BasePage{
	
	WebTable page;
	
	@BeforeClass
	public void createObject() {

		page = new WebTable(driver);

	}
	
	@Test(priority = 17)
	public void closePopup() {

		page.clickonClose();

	}

	@Test(priority = 18)
	public void clickPractice() {

		page.clickOnPracticeBtn();

	}

	@Test(priority = 19)
	public void clickElements() {

		page.clickOnElementsBtn();

}
@Test(priority=19)
public void clickonwebtable() {
	page.clickonwebtable();
	
}
@Test(priority=20)
public void filldata() 

{
	page.fillDetails();
	
}

@Test(priority=21)
public void verifyFillDetails() {
	page.verifyFillDetails();
}
}


