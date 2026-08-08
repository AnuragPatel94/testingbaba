package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basepage.BasePage;
import pages.TextBoxPractice;

public class TextBoxPracticeTest extends BasePage {

    TextBoxPractice page;

    @BeforeClass
    public void createObject() {

        page = new TextBoxPractice(driver);

    }

    @Test(priority = 1)
    public void closePopup() {

        page.clickonClose();

    }

    @Test(priority = 2)
    public void clickPractice() {

        page.clickPractice();

    }

    @Test(priority = 3)
    public void clickElements() {

        page.clickElements();

    }

    @Test(priority = 4)
    public void clickTextBox() {

        page.clickTextBox();

    }

    @Test(priority = 5)
    public void enterData() {

        page.fillDetails();

    }

    @Test(priority = 6)
    public void submit() {

        page.clickSubmit();

    }
    @Test(priority = 7)
    public void clickRadioButtonMenu() 
    {

		page.clickRadioButtonMenu();

	}
    @Test(priority = 8)
    public void selectRadioButtons() throws InterruptedException 
	{
		
		page.selectRadioButtons();
	}
    
	}
	
    
    
    
    	
    
	
