package Pages;

import Base.CSProjectSpecification;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CSBookingConfirmationPage extends CSProjectSpecification {

    public CSBookingConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public CSBookingConfirmationPage FirstName(String fname) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));

        // Clear the field in case it has any default value, and then send keys
        element.clear();
        element.sendKeys(fname);
        return this;
    }



    public CSBookingConfirmationPage LastName(String lname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"last_name\"]")));
        element.sendKeys(String.valueOf(lname));
        return this;
    }

    public CSBookingConfirmationPage Address(String Add) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"address\"]")));
        element.sendKeys(String.valueOf(Add));
        return this;
    }

    public CSBookingConfirmationPage CreditCardNo(String CCNo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cc_num\"]")));
        element.sendKeys(String.valueOf(CCNo));
        return this;
    }

    public CSBookingConfirmationPage EnterCCType() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cc_type\"]")));
        element.click();

        WebElement identifier = By.xpath("//*[@id=\"cc_type\"]").findElement(driver);
        Select select = new Select(identifier);
        select.selectByVisibleText("VISA");
        return new CSBookingConfirmationPage(driver);
    }

    public CSBookingConfirmationPage SelectMonth() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cc_exp_month\"]")));
        element.click();

        WebElement identifier = By.xpath("//*[@id=\"cc_exp_month\"]").findElement(driver);
        Select select = new Select(identifier);
        select.selectByVisibleText("October");
        return new CSBookingConfirmationPage(driver);
    }

    public CSBookingConfirmationPage SelectYear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cc_exp_year\"]")));
        element.click();
        WebElement identifier = By.xpath("//*[@id=\"cc_exp_year\"]").findElement(driver);
        Select select = new Select(identifier);
        select.selectByVisibleText("2029");
        return new CSBookingConfirmationPage(driver);
    }

    public CSBookingConfirmationPage CVVNo(String CVVNo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cc_cvv\"]")));
        element.sendKeys(String.valueOf(CVVNo));
        return this;
    }

    public CSBookingConfirmationPage BookButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"book_now\"]")));
        element.click();
        return this;
    }

    public CSBookingConfirmationPage GetOrderNo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"order_no\"]")));
        element.getText();
        return this;
    }

    public CSBookingConfirmationPage IntenaryClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"my_itinerary\"]")));
        element.click();
        return this;
    }



    public CSBookingConfirmationPage CancelBooking() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/a[2]")));
        element.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"booked_form\"]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[1]/input")));
        element1.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"booked_form\"]/table/tbody/tr[3]/td/input[1]")));
        element2.click();


        Alert alert = driver.switchTo().alert();
        alert.accept();


        Thread.sleep((6000));
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/a[4]")).click();
        return this;
    }

    public CSBookingConfirmationPage Logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/a[4]")));
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/a[4]")).click();

        return this;

    }

}
