package io

import io.appium.java_client.AppiumDriver

open class AppiumManager {

    protected companion object {
        var driver: AppiumDriver? = null
    }
}