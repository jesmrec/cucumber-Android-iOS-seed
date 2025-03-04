package io.cucumber

import io.android.AndroidManager
import io.ios.IOSManager
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.Scenario
import utils.LocProperties

class Hooks {

    private val platform: String = System.getProperty("platform")

    @Before
    fun setup(scenario: Scenario) {
        if (platform == "Android") {
            AndroidManager.getDriver().activateApp(
                LocProperties.properties?.getProperty("androidPackage")
            )
        } else if (platform == "iOS") {
            IOSManager.getDriver().activateApp(
                LocProperties.properties?.getProperty("iOSPackage")
            )
        }
    }

    @After
    fun tearDown(scenario: Scenario) {
        if (platform == "Android") {
            AndroidManager.getDriver().terminateApp(
                LocProperties.properties?.getProperty("androidPackage")
            )
        } else if (platform == "iOS") {
            IOSManager.getDriver().terminateApp(
                LocProperties.properties?.getProperty("iOSPackage")
            )
        }
    }
}