package Base;

import UtilityClass.CSUtilityClass;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class CSProjectSpecification extends CSUtilityClass {
    //public static String Url ="https://adactinhotelapp.com/index.php";

    @BeforeClass
    public void testDetails() {

        if (Extent == null) {
            System.out.println("ExtentReports is not initialized! Check DBUtilityClass.");
        }
        Test = Extent.createTest(TestName,TestDescription);
        Test.assignCategory(TestCategory);
        Test.assignAuthor(TestAuthor);

    }
    public void CSlaunchandLoad() {
        if (driver == null) {
            CSbrowserlaunch();
        }
    }


        public void tearDown(ITestResult result) {
            if (ITestResult.FAILURE == result.getStatus()) {
                CSUtilityClass.captureScreenshot(result.getName()); // Call screenshot method
            }else {
                System.out.println("Driver is null, cannot capture screenshot!");
            }
            if (driver != null) {
                driver.quit();
            }
        }


        @AfterSuite
        public void DBreportClose() {

            if (driver != null) {
                driver.quit();
                System.out.println("WebDriver closed successfully.");
            }

            if (Extent != null) {
                Extent.flush();
                System.out.println("ExtentReports flushed and saved.");
            }

        }


    }
