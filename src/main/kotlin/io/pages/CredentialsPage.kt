package io.pages

import io.appium.java_client.AppiumBy
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import utils.Log
import java.time.Duration
import java.util.logging.Level

class CredentialsPage private constructor() : CommonPage() {

    private val userNameFieldxpath: String = "//android.widget.EditText[@resource-id=\"email\"]"
    private val nextButtonxpath: String = "//android.widget.Button[@text=\"Next\"]"
    private val passwordFieldxpath: String = "//android.widget.EditText[@resource-id=\"password\"]"
    private val signInButtonxpath: String = "//android.widget.Button[@text=\"Sign in\"]"
    private val grantAccessButtonxpath: String = "//android.widget.Button[@resource-id=\"btnAccept\"]"
    private val dlixpath: String = "//android.widget.TextView[@text=\"*/dli/*\"]"

    private val userName: String = System.getProperty("username")
    private val password: String = System.getProperty("password")

    fun enterCredentials() {
        val usernameField: List<WebElement>? = getDriver()!!.findElements(By.xpath(userNameFieldxpath))
        if (usernameField?.isNotEmpty() == true) {
            Log.log(Level.FINE, "Enter credentials")
            usernameField?.get(0)?.sendKeys(userName)
            getDriver()!!.findElement(By.xpath(nextButtonxpath)).click()
            getDriver()!!.findElement(By.xpath(passwordFieldxpath)).sendKeys(password)
            getDriver()!!.findElement(By.xpath(signInButtonxpath)).click()
            getDriver()!!.findElement(By.xpath(signInButtonxpath)).click()
        }
    }

    fun grantPermissions() {
        Log.log(Level.FINE, "Accepting services")

        WebDriverWait(getDriver()!!, Duration.ofSeconds(15)).apply {
            until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(dlixpath)))
        }

        swipe(0.50, 0.80, 0.50, 0.20)
        getDriver()!!.findElement(By.xpath(grantAccessButtonxpath)).click()
    }

    companion object {
        val instance: CredentialsPage by lazy { CredentialsPage() }
    }
}
