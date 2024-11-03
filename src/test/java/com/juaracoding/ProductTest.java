package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductsPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductTest {

    private static WebDriver driver;
    private ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static ProductsPage productsPage = new ProductsPage();

    public ProductTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("I am logged in with username {string}")
    public void i_am_logged_in_with_username(String username) {
        loginPage.loginUser(username, "secret_sauce");
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS, "I am logged in with username "+username);
    }

    @And("I am on the product page")
    public void i_am_on_the_product_page() {
        Assert.assertEquals(loginPage.getTxtProduct(), "Products");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        extentTest.log(LogStatus.PASS, "I am on the product page");
    }

    @When("I click add to cart button for two product")
    public void i_click_add_to_cart_button_for_two_product() {
        for (int i = 0; i < 2; i++) {
            productsPage.clickProductButton(i);
        }
        extentTest.log(LogStatus.PASS, "I click add to cart button for two product");
    }

    @And("I click cart button")
    public void i_click_cart_button() {
        productsPage.setCartButton();
        extentTest.log(LogStatus.PASS, "I click cart button");
    }

    @Then("There will be two products in the cart")
    public void there_will_be_two_products_in_the_cart() {
        Assert.assertEquals(productsPage.getCartTotalItem(), 2);
        extentTest.log(LogStatus.PASS, "There will be two products in the cart");
    }

    @And("I am logout")
    public void i_am_logout() {
        productsPage.logout();
        extentTest.log(LogStatus.PASS, "I am logout");
    }

}
