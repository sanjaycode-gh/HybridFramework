package com.sy.pages;

import com.sy.utils.ScreenshotUtil;
import com.sy.drivers.DriverFactory;
import com.sy.utils.FrameworkProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
       this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user-name")
    public WebElement usernameLocator;

    @FindBy(id = "password")
    public WebElement passwordLocator;

    @FindBy(name = "login-button")
    public WebElement loginButtonLocator;

    public void login(String username, String password){
        usernameLocator.sendKeys(username);
        passwordLocator.sendKeys(password);
        loginButtonLocator.click();
        HomePage homePage = new HomePage(driver);
        FrameworkProperties properties = new FrameworkProperties();
        try {
            if (homePage.getLogo().equalsIgnoreCase(properties.getProperty("swaglabsLogo"))) {
                System.out.println("User has successfully logged in");
            }
        }
        catch(Exception TimeoutException){
            System.err.println("User log in failed");
            ScreenshotUtil.takeScreenshot(driver);
        }


    }


}
