package io.cucumber

import io.pages.LoginPage
import io.pages.MainPage

class World {

    val loginPage: LoginPage = LoginPage.instance
    val mainPage: MainPage = MainPage.instance
}
