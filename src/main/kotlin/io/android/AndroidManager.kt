package io.android

import io.AppiumManager
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AutomationName
import org.openqa.selenium.remote.DesiredCapabilities
import utils.LocProperties
import utils.Log
import java.io.File
import java.net.URI
import java.time.Duration
import java.util.logging.Level

class AndroidManager private constructor() : AppiumManager() {

    companion object {
        private var packageName = LocProperties.getProperty("androidPackage")

        private fun init() {
            val rootPath = File(System.getProperty("user.dir"))
            val appDir = File(rootPath, "src/test/resources")
            app = LocProperties.getProperty("apkName")?.let { File(appDir, it) }

            val capabilities = DesiredCapabilities()
            setCapabilities(capabilities)

            try {
                driver = AndroidDriver(URI(driverURL).toURL(), capabilities)
                driver!!.manage()?.timeouts()?.implicitlyWait(Duration.ofSeconds(implicitWait))
                Log.log(Level.FINE, "Driver initialized")
            } catch (e: Exception) {
                Log.log(Level.SEVERE, "Exception in FileHandler: " + e.message)
            }
        }

        fun getDriver(): AndroidDriver {
            if (driver == null) {
                init()
            }
            return driver as AndroidDriver
        }

        private fun setCapabilities(capabilities: DesiredCapabilities) {

            capabilities.setCapability("appium:platformName", "Android")

            capabilities.setCapability("appium:deviceName", "test")

            capabilities.setCapability("appium:autoLaunch", true)

            capabilities.setCapability("appium:app", app?.absolutePath)

            capabilities.setCapability(
                "appium:automationName",
                AutomationName.ANDROID_UIAUTOMATOR2
            )

            capabilities.setCapability("appium:appPackage", packageName)

            capabilities.setCapability(
                "appium:appActivity",
                ".presentation.MainActivity"
            )

            capabilities.setCapability("appium:appWaitPackage", packageName)

            capabilities.setCapability("appium:appWaitForLaunch", "true")

            capabilities.setCapability("appium:autoGrantPermissions", true)

            capabilities.setCapability("appium:unicodeKeyboard", true)

            capabilities.setCapability("appium:resetKeyboard", true)

            capabilities.setCapability("appium:disableWindowAnimation", true)

            capabilities.setCapability("appium:noReset", true)

            capabilities.setCapability("appium:newCommandTimeout", 60)

            capabilities.setCapability("appium:avdLaunchTimeout", 300000)

            capabilities.setCapability("appium:avdReadyTimeout", 300000)

        }
    }
}
