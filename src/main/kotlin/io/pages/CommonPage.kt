package io.pages

import io.android.AndroidManager
import io.appium.java_client.AppiumDriver
import io.ios.IOSManager

open class CommonPage {

    private val platform: String = System.getProperty("platform")

    fun getDriver(): AppiumDriver? {
        return when (platform) {
            "Android" -> AndroidManager.getDriver()
            "iOS" -> IOSManager.getDriver()
            else -> null
        }
    }
}
