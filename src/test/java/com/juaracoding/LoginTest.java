package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTest {

    private static WebDriver driver;
    private ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();

    public LoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        driver.get(Constants.URL);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.URL);
        extentTest.log(LogStatus.PASS, "I am on the login page");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password){
        loginPage.loginUser(username, password);
        extentTest.log(LogStatus.PASS, "I enter username "+username+" and password "+password);
    }

    @And("I click the login button")
    public void i_click_the_login_button(){
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS, "I click the login button");
    }

    @Then("I should be redirected to product page")
    public void i_should_be_redirected_to_product_page(){
        Assert.assertEquals(loginPage.getTxtProduct(), "Products");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        extentTest.log(LogStatus.PASS, "I should be redirected to product page");
    }

    @Then("Alert with message {string} will appear")
    public void alert_with_message_will_appear(String expectedErrorMessage){
        Assert.assertTrue(loginPage.getTxtInvalidUser().contains(expectedErrorMessage));
        extentTest.log(LogStatus.PASS, "Alert with message "+expectedErrorMessage+" will appear");
    }

}
