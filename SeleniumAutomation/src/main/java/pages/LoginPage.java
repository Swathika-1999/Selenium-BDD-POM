package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By signInLink = By.linkText("Sign In");
    By email = By.id("email");
    By pass = By.id("pass");
    By errorMsg = By.cssSelector("div.mage-error");

    public void loginWithInvalidPassword(String emailInput, String wrongPass) throws InterruptedException {
        driver.findElement(signInLink).click();
        Thread.sleep(2000);
        driver.findElement(email).sendKeys(emailInput);
        driver.findElement(pass).sendKeys(wrongPass);
        driver.findElement(By.id("send2")).click();
    }

    public String getLoginErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }

    public void login(String userEmail, String userPass) throws InterruptedException {
        driver.findElement(signInLink).click();
        Thread.sleep(2000);
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(pass).sendKeys(userPass);
        driver.findElement(By.id("send2")).click();
        Thread.sleep(3000);
    }
}
