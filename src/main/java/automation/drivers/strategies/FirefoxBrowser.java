package automation.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements DriverStrategy {

    public WebDriver setStrategy(){

        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
