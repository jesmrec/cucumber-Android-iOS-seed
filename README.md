# Cucumber + Appium + Mobile testing

This is a sample project to show how to run Cucumber tests on Android/iOS devices using Appium with Java driver

## Requirements

Be sure your machine hosts the Android SDK. It is always included in the latest version of Android Studio, but other package manager like homebrew allows to install it without the IDE.

Install and run *Appium* in your machine. This sample is intended to run with *Appium* 2.15+. If *Appium* is not installed in your machine, follow the [official Appium installation manual](https://appium.io/docs/en/2.0/quickstart/install/)

The sample is setup to run in both Android and iOS:

- For Android, you need to attach an emulator or a real device, running in advance.
- For iOS, it only works with simulator. You need to have Xcode installed in your machine. Not required to run in advance, the simulator will be launched by Appium.

The test subject will be the [ownCloud](https://github.com/owncloud/) mobile apps. Artifacts .apk and .app are included in the project.

Also, required to have an ownCloud server running and reachable from the device, including a user with the following setup:

- Username: user1
- Password: a
- Display name: Joeh Smith

## Use Gradle

Now, we are ready to launch the test. Type the following command to run the tests. 

Two parameters are required to run the tests:

- Platform: iOS / Android
  - Server: URL of the ownCloud server to execute against

    ./gradlew clean test --info -Dplatform=Android -Dserver=https://myserver.com
    ./gradlew clean test --info -Dplatform=iOS -Dserver=https://yourserver.com

If everything goes fine, you'll see everything green!

<font color='green'>

      Given "Joeh Smith" is on the login page
      When "Joeh Smith" enters user1 and a
      And "Joeh Smith" clicks on the login button
      Then "Joeh Smith" should be redirected to the home page

    ┌───────────────────────────────────────────────────────────────────────────────────┐
    │ Share your Cucumber Report with your team at https://reports.cucumber.io          │
    │ Activate publishing with one of the following:                                    │
    │                                                                                   │
    │ src/test/resources/cucumber.properties:          cucumber.publish.enabled=true    │
    │ src/test/resources/junit-platform.properties:    cucumber.publish.enabled=true    │
    │ Environment variable:                            CUCUMBER_PUBLISH_ENABLED=true    │
    │ JUnit:                                           @CucumberOptions(publish = true) │
    │                                                                                   │
    │ More information at https://cucumber.io/docs/cucumber/environment-variables/      │
    │                                                                                   │
    │ Disable this message with one of the following:                                   │
    │                                                                                   │
    │ src/test/resources/cucumber.properties:          cucumber.publish.quiet=true      │
    │ src/test/resources/junit-platform.properties:    cucumber.publish.quiet=true      │
    └───────────────────────────────────────────────────────────────────────────────────┘

   
</font>

This sample is ready to use [cucumber-reports](https://cucumber.io/docs/cucumber/reporting/?lang=java). Check documentation about the values to set in cucumber.properties file 
