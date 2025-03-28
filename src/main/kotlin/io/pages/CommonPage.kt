package io.pages

import io.android.AndroidManager
import io.appium.java_client.AppiumDriver
import io.ios.IOSManager
import org.openqa.selenium.Dimension
import org.openqa.selenium.interactions.PointerInput
import utils.Log
import java.time.Duration
import java.util.Arrays
import java.util.logging.Level

open class CommonPage {

    private val platform: String = System.getProperty("platform")

    fun getDriver(): AppiumDriver? {
        return when (platform) {
            "Android" -> AndroidManager.getDriver()
            "iOS" -> IOSManager.getDriver()
            else -> null
        }
    }

    /* Finger actions */
    fun swipe(startx: Double, starty: Double, endx: Double, endy: Double) {
        Log.log(Level.FINE, "Starting swipe")
        val size: Dimension = getDriver()!!.manage().window().getSize()
        val startY = (size.height * starty).toInt()
        val endY = (size.height * endy).toInt()
        val startX = (size.width * startx).toInt()
        val endX = (size.width * endx).toInt()
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val swipe = org.openqa.selenium.interactions.Sequence(finger, 1)
        swipe.addAction(
            finger.createPointerMove(
                Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), startX, startY
            )
        )
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        swipe.addAction(
            finger.createPointerMove(
                Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), endX, endY
            )
        )
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
        getDriver()!!.perform(Arrays.asList(swipe))
    }

    fun printPage() {
        val pageSource = getDriver()!!.pageSource
        println(pageSource)
    }
}
