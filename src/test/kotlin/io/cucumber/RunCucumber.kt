package io.cucumber

import io.android.AndroidManager
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import io.ios.IOSManager
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.runner.RunWith
import utils.LocProperties

@RunWith(Cucumber::class)
@CucumberOptions(plugin = ["pretty"])
class RunCucumberTest {

    companion object {
        private val platform: String = System.getProperty("platform")

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {
            when (platform) {
                "Android" -> {
                    AndroidManager.getDriver().removeApp(LocProperties.getProperty("androidPackage"))
                    AndroidManager.getDriver().removeApp("io.appium.settings")
                    AndroidManager.getDriver().quit()
                }

                "iOS" -> {
                    IOSManager.getDriver().removeApp(LocProperties.getProperty("iOSPackage"))
                    IOSManager.getDriver().quit()
                }
            }
        }
    }
}
