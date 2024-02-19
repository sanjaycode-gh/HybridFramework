package com.sy;


import com.sy.utils.FrameworkProperties;
import com.sy.utils.Utils;
import com.sy.context.TestContext;
import com.sy.utils.LogUtil;
import com.sy.utils.TestCases;
import com.sy.drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;
    private final TestContext context;
    private FrameworkProperties frameworkProperties;

    public Hooks(TestContext context){
        this.context = context;
        frameworkProperties = new FrameworkProperties();
    }

    @Before
    public void initialize(Scenario scenario){
        System.out.println("Before Thread ID: " + Thread.currentThread().threadId() + "," +
                "Scenario Name: "+ scenario.getName());

        driver = DriverFactory.initialize(frameworkProperties.getProperty("browserName"));
        context.driver = driver;
        TestCases[] tests = TestCases.values();
        Utils.report.attachReporter(Utils.spark);
        Utils.test = Utils.report.createTest(tests[Utils.testCaseCounter].getTestName());
        LogUtil.startTest(tests[Utils.testCaseCounter].getTestName());
        Utils.testCaseCounter++;

    }
    @After
    public void teardown(Scenario scenario){
        System.out.println("After Thread ID: " + Thread.currentThread().threadId() + "," +
                "Scenario Name: "+ scenario.getName());
        driver.close();

        Utils.report.flush();
    }
}
