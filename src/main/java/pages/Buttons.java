package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basepage.BasePage;

public class Buttons extends BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Buttons(WebDriver driver) {
		this.driver= driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath ="//button[normalize-space()='×']")
	private WebElement closebtn;

	@FindBy(xpath ="//a[normalize-space()='Practice']")
	private WebElement practiceBtn;

	@FindBy(xpath ="//button[normalize-space()='elements']")
	private WebElement elementsBtn;

	
	@FindBy(xpath="//a[@href='#tab_5' and normalize-space()='buttons']")
	private WebElement buttonTab;
	
	@FindBy(xpath="//button[@ondblclick='doubletext()']")
	private WebElement doubleClickButton;
	
	
	@FindBy(xpath="//button[contains(normalize-space(),'Right Click Me')]")
	private WebElement rightClickButton;
	
	
	@FindBy(xpath="//button[@onclick='clicktext()']")
	private WebElement clickMeButton;
	
	@FindBy(id = "double-content")
	private WebElement doubleClickMessage;
	
	@FindBy(id = "right-content")
	private WebElement rightClickMessage;
	
	@FindBy(id = "click-content")
	private WebElement clickMessage;
	
	

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

public void clickonButtons() {
	
	
	buttonTab.click();
}

public void clickondblbtn() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    Actions actions = new Actions(driver);
    actions.doubleClick(doubleClickButton).perform();

    wait.until(ExpectedConditions.textToBePresentInElement(
            doubleClickMessage,
            "you have done a double click"
    ));

    String actual = doubleClickMessage.getText();
    String expected = "you have done a double click";

    System.out.println("Actual   : " + actual);
    System.out.println("Expected : " + expected);

    Assert.assertEquals(actual, expected,
            "Double click message validation failed");

    System.out.println("Double click message validation PASS");
}

public void clickonrightbtn() {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    Actions actions = new Actions(driver);
    actions.contextClick(rightClickButton).perform();

    wait.until(ExpectedConditions.textToBePresentInElement(
            rightClickMessage,
            "you have done a right click"
    ));

    String actual = rightClickMessage.getText();
    String expected = "you have done a right click";

    System.out.println("Actual   : " + actual);
    System.out.println("Expected : " + expected);

    Assert.assertEquals(actual, expected,
            "Right click message validation failed");

    System.out.println("Right click message validation PASS");
}

public void clickonclickmebtn() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    Actions actions = new Actions(driver);
    actions.click(clickMeButton).perform();

    wait.until(ExpectedConditions.textToBePresentInElement(
    		clickMessage,
            "you have done a dynamic click"
    ));

    String actual = clickMessage.getText();
    String expected = "you have done a dynamic click";

    System.out.println("Actual   : " + actual);
    System.out.println("Expected : " + expected);

    Assert.assertEquals(actual, expected,
            "Dynamic click message validation failed");

    System.out.println("Dynamic click message validation PASS");
}
}
