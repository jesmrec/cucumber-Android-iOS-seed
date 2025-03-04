package io.ios

import io.AppiumManager
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.AutomationName
import org.openqa.selenium.remote.DesiredCapabilities
import utils.LocProperties
import java.io.File
import java.net.MalformedURLException
import java.net.URL
import java.time.Duration

class IOSManager private constructor() : AppiumManager() {

    companion object {
        private val driverURL = LocProperties.properties?.getProperty("appiumURL")
        private val packageName = LocProperties.properties?.getProperty("iOSPackage")
        private const val implicitWait: Long = 5
        private var app: File? = null
        private var driver: IOSDriver? = null

        private fun init() {
            val rootPath = File(System.getProperty("user.dir"))
            val appDir = File(rootPath, "src/test/resources")
            app = File(appDir, LocProperties.properties?.getProperty("appName"))

            val capabilities = DesiredCapabilities()
            setCapabilities(capabilities)

            try {
                driver = IOSDriver(URL(driverURL), capabilities)
                driver?.manage()?.timeouts()?.implicitlyWait(Duration.ofSeconds(implicitWait))
            } catch (e: MalformedURLException) {

            }
        }

        fun getDriver(): IOSDriver {
            if (driver == null) {
                init()
            }
            return driver!!
        }

        private fun setCapabilities(capabilities: DesiredCapabilities) {

            capabilities.setCapability("appium:platformName", "iOS")

            capabilities.setCapability("appium:deviceName", "iPhone 16")

            capabilities.setCapability("appium:platformVersion", "18.2")

            capabilities.setCapability("appium:automationName", AutomationName.IOS_XCUI_TEST)

            capabilities.setCapability("appium:app", app?.absolutePath)

            capabilities.setCapability("appium:showXcodeLog", true)

            capabilities.setCapability("appium:fullReset", false)

            capabilities.setCapability("appium:noReset", false)

            capabilities.setCapability("appium:newCommandTimeout", 60)

            capabilities.setCapability("appium:useNewWDA", true)

            capabilities.setCapability("appium:bundleId", packageName)
        }
    }
}
