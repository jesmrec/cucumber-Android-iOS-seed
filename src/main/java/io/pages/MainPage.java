package io.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utils.log.Log;

public class MainPage extends CommonPage {

    @AndroidFindBy(id = "com.owncloud.android:id/root_toolbar")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Show/Hide sidebar\"])[2]")
    private WebElement mainPage;

    private static final MainPage INSTANCE = new MainPage();

    private MainPage() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    //Singletonize
    public static MainPage getInstance() {
        return INSTANCE;
    }

    public boolean isMainPageDisplayed() {
        Log.log(Level.FINE, "Starts: Is Main Page Displayed.");
        return mainPage.isDisplayed();
    }
}
