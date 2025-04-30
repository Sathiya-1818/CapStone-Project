package TestCases;

import Base.CSProjectSpecification;
import Pages.CSHomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class T2_CSInvalidLoginTest extends CSProjectSpecification {

    @BeforeTest
    public void setup() throws IOException {
        // Set up ExtentReports for test logging
        ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\HOSUR PS\\IdeaProjects\\MainProject\\CSReports\\CapStoneProjectReports.html");
        Extent = new ExtentReports();
        Extent.attachReporter(reporter);

        // Test metadata
        TestName = "RegressionTest";
        TestDescription = "Testing the functionalities with hardcoded data";
        TestAuthor = "Sathiya Priya";
        TestCategory = "Regression Testing";
    }

    @Test(priority = 1, groups = "C")
    public void CSInvalidLoginTest() throws InterruptedException {

        Test = Extent.createTest("Invalid Login Functionality","Checking whether Login function is running successfully");

        CSHomePage Obj = new CSHomePage(driver);
        //Obj.CSbrowserlaunch("https://adactinhotelapp.com/index.php");
        Obj.loginClick()
                .Username("Sangee896")
                .Password("sangee123")
                .LoginButton()
                .ValidateLogin1();
        Test.fail("Login Unsuccessful");

    }}
