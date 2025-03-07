package io.cucumber;

import java.util.logging.Level;

import io.android.AndroidManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.ios.IOSManager;
import utils.LocProperties;
import utils.log.Log;

public class Hooks {

    private String platform = System.getProperty("platform");

    @Before
    public void setup(Scenario scenario) {
        Log.log(Level.FINE, "START SCENARIO EXECUTION: " + scenario.getName());
        switch (platform) {
            case "Android":
                AndroidManager.getDriver().activateApp(
                        LocProperties.getProperties().getProperty("androidPackage"));
                break;
            case "iOS":
                IOSManager.getDriver().activateApp(
                        LocProperties.getProperties().getProperty("iOSPackage"));
                break;
            default:
                break;
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        Log.log(Level.FINE, "END SCENARIO EXECUTION: " + scenario.getName());
        switch (platform) {
            case "Android":
                AndroidManager.getDriver().terminateApp(
                        LocProperties.getProperties().getProperty("androidPackage"));
                break;
            case "iOS":
                IOSManager.getDriver().terminateApp(
                        LocProperties.getProperties().getProperty("iOSPackage"));
                break;
            default:
                break;
        }

    }
}
