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
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Lesson3"
include(":app")
include(":app:intentapp")
include(":intentapp_v2")
include(":app:sharer")
include(":sharer_v2")
include(":favoritebook")
include(":sharer_v2:shareactivity")
include(":myapplication")
include(":systemintentsapp")
include(":simplefragmentapp")
