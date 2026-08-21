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

public class BrowserWindow extends BasePage {

	WebDriver driver;
	WebDriverWait wait;

	public BrowserWindow(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);}


	@FindBy(xpath="//button[contains(@data-target,'alerts')]")
	private WebElement alrtwindows;

	@FindBy(xpath="//a[normalize-space()='browser windows']")
	private WebElement browserwindow;

	@FindBy(xpath="//a[normalize-space()='New Tab']")
	private WebElement newTab;

	@FindBy(xpath="//a[normalize-space()='New Window']")
	private WebElement newWindow;

	@FindBy(xpath="//a[normalize-space()='New Window Message']")
	private WebElement newWindowMessage;


	public void clickalrtwindows() 
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(alrtwindows));
	    alrtwindows.click();
	}

	public void clickbrowserwindow() 
	{
		browserwindow.click();
	}


	public String clickNewTab() 
	{
		String mainWindow = driver.getWindowHandle();
		newTab.click();

		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {

			if (!window.equals(mainWindow)) {

				driver.switchTo().window(window);
				String url = driver.getCurrentUrl();
				System.out.println("New Tab URL = " + url);

				driver.close();
				driver.switchTo().window(mainWindow);

				return url;
			}
		}

		return null;
	}


	public String clickNewWindow() {

	    String mainWindow = driver.getWindowHandle();
	    newWindow.click();

	    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));

	    for (String window : driver.getWindowHandles()) {

	        if (!window.equals(mainWindow)) {

	            driver.switchTo().window(window);
	            String url = driver.getCurrentUrl();
	            System.out.println("New Window URL = " + url);

	            driver.close();
	            driver.switchTo().window(mainWindow);

	            return url;
	            }
	        }
	    return null;
	}


	public void clickNewWindowMessage() 
	{
	    newWindowMessage.click();
	    
	}
	
	}