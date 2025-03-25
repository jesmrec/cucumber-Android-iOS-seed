package io.pages

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import utils.Log
import java.util.logging.Level


class MainPage private constructor() : CommonPage() {

    @AndroidFindBy(xpath = "//*[@resource-id='fab']")
    private val fabButton: WebElement? = null

    init {
        PageFactory.initElements(AppiumFieldDecorator(getDriver()), this)
    }

    fun isFilesDisplayed(): Boolean? {
        Log.log(Level.FINE, "Checking whether files are displayed")
        return fabButton?.isDisplayed
    }

    companion object {
        val instance: MainPage by lazy { MainPage() }
    }
}
