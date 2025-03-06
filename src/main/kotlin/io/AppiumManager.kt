package io

import io.appium.java_client.AppiumDriver
import utils.LocProperties
import java.io.File

open class AppiumManager {

    protected companion object {
        val driverURL = LocProperties.getProperty("appiumURL")
        val implicitWait: Long = 5
        var app: File? = null
        var driver: AppiumDriver? = null
    }
}