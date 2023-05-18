rootProject.name = "ktor-quickstart"

include(
    "domain",
    "main",
    "rest-server",
    "persistence"
)

// PRIMARY
project(":rest-server").projectDir = file("primary/rest-server")

// SECONDARY
project(":persistence").projectDir = file("secondary/persistence")
