pluginManagement {
    repositories {
        google()
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

rootProject.name = "Kotero"
include(":app")
include(":core:model")
include(":core:network")
include(":core:database")
include(":core:common")
include(":core:data")
include(":core:datastore")
include(":core:ui")
include(":features:auth")
include(":features:main")
