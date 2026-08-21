package pages;


import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import basepage.BasePage;

public class TextBoxPractice extends BasePage {
	String excelFilePath = "C:\\Users\\lib-11\\Desktop\\testingbaba\\TestData\\testdata.xlsx";
	WebDriver driver;

	public TextBoxPractice(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=("//a[normalize-space()='text box']"))
	private WebElement textBoxBtn;

	@FindBy(xpath=("//input[@id='fullname1']"))
	private WebElement fullName;

	@FindBy(xpath=("//input[@id='fullemail1']"))
	private WebElement email;

	@FindBy(xpath=("//textarea[@id='fulladdresh1']"))
	private WebElement currentAddress;

	@FindBy(xpath=("//textarea[@id='paddresh1']"))
	private WebElement permanentAddress;

	@FindBy(xpath=("//input[@value='Submit']"))
	private WebElement submitBtn;

	@FindBy(xpath = "//*[@class='col-md-6 mt-5']//label")
	private List<WebElement> listofElements;


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


	public void verifyFillDetails() 
	{
		for (int i = 1; i < listofElements.size(); i += 2) {

			int column = (i - 1) / 2;
			String expected =getCellData(excelFilePath, 0, 1, column);
			String actual =listofElements.get(i).getText();

			System.out.println("-----------------------------");
			System.out.println("Column   : " + column);
			System.out.println("Expected : " + expected);
			System.out.println("Actual   : " + actual);

			Assert.assertEquals(actual,expected,"Details mismatch at column " + column);

			System.out.println("Verification : PASS");
		}
	}

	public void clickSubmit()
	{
		submitBtn.click();
	}
}
