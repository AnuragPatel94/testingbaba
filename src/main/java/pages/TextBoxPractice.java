package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basepage.BasePage;

public class TextBoxPractice extends BasePage {
	String excelFilePath = "C:\\Users\\lib-11\\Desktop\\testingbaba\\TestData\\testdata.xlsx";
	WebDriver driver;

	public TextBoxPractice(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//button[normalize-space()='×']")
	WebElement closebtn;

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

	@FindBy(xpath=("//a[normalize-space()='radio buttons']"))
	WebElement RadioBtn;

	@FindBy(xpath = "//input[@id='yes']")
	WebElement yesBtn;

	@FindBy(xpath = "//input[@id='impressive']")
	WebElement impressiveBtn;

	@FindBy(xpath = "//input[@id='no']")
	WebElement noBtn;
	
	@FindBy(xpath = "//p[@id='radio-content']")
	WebElement radioMessage;
	
	

	public void clickonClose() {
	    try {
	        Thread.sleep(2000);
	        closebtn.click();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	public void clickPractice()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(practiceBtn));

		practiceBtn.click();
	}

	public void clickElements()
	{
		elementsBtn.click();
	}

	public void clickTextBox() 
	{
		textBoxBtn.click();
	}

	public void fillDetails() 
	{
		fullName.sendKeys(getCellData(excelFilePath,0,1,0));
		email.sendKeys(getCellData(excelFilePath,0,1,1));
		currentAddress.sendKeys(getCellData(excelFilePath,0,1,2));
		permanentAddress.sendKeys(getCellData(excelFilePath,0,1,3));
	}

	public void clickSubmit()
	{
		submitBtn.click();
	}

	public void clickRadioButtonMenu()
	{
       
		RadioBtn.click();
	}

	public void selectRadioButtons() throws InterruptedException {

	    Thread.sleep(5000);

	    for (int i = 1; i <= 3; i++) {

	    	String value = getCellData(excelFilePath, 1, i, 0);
	    	String status = getCellData(excelFilePath, 1, i, 1);

	    	System.out.println("--------------------------------");
	    	System.out.println("Row       : " + i);
	    	System.out.println("Value     : [" + value + "]");
	    	System.out.println("Status    : [" + status + "]");

	        if (status.equalsIgnoreCase("TRUE")) {

	            switch (value.toLowerCase()) {

	            case "yes":
	                yesBtn.click();
	                break;

	            case "no":
	                noBtn.click();
	                break;

	            case "impressive":
	                impressiveBtn.click();
	                break;

	            default:
	                System.out.println("Invalid Radio Button : " + value);
	                continue;
	            }

	            
	            Thread.sleep(3000);
	            String actualMessage = radioMessage.getText();
	            String expectedMessage = "You have selected " + value.toLowerCase();

	            
	            System.out.println("=================================");
	            System.out.println("Clicked Radio Button : " + value);
	            System.out.println("Expected Message     : " + expectedMessage);
	            System.out.println("Actual Message       : " + actualMessage);

	            // Verify
	            Assert.assertEquals(actualMessage, expectedMessage);

	            System.out.println("Verification : PASS");

	        } else {

	            System.out.println("Skipped Radio Button : " + value);
	        }
	    }
	}}
	        
	     