package automation.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowser implements DriverStrategy {

    public WebDriver setStrategy() {
        WebDriver driver = new EdgeDriver();
        return driver;
    }

}
