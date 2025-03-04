package io.pages;

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory


class MainPage private constructor(): CommonPage() {

    @AndroidFindBy(id = "com.owncloud.android:id/root_toolbar")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Show/Hide sidebar\"])[2]")
    private val mainPage: WebElement? = null;

    init {
        PageFactory.initElements(AppiumFieldDecorator(getDriver()), this);
    }

    fun isMainPageDisplayed(): Boolean? {
        return mainPage?.isDisplayed()
    }

    companion object {
        val instance: MainPage = MainPage()
    }
}
