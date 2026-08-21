package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basepage.BasePage;

public class Alerts extends BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Alerts (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//button[contains(@data-target,'alerts')]")
	private WebElement alrtwindows;
	
	@FindBy(xpath="//a[normalize-space()='alerts']")
	private WebElement alertbtn;
	
	@FindBy(xpath="//button[@onclick='myalert()']")
	private WebElement alertbtn1;
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[13]/div[2]/div[2]/button[1]")
	private WebElement alertbtn2;
	
	@FindBy(xpath="//button[@onclick='myconfirm()']")
	private WebElement alertbtn3;
	
	@FindBy(xpath="//span[@id='confirm-result']")
	private WebElement result;
	
	@FindBy(xpath="//button[@onclick='myprompt()']")
	private WebElement alertbtn4;
	
	@FindBy(xpath="//span[@id='name-result']")
	private WebElement inputvalue;
	
	
	
	public void clickalrtwindows() 
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(alrtwindows));
	    alrtwindows.click();
	}
	
	
	public void clickalertbtn() 
	{
		alertbtn.click();
	}
	
	public void clickalertbtn1() 
	{
		alertbtn1.click();
		driver.switchTo().alert().accept();
	}
	
	public void clickalertbtn2() throws InterruptedException
	{
		alertbtn2.click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
	}
	
	public void clickalertbtn3() {
	    alertbtn3.click();
	    Alert alert = driver.switchTo().alert();
	    alert.dismiss();

	    String msg = result.getText();
	    System.out.println("Confirm Alert Result: " + msg);
	}
	
	public void clickalertbtn4() {
	    alertbtn4.click();

	    Alert alert = driver.switchTo().alert();
	    alert.sendKeys("Anurag");
	    alert.accept();

	    String msg = inputvalue.getText();
	    System.out.println("Prompt Alert Result: " + msg);
	}
		
		}
	
	


