package io.pages

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import utils.Log
import java.util.logging.Level


class MainPage : CommonPage() {

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/" +
            "android.view.View/android.view.View/android.view.View[3]/android.widget.Button")
    private lateinit var fabButton: WebElement

    init {
        PageFactory.initElements(AppiumFieldDecorator(getDriver()), this)
    }

    fun isMainPageDisplayed(): Boolean {
        Log.log(Level.FINE, "Checking whether main page is displayed")
        return ::fabButton.isInitialized && fabButton.isDisplayed
    }

    fun isFolderDisplayed(folderName: String): Boolean {
        Log.log(Level.FINE, "Checking whether files are displayed")
        val folder = getDriver()!!.findElement(By.xpath(
            "//android.widget.TextView[@text=\"$folderName\"]"))
        return folder.isDisplayed
    }

    companion object {
        val instance: MainPage by lazy { MainPage() }
    }
}
