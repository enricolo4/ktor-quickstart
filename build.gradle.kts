val ktorVersion: String by project
val kafkaVersion: String by project
val nettyVersion: String by project
val javaVersion: String by project
val kotestVersion: String by project
val mockkVersion: String by project
val logbackVersion: String by project


plugins {
    val kotlinVersion = "1.8.21"

    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    kotlin("plugin.allopen") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
}

allprojects {
    repositories {
        mavenCentral()
//        mavenLocal()
//        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
//        maven("https://jcenter.bintray.com")
//        maven("https://jitpack.io")
    }

    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.kapt")
        plugin("org.jetbrains.kotlin.plugin.serialization")
        plugin("kotlin-allopen")
    }

    dependencies {
//        implementation("io.ktor:ktor-serialization:$ktorVersion")
//        implementation("io.ktor:ktor-client-json:$ktorVersion")
//        implementation("io.ktor:ktor-client-serialization:$ktorVersion")

        implementation("ch.qos.logback:logback-classic:$logbackVersion")
        implementation("io.insert-koin:koin-core-coroutines:3.4.0")
        implementation("io.insert-koin:koin-ktor:3.4.0")

//        implementation("io.ktor:ktor-client-logging:$ktorVersion")

//        testImplementation("io.mockk:mockk:$mockkVersion")
//        testImplementation("io.kotest.extensions:kotest-assertions-ktor:$kotestVersion")
//        testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    }

    group = "com.quickstart"
    version = "0.0.1"

    java {
        sourceCompatibility = JavaVersion.toVersion(javaVersion)
        targetCompatibility = JavaVersion.toVersion(javaVersion)
    }

    sourceSets {
        main { java.setSrcDirs(listOf("src/main/kotlin")) }
        test { java.setSrcDirs(listOf("src/test/kotlin")) }
    }

    kotlin {
        sourceSets {
            main { kotlin.setSrcDirs(listOf("src/main/kotlin")) }
            test { kotlin.setSrcDirs(listOf("src/test/kotlin")) }
        }
    }

    tasks {
        compileKotlin {
            kotlinOptions {
                jvmTarget = javaVersion
            }
        }
        compileTestKotlin {
            kotlinOptions {
                jvmTarget = javaVersion
            }
        }
        test {
            useJUnitPlatform()
        }
    }
}
