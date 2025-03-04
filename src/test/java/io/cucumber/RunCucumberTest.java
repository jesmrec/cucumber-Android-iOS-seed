package io.cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.logging.Level;

import io.android.AndroidManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.ios.IOSManager;
import utils.LocProperties;
import utils.log.Log;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})
public class RunCucumberTest {

    private static String platform = System.getProperty("platform");

    @BeforeClass
    public static void beforeclass() {
        Log.init();
        Log.log(Level.FINE, "START EXECUTION\n");
    }

    @AfterClass
    public static void afterclass() {
        if (platform.equals("Android")) {
            AndroidManager.getDriver().removeApp(
                    LocProperties.getProperties().getProperty("androidPackage"));
            AndroidManager.getDriver().removeApp("io.appium.settings");
            AndroidManager.getDriver().quit();
        } else if (platform.equals("iOS")) {
            IOSManager.getDriver().removeApp(
                    LocProperties.getProperties().getProperty("iOSPackage"));
            IOSManager.getDriver().quit();
        }
        Log.log(Level.FINE, "END EXECUTION\n");
    }
}
