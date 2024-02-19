package com.sy.utils;

import com.sy.drivers.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.util.FileCopyUtils;

import java.io.File;

public class ScreenshotUtil {

    public static boolean takeScreenshot(WebDriver driver){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
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
