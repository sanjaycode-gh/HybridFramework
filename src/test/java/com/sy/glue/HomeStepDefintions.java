package com.sy.glue;


import com.sy.utils.FrameworkProperties;
import com.sy.utils.Utils;
import com.sy.context.TestContext;
import com.sy.pages.HomePage;
import com.sy.pages.PageFactoryManager;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;


import static org.junit.Assert.assertEquals;


public class HomeStepDefintions {
    private WebDriver driver;
    private HomePage homePage;
    private FrameworkProperties frameworkProperties;
    public HomeStepDefintions(TestContext context){
        driver = context.driver;
        homePage = PageFactoryManager.getHomePage(driver);
        frameworkProperties = new FrameworkProperties();
    }

    @Then("^User is successfully logged in")
    public void user_is_successfully_logged_in(){
        if(frameworkProperties.getProperty("swaglabsLogo").equalsIgnoreCase(homePage.getLogo())){
            Utils.test.log(Status.PASS, "User Successfully logged in");
        }
        else{
            Utils.test.log(Status.FAIL, "User login failed");
        }
        assertEquals(frameworkProperties.getProperty("swaglabsLogo"),homePage.getLogo());


    }

    @When("User add backpack item to cart")
    public void userAddBackpackItemToCart() {
        int actualItemsAdded = homePage.addBackpackToCart();
        if(actualItemsAdded == 2){
            Utils.test.log(Status.PASS, "User added the backpack to the cart");
        }
        else{
            Utils.test.log(Status.FAIL, "backpack added to the cart is not equal to 1");
        }
        assertEquals(1,actualItemsAdded);

    }
}
