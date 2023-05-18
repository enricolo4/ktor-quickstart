val ktorVersion: String by project

plugins {
    val ktorVersion = "2.3.0"

    id("io.ktor.plugin") version ktorVersion
}

dependencies {
    implementation(project(":domain"))

    api("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    api("io.ktor:ktor-server-netty:$ktorVersion")
    api("io.ktor:ktor-server-core:$ktorVersion")
    api("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    api("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

    testImplementation("io.ktor:ktor-server-tests-jvm:$ktorVersion")
}
