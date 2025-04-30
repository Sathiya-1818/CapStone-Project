package Pages;

import Base.CSProjectSpecification;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CSHomePage extends CSProjectSpecification {
    @FindBy(xpath = "//*[@id=\"login_form\"]/table/tbody/tr[7]/td/a")
    WebElement register;

    private static final String SCREENSHOT_FOLDER = "C:\\Users\\HOSUR PS\\IdeaProjects\\MainProject\\CSSnaps\\";
    public String TestName;
    private String ActualUsername;

    public CSHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CSRegisterPage registerclick() {
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/table/tbody/tr[7]/td/a")).click();
        return new CSRegisterPage();
    }

    public CSLoginPage loginClick() {
        driver.findElement((By.xpath("//*[@id=\"username\"]"))).click();
        return new CSLoginPage(driver);
    }

    public CSHomePage ValidateLogin() throws InterruptedException {
        Thread.sleep(6000);

        WebElement Username = driver.findElement(By.xpath("//*[@id=\"username_show\"]"));
        String ExpectedUsername = "HelloSangee986!";
        CSVisibilityofElement(Username);
        String ActualUsername = Username.getText();
        System.out.println(ActualUsername);

        if (ExpectedUsername.equalsIgnoreCase(ActualUsername)) {
            System.out.println("Registration is Successfull");
        } else {
            System.out.println("Registration is Unsuccessfull");
        }
        return this;
    }
    public CSHomePage ValidateLogin1() {
        WebElement Username = driver.findElement(By.xpath("//*[@id=\"username\"]"));

        String ExpectedUsername = "Sangee986";
        if (ExpectedUsername==ActualUsername) {
            System.out.println("Registration is Successfull");
        } else {
            System.out.println("Registration is Unsuccessfull");
        }
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Ensure folder exists
            File folder = new File(SCREENSHOT_FOLDER);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = SCREENSHOT_FOLDER + TestName + "_" + timestamp + ".png";

            FileUtils.copyFile(srcFile, new File(filePath));
            System.out.println("Screenshot saved successfully: " + filePath);

            //return filePath; // Returns the saved path for reference
        } catch (IOException e) {
            System.out.println("Screenshot saving failed: " + e.getMessage());
            e.printStackTrace(); // Helps debug any issues
        }
        return this;
    }

}
