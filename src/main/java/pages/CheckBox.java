package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basepage.BasePage;

public class CheckBox extends BasePage {

	WebDriver driver;
	WebDriverWait wait;

	public CheckBox(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space()='×']")
	private WebElement closebtn;

	@FindBy(xpath = "//a[normalize-space()='Practice']")
	private WebElement practiceBtn;

	@FindBy(xpath = "//button[normalize-space()='elements']")
	private WebElement elementsBtn;

	@FindBy(xpath = "//a[normalize-space()='check box']")
	private WebElement checkBoxBtn;

	@FindBy(xpath = "//label[@for='myCheck']")
	private WebElement mobiletxt;

	@FindBy(xpath = "//label[@for='mylaptop']")
	private WebElement laptoptxt;

	@FindBy(xpath = "//label[@for='desktop']")
	private WebElement desktoptxt;

	@FindBy(id = "myCheck")
	private WebElement mobileCheckbox;

	@FindBy(xpath = "//h6[@id='text']")
	private WebElement Message;

	@FindBy(xpath = "//h6[@id='text1']")
	private WebElement Message1;

	@FindBy(xpath = "//h6[@id='text2']")
	private WebElement Message2;

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

	// Click Check Box menu and enter iframe
	public void clickCheckBoxBtn() 
	{
		checkBoxBtn.click();
		WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe")));
		driver.switchTo().frame(frame);
	}

	// Mobile checkbox
	public void clickMobileCheckBox() 
	{
		mobiletxt.click();
		wait.until(ExpectedConditions.visibilityOf(Message));
		String message = Message.getText();
		System.out.println("Mobile checkbox message: " + message);
	}

	// Laptop checkbox
	public void clickLaptopCheckBox() 
	{
		laptoptxt.click();
		wait.until(ExpectedConditions.visibilityOf(Message));
		String message1 = Message1.getText();
		System.out.println("Laptop checkbox message: " + message1);
	}


	// Desktop checkbox
	public void clickDesktopCheckBox() 
	{
		desktoptxt.click();
		wait.until(ExpectedConditions.visibilityOf(Message));
		String message2 = Message2.getText();
		System.out.println("Desktop checkbox message: " + message2);
		
	}

             
	
	// Exit iframe
	public void switchToMainPage() {
		driver.switchTo().defaultContent();
	}
}