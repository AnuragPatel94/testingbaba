package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import basepage.BasePage;
import org.openqa.selenium.By;

public class WebTable extends BasePage{

	WebDriver driver;
	String path="C:\\Users\\lib-11\\Desktop\\testingbaba\\TestData\\testdata.xlsx";
	WebDriverWait wait;

	public WebTable(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);

	}

	@FindBy(xpath="//a[normalize-space()='web tables']")
	private WebElement webtb;

	@FindBy(xpath="//iframe[@src='Webtable.html']")
	private WebElement frame;

	@FindBy(xpath="//input[@name='name']")
	private WebElement nameph;

	@FindBy(xpath="//input[@title='eg name@gmail.com']")
	private WebElement mailph;

	@FindBy (xpath="//button[@type='submit']")
	private WebElement savebtn;

	@FindBy(xpath="//table[@class='table table-bordered data-table']//tbody/tr")
	private List<WebElement> rowsdata;

	@FindBy(xpath="//button[@class='btn btn-info btn-xs btn-edit']")
	private WebElement editbtn;

	@FindBy(xpath="//td[normalize-space()='anurag']")
	private WebElement name;

	@FindBy(xpath="//td[normalize-space()='anurag@gmail.com']")
	private WebElement mail;

	
	public void clickonwebtable() 
	{
		webtb.click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='Webtable.html']")));
		System.out.println("Successfully switched to Webtable iframe");
	}

	public void fillDetails() 
	{
		for (int row = 1; row <= 10; row++) {

			String name = getCellData(path, 2, row, 0);
			String email = getCellData(path, 2, row, 1);
			System.out.println("Saved: " + name + " | " + email);

			nameph.clear();
			nameph.sendKeys(name);
			mailph.clear();
			mailph.sendKeys(email);

			WebElement savebtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
			savebtn.click();
		}}

	public void verifyFillDetails()
	{
		for (int i = 0; i < rowsdata.size(); i++) {

			// Excel data
			String expectedName =getCellData(path, 2, i + 1, 0);
			String expectedEmail =getCellData(path, 2, i + 1, 1);

			// UI row
			WebElement row = rowsdata.get(i);
			String actualName =row.findElement(By.xpath("./td[1]")).getText();
			String actualEmail =row.findElement(By.xpath("./td[2]")).getText();

			System.out.println("--------------------------------");

			System.out.println("Row          : " + (i + 1));

			System.out.println("Expected Name  : " + expectedName);
			System.out.println("Actual Name    : " + actualName);

			System.out.println("Expected Email : " + expectedEmail);
			System.out.println("Actual Email   : " + actualEmail);

			Assert.assertEquals(actualName,expectedName,"Name mismatch at row " + (i + 1));
			Assert.assertEquals(actualEmail,expectedEmail,"Email mismatch at row " + (i + 1));
			System.out.println("Verification : PASS");
		}}
}
