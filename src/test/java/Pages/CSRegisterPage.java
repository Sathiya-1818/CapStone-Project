package Pages;

import Base.CSProjectSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CSRegisterPage extends CSProjectSpecification {

    public CSRegisterPage() {
        this.driver = driver;
    }

    public CSRegisterPage Username() {
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Sangee986");
        return this;
    }
    public CSRegisterPage Password() {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("sangee123");
        return this;
    }
    public CSRegisterPage ConfirmPassword() {
        driver.findElement(By.xpath("//*[@id=\"re_password\"]")).sendKeys("sangee123");
        return this;
    }
    public CSRegisterPage Fullname() {
        driver.findElement(By.xpath("//*[@id=\"full_name\"]")).sendKeys("Sangeetha");
        return this;
    }
    public CSRegisterPage Email() {
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("meh412523@gmail.com");
        return this;
    }
    public CSRegisterPage Captcha() {

        WebElement captcha = driver.findElement(By.xpath("//*[@id=\"captcha\"]"));
        driver.get(captcha.getAttribute(String.valueOf(captcha)));

        driver.findElement(By.xpath("//*[@id=\"captcha-form\"]")).sendKeys((CharSequence) captcha);
        return this;
    }
    public CSRegisterPage TermAgree() {
        WebElement  captcha = driver.findElement(By.xpath("//*[@id=\"tnc_box\"]"));
        driver.findElement(By.xpath("//*[@id=\"tnc_box\"]")).click();
        return this;
    }
    public CSRegisterPage RegButton() {
        driver.findElement(By.xpath("//*[@id=\"Submit\"]")).click();
        return this;
    }

}
