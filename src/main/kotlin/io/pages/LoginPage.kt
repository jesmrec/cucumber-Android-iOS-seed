package io.pages

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import utils.Log
import java.util.logging.Level


class LoginPage private constructor() : CommonPage() {

    @AndroidFindBy(xpath = "//*[@resource-id='server_url_field']")
    private var urlField: WebElement? = null

    @AndroidFindBy(xpath = "//*[@resource-id='login_button']")
    private val loginButton: WebElement? = null

    private val server: String = System.getProperty("server")

    init {
        PageFactory.initElements(AppiumFieldDecorator(getDriver()), this)
    }

    fun typeURL() {
        Log.log(Level.FINE, "Type URL")
        urlField?.clear()
        urlField?.sendKeys(server)
    }

    fun clickLogin() {
        Log.log(Level.FINE, "Click Login")
        loginButton?.click()
    }

    companion object {
        val instance: LoginPage by lazy { LoginPage() }
    }
}