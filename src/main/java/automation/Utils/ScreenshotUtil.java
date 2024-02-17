package automation.Utils;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.util.FileCopyUtils;

import java.io.File;

public class ScreenshotUtil {

    public static boolean takeScreenshot(){
        File file = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(file, new File("screenshots\\" + "screenshot-" + generateDateTime() + ".png"));
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private static String generateDateTime(){
        long time = System.currentTimeMillis();

        return Integer.toString((int) time);
    }
}
