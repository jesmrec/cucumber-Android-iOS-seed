package io;

import io.appium.java_client.AppiumDriver;
import utils.LocProperties;

public class AppiumManager {

    protected static final String driverURL = LocProperties.getProperties().getProperty("appiumURL");
    protected static AppiumDriver driver = null;
    protected static final int implicitWait = 5;

}
