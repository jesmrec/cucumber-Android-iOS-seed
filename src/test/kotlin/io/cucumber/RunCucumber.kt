package io.cucumber

import io.android.AndroidManager
import io.ios.IOSManager
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.runner.RunWith
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import utils.LocProperties
import java.util.logging.Level
import kotlin.jvm.JvmStatic


@RunWith(Cucumber::class)
@CucumberOptions(plugin = ["pretty"])
class RunCucumberTest {

    companion object {
        private val platform: String = System.getProperty("platform")

        @BeforeClass
        @JvmStatic
        fun beforeClass(): Unit {
        }

        @AfterClass
        @JvmStatic
        fun afterClass(): Unit {
            when (platform) {
                "Android" -> {
                    AndroidManager.getDriver()
                        .removeApp(LocProperties.properties?.getProperty("androidPackage"))
                    AndroidManager.getDriver().removeApp("io.appium.settings")
                    AndroidManager.getDriver().quit()
                }

                "iOS" -> {
                    IOSManager.getDriver()
                        .removeApp(LocProperties.properties?.getProperty("iOSPackage"))
                    IOSManager.getDriver().quit()
                }
            }
        }
    }
}
