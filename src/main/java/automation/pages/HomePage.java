package automation.pages;

import automation.Utils.ScreenshotUtil;
import automation.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    public HomePage(){
        driver = DriverSingleton.getDriver();
    }

    private By swaglabsLogo = By.className("app_logo");
    private By addToCartBackpackLocator = By.id("add-to-cart-sauce-labs-backpack");
    private By cartButtonLocator = By.className("shopping_cart_link");
    private By cartValueLocator = By.className("shopping_cart_badge");

    public String getLogo(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(swaglabsLogo));
        return driver.findElement(swaglabsLogo).getText();
    }
    public int addBackpackToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBackpackLocator));
        driver.findElement(addToCartBackpackLocator).click();
        String value = driver.findElement(cartValueLocator).getText();
        int cartValue = Integer.parseInt(value);
        driver.findElement(cartButtonLocator).click();
        return cartValue;


    }

}
