package io.cucumber

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert
import java.util.Locale
import java.util.logging.Level

class StepDefinitions {

    private var world: World? = null

    fun StepDefinitions(world: World?) {
        this.world = world
    }

    init {

        @Given("{string} is on the login page")
        fun user_in_login_page(displayName: String?) {
            world?.loginPage?.typeURL()
            world?.loginPage?.acceptCertificate()
        }

        @When("{string} enters {word} and {word}")
        fun user_enters_credentials(displayName: String?, username: String?, password: String?) {
            world?.loginPage?.typeCredentials(username, password)
        }

        @When("{string} clicks on the login button")
        fun user_clicks_login(displayName: String?) {
            world?.loginPage?.submitLogin(displayName)
        }

        @Then("{string} should be redirected to the home page")
        fun user_redirected_home_page(displayName: String?) {
            Assert.assertTrue(world?.mainPage?.isMainPageDisplayed()!!)
        }
    }
}