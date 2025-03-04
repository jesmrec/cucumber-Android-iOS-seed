package io.cucumber;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.log.Log;

public class StepDefinitions {

    private World world;

    public StepDefinitions(World world) {
        this.world = world;
    }

    @Given("{string} is on the login page")
    public void user_in_login_page(String displayName) {
        String stepName = new Object(){}.getClass().getEnclosingMethod().getName().toUpperCase();
        Log.log(Level.FINE, "----STEP----: " + stepName);
        world.loginPage.typeURL();
        world.loginPage.acceptCertificate();
    }

    @When("{string} enters {word} and {word}")
    public void user_enters_credentials(String displayName, String username, String password) {
        String stepName = new Object(){}.getClass().getEnclosingMethod().getName().toUpperCase();
        Log.log(Level.FINE, "----STEP----: " + stepName);
        world.loginPage.typeCredentials(username, password);
    }

    @When("{string} clicks on the login button")
    public void user_clicks_login(String displayName) {
        String stepName = new Object(){}.getClass().getEnclosingMethod().getName().toUpperCase();
        Log.log(Level.FINE, "----STEP----: " + stepName);
        world.loginPage.submitLogin(displayName);
    }

    @Then("{string} should be redirected to the home page")
    public void user_redirected_home_page(String displayName) {
        String stepName = new Object(){}.getClass().getEnclosingMethod().getName().toUpperCase();
        Log.log(Level.FINE, "----STEP----: " + stepName);
        assertTrue(world.mainPage.isMainPageDisplayed());
    }
}
