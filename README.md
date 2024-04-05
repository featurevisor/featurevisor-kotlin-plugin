![GitHub Release](https://img.shields.io/github/v/release/featurevisor/featurevisor-kotlin-plugin)

**featurevisor-kotlin**

This repository is a work in progress to use test runner by just using gradle plugin.

We are not ready yet. Please come back later.

**Installation**

`put below line of code in setting.gradle.kts`

```
pluginManagement {
  repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }

    maven {
      url = uri("https://maven.pkg.github.com/featurevisor/featurevisor-kotlin-plugin")
      credentials {
        username = GITHUB_USERNAME
        password = GITHUB_PASSWORD_OR_TOKEN
      }
    }

  }
}
```

`put below code in build.gradle.kts`

```
plugins {
  id("com.featurevisor.plugin") version "<LATEST_VERSION>"
}

```

...

**Usage**

...

