package io.pages;

import io.android.AndroidManager;
import io.appium.java_client.AppiumDriver;
import io.ios.IOSManager;

public class CommonPage {

    private final String platform = System.getProperty("platform");

    public CommonPage() {
    }

    public AppiumDriver getDriver() {
        return switch (platform) {
            case "Android" -> AndroidManager.getDriver();
            case "iOS" -> IOSManager.getDriver();
            default -> null;
        };
    }
}
