package com.sy.glue;


import com.sy.utils.FrameworkProperties;
import com.sy.utils.Utils;
import com.sy.context.TestContext;
import com.sy.pages.CartPage;
import com.sy.pages.PageFactoryManager;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;


import static org.junit.Assert.assertEquals;


public class CartStepDefinitions {

    private WebDriver driver;
    private CartPage cartPage;
    private String orderMessage;
    private FrameworkProperties frameworkProperties;

    public CartStepDefinitions(TestContext context){
        driver = context.driver;
        cartPage = PageFactoryManager.getCartPage(driver);
        frameworkProperties = new FrameworkProperties();

    }
    @And("User proceed to checkout and place the order")
    public void userProceedToCheckoutAndPlaceTheOrder() {
        orderMessage = cartPage.checkout(frameworkProperties.getProperty("firstName"), frameworkProperties.getProperty("lastName"), frameworkProperties.getProperty("zip"));
        Utils.test.log(Status.PASS, "User has placed the order by providing all the necessary detail in the checkout");
    }

    @Then("Order has placed successfully")
    public void orderHasPlacedSuccessfully() {
        if(frameworkProperties.getProperty("orderMessage").equalsIgnoreCase(orderMessage)){
            Utils.test.log(Status.PASS, "Order is placed successfully");
        }
        else{
            Utils.test.log(Status.FAIL, "Order is not placed");
        }
        assertEquals("Your order has not placed",frameworkProperties.getProperty("orderMessage"),orderMessage);

    }
}
