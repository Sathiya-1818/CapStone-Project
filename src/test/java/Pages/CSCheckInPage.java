package Pages;

import Base.CSProjectSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CSCheckInPage extends CSProjectSpecification {

    @FindBy(xpath="//*[@id=\"location\"]")
    WebElement Location;

    public CSCheckInPage(WebDriver driver) {
        this.driver = driver;
    }

    public CSCheckInPage SelectLocation() throws InterruptedException {
        Thread.sleep(6000);
        WebElement Location = driver.findElement(By.xpath("//*[@id=\"location\"]"));
        Location.click();

        WebElement identifier = By.xpath("//*[@id=\"location\"]").findElement(driver);
        Select select = new Select(identifier);
        select.selectByVisibleText("Melbourne");
        return this;
    }

    public CSCheckInPage SelectHotel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hotels\"]")));
        element.click();

        WebElement identifier = By.xpath("//*[@id=\"hotels\"]").findElement(driver);
        Select select = new Select(identifier);
        select.selectByVisibleText("Hotel Sunshine");
        return this;
    }

    public CSCheckInPage SelectRoomType() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"room_type\"]")));
        element.click();

        WebElement identifier = By.xpath("//*[@id=\"room_type\"]").findElement(driver);
        Select select = new Select(identifier);
        select.selectByVisibleText("Deluxe");
        return this;
    }

    public CSCheckInPage SelectNoOfRooms() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"room_nos\"]")));
        element.click();

        WebElement identifier = By.xpath("//*[@id=\"room_nos\"]").findElement(driver);
        Select select = new Select(identifier);
        select.selectByIndex(2);
        return this;
    }

    public CSCheckInPage CheckInDate(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"datepick_in\"]")));
        element.sendKeys(name);
        return this;
    }

    public CSCheckInPage CheckOutDate(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"datepick_out\"]")));
        element.sendKeys(name);
        return this;
    }

    public CSCheckInPage EntNoOfAdults() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"adult_room\"]")));
        element.click();

        WebElement identifier = By.xpath("//*[@id=\"adult_room\"]").findElement(driver);
        Select select = new Select(identifier);
        select.selectByIndex(3);
        return this;
    }

    public CSCheckInPage EntNoOfChildren() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"child_room\"]")));
        element.click();

        WebElement identifier = By.xpath("//*[@id=\"child_room\"]").findElement(driver);
        Select select = new Select(identifier);
        select.selectByIndex(2);
        return this;
    }

    public CSCheckInPage SearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Submit\"]")));
        element.click();
        return this;
    }
    public CSCheckInPage SelectfromHotel() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"radiobutton_0\"]")));
        element.click();

        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"continue\"]")));
        element1.click();
        return new CSCheckInPage(driver);
    }

}
