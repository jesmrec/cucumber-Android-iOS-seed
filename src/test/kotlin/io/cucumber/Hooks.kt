package io.cucumber

import io.android.AndroidManager
import io.ios.IOSManager
import io.cucumber.java.After
import io.cucumber.java.Before
import utils.LocProperties
import utils.Log

class Hooks {

    private val platform: String = System.getProperty("platform")

    @Before
    fun setup() {
        Log.init()
        when (platform) {
            "Android" -> AndroidManager.getDriver().activateApp(LocProperties
                .getProperty("androidPackage"))
            "iOS" -> IOSManager.getDriver().activateApp(LocProperties.getProperty("iOSPackage"))
        }
    }

    @After
    fun tearDown() {
        when (platform) {
            "Android" -> AndroidManager.getDriver().terminateApp(LocProperties
                .getProperty("androidPackage"))
            "iOS" -> IOSManager.getDriver().terminateApp(LocProperties.getProperty("iOSPackage"))
        }
    }
}
