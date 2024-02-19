package com.sy.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Utils {
    public static int testCaseCounter = 0;

    public static ExtentTest test;
    public static ExtentSparkReporter spark = new ExtentSparkReporter("report/TestReport.html");
    public static ExtentReports report = new ExtentReports();




}
