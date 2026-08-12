package basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.ExcelUtils;

public class BasePage implements ExcelUtils {

    public static WebDriver driver;
    public static Properties prop;
    
   
    @BeforeClass
    @Parameters({"os", "browser"})
    public void setup(String os, String br) throws IOException {

        // Load properties
        FileReader file = new FileReader( "./src/test/resources/config.properties");

        prop = new Properties();
        prop.load(file);
        file.close();

        // Read environment
        String environment = prop.getProperty("execution_env");

        if (environment == null || environment.trim().isEmpty()) {
            throw new RuntimeException(
                    "execution_env is missing in config.properties"
            );
        }

        System.out.println("Execution Environment : " + environment);
        System.out.println("OS                     : " + os);
        System.out.println("Browser                : " + br);


        // Launch browser
        switch (br.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException(
                        "Invalid browser: " + br
                );
        }


        driver.manage().deleteAllCookies();

        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.ofSeconds(5));


        // Read environment-specific URL
        String url = prop.getProperty(
                environment + "_URL"
        );

        if (url == null || url.trim().isEmpty()) {
            throw new RuntimeException(
                    "URL not found for environment: "
                    + environment
            );
        }

        System.out.println("Application URL : " + url);

        driver.get(url);

        driver.manage().window().maximize();
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

