package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AccountPage;
import pages.LoginPage;

public class AccountSteps {

    WebDriver driver;
    AccountPage accountPage;
    LoginPage loginPage;

    @Given("user launches the browser")
    public void user_launches_the_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("user navigates to Magento homepage")
    public void user_navigates_to_magento_homepage() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @And("user clicks create account with empty form")
    public void user_clicks_create_account_with_empty_form() {
        accountPage = new AccountPage(driver);
        accountPage.submitEmptyAccountForm();
    }

    @Then("error message should be shown")
    public void error_message_should_be_shown() {
        Assert.assertTrue(accountPage.getErrorMessage().length() > 0);
    }

    @And("user enters invalid email while creating account")
    public void user_enters_invalid_email() throws InterruptedException {
        accountPage = new AccountPage(driver);
        accountPage.goToCreateAccount();
        accountPage.fillInvalidEmailAccount("Test", "User", "invalid-email", "Swathika@123");
    }

    @And("user tries to login with invalid password")
    public void user_tries_login_with_wrong_password() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.loginWithInvalidPassword("swathikasri@gmail.com", "  ");
    }

    @Then("login error should be shown")
    public void login_error_should_be_shown() {
        Assert.assertTrue(loginPage.getLoginErrorMessage().length() > 0);
    }

    @And("user creates a new account with valid details")
    public void user_creates_a_new_account_with_valid_details() throws InterruptedException {
        accountPage = new AccountPage(driver);
        accountPage.goToCreateAccount();
        accountPage.fillAccountDetails("Swathika", "Pradeep", "swathikasri15@gmail.com", "Swathika@456");
    }

    @And("user logs into the application")
    public void user_logs_into_the_application() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.login("swathikasri62@gmail.com", "Swathika@123");
    }

    @Then("browser is closed")
    public void browser_is_closed() {
        driver.quit();
    }

}
