val kotysaVersion: String by project
//val postgresqlR2dbc:String by project

dependencies {
    implementation(project(":domain"))
    implementation("org.ufoss.kotysa:kotysa-r2dbc:$kotysaVersion")
    runtimeOnly("io.r2dbc:r2dbc-h2:1.0.0.RELEASE")
//    implementation("io.r2dbc:r2dbc-postgresql:0.8.13.RELEASE")
//    runtimeOnly("org.postgresql:postgresql")
}
