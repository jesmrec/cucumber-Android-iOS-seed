package io.pages

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import utils.Log
import java.util.logging.Level


class LoginPage : CommonPage() {

    @AndroidFindBy(xpath = "//*[@resource-id='server_url_field']")
    private lateinit var urlField: WebElement

    @AndroidFindBy(xpath = "//*[@resource-id='login_button']")
    private lateinit var loginButton: WebElement

    private val server: String = System.getProperty("server")

    init {
        PageFactory.initElements(AppiumFieldDecorator(getDriver()), this)
    }

    fun typeURL() {
        Log.log(Level.FINE, "Type URL")
        urlField.apply{
            clear()
            sendKeys(server)
        }
    }

    fun clickLogin() {
        Log.log(Level.FINE, "Click Login")
        loginButton.click()
    }

    companion object {
        val instance: LoginPage by lazy { LoginPage() }
    }
}