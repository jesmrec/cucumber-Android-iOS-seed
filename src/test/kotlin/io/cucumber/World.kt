package io.cucumber

import io.pages.LoginPage
import io.pages.MainPage

class World {

    //Involved pages
    val loginPage: LoginPage = LoginPage.instance
    val mainPage: MainPage = MainPage.instance
}