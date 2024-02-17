package automation.drivers.strategies;

import automation.Utils.Constants;

public class DriverStrategyImplementor {

    public static DriverStrategy chooseStrategy(String strategy){

        strategy = strategy.toLowerCase();

        switch (strategy){

            case Constants.CHROME -> {
                return new ChromeBrowser();
            }

            case Constants.FIREFOX -> {
                return new FirefoxBrowser();
            }

            case Constants.EDGE -> {
                return new EdgeBrowser();
            }

            default -> {
                return null;
            }
        }
    }
}
