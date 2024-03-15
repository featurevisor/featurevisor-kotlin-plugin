plugins {
    kotlin("jvm") version "1.9.22"

    `java-gradle-plugin`
    `maven-publish`
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/featurevisor/featurevisor-kotlin")
        credentials {
            username = System.getenv("GITHUB_ACTOR")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/featurevisor/featurevisor-kotlin-plugin")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
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
    implementation("com.featurevisor:featurevisor-kotlin:0.0.8")
    implementation(gradleApi())
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}