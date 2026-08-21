package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepage.BasePage;

public class RBPractice extends BasePage {
	String excelFilePath = "C:\\Users\\lib-11\\Desktop\\testingbaba\\TestData\\testdata.xlsx";
	WebDriver driver;

	public RBPractice(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath=("//a[normalize-space()='radio buttons']"))
	private WebElement RadioBtn;

	@FindBy(xpath = "//input[@id='yes']")
	private WebElement yesBtn;

	@FindBy(xpath = "//input[@id='impressive']")
	private WebElement impressiveBtn;

	@FindBy(xpath = "//input[@id='no']")
	private WebElement noBtn;

	@FindBy(xpath = "//p[@id='radio-content']")
	private WebElement radioMessage;



	public void clickRadioButtonMenu()
	{
		RadioBtn.click();
	}

	public void selectRadioButtons() throws InterruptedException 
	{
		Thread.sleep(3000);

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

			} else 
			{
				System.out.println("Skipped Radio Button : " + value);
			}
		}
	}}
