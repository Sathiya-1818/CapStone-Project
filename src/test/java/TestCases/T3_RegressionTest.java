package TestCases;

import Base.CSProjectSpecification;
import Pages.CSBookingConfirmationPage;
import Pages.CSCheckInPage;
import Pages.CSHomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class T3_RegressionTest extends CSProjectSpecification {

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
    @Test(priority = 1, groups = "A")
    public static void LoginTest() {

        Test = Extent.createTest("Login Functionality","Testing the Login functionality");
        CSHomePage Obj = new CSHomePage(driver);
        //Obj.CSlaunchandLoad("chrome","https://adactinhotelapp.com/index.php");
        Obj.loginClick()
                .Username("Sangee986")
                .Password("sangee123")
                .LoginButton();
        Test.pass("Login Test executed successfully.");
    }

    @Test(priority = 2, groups = "A")
    public static void CheckInTest() throws InterruptedException {

        Test = Extent.createTest("CheckIn Functionality","Checking whether the CheckIn functionality is processing successfully");
        CSCheckInPage check = new CSCheckInPage(driver);
        check.SelectLocation()
                .SelectHotel()
                .SelectRoomType()
                .SelectNoOfRooms()
                .CheckInDate("16/05/2025")
                .CheckOutDate("19/05/2025")
                .EntNoOfAdults()
                .EntNoOfChildren()
                .SearchButton()
                .SelectfromHotel();
        Test.pass("CheckIn Test executed successfully.");

    }

    @Test(priority = 3, groups = "A")
    public static void BookingTest() throws InterruptedException {

        Test = Extent.createTest("Booking Confirmation Functionality","Checking whether the booking process is running successfully till confirmation process");

        CSBookingConfirmationPage Booking = new CSBookingConfirmationPage(driver);

        Booking.FirstName("Priya")
                .LastName("Mohan")
                .Address("No 12, " + "6th Floor, "+"Block E, "+
                        "Avinash Apartments, "+"Anna Nagar, "+"Chrnnai, "+
                        "Tamilnadu")
                .CreditCardNo("1548545865453333")
                .EnterCCType()
                .SelectMonth()
                .SelectYear()
                .CVVNo("987")
                .BookButton()
                .GetOrderNo()
                .IntenaryClick();
        Test.pass("Booking Test executed successfully.");
    }

    @Test(priority = 4, groups = "A")
    public static void Logout() throws InterruptedException {

        Test=Extent.createTest("LogOut Functionality","checking whether the user logged out successfully");
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"logout\"]")).click();
        System.out.println("Logged Out Successfully");
        Test.pass("Logging Out Test executed successfully.");
        driver.close();

    }
}
