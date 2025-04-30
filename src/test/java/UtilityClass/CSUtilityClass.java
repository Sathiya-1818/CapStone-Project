package UtilityClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class CSUtilityClass {

    public static WebDriver driver;
    private static final String SCREENSHOT_FOLDER = "C:\\Users\\HOSUR PS\\IdeaProjects\\MainProject\\CSSnaps\\";
    public static Properties Prop;
    public String SheetName;

    public static ExtentTest Test;
    public static ExtentReports Extent = new ExtentReports();

    public String TestName, TestDescription, TestCategory, TestAuthor;

    @BeforeTest
    public void CSbrowserlaunch(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://adactinhotelapp.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterTest
    public void CScloseBrowser(){
        driver.quit();

    }
    public void CSVisibilityofElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void readFromPropFile(String fileName) throws IOException {

        FileReader file = new FileReader("C:\\Users\\HOSUR PS\\IdeaProjects\\MainProject\\src\\test\\resources\\CSTestData\\"+fileName+".properties");
        Prop = new Properties();
        Prop.load(file);
    }

    public static String[][] CSexcelRead(String sheetName) throws IOException {

        XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\HOSUR PS\\IdeaProjects\\MainProject\\src\\test\\resources\\CSTestData\\CSLoginData.xlsx");

        XSSFSheet sheet = book.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();

        int columnCount = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[rowCount][columnCount];

        for(int i =1 ; i <= rowCount; i++) {

            XSSFRow row = sheet.getRow(i);

            for(int j =0 ; j<columnCount; j++) {

                XSSFCell cell = row.getCell(j);

                data[i-1][j] = cell.getStringCellValue();

            }

        }

        book.close();
        return data;
    }


    public static String captureScreenshot(String testName) {

        if (driver == null) {
            System.out.println("Driver is closed or not initialized—unable to capture screenshot.");
            return null;
        }

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Ensure folder exists
            File folder = new File(SCREENSHOT_FOLDER);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = SCREENSHOT_FOLDER + testName + "_" + timestamp + ".png";

            FileUtils.copyFile(srcFile, new File(filePath));
            System.out.println("Screenshot saved successfully: " + filePath);

            return filePath; // Returns the saved path for reference
        } catch (IOException e) {
            System.out.println("Screenshot saving failed: " + e.getMessage());
            e.printStackTrace(); // Helps debug any issues
        }
        return null;
    }

}
