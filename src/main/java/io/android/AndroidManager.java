package io.android;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.logging.Level;

import io.AppiumManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import utils.LocProperties;
import utils.log.Log;

public class AndroidManager extends AppiumManager {

    protected static final String packageName = LocProperties.getProperties()
            .getProperty("androidPackage");
    private static File app = null;

    private AndroidManager() {
    }

    private static void init() {

        File rootPath = new File(System.getProperty("user.dir"));
        File appDir = new File(rootPath, "src/test/resources");
        app = new File(appDir, LocProperties.getProperties().getProperty("apkName"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        setCapabilities(capabilities);

        try {
            driver = new AndroidDriver(new URL(driverURL), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        } catch (MalformedURLException e) {
            Log.log(Level.SEVERE, "Driver could not be created: " + e.getMessage());
        }
    }

    //Singletonize
    public static AndroidDriver getDriver() {
        if (driver == null) {
            init();
        }
        return (AndroidDriver)driver;
    }

    //Check https://appium.io/docs/en/2.5/guides/caps/
    private static void setCapabilities(DesiredCapabilities capabilities) {

        capabilities.setCapability("appium:platformName", "Android");

        capabilities.setCapability("appium:deviceName", "test");

        capabilities.setCapability("appium:app", app.getAbsolutePath());

        capabilities.setCapability("appium:automationName",
                "UiAutomator2");

        capabilities.setCapability("appium:appPackage", packageName);

        capabilities.setCapability("appium:appActivity",
                "com.owncloud.android.ui.activity.SplashActivity");

        capabilities.setCapability("appium:appWaitPackage", packageName);

        capabilities.setCapability("appium:avd", "Pixel_6_API_31");

        capabilities.setCapability("appium:autoLaunch", true);

        capabilities.setCapability("appium:appWaitForLaunch","true");

        capabilities.setCapability("appium:autoGrantPermissions", true);

        capabilities.setCapability("appium:unicodeKeyboard", true);

        capabilities.setCapability("appium:resetKeyboard", true);

        capabilities.setCapability("appium:disableWindowAnimation", true);

        capabilities.setCapability("appium:noReset", true);

        capabilities.setCapability("appium:newCommandTimeout", 60);

    }
}
