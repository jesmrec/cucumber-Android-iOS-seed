defaultTasks("clean", "test")

val cucumberVersion = "7.21.0"
val apacheCommonsExecVersion = "1.3"
val apacheCommonsLangVersion = "3.9"
val apacheCommonsTextVersion = "1.9"
val apacheCommonsCodec = "1.10"
val apacheCommonsIo = "2.6"
val javaClientVersion = "9.3.0"
val slf4japiVersion = "1.7.7"
val junitVersion = "4.13.1"
val assertjcoreVersion = "3.8.0"
val slf4jVersion = "2.0.7"

buildscript {
    val kotlinVersion = "2.0.20"
    repositories {
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

plugins {
    java
    kotlin("jvm") version "2.0.20"
}

dependencies {
    testImplementation("io.cucumber:cucumber-java:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-junit:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-core:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-picocontainer:$cucumberVersion")
    testImplementation("org.apache.commons:commons-exec:$apacheCommonsExecVersion")
    testImplementation("org.apache.commons:commons-lang3:$apacheCommonsLangVersion")

    implementation("org.slf4j:slf4j-nop:$slf4jVersion")
    implementation("io.appium:java-client:$javaClientVersion")
    implementation("org.apache.commons:commons-text:$apacheCommonsTextVersion")
    implementation("commons-codec:commons-codec:$apacheCommonsCodec")
    implementation("commons-io:commons-io:$apacheCommonsIo")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Otras dependencias
    testImplementation("org.slf4j:slf4j-api:$slf4japiVersion")
    testImplementation("junit:junit:$junitVersion")
    testImplementation("org.assertj:assertj-core:$assertjcoreVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

repositories {
    mavenCentral()
}

tasks.test {
    testLogging.showStandardStreams = true
    systemProperty("platform", System.getProperty("platform"))
    systemProperty("server", System.getProperty("server"))
}

gradle.startParameter.isContinueOnFailure = true

kotlin {
    jvmToolchain(21)
}
