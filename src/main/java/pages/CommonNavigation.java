package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basepage.BasePage;

public class CommonNavigation extends BasePage{
	
	private WebDriver driver;
	
	public CommonNavigation(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[normalize-space()='×']")
	private WebElement closebtn;

	@FindBy(xpath = "//a[normalize-space()='Practice']")
	private WebElement practiceBtn;

	@FindBy(xpath = "//button[normalize-space()='elements']")
	private WebElement elementsBtn;
	
	
	public void clickonClose() 
	{
		try {
			Thread.sleep(2000);
			closebtn.click();}
		catch (InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}
	}

	public void clickOnPracticeBtn() 
	{
		practiceBtn.click();
	}

	public void clickOnElementsBtn() 
	{
		elementsBtn.click();
	}
	
	


}
