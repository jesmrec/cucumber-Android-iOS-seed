package io.ios;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;

import io.AppiumManager;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import utils.LocProperties;
import utils.log.Log;

public class IOSManager extends AppiumManager {

    private static final String driverURL = LocProperties.getProperties().getProperty("appiumURL");
    private static final String packageName = LocProperties.getProperties().getProperty("iOSPackage");
    private static final int implicitWait = 5;
    private static File app = null;

    private IOSManager() {
    }

    private static void init() {

        File rootPath = new File(System.getProperty("user.dir"));
        File appDir = new File(rootPath, "src/test/resources");
        app = new File(appDir, LocProperties.getProperties().getProperty("appName"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        setCapabilities(capabilities);

        try {
            driver = new IOSDriver(new URL(driverURL), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        } catch (MalformedURLException e) {
            Log.log(Level.SEVERE, "Driver could not be created: " + e.getMessage());
        }
    }

    public static IOSDriver getDriver() {
        if (driver == null) {
            init();
        }
        return (IOSDriver)driver;
    }

    //Check https://appium.github.io/appium-xcuitest-driver/latest/reference/capabilities/
    private static void setCapabilities(DesiredCapabilities capabilities) {

        capabilities.setCapability("appium:platformName", "iOS");

        capabilities.setCapability("appium:deviceName", "iPhone 16");

        capabilities.setCapability("appium:platformVersion", "18.2");

        capabilities.setCapability("appium:automationName",
                AutomationName.IOS_XCUI_TEST);

        capabilities.setCapability("appium:app", app.getAbsolutePath());

        capabilities.setCapability("appium:showXcodeLog", true);

        //The following capabilities prevents reinstalling the app every test.
        capabilities.setCapability("appium:fullReset", false);

        capabilities.setCapability("appium:noReset", false);

        capabilities.setCapability("appium:newCommandTimeout", 60);

        capabilities.setCapability("appium:useNewWDA", true);

        capabilities.setCapability("appium:bundleId", packageName);

    }
}
