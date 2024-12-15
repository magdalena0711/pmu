pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven {
            url  = uri("https://raw.githubusercontent.com/MetaMask/android-sdk-releases/main/")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url  = uri("https://raw.githubusercontent.com/MetaMask/android-sdk-releases/main/")
        }
    }
}

rootProject.name = "Projekat"
include(":app")
 