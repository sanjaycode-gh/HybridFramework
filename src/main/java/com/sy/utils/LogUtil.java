package com.sy.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class LogUtil {
private static Logger log = LogManager.getLogger(LogUtil.class);

    public static void startTest(String testName){
    log.info(testName +" has started !!");
    }
    public static void endTest(String testName){
    log.info(testName +" has started !!");
    }
    public static void info(String message){
        log.info(message);
    }
    public static void warn(String message){
        log.warn(message);
    }
    public static void fatal(String message){
        log.fatal(message);
    }
    public static void error(String message){
        log.error(message);
    }
    public static void debug(String message){
        log.debug(message);
    }
    

}
