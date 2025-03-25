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

    private val userNameFieldxpath: String = "//*[@resource-id='email']"
    private val nextButtonxpath: String = "//android.widget.Button[@text=\"Next\"]"
    private val passwordFieldxpath: String = "//*[@resource-id='password']"
    private val signInButtonxpath: String = "//android.widget.Button[@text=\"Sign in\"]"
    private val grantAccessButtonxpath: String = "//*[@resource-id='btnAccept']"
    private val dlixpath: String = "//android.widget.TextView[@text=\"*/dli/*\"]"

    private val userName: String = System.getProperty("username")
    private val password: String = System.getProperty("password")

    fun enterCredentials() {
        val usernameField: List<WebElement> =
            getDriver()!!.findElements(By.xpath(userNameFieldxpath))
        if (usernameField.isNotEmpty()) { //If it is already stored in the device browser
            Log.log(Level.FINE, "Enter credentials")
            usernameField.get(0).sendKeys(userName)
            val nextButton: WebElement = getDriver()!!.findElement(By.xpath(nextButtonxpath))
            nextButton.click()
            val passwordField: WebElement = getDriver()!!.findElement(By.xpath(passwordFieldxpath))
            passwordField.sendKeys(password)
            val signInButton: WebElement = getDriver()!!.findElement(By.xpath(signInButtonxpath))
            signInButton.click()
            signInButton.click()
        }
    }

    fun grantPermissions() {
        Log.log(Level.FINE, "Accepting services")
        val wait = WebDriverWait(getDriver()!!, Duration.ofSeconds(15.toLong()))
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(dlixpath))
        )
        swipe(0.50, 0.80, 0.50, 0.20)
        val grantAccessButton: WebElement =
            getDriver()!!.findElement(By.xpath(grantAccessButtonxpath))
        grantAccessButton.click()
    }

    companion object {
        val instance: CredentialsPage by lazy { CredentialsPage() }
    }
}
