plugins {
    val ktorVersion = "2.3.0"

    id("io.ktor.plugin") version ktorVersion
}

//application {
//    mainModule.set("com.quickstart")
//    mainClass.set("com.quickstart.QuickstartApplication")
//}

val primaryProjects = listOf(":rest-server")
val secondaryProjects = listOf(":persistence")
val projects = listOf(":domain") + primaryProjects + secondaryProjects

dependencies {
    projects.map { projects -> project(projects) }
        .forEach { projectDependency -> api(projectDependency) }
}
