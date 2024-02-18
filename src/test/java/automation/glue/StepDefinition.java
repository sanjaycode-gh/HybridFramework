package automation.glue;

import automation.Utils.*;
import automation.config.AutomationSpringFrameworkConfig;
import automation.drivers.DriverSingleton;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import automation.pages.CartPage;
import automation.pages.HomePage;
import automation.pages.LoginPage;

import static org.junit.Assert.assertEquals;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationSpringFrameworkConfig.class)
public class StepDefinition {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;
    private String orderMessage;
    ExtentTest test;
    static ExtentSparkReporter spark = new ExtentSparkReporter("report/TestReport.html");
    static ExtentReports report = new ExtentReports();




    @Autowired
    ConfigurationProperties configurationProperties;

    @Before
    public void initialize(Scenario scenario){
        System.out.println("Before Thread ID: " + Thread.currentThread().threadId() + "," +
                "Scenario Name: "+ scenario.getName());

        DriverSingleton.getInstance(configurationProperties.getBrowserName());
        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        TestCases[] tests = TestCases.values();
        report.attachReporter(spark);
        test = report.createTest(tests[Utils.testCaseCounter].getTestName());
        LogUtil.startTest(tests[Utils.testCaseCounter].getTestName());
        Utils.testCaseCounter++;

    }

    @Given("^User navigates to swaglabs website")
    public void user_navigates_to_swaglabs_website(){
        driver = DriverSingleton.getDriver();
        driver.get(configurationProperties.getUrl());
        LogUtil.info("Navigating to the "+configurationProperties.getUrl());
        test.log(Status.PASS,"Navigating to " + configurationProperties.getUrl());

    }
    @When("^User enters valid credentials and enter login")
    public void user_enters_valid_credentials_and_enter_login(){
        loginPage.login(Constants.VALID_USERNAME,Constants.PASSWORD);
        test.log(Status.PASS, "User authentication is validated");
    }
    @Then("^User is successfully logged in")
    public void user_is_successfully_logged_in(){
        if(configurationProperties.getSwaglabsLogo().equalsIgnoreCase(homePage.getLogo())){
            test.log(Status.PASS, "User Successfully logged in");
        }
        else{
            test.log(Status.FAIL, "User login failed");
        }
        assertEquals(configurationProperties.getSwaglabsLogo(),homePage.getLogo());

    }

    @When("User add backpack item to cart")
    public void userAddBackpackItemToCart() {
        int actualItemsAdded = homePage.addBackpackToCart();
        if(actualItemsAdded == 2){
            test.log(Status.PASS, "User added the backpack to the cart");
        }
        else{
            test.log(Status.FAIL, "backpack added to the cart is not equal to 1");
        }
        assertEquals(1,actualItemsAdded);

    }

    @And("User proceed to checkout and place the order")
    public void userProceedToCheckoutAndPlaceTheOrder() {
        orderMessage = cartPage.checkout(configurationProperties.getFirstName(), configurationProperties.getLastName(), configurationProperties.getZip());
        test.log(Status.PASS, "User has placed the order by providing all the necessary detail in the checkout");
    }

    @Then("Order has placed successfully")
    public void orderHasPlacedSuccessfully() {
        if(configurationProperties.getOrderMessage().equalsIgnoreCase(orderMessage)){
            test.log(Status.PASS, "Order is placed successfully");
        }
        else{
            test.log(Status.FAIL, "Order is not placed");
        }
        assertEquals("Your order has not placed",configurationProperties.getOrderMessage(),orderMessage);

    }

    @After
    public void teardown(Scenario scenario){
        System.out.println("After Thread ID: " + Thread.currentThread().threadId() + "," +
                "Scenario Name: "+ scenario.getName());
        DriverSingleton.closeObjectInstance();

        report.flush();
    }
}
