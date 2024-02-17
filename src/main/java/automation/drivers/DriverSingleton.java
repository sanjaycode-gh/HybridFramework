package automation.drivers;

import automation.drivers.strategies.DriverStrategy;
import automation.drivers.strategies.DriverStrategyImplementor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverSingleton {

       private static DriverSingleton instance = null;
       private static WebDriver driver;

       private DriverSingleton(String browserName){
              instantiate(browserName);

       }

       public WebDriver instantiate(String strategy){

              DriverStrategy driverStrategy = DriverStrategyImplementor.chooseStrategy(strategy);
              driver = driverStrategy.setStrategy();

              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
              driver.manage().window().maximize();

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
              driver.quit();
       }

       public static WebDriver getDriver(){
              return driver;
       }




}
