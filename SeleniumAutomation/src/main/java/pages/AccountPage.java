package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By createAccountLink = By.linkText("Create an Account");
    By firstName = By.id("firstname");
    By lastName = By.id("lastname");
    By email = By.id("email_address");
    By password = By.id("password");
    By confirmPassword = By.id("password-confirmation");
    By errorMsg = By.cssSelector("div.mage-error");

    public void submitEmptyAccountForm() {
        driver.findElement(createAccountLink).click();
        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }

    public void fillInvalidEmailAccount(String fname, String lname, String emailVal, String pwd) throws InterruptedException {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(email).sendKeys(emailVal);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
        Thread.sleep(2000);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(pwd);
        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
    }

    public void goToCreateAccount() {
        driver.findElement(createAccountLink).click();
    }

    public void fillAccountDetails(String fname, String lname, String emailVal, String pwd) throws InterruptedException {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(email).sendKeys(emailVal);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(confirmPassword).sendKeys(pwd);
        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
        Thread.sleep(3000);

    }
}
