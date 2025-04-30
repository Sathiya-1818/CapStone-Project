package Pages;

import Base.CSProjectSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CSLoginPage extends CSProjectSpecification {

    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement Username ;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement Password ;

    @FindBy(xpath = "//*[@id=\"login\"]")
    WebElement LoginButton;

    public CSLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public CSLoginPage Username(String name){
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(name);
        return this;
    }
    public CSLoginPage Password(String password) {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        return this;
    }
    public CSHomePage LoginButton() {
        LoginButton.click();
        return new CSHomePage(driver);
    }

}
