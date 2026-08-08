package basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.ExcelUtils;


public class BasePage implements ExcelUtils {

    public static WebDriver driver;
    

    @BeforeClass
    public void launchBrowser() {
    	 

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.astrovidhan.com/");
    }

    @Override
    public String getCellData(String excelFilePath, int sheetNo, int row, int col)
    {

        String value = "";

        try {

        	FileInputStream fis = new FileInputStream(excelFilePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheetAt(sheetNo);

            value = sheet.getRow(row).getCell(col).toString();

            workbook.close();

        }

        catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return value;

    }
    public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
   @AfterClass
    public void tearDown() {

        if (driver != null) {

            driver.quit();

        }}

    }

