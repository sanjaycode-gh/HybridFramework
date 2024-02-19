package com.sy.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    private static LoginPage loginPage;
    private static HomePage homePage;
    private static CartPage cartPage;

    public static LoginPage getLoginPage(WebDriver driver) {
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }

    public static HomePage getHomePage(WebDriver driver) {
        return homePage == null ? new HomePage(driver) : homePage;
    }

    public static CartPage getCartPage(WebDriver driver) {
        return cartPage== null ? new CartPage(driver) : cartPage;
    }
}
