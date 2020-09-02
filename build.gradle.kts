import pl.allegro.tech.build.axion.release.domain.TagNameSerializationConfig

plugins {
    kotlin("jvm") version "1.3.72"

    // releasing
//    id("net.researchgate.release") version "2.8.1"
    id("pl.allegro.tech.build.axion-release") version "1.12.0"


}

scmVersion {
    tag(closureOf<TagNameSerializationConfig> {
        prefix = project.name
    })
}

project.version = scmVersion.version

allprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")
//    apply(plugin = "net.researchgate.release")


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
