package TestCases;

import Base.CSProjectSpecification;
import Pages.CSBookingConfirmationPage;
import Pages.CSHomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class T4_CancelBookingTest extends CSProjectSpecification {

    @BeforeTest
    public void setup() throws IOException {

        ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\HOSUR PS\\IdeaProjects\\MainProject\\CSReports\\CapStoneProjectReports.html");
        Extent = new ExtentReports();
        Extent.attachReporter(reporter);

        TestName = "RegressionTest";
        TestDescription = "Testing the functionalities with hardcoded data";
        TestAuthor = "Sathiya Priya";
        TestCategory = "Regression Testing";
    }

    @Test(priority = 1, groups = "B")
    public void CSLoginTest() {

        CSHomePage Obj = new CSHomePage(driver);
        //Obj.CSbrowserlaunch("https://adactinhotelapp.com/index.php");
        Obj.loginClick()
                .Username("Sangee986")
                .Password("sangee123")
                .LoginButton();
        Test.pass("Login Test executed successfully.");
    }

    @Test(priority = 2, groups = "B")
    public void CSCancelBooking() throws InterruptedException {

        CSBookingConfirmationPage Obj = new CSBookingConfirmationPage(driver);
        Obj
                .CancelBooking().CScloseBrowser();
        Test.pass("Cancel Booking Test executed successfully.");
    }
}
