
plugins {
    kotlin("jvm") version "1.3.72"

    // releasing
    id("net.researchgate.release") version "2.8.1"
}

allprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")


    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    }
}

subprojects {
    project.version = parent?.version ?: error("Subproject has no parent, you are in wrong universe.")
}
