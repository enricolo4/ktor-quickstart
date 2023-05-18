package com.quickstart.health.controller

import com.quickstart.health.dto.RestHealthResponse
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.healthController() {
    get("/health") {
        val test = RestHealthResponse(
            status = "success",
            version = "teste",
            remoteService = "success",
            database = "success",
        )

        call.respond(test)
    }
}
