package io.pages

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import utils.Log
import java.util.logging.Level


class MainPage : CommonPage() {

    @AndroidFindBy(xpath = "//*[@resource-id='fab']")
    private lateinit var fabButton: WebElement

    init {
        PageFactory.initElements(AppiumFieldDecorator(getDriver()), this)
    }

    fun isFilesDisplayed(fileName: String = "TestForE2EAuto"): Boolean {
        Log.log(Level.FINE, "Checking whether files are displayed")
        val folderDisp = getDriver()!!.findElement(By.xpath(
            "//android.widget.TextView[@text=\"$fileName\"]"))
        return ::fabButton.isInitialized && fabButton.isDisplayed && folderDisp.isDisplayed
    }

    companion object {
        val instance: MainPage by lazy { MainPage() }
    }
}
