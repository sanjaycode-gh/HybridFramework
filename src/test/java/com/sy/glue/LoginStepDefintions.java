package com.sy.glue;

import com.sy.utils.Constants;
import com.sy.utils.FrameworkProperties;
import com.sy.utils.LogUtil;
import com.sy.utils.Utils;
import com.sy.context.TestContext;
import com.sy.pages.LoginPage;
import com.sy.pages.PageFactoryManager;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;



public class LoginStepDefintions {

    private WebDriver driver;
    private LoginPage loginPage;
    private FrameworkProperties frameworkProperties;
    public LoginStepDefintions(TestContext context){
        driver = context.driver;
        loginPage = PageFactoryManager.getLoginPage(driver);
        frameworkProperties = new FrameworkProperties();

    }

    @Given("^User navigates to swaglabs website")
    public void user_navigates_to_swaglabs_website(){
        driver.get(frameworkProperties.getProperty("url"));
        LogUtil.info("Navigating to the "+frameworkProperties.getProperty("url"));
        Utils.test.log(Status.PASS,"Navigating to " + frameworkProperties.getProperty("url"));


    }
    @When("^User enters valid credentials and enter login")
    public void user_enters_valid_credentials_and_enter_login(){
        loginPage.login(Constants.VALID_USERNAME,Constants.PASSWORD);
        Utils.test.log(Status.PASS, "User authentication is validated");
    }
}
