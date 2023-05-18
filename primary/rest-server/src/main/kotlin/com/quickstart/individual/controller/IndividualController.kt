package com.quickstart.individual.controller

import com.quickstart.individual.dto.IndividualRequestDTO
import com.quickstart.individual.dto.toDTO
import com.quickstart.individual.ports.primary.CreateIndividualPort
import com.quickstart.individual.ports.primary.GetIndividualPort
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import java.util.UUID
import org.koin.ktor.ext.inject

internal fun Routing.individualController() {
    val createIndividualPort: CreateIndividualPort by inject()
    val getIndividualPort: GetIndividualPort by inject()

    post("/individual") {
        val individualRequestDTO = call.receive<IndividualRequestDTO>()
        val individual = createIndividualPort(individualRequestDTO.toModel())

        call.respond(individual.toDTO())
    }

    get("/individual/{id}") {
        val id = UUID.fromString(call.parameters["id"])

        getIndividualPort.getById(id)
            ?.toDTO()
            ?.let {
                call.respond(it)
            } ?: call.respond(HttpStatusCode.NotFound)
    }
}
