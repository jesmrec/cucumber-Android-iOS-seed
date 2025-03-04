package io.pages

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory

class LoginPage private constructor() : CommonPage() {

    @AndroidFindBy(id = "com.owncloud.android:id/hostUrlInput")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Server URL\"]")
    private val urlServer: WebElement? = null

    @AndroidFindBy(id = "com.owncloud.android:id/embeddedCheckServerButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Proceed\"]")
    private val checkServerButton: WebElement? = null

    @AndroidFindBy(id = "com.owncloud.android:id/account_username")
    @iOSXCUITFindBy(accessibility = "Server Username")
    private val userNameText: WebElement? = null

    @AndroidFindBy(id = "com.owncloud.android:id/account_password")
    @iOSXCUITFindBy(accessibility = "Server Password")
    private val passwordText: WebElement? = null

    @AndroidFindBy(id = "com.owncloud.android:id/loginButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Login\"]")
    private val loginButton: WebElement? = null

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"YES\");")
    @iOSXCUITFindBy(accessibility = "Approve")
    private val acceptCertificate: WebElement? = null

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Start setup\"]")
    private val startSetup: WebElement? = null

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    private val done: WebElement? = null

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Personal\"]")
    private val personal: WebElement? = null

    private val platform: String = System.getProperty("platform")
    private val server: String = System.getProperty("server")

    init {
        PageFactory.initElements(AppiumFieldDecorator(getDriver()), this)
    }

    fun typeURL() {
        if (platform == "iOS") {
            startSetup?.click()
        }
        urlServer!!.sendKeys(server)
        checkServerButton?.click()
    }

    fun typeCredentials(userName: String?, password: String?) {
        userNameText?.sendKeys(userName)
        passwordText?.sendKeys(password)
    }

    fun submitLogin(displayName: String?) {
        loginButton?.click()
        if (platform == "iOS") {
            done?.click()
            selectFirstBookmark(displayName)
            personal?.click()
        }
    }

    fun acceptCertificate() {
        acceptCertificate?.click()
    }

    fun selectFirstBookmark(displayName: String?) {
        getDriver()!!.findElement(By.id(displayName)).click() //iOS
    }

    companion object {
        val instance: LoginPage = LoginPage()
    }
}