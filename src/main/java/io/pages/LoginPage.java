package io.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends CommonPage {

    @AndroidFindBy(id = "com.owncloud.android:id/hostUrlInput")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Server URL\"]")
    private WebElement urlServer;

    @AndroidFindBy(id = "com.owncloud.android:id/embeddedCheckServerButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Proceed\"]")
    private WebElement checkServerButton;

    @AndroidFindBy(id = "com.owncloud.android:id/account_username")
    @iOSXCUITFindBy(accessibility = "Server Username")
    private WebElement userNameText;

    @AndroidFindBy(id = "com.owncloud.android:id/account_password")
    @iOSXCUITFindBy(accessibility = "Server Password")
    private WebElement passwordText;

    @AndroidFindBy(id = "com.owncloud.android:id/loginButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Login\"]")
    private WebElement loginButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"YES\");")
    @iOSXCUITFindBy(accessibility = "Approve")
    private WebElement acceptCertificate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Start setup\"]")
    private WebElement startSetup;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    private WebElement done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Personal\"]")
    private WebElement personal;

    private static final LoginPage INSTANCE = new LoginPage();
    private final String platform = System.getProperty("platform");
    private final String server = System.getProperty("server");

    private LoginPage() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    //Singletonize
    public static LoginPage getInstance() {
        return INSTANCE;
    }

    public void typeURL() {
        if (platform.equals("iOS")) {
            startSetup.click();
        }
        urlServer.sendKeys(server);
        checkServerButton.click();
    }

    public void typeCredentials(String userName, String password) {
        userNameText.sendKeys(userName);
        passwordText.sendKeys(password);
    }

    public void submitLogin(String displayName) {
        loginButton.click();
        if (platform.equals("iOS")) {
            done.click();
            selectFirstBookmark(displayName);
            personal.click();
        }
    }

    public void acceptCertificate() {
        acceptCertificate.click();
    }

    public void selectFirstBookmark(String displayName) {
        getDriver().findElement(By.id(displayName)).click(); //iOS
    }

}
