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

    @Given("I am logged in")
    public void i_am_logged_in() {
        loginPage.loginUser("standard_user", "secret_sauce");
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS, "I am logged in");
    }

    @And("I am on the product page")
    public void i_am_on_the_product_page() {
        Assert.assertEquals(loginPage.getTxtProduct(), "Products");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        extentTest.log(LogStatus.PASS, "I am on the product page");
    }

    @When("I click add to cart button for three product")
    public void i_click_add_to_cart_button_for_three_product() {
        for (int i = 0; i < 3; i++) {
            productsPage.clickProductButton(i);
        }
        extentTest.log(LogStatus.PASS, "I click add to cart button for three product");
    }

    @And("I click cart button")
    public void i_click_cart_button() {
        productsPage.setCartButton();
        extentTest.log(LogStatus.PASS, "I click cart button");
    }

    @Then("There will be three products in the cart")
    public void there_will_be_three_products_in_the_cart() {
        Assert.assertEquals(productsPage.getCartTotalItem(), 3);
        extentTest.log(LogStatus.PASS, "There will be three products in the cart");
    }


}
