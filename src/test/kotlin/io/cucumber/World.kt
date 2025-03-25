package io.cucumber

import io.pages.CredentialsPage
import io.pages.LoginPage
import io.pages.MainPage

class World {

    val loginPage: LoginPage = LoginPage.instance
    val mainPage: MainPage = MainPage.instance
    val credentialsPage: CredentialsPage = CredentialsPage.instance
}
