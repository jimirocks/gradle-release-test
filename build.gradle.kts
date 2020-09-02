plugins {
    kotlin("jvm") version "1.3.72"

    // releasing
//    id("net.researchgate.release") version "2.8.1"
    id("pl.allegro.tech.build.axion-release") version "1.12.0"


}

allprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")
//    apply(plugin = "net.researchgate.release")
    apply(plugin = "pl.allegro.tech.build.axion-release")

    project.version = scmVersion.version

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
