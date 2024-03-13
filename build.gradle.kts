plugins {
    kotlin("jvm") version "1.9.22"

    `java-gradle-plugin`
    `maven-publish`
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

publishing {
    publications {
        create<MavenPublication>("default") {
            from(components["java"])
            // Include any other artifacts here, like javadocs
        }
    }

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
            id = "com.featurevisor.featurevisor-kotlin-plugin"
            implementationClass = "com.featurevisor.plugin.TestRunnerPlugin"
//            displayName = "Featurevisor Plugin"
//            description = "Need to use this plugin to "
//            tags.set(listOf("test-runner", "run-test-case", "test"))
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