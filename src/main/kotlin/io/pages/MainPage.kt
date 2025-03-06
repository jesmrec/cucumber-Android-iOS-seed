package io.pages

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import utils.Log
import java.util.logging.Level


class MainPage private constructor(): CommonPage() {

    @AndroidFindBy(id = "com.owncloud.android:id/root_toolbar")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Show/Hide sidebar\"])[2]")
    private val mainPage: WebElement? = null

    init {
        PageFactory.initElements(AppiumFieldDecorator(getDriver()), this)
    }

    fun isMainPageDisplayed(): Boolean {
        Log.log(Level.FINE, "is Main Page displayed")
        return mainPage?.isDisplayed()!!
    }

    companion object {
        val instance: MainPage by lazy { MainPage() }
    }
}
