package automation.drivers;

import automation.drivers.strategies.DriverStrategy;
import automation.drivers.strategies.DriverStrategyImplementor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverSingleton {

       private static DriverSingleton instance = null;
       private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

       private DriverSingleton(String browserName){
              instantiate(browserName);

       }

       public WebDriver instantiate(String strategy){
              WebDriver driver;

              DriverStrategy driverStrategy = DriverStrategyImplementor.chooseStrategy(strategy);
              driver = driverStrategy.setStrategy();

              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
              driver.manage().window().maximize();
              DriverSingleton.driver.set(driver);
              return driver;

       }

       public static DriverSingleton getInstance(String browserName){
              if(instance == null){
                     instance =  new DriverSingleton(browserName);
              }

              return instance;
       }

       public static void closeObjectInstance(){
              instance = null;
              driver.get().quit();
       }

       public static WebDriver getDriver(){
              return driver.get();
       }




}
