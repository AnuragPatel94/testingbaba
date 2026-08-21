package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import basepage.BasePage;

public class FileUpload extends BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public FileUpload(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[normalize-space()='upload and download']")
    private WebElement upload;

    @FindBy(xpath="//input[@id='File1']")
    private WebElement chosefilebtn;

    public void clickupload() throws AWTException {

        upload.click();

        Robot rb = new Robot();
        rb.delay(2000);

        StringSelection ss = new StringSelection(
            "C:\\Users\\lib-11\\Desktop\\testdata.xlsx"
        );

        Toolkit.getDefaultToolkit()
                .getSystemClipboard()
                .setContents(ss, null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
}