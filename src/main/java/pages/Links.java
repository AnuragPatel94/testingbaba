package pages;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basepage.BasePage;

public class Links extends BasePage {

	WebDriver driver;
	WebDriverWait wait;

	public Links(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);

	}

	@FindBy(xpath="//a[normalize-space()='links']")
	private WebElement linkbtn;

	@FindBy(xpath="//a[normalize-space()='Demo Page']")
	private WebElement demopage;

	@FindBy(xpath="//a[normalize-space()='Created']")
	private WebElement createdlink;
	
	@FindBy(xpath="//p[@id='link-result']")
	private WebElement txtmsg;

	
	public void clickonlink() 
	{
		linkbtn.click();
	}


	public void clickOnDemo() 
	{
		String parentWindow = driver.getWindowHandle();
		demopage.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {

			if (!window.equals(parentWindow)) {

				// Switch to new window
				driver.switchTo().window(window);
				System.out.println("New Window Title: " + driver.getTitle());
				System.out.println("New Window URL: " + driver.getCurrentUrl());


				// New window se parent window par wapas
				driver.switchTo().window(parentWindow);
			}
		}}
	
	public void clickOnCreatedLink() {
		createdlink.click();
		String msg=txtmsg.getText();
		
		
		System.out.println("------------------------");
		System.out.println(msg);
	}
}






