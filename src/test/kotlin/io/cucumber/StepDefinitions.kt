package io.cucumber

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.Assert
import org.junit.Assert.assertTrue

class StepDefinitions (world: World) {

    private var world: World? = null

    init {
        this.world = world
    }

    @Given ("Alice is on the login page")
    fun aliceIsOnTheLoginPage() {
    }

    @When ("Alice enters the server URL")
    fun aliceEntersURL() {
        world!!.loginPage.typeURL()
    }

    @When ("Alice clicks on the login button")
    fun aliceClicksLogin() {
        world!!.loginPage.clickLogin()
    }

    @When ("Alice enter credentials")
    fun aliceEnterCredentials() {
        world!!.credentialsPage.enterCredentials()
        world!!.credentialsPage.grantPermissions()
    }

    @Then ("Alice should be redirected to the home page")
    fun aliceRedirectedHome() {
        assertTrue(world!!.mainPage.isFilesDisplayed()!!)
    }
}
