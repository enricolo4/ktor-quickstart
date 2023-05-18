package com.quickstart

import com.quickstart.config.routes
import io.ktor.server.application.Application

fun Application.module() {
    startKoin()
    routes()
}
