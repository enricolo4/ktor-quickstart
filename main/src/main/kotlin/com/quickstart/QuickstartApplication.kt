package com.quickstart

import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(
        factory = Netty,
        module = Application::module,
        port = 8080
    ).start(wait = true)
}
