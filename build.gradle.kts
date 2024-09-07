plugins {
    id("java")
}

group = "net.aboodyy"
version = "1.2"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://oss.sonatype.org/content/repositories/snapshots/") // Add this for BungeeCord
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.15.1-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.10.4")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

tasks.jar {
    archiveBaseName.set("Lab-Expansion")
    archiveVersion.set(project.version.toString())
}
