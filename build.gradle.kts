plugins {
    kotlin("jvm") version "1.9.22"

    `java-gradle-plugin`
    `maven-publish`
}

group = "com.featurevisor"
version = "1.0.0"


repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

publishing {

    repositories {
        mavenLocal()
    }
}

gradlePlugin {
    plugins {
        create("featurevisor-plugin") {
            id = "com.featurevisor.plugin"
            implementationClass = "com.featurevisor.plugin.TestRunnerPlugin"
        }
    }
}


dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("com.github.featurevisor:featurevisor-kotlin:0.0.7")
    implementation(gradleApi())
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}