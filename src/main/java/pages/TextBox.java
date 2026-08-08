package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBox {
	
	WebDriver driver;
	
	public TextBox(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	
}
	@FindBy(xpath = "//button[@data-dismiss='modal']")
	WebElement closeBtn;
	
	@FindBy(xpath=("//a[normalize-space()='Practice']"))
    WebElement practiceBtn;
	
	@FindBy(xpath=("//button[normalize-space()='elements']"))
	WebElement elementsBtn;
	
	@FindBy(xpath=("//a[normalize-space()='text box']"))
     WebElement textBoxBtn;
	
	@FindBy(xpath=("//input[@id='fullname1']"))
	WebElement fullName;
	
	@FindBy(xpath=("//input[@id='fullemail1']"))
	WebElement email;
	
	@FindBy(xpath=("//textarea[@id='fulladdresh1']"))
	WebElement currentAddress;
	
	@FindBy(xpath=("//textarea[@id='paddresh1']"))
	WebElement permanentAddress;
	
	@FindBy(xpath=("//input[@value='Submit']"))
	WebElement submitBtn;
	
	
	// ================= Actions =================
	
	public void clickClose() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    wait.until(ExpectedConditions.visibilityOf(closeBtn));
	    wait.until(ExpectedConditions.elementToBeClickable(closeBtn));

	    closeBtn.click();

	    // Wait for the popup to disappear
	    wait.until(ExpectedConditions.invisibilityOf(closeBtn));
	}
	
	public void clickPractice() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(practiceBtn));

	    practiceBtn.click();
	
    }

    public void clickElements() {
        elementsBtn.click();
    }

    public void clickTextBox() {
        textBoxBtn.click();
    }

    public void enterFullName(String name) {
        fullName.clear();
        fullName.sendKeys(name);
    }

    public void enterEmail(String emailId) {
        email.clear();
        email.sendKeys(emailId);
    }

    public void enterCurrentAddress(String address) {
        currentAddress.clear();
        currentAddress.sendKeys(address);
    }

    public void enterPermanentAddress(String address) {
        permanentAddress.clear();
        permanentAddress.sendKeys(address);
    }

    public void clickSubmit() {
        submitBtn.click();
    }
    
 // Reusable method to fill the entire form
    public void fillTextBoxForm(String name,
                                String emailId,
                                String currentAddr,
                                String permanentAddr) {

        enterFullName(name);
        enterEmail(emailId);
        enterCurrentAddress(currentAddr);
        enterPermanentAddress(permanentAddr);
        clickSubmit();
    }
}
