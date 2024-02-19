package com.sy.pages;

import com.sy.utils.ScreenshotUtil;
import com.sy.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@name='checkout']")
    public WebElement checkoutButtonLocator;

    @FindBy(id = "first-name")
    public WebElement firstNamePlaceholder;

    @FindBy(id = "last-name")
    public WebElement lasttNamePlaceholder;

    @FindBy(id = "postal-code")
    public WebElement zipPlaceholder;

    @FindBy(id = "continue")
    public WebElement continueButtonLocator;

    @FindBy(id = "finish")
    public WebElement btnFinish;

    @FindBy(className = "complete-header")
    public WebElement txtCheckoutComplete;

    public String checkout(String firstName, String lastName, String zip){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButtonLocator));
        checkoutButtonLocator.click();

        firstNamePlaceholder.sendKeys(firstName);
        lasttNamePlaceholder.sendKeys(lastName);
        zipPlaceholder.sendKeys(zip);
        continueButtonLocator.click();
        wait.until(ExpectedConditions.elementToBeClickable(btnFinish));
        btnFinish.click();
        ScreenshotUtil.takeScreenshot(driver);
        String result = txtCheckoutComplete.getText();
        return result;

    }







}
