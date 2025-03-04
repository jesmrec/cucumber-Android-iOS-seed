package io.android

import io.AppiumManager
import io.appium.java_client.android.AndroidDriver
import utils.LocProperties
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File
import java.net.MalformedURLException
import java.net.URL
import java.time.Duration

class AndroidManager private constructor() : AppiumManager() {

    companion object {
        private var driverURL = "http://127.0.0.1:4723/"
        private var packageName = "com.owncloud.android"
        private const val implicitWait: Long = 5
        private var app: File? = null
        private var driver: AndroidDriver? = null

        private fun init() {
            val rootPath = File(System.getProperty("user.dir"))
            val appDir = File(rootPath, "src/test/resources")
            app = File(appDir, "owncloud.apk")

            val capabilities = DesiredCapabilities()
            setCapabilities(capabilities)

            try {
                driver = AndroidDriver(URL(driverURL), capabilities)
                driver!!.manage()?.timeouts()?.implicitlyWait(Duration.ofSeconds(implicitWait))
            } catch (e: Exception) {
                System.out.println(e.message)
            }
        }

        fun getDriver(): AndroidDriver {
            if (driver == null) {
                init()
            }
            return driver!!
        }

        private fun setCapabilities(capabilities: DesiredCapabilities) {

            capabilities.setCapability("appium:platformName", "Android")

            capabilities.setCapability("appium:deviceName", "test")

            capabilities.setCapability("appium:app", app?.absolutePath)

            capabilities.setCapability("appium:automationName", "UIAutomator2")

            capabilities.setCapability("appium:appPackage", packageName)

            capabilities.setCapability("appium:appActivity", "com.owncloud.android.ui.activity.SplashActivity")

            capabilities.setCapability("appium:appWaitPackage", packageName)

            capabilities.setCapability("appium:appWaitForLaunch", "true")

            capabilities.setCapability("appium:autoGrantPermissions", true)

            capabilities.setCapability("appium:unicodeKeyboard", true)

            capabilities.setCapability("appium:resetKeyboard", true)

            capabilities.setCapability("appium:disableWindowAnimation", true)

            capabilities.setCapability("appium:noReset", true)

            capabilities.setCapability("appium:newCommandTimeout", 60)
        }
    }
}
