package com.sy.drivers;

import com.sy.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver initialize(String browserName){
        WebDriver driver;
        browserName = browserName.toLowerCase();

        switch (browserName){

            case Constants.CHROME -> {
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("useAutomationExtension", false);
                options.addArguments("--no-sandbox");
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            }

            case Constants.FIREFOX -> {
                driver = new FirefoxDriver();
            }

            case Constants.EDGE -> {
                driver = new EdgeDriver();
            }

            default ->  throw new IllegalStateException("INVALID BROWSER: " + browserName);

       }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;

    }

}
