package io.cucumber;

import io.pages.LoginPage;
import io.pages.MainPage;

public class World {

    //Involved pages
    public LoginPage loginPage = LoginPage.getInstance();
    public MainPage mainPage = MainPage.getInstance();

    public World() {
    }
}
