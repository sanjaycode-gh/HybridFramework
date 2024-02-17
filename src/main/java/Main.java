import automation.Utils.FrameworkProperties;
import automation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import automation.pages.CartPage;
import automation.pages.HomePage;
import automation.pages.LoginPage;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties properties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(properties.getProperty("browserName"));
        WebDriver driver = DriverSingleton.getDriver();

        driver.get(properties.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        CartPage cartPage = new CartPage();

        loginPage.login("standard_user", "secret_sauce");
        int cartValue = homePage.addBackpackToCart();
        if(cartValue == 1){
            System.out.println("Cart value is 1 and the respective cart test has passed");
        }
        String result = cartPage.checkout("john","Paul", "1234");
        if(result.equalsIgnoreCase("Thank you for your order!")){
            System.out.println("Test has passed");
        }



        DriverSingleton.closeObjectInstance();

    }
}
