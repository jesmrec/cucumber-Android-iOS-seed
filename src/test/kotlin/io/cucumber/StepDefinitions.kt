package io.cucumber

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert

class StepDefinitions (world: World) {

    private var world: World? = null

    init {
        this.world = world
    }

    @Given("{string} is on the login page")
    fun user_in_login_page(displayName: String?) {
        world!!.loginPage.typeURL()
        world!!.loginPage.acceptCertificate()
    }

    @When("{string} enters {word} and {word}")
    fun user_enters_credentials(displayName: String, username: String, password: String) {
        world!!.loginPage.typeCredentials(username, password)
    }

    @When("{string} clicks on the login button")
    fun user_clicks_login(displayName: String) {
        world!!.loginPage.submitLogin(displayName)
    }

    @Then("{string} should be redirected to the home page")
    fun user_redirected_home_page(displayName: String) {
        Assert.assertTrue(world!!.mainPage.isMainPageDisplayed())
    }
}
