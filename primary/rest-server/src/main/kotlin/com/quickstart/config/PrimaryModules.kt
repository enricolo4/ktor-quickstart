package com.quickstart.config

import com.quickstart.config.negotiation.contentNegotiation
import com.quickstart.health.controller.healthController
import com.quickstart.individual.controller.individualController
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.routes() {
    contentNegotiation()
    routing {
        individualController()
        healthController()
    }
}
