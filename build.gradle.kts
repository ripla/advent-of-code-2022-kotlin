plugins {
    kotlin("jvm") version "1.7.22"
}

repositories {
    mavenCentral()
}

dependencies {
    // Other dependencies.
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    wrapper {
        gradleVersion = "7.6"
    }

    test {
        useJUnitPlatform()
    }
}